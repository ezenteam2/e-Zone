DROP SEQUENCE semi_code_seq;
DROP SEQUENCE parti_code_seq;
DROP SEQUENCE mu_code_seq;
DROP SEQUENCE mu_parti_code;
DROP SEQUENCE sq_code_seq;
DROP SEQUENCE qna_code_seq;
DROP SEQUENCE noti_code_seq;
DROP SEQUENCE faq_code_seq;
DROP SEQUENCE sz_code_seq;
DROP SEQUENCE carou_code_seq;


/* 세미나 코드 - 세미나존 예약 및 세미나 등록 */
CREATE SEQUENCE semi_code_seq
	INCREMENT BY 1
	START WITH 1100000;

/* 세미나 참가 코드 - 세미나 참가 예약 */
CREATE SEQUENCE parti_code_seq
	INCREMENT BY 1
	START WITH 1200000;

/* 밋업 코드 - 밋업 */
CREATE SEQUENCE mu_code_seq
	INCREMENT BY 1
	START WITH 2100000;

/* 밋업 참가 코드 - 밋업 참가 예약 */
CREATE SEQUENCE mu_parti_code
	INCREMENT BY 1
	START WITH 2200000;

/* 문의 코드 - 세미나/밋업 문의사항 */
CREATE SEQUENCE sq_code_seq
	INCREMENT BY 1
	START WITH 3100000;

/* QNA 코드 - Q&A */
CREATE SEQUENCE qna_code_seq
	INCREMENT BY 1
	START WITH 3200000;

/* 공지사항 코드 - 공지사항 */
CREATE SEQUENCE noti_code_seq
	INCREMENT BY 1
	START WITH 4100000;

/* FAQ 코드 - FAQ */
CREATE SEQUENCE faq_code_seq
	INCREMENT BY 1
	START WITH 4200000;

/* 세미나존 코드 - 세미나존 */
CREATE SEQUENCE sz_code_seq
	INCREMENT BY 1
	START WITH 5100000;

/* 캐러셀 코드 - 캐러셀 배너 */
CREATE SEQUENCE carou_code_seq
	INCREMENT BY 1
	START WITH 6100000;

COMMIT;