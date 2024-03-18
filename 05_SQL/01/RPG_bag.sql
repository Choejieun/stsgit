CREATE DATABASE RPG default CHARACTER SET UTF8MB4;
use RPG;

select * from item;
select * from Inventory;
select * from item where I_MY = 0;
SELECT * FROM item;
SELECT * FROM item WHERE I_NO IS NOT NULL;
select * from charinfo where C_NAME = '모험가';

drop table Inventory;
drop table charinfo;
drop table item;
select * from charinfo;
UPDATE charinfo SET C_MONEY = 100 WHERE C_NAME = '모험가';


DESC charinfo;


-- AUTO_INCREMENT 열 삭제
ALTER TABLE item DROP COLUMN I_NO;

-- 새로운 열 추가
ALTER TABLE charinfo ADD COLUMN CANTDEL INT;
update charinfo set CANTDEL = 0 where C_NAME = 'a';

-- 순차적인 값 할당
SET @count = 0;
UPDATE item SET New_I_NO = (@count := @count + 1) WHERE I_MY = 1 ORDER BY New_I_NO;

-- 필요한 경우, 새로운 AUTO_INCREMENT 열 추가
ALTER TABLE item ADD COLUMN I_NO INT AUTO_INCREMENT PRIMARY KEY;

-- New_I_NO 열 삭제 (필요한 경우)
ALTER TABLE item DROP COLUMN New_I_NO;



insert into Inventory (IM_NAME, IM_TEXT, IM_INT,IM_MONEY,IM_MY) value('"+imname+"','"+imtext+"',"+imint+","+immoney+","+immy+");



create table item(

I_NAME char(50),
I_TEXT text,
I_INT int,
I_NO int primary key auto_increment,
I_MONEY int,
I_MY char(50),
I_FIELD char(50)

);

create table Inventory(

IM_NAME char(50),
IM_TEXT text,
IM_INT int,
IM_NO int primary key auto_increment,
IM_MONEY int,
IM_MY char(50)
);


create table stand(

I_NAME char(50),
I_TEXT text,
I_INT int,
I_NO int primary key auto_increment,
I_MONEY int,
I_MY char(50)

);



create table charinfo(

C_NAME char(50) not null,
C_ID char(50),
C_PW char(50),
C_MONEY int not null,
C_NO int primary key auto_increment,
 CANTDEL INT

);

insert into charinfo (C_NAME,C_MONEY) value(
'모험가',
100
);
update charinfo set C_MONEY = C_MONEY+100 where C_NO = 1;

alter table item add I_MONEY int;
update item set I_MONEY = 10 where I_NO = 1;
update item set I_MONEY = 10;
update item set I_INT = I_INT-1 WHERE I_NAME = 'a';
update charinfo set C_MONEY = C_MONEY-100 WHERE C_NAME = 'ㅎㅇㅎㅇ';

INSERT INTO stand (I_NO,I_NAME, I_TEXT, I_INT, I_MONEY, I_MY) VALUES ('0','기초의 검', '말랑한 검이다.', 1, 50, '희남박');
create table stand(I_NAME char(50),I_TEXT text,I_INT int,I_NO int primary key auto_increment,I_MONEY int,I_MY char(50));
SELECT * FROM item WHERE I_MY = '0';

SELECT * FROM item WHERE I_MY = '0';
INSERT INTO stand (I_NAME, I_TEXT, I_INT, I_MONEY, I_MY) VALUES ('기초의 검', '말랑한 검이다.', 1, 50, '0');

DELETE FROM item WHERE I_NAME = '작은 하마' and I_INT <= 1;
select * from charinfo;
select * from item;
select * from stand;
drop table item;
drop table charinfo;
drop table stand;

select * from Inventory;
drop table Inventory;
insert into Inventory (IM_NAME, IM_TEXT, IM_INT,IM_MONEY,IM_MY) value('기초의 빵','딱딱한 빵이다.',1,10,8);
create table Inventory(IM_NAME char(50),IM_TEXT text,IM_INT int,IM_NO int primary key auto_increment,IM_MONEY int,IM_MY int);

insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY) value('기초의 빵','딱딱한 빵이다.',1,10,2);
insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY) value('기초의 네일아트','큐티클 제거 세트도 포함',1,100,3);
insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY) value(
'기초의 빵',
'딱딱한 빵이다.',
5,
10,
0
);
insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY) value(
'기초의 검',
'말랑한 검이다.',
1,
50,
'0'
);
insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY) value(
'작은 하마',
'강하다.',
1,
50,
'0'
);

insert into Inventory (IM_NAME, IM_TEXT, IM_INT,IM_MONEY,IM_MY) value(
'%s',
'%s',
'%d',
'%d',
1
);
