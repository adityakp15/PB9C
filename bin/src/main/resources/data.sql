<<<<<<< HEAD
truncate account_transaction;
truncate registered_biller;
truncate bill;
truncate master_biller;
truncate accounts;
truncate user;
truncate role;
insert into user values(1,'pass1',2,1);
insert into user values(2,'pass2',1,2);
insert into user values(3,'pass3',3,3);
insert into user values(4,'pass4',2,4);

insert into role values(1,'Manager');
insert into role values(2,'AccountHolder');
insert into role values(3,'Vendor');


insert into accounts values(00001,5000,'amr.bharathkumar@gmail.com','bharath',1);
insert into accounts values(00002,10000,'amr.bharathkumar@gmail.com','bharath',1);
insert into accounts values(00003,13000,'g8sriram@gmail.com','sriram',4);

insert into master_biller values('B001','Airtel');
insert into master_biller values('B002','Jio');
insert into master_biller values('B003','TNEB');

insert into bill values(001,1000,82208271,'29-08-2022',1,'pending');
insert into bill values(002,1500,5000100,'24-08-2022',2,'approved');

insert into registered_biller values(001,00002,true,2000,82208271,1);


insert into account_transaction values(01,1500,101,'24-08-2022',1,'Successful');

=======
insert into Master_Biller values("b1", "joo");
>>>>>>> 596f0ce5b1faea9d51dfbde8d9cdab7b65bfb6ea
