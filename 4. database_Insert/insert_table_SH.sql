-- 밋업
ALTER TABLE P5MEETUP
	DROP CONSTRAINT PK_P5MEETUP; -- 밋업 기본키

-- 밋업
DROP TABLE P5MEETUP;

-- 밋업
CREATE TABLE P5MEETUP (
	meetup_code     NUMBER         NOT NULL, -- 밋업 코드
	sz_code         NUMBER         NOT NULL, -- 세미나존 코드
	meetup_bookdate DATE           NOT NULL, -- 밋업 등록 날짜
	meetup_title    VARCHAR2(100)  NOT NULL, -- 밋업명
	meetup_subtitle VARCHAR2(100)  NOT NULL, -- 밋업 부제
	meetup_date     DATE           NOT NULL, -- 밋업 진행 날짜
	meetup_stime    DATE           NOT NULL, -- 밋업 시작 시간
	meetup_ftime    DATE           NOT NULL, -- 밋업 종료 시간
	meetup_cate     VARCHAR2(20)   NOT NULL, -- 밋업 카테고리
	meetup_img      VARCHAR2(100)  NOT NULL, -- 밋업 소개 이미지
	meetup_detail   VARCHAR2(1000) NOT NULL, -- 밋업 소개
	meetup_capa     NUMBER         NOT NULL, -- 밋업 제한 인원
	meetup_parno    NUMBER         NULL,     -- 밋업 참가 인원
	meetup_price    NUMBER         NOT NULL  -- 밋업 참가비
);

-- 밋업 기본키
CREATE UNIQUE INDEX PK_P5MEETUP
	ON P5MEETUP ( -- 밋업
		meetup_code ASC -- 밋업 코드
	);

-- 밋업
ALTER TABLE P5MEETUP
	ADD
		CONSTRAINT PK_P5MEETUP -- 밋업 기본키
		PRIMARY KEY (
			meetup_code -- 밋업 코드
		);
		
-- 밋업 참가 예약
ALTER TABLE P5MEETUPPARTI
	DROP CONSTRAINT FK_P5MEMBER_TO_P5MEETUPPARTI; -- 회원 -> 밋업 참가 예약

-- 밋업 참가 예약
ALTER TABLE P5MEETUPPARTI
	DROP CONSTRAINT FK_P5MEETUP_TO_P5MEETUPPARTI; -- 밋업 -> 밋업 참가 예약

-- 밋업 참가 예약
ALTER TABLE P5MEETUPPARTI
	DROP CONSTRAINT PK_P5MEETUPPARTI; -- 밋업 참가 예약 기본키

-- 밋업 참가 예약
DROP TABLE P5MEETUPPARTI;

-- 밋업 참가 예약
CREATE TABLE P5MEETUPPARTI (
	COL                   NUMBER        NOT NULL, -- 밋업 참가 코드
	meetup_code           NUMBER        NOT NULL, -- 밋업 코드
	meetup_parti_bookdate DATE          NULL,     -- 밋업 참가 신청 날짜
	mem_id                VARCHAR2(20)  NULL,     -- 회원 아이디
	meetup_parti_mcnt     NUMBER        NULL,     -- 밋업 참가 신청 인원
	meetup_parti_price    NUMBER        NULL,     -- 밋업 결제 금액
	meetup_parti_curr     VARCHAR(20)   NULL,     -- 밋업 결제 상태
	meetup_parti_comm     VARCHAR(1000) NULL,     -- 밋업 참가 후기
	meetup_parti_review   DATE          NULL      -- 밋업 참가 후기 등록 날짜
);

-- 밋업 참가 예약 기본키
CREATE UNIQUE INDEX PK_P5MEETUPPARTI
	ON P5MEETUPPARTI ( -- 밋업 참가 예약
		COL         ASC, -- 밋업 참가 코드
		meetup_code ASC  -- 밋업 코드
	);

-- 밋업 참가 예약
ALTER TABLE P5MEETUPPARTI
	ADD
		CONSTRAINT PK_P5MEETUPPARTI -- 밋업 참가 예약 기본키
		PRIMARY KEY (
			COL,         -- 밋업 참가 코드
			meetup_code  -- 밋업 코드
		);

