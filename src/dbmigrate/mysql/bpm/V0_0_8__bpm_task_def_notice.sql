
CREATE TABLE BPM_TASK_DEF_NOTICE(
	ID BIGINT auto_increment,
	TASK_DEFINITION_KEY VARCHAR(200),
	TYPE INTEGER,
	RECEIVER VARCHAR(200),
	DUE_DATE VARCHAR(50),
	TEMPLATE_ID BIGINT,
	PROCESS_ID BIGINT,
        CONSTRAINT PK_BPM_TASK_DEF_NOTICE PRIMARY KEY(ID),
        CONSTRAINT FK_BPM_TASK_DEF_NOTICE_PROCESS FOREIGN KEY(PROCESS_ID) REFERENCES BPM_PROCESS(ID),
        CONSTRAINT FK_BPM_TASK_DEF_NOTICE_TEMPLATE FOREIGN KEY(TEMPLATE_ID) REFERENCES BPM_MAIL_TEMPLATE(ID)
) ENGINE=INNODB CHARSET=UTF8;

