CREATE TABLE noticeBoard(
num NUMBER PRIMARY KEY, --각 게시판 글들을 구분하기 위한 값
writer VARCHAR2(12) NOT NULL,
email VARCHAR2(30),
subject VARCHAR2(50) NOT NULL,
passwd VARCHAR2(12) NOT NULL,
reg_date TIMESTAMP(6) NOT NULL, -- 시간 소수점 6자리까지
readcount NUMBER DEFAULT 0, -- 기본값 0
ref NUMBER NOT NULL, --관련글들을 하나로 묶는 단위의 번호
re_step NUMBER NOT NULL, --동일한 관련글 내에있는 글들의 출력 순서
re_level NUMBER NOT NULL, --답글 레벨(들여쓰기 정도)
content VARCHAR2(4000) NOT NULL,
ip VARCHAR2(20) NOT NULL
)
CREATE SEQUENCE noticeboard_seq;
DROP SEQUENCE noticeboard_seq;
SELECT * FROM noticeBoard;