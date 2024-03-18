drop table BBR;
drop table RF;
select * from BBR;
use BBR;
create table BBR(
member int primary key auto_increment,
title char(50) not null,
id char(50) not null,
t time not null,
hit int not null,
text char(50) not null
);
create table RF(
member int primary key auto_increment,
om int primary key auto_increment,
text char(50) not null
);
insert into BBR (title, id, hit, t , text) value('가나다','작서장',now(),1,'241');
insert into RF (member, om, text) value('가나다','작서장',14,1,'241');