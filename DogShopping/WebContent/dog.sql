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

INSERT INTO dog VALUES(dog_seq.nextval,'푸들',1000,'pu.jpg','프랑스',1,2,'푸들은 프랑스 개다',0)
INSERT INTO dog VALUES(dog_seq.nextval,'풍산개',1200,'pung.jpg','독일',2,2,'풍산개는 독일 개다',0)
INSERT INTO dog VALUES(dog_seq.nextval,'진도개',2000,'jin.jpg','한국',2,3,'진도개는 한국 개다',0)
INSERT INTO dog VALUES(dog_seq.nextval,'삽살개',1300,'sab.jpg','중국',1,2,'삽살개는 중국 개다',0)
INSERT INTO dog VALUES(dog_seq.nextval,'삽살개',1300,'sab.jpg','중국',1,2,'삽살개는 중국 개다',0)
INSERT INTO dog VALUES(dog_seq.nextval,'이은지',0,'ej.jpg','한국',160,5000,'에휴',0)
INSERT INTO dog VALUES(dog_seq.nextval,'김희정',0,'hj.jpg','한국',160,5000,'으휴',0)
COMMIT