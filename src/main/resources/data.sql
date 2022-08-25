truncate account_transaction;
truncate registered_biller;
truncate bill;
truncate master_biller;
truncate accounts;
truncate user;
truncate role;
insert into user values(1,1,'pass1',2);
insert into user values(2,2,'pass2',1);
insert into user values(3,3,'pass3',3);
insert into user values(4,4,'pass4',2);

insert into role values(1,'Manager');
insert into role values(2,'AccountHolder');
insert into role values(3,'Vendor');


insert into accounts values(00001,5000,'amr.bharathkumar@gmail.com','bharath',1);
insert into accounts values(00002,10000,'amr.bharathkumar@gmail.com','bharath',1);
insert into accounts values(00003,13000,'g8sriram@gmail.com','sriram',4);

insert into master_biller values('B001','Airtel');
insert into master_biller values('B002','Jio');
insert into master_biller values('B003','TNEB');

--insert into requested_bill (amount, due_date)values(1,1000,'C001','82208271','29-08-2022');
--insert into requested_bill values(2,1500,'C002','5000100','24-08-2022');


insert into registered_biller values(1,00002,true,2000,'C001','82208271','29-08-2022');
insert into registered_biller values(2,00002,true,2000,'C001','82208271','26-08-2022');


insert into account_transaction values(1,1500,2,'24-08-2022',1,'Successful');


