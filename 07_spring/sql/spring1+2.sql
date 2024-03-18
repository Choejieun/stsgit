use my_cat;

create table tbl_test (	
	no int,
	str_data varchar(50)
);	

SELECT * from tbl_guest limit 0, 5;

insert into tbl_test values(1,'1');
insert into tbl_test values(2,'2');
insert into tbl_test values(3,'100');
insert into tbl_test values(4,'HELLO WORLD');

select * from tbl_test;
select no,str_data from tbl_test where no =1;
select no,str_data where no =2;
		select * from tbl_test where no =2;

SELECT no,str_data from tbl_test where no = 1;



create table tbl_guest(				
	bno int auto_increment primary key,			
	btext text			
);				

select * from tbl_guest;

insert into tbl_guest (btext) values('개');					
insert into tbl_guest (btext) values('고양이');					


select count(*) from tbl_guest;
ALTER TABLE tbl_guest DROP COLUMN bno;
	ALTER TABLE tbl_guest ADD COLUMN bno INT AUTO_INCREMENT PRIMARY KEY;