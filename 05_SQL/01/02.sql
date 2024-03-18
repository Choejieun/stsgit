CREATE DATABASE my_cat default CHARACTER SET UTF8MB4;
use my_cat;

drop table board_guest;
create table board_guest(
	no int primary key auto_increment,
	        #no 라는 변수에 자동으로 숫자를 넣는 식
            # primary key  = 중복값 허용 X
    con char(255),
    writer char(50)
);
insert into board_guest (con,writer) values ('안녕','안');
insert into board_guest (con,writer) values ('하이','가');
insert into board_guest (con,writer) values ('바이','나');
select * from board_guest;
select * from board_guest where no > 3 or no=1;

delete from board_guest where no = 5;

update board_guest set writer="고양이";
#이것만 실행 시 고양이로 전부가 바뀜

update TEST SET NUM = 5 where ID =3; #?????????????????????????
