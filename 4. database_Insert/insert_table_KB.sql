


/* E머니 */
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenkb77', '충전','우리은행','1002641272775',100000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenkb77', '출금','우리은행','1002641272775',10000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenht', '충전','신한은행','123141312122',50000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenht', '출금','신한은행','123141312122',15000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenys11', '충전','신한은행','123141312122',150000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenys11', '출금','신한은행','123141312125',50000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezensh56', '충전','국민은행','123456789456',50000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezensh56', '출금','국민은행','123456789456',10000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenhj11', '충전','국민은행','987654123321',90000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenhj11', '출금','국민은행','987654123321',40000, sysdate);


/* 렌탈 상품 */
INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezenys11',12000007,'스키장비', 20000,'원', to_date('2020-03-12'),
to_date('2020-04-30'), '7','택배', '스키장비입니다', 'www.ezenimgserver.com/Ski.png', '파손시 변상', '스포츠','대여중');

INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezenkb77',12000001,'플레이스테이션4', 40000,'원', to_date('2020-03-13'),
to_date('2020-05-30'), '7','택배', '플레이스테이션4 슬림 모델입니다', 'www.ezenimgserver.com/Playstation.png', '파손시 변상, 충돌 주의', '게임, 가전','대여가능');

INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezenkb77',12000001,'아이패드', 25000,'원', to_date('2020-03-13'),
to_date('2020-05-30'), '7','택배', '아이패드 6세대입니다', 'www.ezenimgserver.com/Ipad.png', '파손시 변상, 충돌 주의', '가전','대여가능');


INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezensh56',12000009,'휴대용 버너', 10000,'원', to_date('2020-03-13'),
to_date('2020-05-30'), '7','택배', '휴대용버너입니다', 'www.ezenimgserver.com/
Portableburner.png', '파손시 변상, 폭발 주의', '캠핑','대여가능');

INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezenys11',12000001,'맥북프로 2019년형 13인치', 50000,'원', to_date('2020-03-15'),
to_date('2020-04-30'), '7','택배', '애플 맥북 프로 2019년형 13인치 기본형입니다', 'www.ezenimgserver.com/MacBook.png', '파손시 변상', '가전','대여가능');

INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezenkb77',12000001,'헤어드라이기', 5000,'원', to_date('2020-03-15'),
to_date('2020-04-30'), '7','택배', '헤어드라이기입니다', 'www.ezenimgserver.com/HairDryer.png', '파손시 변상', '가전','대여가능');

INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezenhj11',12000004,'리액트 도서', 10000,'원', to_date('2020-03-15'),
to_date('2020-05-30'), '7','택배', '리액트 교과서', 'www.ezenimgserver.com/ReactBook.png', '파손시 변상', '도서','대여가능');

SELECT * FROM P4emoney;
SELECT * FROM P4rent_item;
