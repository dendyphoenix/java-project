CREATE TABLE dog(
	id NUMBER PRIMARY KEY,
	kind VARCHAR2(12),
	price NUMBER,
	image VARCHAR2(20),
	country VARCHAR2(12),
	height NUMBER,
	weight NUMBER,
	content VARCHAR2(4000),
	readcount NUMBER
)

CREATE SEQUENCE dog_seq;
SELECT * FROM dog;
DROP TABLE dog;
DROP SEQUENCE dog_seq;

INSERT INTO dog VALUES(dog_seq.nextval,'Ǫ��',1000,'pu.jpg','������',1,2,'Ǫ���� ������ ����',0)
INSERT INTO dog VALUES(dog_seq.nextval,'ǳ�갳',1200,'pung.jpg','����',2,2,'ǳ�갳�� ���� ����',0)
INSERT INTO dog VALUES(dog_seq.nextval,'������',2000,'jin.jpg','�ѱ�',2,3,'�������� �ѱ� ����',0)
INSERT INTO dog VALUES(dog_seq.nextval,'��찳',1300,'sab.jpg','�߱�',1,2,'��찳�� �߱� ����',0)
INSERT INTO dog VALUES(dog_seq.nextval,'��찳',1300,'sab.jpg','�߱�',1,2,'��찳�� �߱� ����',0)
INSERT INTO dog VALUES(dog_seq.nextval,'������',0,'ej.jpg','�ѱ�',160,5000,'����',0)
INSERT INTO dog VALUES(dog_seq.nextval,'������',0,'hj.jpg','�ѱ�',160,5000,'����',0)
COMMIT