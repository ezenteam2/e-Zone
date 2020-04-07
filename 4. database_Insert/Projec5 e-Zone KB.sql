-- 회원
ALTER TABLE P5MEMBER
	DROP CONSTRAINT PK_P5MEMBER; -- 회원 기본키

-- 회원
DROP TABLE P5MEMBER;

-- 회원
CREATE TABLE P5MEMBER (
	mem_id    VARCHAR2(20)  NOT NULL, -- 회원 아이디
	mem_pw    VARCHAR2(20)  NOT NULL, -- 회원 비밀번호
	mem_name  VARCHAR2(20)  NOT NULL, -- 회원 이름
	mem_email VARCHAR2(100) NOT NULL, -- 회원 이메일
	mem_nick  VARCHAR2(20)  NOT NULL, -- 회원 닉네임
	mem_phone VARCHAR2(20)  NOT NULL, -- 회원 휴대폰 번호
	mem_addr  VARCHAR2(300) NOT NULL, -- 회원 주소
	mem_cate  VARCHAR2(30)  NOT NULL, -- 회원 관심 카테고리
	mem_prof  VARCHAR2(100) NULL      -- 회원 프로필 이미지
);

-- 회원 기본키
CREATE UNIQUE INDEX PK_P5MEMBER
	ON P5MEMBER ( -- 회원
		mem_id ASC -- 회원 아이디
	);

-- 회원
ALTER TABLE P5MEMBER
	ADD
		CONSTRAINT PK_P5MEMBER -- 회원 기본키
		PRIMARY KEY (
			mem_id -- 회원 아이디
		);
		
	
	
	
-- 세미나/밋업 문의사항
ALTER TABLE P5SEMIQNA
	DROP CONSTRAINT PK_P5SEMIQNA; -- 세미나/밋업 문의사항 기본키

-- 세미나/밋업 문의사항
DROP TABLE P5SEMIQNA;

-- 세미나/밋업 문의사항
CREATE TABLE P5SEMIQNA (
	sq_code     NUMBER         NOT NULL, -- 문의 코드
	qna_type    VARCHAR2(20)   NOT NULL CHECK (qna_type IN ('세미나','밋업','세미나존')), -- 세미나/밋업/세미나존 구분
	semi_code   NUMBER         NOT NULL, -- 코드
	mem_id      VARCHAR2(20)   NOT NULL, -- 회원 아이디
	sq_date     DATE           NOT NULL, -- 문의 등록 날짜
	sq_detail   VARCHAR2(1000) NOT NULL, -- 문의 내용
	qna_ansId   VARCHAR2(20)   NULL,     -- 문의 답변자 아이디
	sq_answer   VARCHAR2(1000) NULL,     -- 문의 답변 내용
	qna_ansDate DATE           NULL      -- 문의 답변 등록 날짜
);

-- 세미나/밋업 문의사항 기본키
CREATE UNIQUE INDEX PK_P5SEMIQNA
	ON P5SEMIQNA ( -- 세미나/밋업 문의사항
		sq_code ASC -- 문의 코드
	);

-- 세미나/밋업 문의사항
ALTER TABLE P5SEMIQNA
	ADD
		CONSTRAINT PK_P5SEMIQNA -- 세미나/밋업 문의사항 기본키
		PRIMARY KEY (
			sq_code -- 문의 코드
		);

