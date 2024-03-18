CREATE DATABASE bbs_2 default CHARACTER SET UTF8MB4;
use bbs_2;

select * from main_board_2;
drop table main_board_2;
delete from main_board_2 where num=1;

update main_board_2 set title = 'a', id = 'a', content = 'a', datatime = now(), topick = 'a' where num = 1;

create table main_board_2(
num int primary key auto_increment,
title char(50),
id char(30),
content text,
datatime datetime,
topick char(50)
);

insert main_board_2 (title,id,content,datatime,topick) value('제목','아이디', '내용',now(),null);
