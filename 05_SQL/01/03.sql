drop table member;
select * from member;
create table member(
n int primary key auto_increment,
id char(50) unique not null,
			# unique 다른사라미 가튼 값을 너을 수 없다
name char(50) not null,
age int not null, #not null = 무조건 항목을 채워라
gender char(1) not null,
tel char(20) not null,
hobby char(50) null
);
insert into member (id,name,age,gender,tel,hobby) values('cat1','고양이',5,'여','010-1234-1234','책읽기');
insert into member (id,name,age,gender,tel,hobby) values('cat2','개냥이',4,'남','010-1234-1234',null);
insert into member (id,name,age,gender,tel,hobby) values('cat3','호랑이',9,'남','010-1234-1234',null);