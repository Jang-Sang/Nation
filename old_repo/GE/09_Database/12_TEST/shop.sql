DROP TABLE t_user CASCADE CONSTRAINT PURGE;
DROP TABLE t_post CASCADE CONSTRAINT PURGE;
DROP TABLE t_likes CASCADE CONSTRAINT PURGE;
DROP TABLE t_picture CASCADE CONSTRAINT PURGE;
DROP TABLE t_comment CASCADE CONSTRAINT PURGE;
DROP TABLE t_friend CASCADE CONSTRAINT PURGE;

CREATE TABLE t_user(
	user_id VARCHAR2(10) PRIMARY KEY NOT NULL,
	password VARCHAR2(10) NOT NULL
);

CREATE TABLE t_post (
	post_id VARCHAR2(10) PRIMARY KEY NOT NULL,
	user_id VARCHAR2(10) NOT NULL,
	title VARCHAR2(50) NOT NULL,
	content VARCHAR2(100),
	is_public char,
	view_count NUMBER,
	created_at timestamp
);

CREATE TABLE t_likes(
	user_id VARCHAR2(10) NOT NULL,
	post_id VARCHAR2(10) NOT NULL
);

CREATE TABLE t_picture(
	user_id VARCHAR2(10) NOT NULL,
	post_id VARCHAR2(10) NOT NULL,
	file_name VARCHAR2(20) NOT NULL
);

CREATE TABLE t_comment(
	user_id VARCHAR2(10) NOT NULL,
	post_id VARCHAR2(10) NOT NULL,
	created_at timestamp,
	content VARCHAR2(100)
);

CREATE TABLE t_friend(
	sender VARCHAR2(10) NOT NULL,
	reciever VARCHAR2(10) NOT NULL,
	request_id NUMBER PRIMARY NOT NULL,
	approved_at timestamp
);

/* Create Foreign Keys */

ALTER TABLE t_post
	ADD FOREIGN KEY (user_id)
	REFERENCES t_user (user_id)
;


ALTER TABLE t_likes
	ADD FOREIGN KEY (user_id)
	REFERENCES t_post (user_id)
;

ALTER TABLE t_likes
	ADD FOREIGN KEY (post_id)
	REFERENCES t_user (post_id)
;

ALTER TABLE t_picture
	ADD FOREIGN KEY (user_id)
	REFERENCES t_post (user_id)
;

ALTER TABLE t_picture
	ADD FOREIGN KEY (post_id)
	REFERENCES t_user (post_id)
;

ALTER TABLE t_comment
	ADD FOREIGN KEY (user_id)
	REFERENCES t_post (user_id)
;

ALTER TABLE t_comment
	ADD FOREIGN KEY (post_id)
	REFERENCES t_user (post_id)
;


ALTER TABLE t_friend
	ADD FOREIGN KEY (sender)
	REFERENCES t_user (sender)
;


ALTER TABLE t_friend
	ADD FOREIGN KEY (reciever)
	REFERENCES t_user (reciever)
;
