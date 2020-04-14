-- 공지사항
ALTER TABLE "MY_SCHEMA"."P5NOTICE"
	DROP CONSTRAINT "FK_P5ADMIN_TO_P5NOTICE"; -- 관리자 -> 공지사항

-- 공지사항
ALTER TABLE "MY_SCHEMA"."P5NOTICE"
	DROP CONSTRAINT "PK_P5NOTICE"; -- 공지사항 기본키

-- 공지사항
DROP TABLE "MY_SCHEMA"."P5NOTICE";

-- 공지사항(완료)
CREATE TABLE P5NOTICE (
	"noti_code"   NUMBER         NOT NULL, -- 공지사항 코드
	"ad_id"       VARCHAR2(20)   NOT NULL, -- 관리자 아이디
	"noti_date"   DATE           NULL,     -- 공지사항 등록 날짜
	"noti_title"  VARCHAR2(100)  NULL,     -- 공지사항 타이틀
	"noti_detail" VARCHAR2(1000) NULL,     -- 공지사항 내용
	"noti_img"    VARCHAR2(100)  NULL      -- 공지사항 이미지
);

-- 공지사항 기본키(완료)
CREATE UNIQUE INDEX "PK_P5NOTICE"
	ON P5NOTICE ( -- 공지사항
		"noti_code" ASC -- 공지사항 코드
	);

-- 공지사항(완료)
ALTER TABLE P5NOTICE
	ADD
		CONSTRAINT "PK_P5NOTICE" -- 공지사항 기본키
		PRIMARY KEY (
			"noti_code" -- 공지사항 코드
		);

-- 공지사항(미완)
ALTER TABLE P5NOTICE
	ADD
		CONSTRAINT "FK_P5ADMIN_TO_P5NOTICE" -- 관리자 -> 공지사항
		FOREIGN KEY (
			"ad_id" -- 관리자 아이디
		)
		REFERENCES "MY_SCHEMA"."P5ADMIN" ( -- 관리자
			"ad_id" -- 관리자 아이디
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;
		
	
	
---------------------------
	
-- FAQ
ALTER TABLE "MY_SCHEMA"."P5FAQ"
	DROP CONSTRAINT "FK_P5ADMIN_TO_P5FAQ"; -- 관리자 -> FAQ

-- FAQ
ALTER TABLE "MY_SCHEMA"."P5FAQ"
	DROP CONSTRAINT "PK_P5FAQ"; -- FAQ 기본키

-- FAQ
DROP TABLE "MY_SCHEMA"."P5FAQ";

-- FAQ(완료)
CREATE TABLE P5FAQ (
	"faq_code"   NUMBER         NOT NULL, -- FAQ 코드
	"ad_id"      VARCHAR2(20)   NOT NULL, -- 관리자 아이디
	"faq_cate"   VARCHAR2(20)   NULL,     -- FAQ 카테고리
	"faq_title"  VARCHAR2(100)  NULL,     -- FAQ 타이틀
	"faq_detail" VARCHAR2(1000) NULL,     -- FAQ 내용
	"faq_img"    VARCHAR2(100)  NULL      -- FAQ 이미지
);

-- FAQ 기본키(완료)
CREATE UNIQUE INDEX PK_P5FAQ
	ON P5FAQ ( -- FAQ
		"faq_code" ASC -- FAQ 코드
	);

-- FAQ(완료)
ALTER TABLE P5FAQ
	ADD
		CONSTRAINT "PK_P5FAQ" -- FAQ 기본키
		PRIMARY KEY (
			"faq_code" -- FAQ 코드
		);

-- FAQ(미완)
ALTER TABLE P5FAQ
	ADD
		CONSTRAINT "FK_P5ADMIN_TO_P5FAQ" -- 관리자 -> FAQ
		FOREIGN KEY (
			"ad_id" -- 관리자 아이디
		)
		REFERENCES "MY_SCHEMA"."P5ADMIN" ( -- 관리자
			"ad_id" -- 관리자 아이디
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;
		
----------------------------------------------------------------
	
-- 캐러셀 배너
ALTER TABLE "MY_SCHEMA"."P5CAROUSEL"
	DROP CONSTRAINT "PK_P5CAROUSEL"; -- 캐러셀 배너 기본키

-- 캐러셀 배너
DROP TABLE "MY_SCHEMA"."P5CAROUSEL";

-- 캐러셀 배너
CREATE TABLE P5CAROUSEL (
	"carou_code"  NUMBER        NOT NULL, -- 캐러셀 코드
	"carou_order" NUMBER        NULL,     -- 캐러셀 순서
	"carou_img"   VARCHAR2(100) NULL,     -- 캐러셀 이미지
	"carou_link"  VARCHAR2(100) NULL,     -- 캐러셀 링크
	"carou_date"  DATE          NULL      -- 캐러셀 등록 날짜
);

-- 캐러셀 배너 기본키
CREATE UNIQUE INDEX PK_P5CAROUSEL
	ON P5CAROUSEL ( -- 캐러셀 배너
		"carou_code" ASC -- 캐러셀 코드
	);

-- 캐러셀 배너
ALTER TABLE P5CAROUSEL
	ADD
		CONSTRAINT "PK_P5CAROUSEL" -- 캐러셀 배너 기본키
		PRIMARY KEY (
			"carou_code" -- 캐러셀 코드
		);
		
-----------------------------

	
-- 세미나존
ALTER TABLE "MY_SCHEMA"."P5SEMIZONE"
	DROP CONSTRAINT "PK_P5SEMIZONE"; -- 세미나존 기본키

-- 세미나존
DROP TABLE "MY_SCHEMA"."P5SEMIZONE";

-- 세미나존(완료)
CREATE TABLE P5SEMIZONE (
	"sz_code"   NUMBER         NOT NULL, -- 세미나존 코드
	"sz_title"  VARCHAR2(30)   NULL,     -- 세미나존명
	"sz_capa"   NUMBER         NULL,     -- 세미나존 수용 인원
	"sz_detail" VARCHAR2(2000) NULL,     -- 세미나존 소개
	"sz_unitPrice" NUMBER      NULL,     -- 세미나존 단위 가격
	"sz_intro"  VARCHAR2(1000) NULL,     -- 세미나존 시설 안내
	"sz_notice" VARCHAR2(1000) NULL,     -- 세미나존 주의 사항
	"sz_refund" VARCHAR2(1000) NULL,     -- 세미나존 환불 규정
	"sz_img"    VARCHAR2(100)  NULL      -- 세미나존 이미지
);

-- 세미나존 기본키(완료)
CREATE UNIQUE INDEX PK_P5SEMIZONE
	ON P5SEMIZONE ( -- 세미나존
		"sz_code" ASC -- 세미나존 코드
	);

-- 세미나존(완료)
ALTER TABLE P5SEMIZONE
	ADD
		CONSTRAINT "PK_P5SEMIZONE" -- 세미나존 기본키
		PRIMARY KEY (
			"sz_code" -- 세미나존 코드
		);
	
COMMIT;