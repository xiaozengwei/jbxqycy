

-------------------------------------------------------------------------------
--  template field
-------------------------------------------------------------------------------
CREATE TABLE TEMPLATE_FIELD(
        ID BIGINT auto_increment,
	NAME VARCHAR(50),
	TYPE VARCHAR(50),
	CONTENT TEXT,
	INFO_ID BIGINT,
        CONSTRAINT PK_TEMPLATE_FIELD PRIMARY KEY(ID),
        CONSTRAINT FK_TEMPLATE_FIELD_INFO FOREIGN KEY(INFO_ID) REFERENCES TEMPLATE_INFO(ID)
) engine=innodb;

