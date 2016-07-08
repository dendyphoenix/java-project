CREATE TABLE board(
num NUMBER PRIMARY KEY, --각 게시판 글들을 구분하기 위한 값
writer VARCHAR2(12) NOT NULL,
email VARCHAR2(30),
subject VARCHAR2(50) NOT NULL,
passwd VARCHAR2(12) NOT NULL,
reg_date TIMESTAMP(6) NOT NULL,
readcount NUMBER DEFAULT 0,
ref NUMBER NOT NULL, -- 관련글들을 하나로 묶는 단위의 번호
re_step NUMBER NOT NULL, --동일한 관련글 내에 있는 글들의 출력순서
re_level NUMBER NOT NULL, --답글레벨(들여쓰기 정도)
content VARCHAR2(4000) NOT NULL,
ip VARCHAR2(20) NOT NULL
)

--Sequence : 숫자값을 차례대로 반환
CREATE SEQUENCE board_seq;

SELECT * FROM board;