
CREATE TABLE BPM_CATEGORY(
	ID BIGINT auto_increment,
	NAME VARCHAR(200),
	PRIORITY INTEGER,
        CONSTRAINT PK_BPM_CATEGORY PRIMARY KEY(ID)
) ENGINE=INNODB CHARSET=UTF8;

