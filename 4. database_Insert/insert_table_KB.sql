


/* E�Ӵ� */
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenkb77', '����','�츮����','1002641272775',100000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenkb77', '���','�츮����','1002641272775',10000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenht', '����','��������','123141312122',50000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenht', '���','��������','123141312122',15000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenys11', '����','��������','123141312122',150000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenys11', '���','��������','123141312125',50000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezensh56', '����','��������','123456789456',50000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezensh56', '���','��������','123456789456',10000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenhj11', '����','��������','987654123321',90000, sysdate);
INSERT INTO P4EMONEY VALUES (emo_code_seq.nextval, 'userezenhj11', '���','��������','987654123321',40000, sysdate);


/* ��Ż ��ǰ */
INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezenys11',12000007,'��Ű���', 20000,'��', to_date('2020-03-12'),
to_date('2020-04-30'), '7','�ù�', '��Ű����Դϴ�', 'www.ezenimgserver.com/Ski.png', '�ļս� ����', '������','�뿩��');

INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezenkb77',12000001,'�÷��̽����̼�4', 40000,'��', to_date('2020-03-13'),
to_date('2020-05-30'), '7','�ù�', '�÷��̽����̼�4 ���� ���Դϴ�', 'www.ezenimgserver.com/Playstation.png', '�ļս� ����, �浹 ����', '����, ����','�뿩����');

INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezenkb77',12000001,'�����е�', 25000,'��', to_date('2020-03-13'),
to_date('2020-05-30'), '7','�ù�', '�����е� 6�����Դϴ�', 'www.ezenimgserver.com/Ipad.png', '�ļս� ����, �浹 ����', '����','�뿩����');


INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezensh56',12000009,'�޴�� ����', 10000,'��', to_date('2020-03-13'),
to_date('2020-05-30'), '7','�ù�', '�޴������Դϴ�', 'www.ezenimgserver.com/
Portableburner.png', '�ļս� ����, ���� ����', 'ķ��','�뿩����');

INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezenys11',12000001,'�ƺ����� 2019���� 13��ġ', 50000,'��', to_date('2020-03-15'),
to_date('2020-04-30'), '7','�ù�', '���� �ƺ� ���� 2019���� 13��ġ �⺻���Դϴ�', 'www.ezenimgserver.com/MacBook.png', '�ļս� ����', '����','�뿩����');

INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezenkb77',12000001,'������̱�', 5000,'��', to_date('2020-03-15'),
to_date('2020-04-30'), '7','�ù�', '������̱��Դϴ�', 'www.ezenimgserver.com/HairDryer.png', '�ļս� ����', '����','�뿩����');

INSERT INTO P4rent_item (rent_item_code,mem_id, cate_code, rent_item_title,rent_item_price,
rent_item_price_per, rent_item_sdate, rent_item_fdate, rent_item_mindur,rent_item_method,
rent_item_detail, rent_item_img, rent_item_notice, rent_item_keyword, rent_item_curr)
VALUES (rent_item_code_seq.nextval, 'userezenhj11',12000004,'����Ʈ ����', 10000,'��', to_date('2020-03-15'),
to_date('2020-05-30'), '7','�ù�', '����Ʈ ������', 'www.ezenimgserver.com/ReactBook.png', '�ļս� ����', '����','�뿩����');

SELECT * FROM P4emoney;
SELECT * FROM P4rent_item;
