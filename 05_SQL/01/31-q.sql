CREATE DATABASE my_cat default CHARACTER SET UTF8MB4;
use my_cat;

select * from board;
select * from board order by b_no limit 5;
select * from board order by b_no limit 0,5;
								     -- 5번 부터 5개 보여주시오
select * from board order by b_no limit 5,5;
select * from board order by b_no limit 10,5;
select * from board order by b_no limit 15,5;

select count(*) from board;

select count(*) from board where b_reply_orino is not null;
select * from board where b_no = 5;
drop table board;
delete from board where b_no = 1;

desc board;
ALTER TABLE board CHANGE b_reply_orino b_reply_ori INT;
ALTER TABLE board CHANGE b_time b_datetime datetime;

update board set b_title = '1', b_time = now(), b_text = '1', b_id = '1'  where b_no =10;
update board set b_hit='%s'  where b_hit ='$s';

create table board (
b_no int primary key auto_increment,
b_title char(30),
b_ID char(10),
b_time datetime,
b_hit int,
b_text text,

b_reply_count int,
b_reply_orino int,
b_reply_text text
);


insert into board (b_title,b_ID,b_time,b_text,b_hit) value (
'제목',
'id',
now(),
'글입니다. 글글.....글....',
0
);

insert into board (b_ID,b_time,b_reply_orino,b_reply_text) value(
'댓글 작성자',
now(),
1,
'댓글내용'
);

insert into board (b_ID,b_time,b_reply_orino,b_reply_text)
values (
'cat1'
,
now()
,
10
,
'댓글임......욕욕욕...'
);

