
CREATE TABLE PARTY_STRUCT_TYPE(
        ID BIGINT auto_increment,
        NAME VARCHAR(50),
	REF VARCHAR(50),
	DIM_ID BIGINT,
	SCOPE_ID VARCHAR(50),
        CONSTRAINT PK_PARTY_STRUCT_TYPE PRIMARY KEY(ID),
        CONSTRAINT FK_PARTY_STRUCT_TYPE_DIM FOREIGN KEY(DIM_ID) REFERENCES PARTY_DIM(ID)
) ENGINE=INNODB CHARSET=UTF8;
