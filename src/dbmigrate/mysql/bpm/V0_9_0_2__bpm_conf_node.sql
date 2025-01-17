
CREATE TABLE BPM_CONF_NODE(
	ID BIGINT auto_increment,
	CODE VARCHAR(200),
	NAME VARCHAR(200),
	TYPE VARCHAR(200),
	CONF_USER INT,
	CONF_LISTENER INT,
	CONF_RULE INT,
	CONF_FORM INT,
	CONF_OPERATION INT,
	CONF_NOTICE INT,
	PRIORITY INT,
	CONF_BASE_ID BIGINT,
        CONSTRAINT PK_BPM_CONF_NODE PRIMARY KEY(ID),
        CONSTRAINT FK_BPM_CONF_NODE_CONF_BASE FOREIGN KEY(CONF_BASE_ID) REFERENCES BPM_CONF_BASE(ID)
) ENGINE=INNODB CHARSET=UTF8;

