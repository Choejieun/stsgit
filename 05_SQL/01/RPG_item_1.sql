use RPG;
select * from item;
select * from stand;
select * from inventory; 

update item set I_INT = I_INT-1 WHERE  I_MY != '응?두리번커피' and I_FIELD = '응?두리번커피' and I_NAME = '빨간 포션';
delete from item where I_FIELD = '중복검사' and  I_NAME = '기초의 빵1111' and I_MY = '중복검사';

select * from charinfo;
SHOW STATUS WHERE `variable_name` = 'Threads_connected';
SHOW PROCESSLIST;
KILL 1453;
update inventory set IM_INT = IM_INT+1 where IM_NAME = IN_NAME;


insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY,I_FIELD) value(
'입짧은 달님 계란기름 라면',  -- 제목
'달짝찌근한 라면, 맛이 정말 좋다. 공짜로 드립니다',	-- 설명
2,			-- 초기 갯수
0,			-- 구매가
'1',		-- 판매색인 (태 0,바보 1,무한 2)
'a'			
);
insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY) value(
'오라클 입문 베이스 서적',  -- 제목
'침이 묻어있다.',	-- 설명
20,			-- 초기 갯수
0,			-- 구매가
'1'			-- 판매색인 (태 0,바보 1,무한 2)
);


drop table item;
drop table Inventory;