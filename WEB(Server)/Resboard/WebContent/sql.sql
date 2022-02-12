CREATE TABLE MEM(
   ID VARCHAR2(30),
   PW VARCHAR2(30),
   NICK VARCHAR2(30),
   CONSTRAINT PK_MEM PRIMARY KEY(ID)   
)

INSERT INTO MEM VALUES('cs222','12345','���2');
INSERT INTO MEM VALUES('kakaozzang','12345','���̾�����');
INSERT INTO MEM VALUES('pg12345','12345','���̸����α�');
INSERT INTO MEM VALUES('pg54321','12345','�α������ΰ�');
INSERT INTO MEM VALUES('heon','12345','����Ŵ');

select * from mem;

CREATE TABLE BOARD(
   NUM NUMBER(5),
   NAME VARCHAR2(100),
   WRITER VARCHAR2(30),
   LOCATION VARCHAR2(50),
   CONTENT VARCHAR2(500),
   VIEWS NUMBER(5),
   CONSTRAINT PK_BOARD PRIMARY KEY(NUM),
   CONSTRAINT FK_WRITER FOREIGN KEY(WRITER) REFERENCES MEM(ID) ON DELETE CASCADE
)



CREATE SEQUENCE BOARD_SEQ
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,'���� ���� ���� 1ź','cs222','���� �ֹ�ܹ�' ,'�ν�Ÿ������ ������ �ܹ���',0);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,'�α��� ī������ 1','pg12345','���� ����ġ' ,'�����⵵ �ѳ� ���� �����в��� ������ ģ���ϼż� ����� ���Ҿ��',0);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,'���� ���� ���� 2ź','cs222','���� ����ġ�����' ,'�λ� ����!! �߱���� Ƣ���� ��¥ �ż��迡��',0);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,'���� ���� ���� 3ź','cs222','���� �Դ���' ,'���ְ� �����⵵ ���Ƽ� ���� ���� �ȴ�ϴ�!',0);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,'�α��� ī������ 2','pg12345','���� ����' ,'���׸�� ������',0);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,'�α��� �ΰ��� ī������ 1','pg54321','���� Ƽ��' ,'�λ� ��ũƼ!',0);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,'���� ���� ���� 4ź','cs222','���� ����ī��' ,'���� ������ ������ ���� ��� ����',0);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,'���̾� ���ְ� ���� ���� ����','kakaozzang','���� ���̱���' ,'���� ȥ�� �ϱ� ���� �������',0);


CREATE TABLE REPLY(
   NUM NUMBER(5),
   BOARDNUM NUMBER(5),
   CONTENT VARCHAR2(500),
   WRITER VARCHAR2(30),
   CONSTRAINT PK_REPLY PRIMARY KEY(NUM),
   CONSTRAINT FK_BOARDNUM FOREIGN KEY(BOARDNUM) REFERENCES BOARD(NUM) ON DELETE CASCADE,
   CONSTRAINT FK_WRITER_REPLY FOREIGN KEY(WRITER) REFERENCES MEM(ID) ON DELETE CASCADE
)

CREATE SEQUENCE REPLY_SEQ
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

INSERT INTO REPLY VALUES(REPLY_SEQ.NEXTVAL, 1,'���ְڳ׿� ���� ������ ������Կ�','pg12345');
INSERT INTO REPLY VALUES(REPLY_SEQ.NEXTVAL, 1,'���־��� �޴��� ��õ���ּ���','kakaozzang');

select * from REPLY;







