use RPG;
select * from item;
select * from stand;

insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY) value(
'2억 오픈 월드 RPG',  -- 제목
'RPG? 그게 뭐지',	-- 설명
1,			-- 초기 갯수
1000,			-- 구매가
'2'			-- 판매색인 (태 0,바보 2,무한 3)
);
insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY) value(
'캐삭빵 면제권',  -- 제목
'캐삭이 되지 않는다.',	-- 설명
1,			-- 초기 갯수
1000,			-- 구매가
'2'			-- 판매색인 (태 0,바보 2,무한 3)
);