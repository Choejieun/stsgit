use my_cat;

select * from member;
drop table member;

create table member(
	s_id char(50) primary key,
    s_pw char(50) not null
    );
    
    select count(*) from member where s_id = 'daw' and s_pw = 'd23' ;