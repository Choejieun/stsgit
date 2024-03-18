CREATE DATABASE bbs_1 default CHARACTER SET UTF8MB4;
use bbs_1;

select * from main_board;
create table main_board(
num int primary key auto_increment,
title char(20),
content text,
id char(10)
);

update main_board set title = '1121212121', id = 'ㅎㅇㅎㅇㅎ', content = 'ㅇㅎㅇㅎㅇㅎㅇㅎㅇ111' where num = 6;
insert into main_board (num, title, content, id) values(0,'엉딩이댄스','루우우우욱뿌우우욱!!!!!!!!','뿌우우뿌뿌ㅃ뿡');

delete from main_board where num = 1;
insert into main_board values(0,'1','3','2');
insert into main_board values(0,'제목','내용','작성자');
insert into main_board values(0,'제목2','내용2','작성자2');