-- 세미나/밋업 문의사항
ALTER TABLE P5SEMIQNA
	ADD
		CONSTRAINT FK_P5MEMBER_TO_P5SEMIQNA -- 회원 -> 세미나/밋업 문의사항
		FOREIGN KEY (
			mem_id -- 회원 아이디
		)
		REFERENCES P5MEMBER ( -- 회원
			mem_id -- 회원 아이디
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;

	-- 세미나 참가 예약
ALTER TABLE P5SEMIPARTI
	DROP CONSTRAINT FK_P5MEMBER_TO_P5SEMIPARTI; -- 회원 -> 세미나 참가 예약

-- 세미나 참가 예약
ALTER TABLE P5SEMIPARTI
	DROP CONSTRAINT FK_P5SEMIBOOK_TO_P5SEMIPARTI; -- 세미나존 예약 및 세미나 등록 -> 세미나 참가 예약

-- 세미나 참가 예약
ALTER TABLE P5SEMIPARTI
	DROP CONSTRAINT PK_P5SEMIPARTI; -- 세미나 참가 예약 기본키

-- 세미나 참가 예약
DROP TABLE P5SEMIPARTI;

-- 세미나 참가 예약
CREATE TABLE P5SEMIPARTI (
	parti_code      NUMBER         NOT NULL, -- 세미나 참가 코드
	semi_code       NUMBER         NOT NULL, -- 세미나 코드
	parti_bookdate  DATE           NOT NULL, -- 세미나 참가 신청 날짜
	mem_id          VARCHAR2(20)   NOT NULL, -- 회원 아이디
	parti_mcnt      NUMBER         NOT NULL, -- 세미나 참가 신청 인원
	parti_price     NUMBER         NOT NULL, -- 세미나 참가 결제 금액
	parti_curr      VARCHAR2(20)   NOT NULL CHECK (parti_curr IN ('입금대기','입금완료')), -- 세미나 참가 결제 상태
	parti_comm      VARCHAR2(1000) NULL,     -- 세미나 참가 후기
	parti_comm_date DATE           NULL      -- 세미나 참가 후기 날짜
);

-- 세미나 참가 예약 기본키
CREATE UNIQUE INDEX PK_P5SEMIPARTI
	ON P5SEMIPARTI ( -- 세미나 참가 예약
		parti_code ASC -- 세미나 참가 코드
	);

-- 세미나 참가 예약
ALTER TABLE P5SEMIPARTI
	ADD
		CONSTRAINT PK_P5SEMIPARTI -- 세미나 참가 예약 기본키
		PRIMARY KEY (
			parti_code -- 세미나 참가 코드
		);

	
	
-- 세미나 참가 예약
ALTER TABLE P5SEMIPARTI
	ADD
		CONSTRAINT FK_P5MEMBER_TO_P5SEMIPARTI -- 회원 -> 세미나 참가 예약
		FOREIGN KEY (
			mem_id -- 회원 아이디
		)
		REFERENCES P5MEMBER ( -- 회원
			mem_id -- 회원 아이디
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;

-- 세미나 참가 예약
ALTER TABLE P5SEMIPARTI
	ADD
		CONSTRAINT FK_P5SEMIBOOK_TO_P5SEMIPARTI -- 세미나존 예약 및 세미나 등록 -> 세미나 참가 예약
		FOREIGN KEY (
			semi_code, -- 세미나 코드
			mem_id     -- 회원 아이디
		)
		REFERENCES P5SEMIBOOK ( -- 세미나존 예약 및 세미나 등록
			semi_code, -- 세미나 코드
			mem_id     -- 회원 아이디
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;
		
	
	-- 세미나존 예약 및 세미나 등록
ALTER TABLE P5SEMIBOOK
	DROP CONSTRAINT FK_P5MEMBER_TO_P5SEMIBOOK; -- 회원 -> 세미나존 예약 및 세미나 등록

-- 세미나존 예약 및 세미나 등록
ALTER TABLE P5SEMIBOOK
	DROP CONSTRAINT FK_P5SEMIZONE_TO_P5SEMIBOOK; -- 세미나존 -> 세미나존 예약 및 세미나 등록

-- 세미나존 예약 및 세미나 등록
ALTER TABLE P5SEMIBOOK
	DROP CONSTRAINT PK_P5SEMIBOOK; -- 세미나존 예약 및 세미나 등록 기본키

-- 세미나존 예약 및 세미나 등록
DROP TABLE P5SEMIBOOK;

-- 세미나존 예약 및 세미나 등록
CREATE TABLE P5SEMIBOOK (
	semi_code     NUMBER         NOT NULL, -- 세미나 코드
	mem_id        VARCHAR2(20)   NOT NULL, -- 회원 아이디
	zone_code     NUMBER         NOT NULL, -- 세미나존 코드
	semi_bookdate DATE           NOT NULL, -- 세미나 등록 날짜
	semi_title    VARCHAR2(100)  NOT NULL, -- 세미나명
	semi_subtitle VARCHAR2(100)  NOT NULL, -- 세미나 부제
	semi_date     DATE           NOT NULL, -- 세미나 날짜
	semi_stime    DATE           NOT NULL, -- 세미나 시작 시간
	semi_ftime    DATE           NOT NULL, -- 세미나 종료 시간
	semi_cate     VARCHAR2(20)   NOT NULL
	CHECK (semi_cate IN ('IT기술','스포츠'
	,'건강','음식','음악','가족','언어 문화', '영상제작', '기타')), -- 세미나 카테고리
	semi_img      VARCHAR2(100)  NOT NULL , -- 세미나 소개 이미지
	semi_detail   VARCHAR2(1000) NOT NULL, -- 세미나 소개
	semi_capa     NUMBER         NOT NULL, -- 세미나 제한 인원
	semi_parno    NUMBER         NOT NULL, -- 세미나 참가 인원
	semi_price    NUMBER         NOT NULL, -- 세미나 참가비
	semi_curr     VARCHAR2(20)   NOT NULL CHECK (semi_curr IN ('입금대기','입금완료')),     -- 세미나존 결제 상태
	zone_comm     VARCHAR2(1000) NULL,     -- 세미나존 후기
	zone_commDate DATE           NULL      -- 세미나존 후기 등록날짜
);	

-- 세미나존 예약 및 세미나 등록 기본키
CREATE UNIQUE INDEX PK_P5SEMIBOOK
	ON P5SEMIBOOK ( -- 세미나존 예약 및 세미나 등록
		semi_code ASC, -- 세미나 코드
		mem_id    ASC  -- 회원 아이디
	);

-- 세미나존 예약 및 세미나 등록
ALTER TABLE P5SEMIBOOK
	ADD
		CONSTRAINT PK_P5SEMIBOOK -- 세미나존 예약 및 세미나 등록 기본키
		PRIMARY KEY (
			semi_code, -- 세미나 코드
			mem_id     -- 회원 아이디
		);

-- 세미나존 예약 및 세미나 등록
ALTER TABLE P5SEMIBOOK
	ADD
		CONSTRAINT FK_P5MEMBER_TO_P5SEMIBOOK -- 회원 -> 세미나존 예약 및 세미나 등록
		FOREIGN KEY (
			mem_id -- 회원 아이디
		)
		REFERENCES P5MEMBER ( -- 회원
			mem_id -- 회원 아이디
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;

-- 세미나존 예약 및 세미나 등록
ALTER TABLE P5SEMIBOOK
	ADD
		CONSTRAINT FK_P5SEMIZONE_TO_P5SEMIBOOK -- 세미나존 -> 세미나존 예약 및 세미나 등록
		FOREIGN KEY (
			zone_code -- 세미나존 코드
		)
		REFERENCES P5SEMIZONE ( -- 세미나존
			sz_code -- 세미나존 코드
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;