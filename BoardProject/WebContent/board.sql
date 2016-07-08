CREATE TABLE board(
num NUMBER PRIMARY KEY, --�� �Խ��� �۵��� �����ϱ� ���� ��
writer VARCHAR2(12) NOT NULL,
email VARCHAR2(30),
subject VARCHAR2(50) NOT NULL,
passwd VARCHAR2(12) NOT NULL,
reg_date TIMESTAMP(6) NOT NULL,
readcount NUMBER DEFAULT 0,
ref NUMBER NOT NULL, -- ���ñ۵��� �ϳ��� ���� ������ ��ȣ
re_step NUMBER NOT NULL, --������ ���ñ� ���� �ִ� �۵��� ��¼���
re_level NUMBER NOT NULL, --��۷���(�鿩���� ����)
content VARCHAR2(4000) NOT NULL,
ip VARCHAR2(20) NOT NULL
)

--Sequence : ���ڰ��� ���ʴ�� ��ȯ
CREATE SEQUENCE board_seq;

SELECT * FROM board;