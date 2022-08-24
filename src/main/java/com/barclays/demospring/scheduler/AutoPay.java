package com.barclays.demospring.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.demospring.model.AccountTransaction;
import com.barclays.demospring.model.Bill;
import com.barclays.demospring.model.RegisteredBiller;
import com.barclays.demospring.repo.BillRepo;
import com.barclays.demospring.repo.BillerRepo;
import com.barclays.demospring.repo.RegisteredBillerRepo;
import com.barclays.demospring.repo.TransactionRepo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@Component
public class AutoPay {
	@Autowired
	private RegisteredBillerRepo registeredrepo;
	
	@Autowired
	private TransactionRepo transrepo;
	
	@Autowired
	private BillRepo bill_repo;
	
	@ResponseBody
	@Scheduled(initialDelay = 10000,fixedDelay = 60000)
	public void makeautopay() throws ParseException
	{
		
		Date date1 = getDateWithoutTimeUsingCalendar();
		final Logger log = LogManager.getLogger(RegisteredBiller.class);
		log.info(date1);
		
		
		List<Object> val = registeredrepo.findByaP(true);
		for(Object o:val) {
			AccountTransaction new_transaction = new AccountTransaction();
			int seqid = ((RegisteredBiller) o).togetseqid();
			String payment_date = ((RegisteredBiller) o).togetDate();
			SimpleDateFormat formatter2=new SimpleDateFormat("dd-MM-yyyy");
			Date date2=formatter2.parse(payment_date);
			
			long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
		    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		    
			System.out.println(seqid+" "+date2);
			System.out.println(diff);
			if(diff<=3)
			{
				new_transaction.setDate(payment_date);
				new_transaction.setDebitCredit(1);
				new_transaction.setDescription("successful");
				new_transaction.setBillReference(seqid);
				Bill a = bill_repo.findBybCodeAndConsumerNumber(((RegisteredBiller) o).getbCode(),((RegisteredBiller) o).getcNumber()).orElse(new Bill());
				new_transaction.setAmount(a.getAmount());
				transrepo.save(new_transaction);
				System.out.println("Added");
				registeredrepo.deleteById(seqid);
				System.out.println("found");
			}
		}
		
		
		
	}
	
	public static Date getDateWithoutTimeUsingCalendar() {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);

	    return calendar.getTime();
	}

}
