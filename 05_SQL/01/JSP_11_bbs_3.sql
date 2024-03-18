CREATE DATABASE bbs_3 default CHARACTER SET UTF8MB4;
use bbs_3;

select * from main_board_3 where title like '%원%' limit 0,5; 
select * from main_board_3 ORDER BY num ;
drop table main_board_3;
delete from main_board_3 where num=1;
select count(*) from main_board_3  where title like '%제목%' and topick like 'free';
select count(*) from PS_MEMBER where id like 1 and pw like 1;
select count(*) from main_board_3  where title like '%ti%';
INSERT INTO PS_MEMBER (id,pw,userNAME) VALUES ('3','3','ì¼ìì´');

update main_board_3 set title = 'a', id = 'a', content = 'a', datatime = now(), topick = 'a' where num = 1;

create table main_board_3(
num int primary key auto_increment,
title char(50),
id char(30),
content text,
datatime datetime,
topick char(50)
);

create table PS_MEMBER(
id char(30),
pw char(30),
userNAME char(30)
);
select * from PS_MEMBER;
drop table PS_MEMBER;
select count(*) from PS_MEMBER where id like '2' and pw like '2';
insert PS_MEMBER value('1','1','유저1번');
insert main_board_3 (title,id,content,datatime,topick) value('다이아몬드','아이디', '내용',now(),'free');
select * from main_board_3 WHERE topick LIKE '%lite%' ORDER BY num  limit 0,5;