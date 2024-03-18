CREATE DATABASE my_cat default CHARACTER SET UTF8MB4;
use my_cat;

drop table tottenham_squad;
select * from tottenham_squad order by p_number;
select * from tottenham_squad order by p_height, p_number;
select * from tottenham_squad order by weekly_pay desc,p_height desc, p_weight;
							 # p_number 칼럼을 기준으로 정렬한다.
							 # 2개 정렬 기준을 가질 수도 있다.
                             # desc 명령어로 오름/내림 차순을 바꾼다.
select * from tottenham_squad where p_position = '공격수';
#공격수만 출력
select * from tottenham_squad where p_number > 7;
#7번 이상만 출력
select * from tottenham_squad where p_number > 6 and p_name like '%흥%';
#6번 이상에 이름에 %흥%이 들어가는 사람
select p_number, p_name from tottenham_squad;
# * 표시가 전체라는 뜻이라...
#선수단 정보 중 등번호, 이름만 뽑아보기


desc tottenham_squad;
#테이블의 자료형 확인 , 문자열 숫자열 등

ALTER TABLE tottenham_squad ADD weekly_pay int;
ALTER TABLE tottenham_squad drop column weekly_pay;
 ALTER TABLE tottenham_squad  MODIFY weekly_pay int; #다시 숫자형
 ALTER TABLE tottenham_squad  MODIFY weekly_pay char(50); #다시 숫자형
#주급을 추가 해준다.
update tottenham_squad set weekly_pay = 90 where p_number >= 7 limit 5;
update tottenham_squad set weekly_pay = '90억' where p_number > 7 LIMIT 5;
#주급에 다가 돈을 넣는다.
#7번 이상인 애들 중 5명한테만 90억을 준다.


delete from tottenham_squad where p_number = 4;
update tottenham_squad set p_name = '오지상으로 개병 ★' where p_number = 21;


insert into tottenham_squad values(	
0	
,	
7	
,	
'손흥민'	
,	
'1992-07-08'	
,	
'공격수'	
,	
183	
,	 
78	
);	
create table tottenham_squad(                        		
	id int primary key auto_increment,	
		
	p_number int not null,	
	p_name char(50),	
	p_birth date,	
	p_position char(20),	
	p_height int,	
	p_weight int	
);		

#공격수
insert into tottenham_squad values(0,22,'브레넌 존슨','2001-05-23','공격수',179,73);
insert into tottenham_squad values(0,7,'손흥민','1992-07-08','공격수',183,78);
insert into tottenham_squad values(0,63,'제이미 돈리','2005-01-03','공격수',180,80);
insert into tottenham_squad values(0,36,'알레호 벨리스','2003-09-19','공격수',187,77);
insert into tottenham_squad values(0,9,'히살리송','1997-05-10','공격수',179,71);
insert into tottenham_squad values(0,14,'이반페리시치','1989-02-02','공격수',186,77);

#미드필더
insert into tottenham_squad values(0,21,'데얀클루셰프스키','2000-04-25','미드필더',186,75);
insert into tottenham_squad values(0,19,'라이언세세뇽','2000-05-18','미드필더',178,70);
insert into tottenham_squad values(0,30,'로드리고벤탄쿠르','1997-06-26','미드필더',187,77);
insert into tottenham_squad values(0,27,'마노르 솔로몬','1999-07-24','미드필더',167,63);
insert into tottenham_squad values(0,11,'브리안 힐 살바티에라','2001-02-11','미드필더',175,60);
insert into tottenham_squad values(0,58,'야고 산티아고','2003-04-15','미드필더',180,80);
insert into tottenham_squad values(0,4,'올리버 스킵','2000-09-16','미드필더',175,70);
insert into tottenham_squad values(0,38,'이브스 비수마','1996-08-30','미드필더',182,72);
insert into tottenham_squad values(0,10,'제임스 메디슨','1996-11-23','미드필더',175,73);
insert into tottenham_squad values(0,18,'지오바니 로셀소','1996-04-09','미드필더',177,74);
insert into tottenham_squad values(0,29,'파페 마타르 사르','2002-09-14','미드필더',184,70);
insert into tottenham_squad values(0,5,'피에르 호이비에르','1995-08-05','미드필더',187,84);

#수비수
insert into tottenham_squad values(0,38,'데스티니 우도지','2002-11-28','수비수',186,80);
insert into tottenham_squad values(0,37,'미키 판 더 펜','2001-04-19','수비수',193,81);
insert into tottenham_squad values(0,33,'벤 데이비스','1993-04-24','수비수',181,76);
insert into tottenham_squad values(0,65,'알피 도링턴','2005-04-20','수비수',192,86);
insert into tottenham_squad values(0,35,'애슐리 필립스','2005-06-26','수비수',192,86);
insert into tottenham_squad values(0,15,'에릭 다이어','1994-01-15','미드필더',188,90);
insert into tottenham_squad values(0,12,'에메르송 로얄','1999-01-14','수비수',181,79);
insert into tottenham_squad values(0,17,'크리스티안 로메로','1998-04-27','수비수',185,79);
insert into tottenham_squad values(0,23,'페드로 포로','1999-09-13','수비수',173,71);

#골키퍼
insert into tottenham_squad values(0,21,'굴리엘모 비카리오','1996-10-07','골키퍼',188,83);
insert into tottenham_squad values(0,40,'브랜든 오스틴','1999-01-08','골키퍼',188,80);
insert into tottenham_squad values(0,41,'알피 화이트맨','1998-10-02','골키퍼',189,84);
insert into tottenham_squad values(0,1,'위고 요리스','1986-12-26','골키퍼',188,82);
insert into tottenham_squad values(0,20,'프레이저 포스터','1988-03-17','골키퍼',201,93);