-- 밋업 참가 예약
ALTER TABLE P5MEETUPPARTI
	ADD
		CONSTRAINT FK_P5MEMBER_TO_P5MEETUPPARTI -- 회원 -> 밋업 참가 예약
		FOREIGN KEY (
			mem_id -- 회원 아이디
		)
		REFERENCES P5MEMBER ( -- 회원
			mem_id -- 회원 아이디
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;

-- 밋업 참가 예약
ALTER TABLE P5MEETUPPARTI
	ADD
		CONSTRAINT FK_P5MEETUP_TO_P5MEETUPPARTI -- 밋업 -> 밋업 참가 예약
		FOREIGN KEY (
			meetup_code -- 밋업 코드
		)
		REFERENCES P5MEETUP ( -- 밋업
			meetup_code -- 밋업 코드
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;
	
-- 밋업 참가 예약	
ALTER TABLE P5MEETUPPARTI ADD CONSTRAINT P5MEETUPPARTI_check CHECK meetup_parti_curr IN('입금대기','입금완료');

-- 관리자
ALTER TABLE P5ADMIN
	DROP CONSTRAINT PK_P5ADMIN; -- 관리자 기본키

-- 관리자
DROP TABLE P5ADMIN;

-- 관리자
CREATE TABLE P5ADMIN (
	ad_id    VARCHAR2(20) NOT NULL, -- 관리자 아이디
	ad_pw    VARCHAR2(20) NULL,     -- 관리자 비밀번호
	ad_name  VARCHAR2(20) NULL,     -- 관리자 이름
	ad_empno VARCHAR2(20) NULL      -- 관리자 사원 번호
);

-- 관리자 기본키
CREATE UNIQUE INDEX PK_P5ADMIN
	ON P5ADMIN ( -- 관리자
		ad_id ASC -- 관리자 아이디
	);

-- 관리자
ALTER TABLE P5ADMIN
	ADD
		CONSTRAINT PK_P5ADMIN -- 관리자 기본키
		PRIMARY KEY (
			ad_id -- 관리자 아이디
		);

-- Q&A
ALTER TABLE P5QNA
	DROP CONSTRAINT FK_P5MEMBER_TO_P5QNA; -- 회원 -> Q&A

-- Q&A
ALTER TABLE P5QNA
	DROP CONSTRAINT FK_P5ADMIN_TO_P5QNA; -- 관리자 -> Q&A

-- Q&A
ALTER TABLE P5QNA
	DROP CONSTRAINT PK_P5QNA; -- Q&A 기본키

-- Q&A
DROP TABLE P5QNA;

-- Q&A
CREATE TABLE P5QNA (
	qna_code   NUMBER        NOT NULL, -- QNA 코드
	qna_cate   VARCHAR(20)   NULL,     -- QNA 카테고리
	mem_id     VARCHAR2(20)  NULL,     -- 회원 아이디
	qna_date   DATE          NULL,     -- QNA 등록 날짜
	qna_title  VARCHAR(100)  NULL,     -- QNA 제목
	qna_detail VARCHAR(1000) NULL,     -- QNA 내용
	qna_open   VARCHAR(1)    NULL,     -- QNA 공개 유무
	qna_answ   VARCHAR(1000) NULL,     -- QNA 답변
	qna_adate  DATE          NULL,     -- QNA 답변 등록 날짜
	ad_id      VARCHAR2(20)  NULL      -- 관리자 아이디
);

-- Q&A 기본키
CREATE UNIQUE INDEX PK_P5QNA
	ON P5QNA ( -- Q&A
		qna_code ASC -- QNA 코드
	);

-- Q&A
ALTER TABLE P5QNA
	ADD
		CONSTRAINT PK_P5QNA -- Q&A 기본키
		PRIMARY KEY (
			qna_code -- QNA 코드
		);

-- Q&A
ALTER TABLE P5QNA
	ADD
		CONSTRAINT FK_P5MEMBER_TO_P5QNA -- 회원 -> Q&A
		FOREIGN KEY (
			mem_id -- 회원 아이디
		)
		REFERENCES P5MEMBER ( -- 회원
			mem_id -- 회원 아이디
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;

-- Q&A
ALTER TABLE P5QNA
	ADD
		CONSTRAINT FK_P5ADMIN_TO_P5QNA -- 관리자 -> Q&A
		FOREIGN KEY (
			ad_id -- 관리자 아이디
		)
		REFERENCES P5ADMIN ( -- 관리자
			ad_id -- 관리자 아이디
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;
	
-- Q&A		
ALTER TABLE P5QNA ADD CONSTRAINT P5QNA_check CHECK qna_open IN('공개','비공개');