use RPG;
select * from item;

insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY) value(
'입짧은 달님 계란기름 라면',  -- 제목
'달짝찌근한 라면, 맛이 정말 좋다. 공짜로 드립니다',	-- 설명
2,			-- 초기 갯수
0,			-- 구매가
'1'			-- 판매색인 (태 0,바보 2,무한 3)
);
insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY) value(
'오라클 입문 베이스 서적',  -- 제목
'침이 묻어있다.',	-- 설명
20,			-- 초기 갯수
0,			-- 구매가
'1'			-- 판매색인 (태 0,바보 2,무한 3)
);