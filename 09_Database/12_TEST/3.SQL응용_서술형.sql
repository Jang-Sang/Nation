-- 아래의 요구사항을 검토하여 제시된 데이터베이스를 설계하세요
--
-- [요구사항]
--    a. 학생 은 '학생고유번호(PK)', '학생이름', '나이', '학년', '전공학과번호(FK)' 의 속성을 갖습니다 
--
--      1) '학생이름'은 필수입니다
--      2) '나이' 는 0 이상의 정수입니다. 
--      3) '학년'은 1~4 까지의 숫자값만 갖습니다.
--
--    b. 학과 는 '학과고유번호(PK)', '학과명', '건물동번호' 의 속성을 갖습니다.
--       1) '학과명'은 필수 속성이며 고유해야 합니다.
--       2) '건물동번호' 는  'K301', 'A203', 'B306' 세가지중 하나의 값을 갖습니다
--
-- [문제]
--     a. 위 요구사항을 구현할 물리적 설계 (DDL) 을 작성하세요
--         - 테이블명과 컬럼명은 아래와 같이 작성하세요
--	   b. 위 테이블에 학과 3개와 학생 5명의 데이터를 INSERT 하는 쿼리 (DML) 을 작성하세요 
--
-- [학생테이블 (TEST_STUDENT) ]
--
--	학생고유번호	stu_uid
--	학생이름		stu_name
--	나이			stu_age
--	학년			stu_grade
--	전공학과번호	dept_uid
--
-- [학과테이블 (TEST_DEPARTMENT) ]
--
--	학과고유번호	dept_uid
--	학과명		dept_name
--	건물동번호		dept_build        

-- ↓ DDL 을 작성하세요
DROP TABLE TEST_STUDENT CASCADE CONSTRAINT PURGE;
DROP TABLE TEST_DEPARTMENT CASCADE CONSTRAINT PURGE;

CREATE TABLE TEST_DEPARTMENT(
	dept_uid NUMBER PRIMARY KEY,
	dept_name VARCHAR(10) NOT NULL UNIQUE,
	dept_build VARCHAR(10) CHECK(dept_build IN ('K301', 'A203', 'B306'))
);

CREATE TABLE TEST_STUDENT (
	stu_uid NUMBER PRIMARY KEY,
	stu_name VARCHAR2(20) NOT NULL,
	stu_age INT CHECK(stu_age >= 0),
	stu_grade NUMBER CHECK(stu_grade BETWEEN 1 AND 4),
	stu_deptno NUMBER REFERENCES TEST_DEPARTMENT(dept_uid)
);

-- ↓ DML 을 작성하세요
--학생 5명 ,학과 3개
INSERT INTO TEST_DEPARTMENT VALUES ( 111,'컴퓨터','K301');
INSERT INTO TEST_DEPARTMENT VALUES ( 222,'미용','A203');
INSERT INTO TEST_DEPARTMENT VALUES ( 333,'전자','B306');

INSERT INTO TEST_STUDENT VALUES (123456, '이병헌', 23, 1, 111);
INSERT INTO TEST_STUDENT VALUES (123457, '이효리', 23, 1, 222);
INSERT INTO TEST_STUDENT VALUES (123987, '유재석', 28, 3, 333);
INSERT INTO TEST_STUDENT VALUES (123546 ,'박지훈', 34, 2, 333);
INSERT INTO TEST_STUDENT VALUES (987654 ,'주지훈', 22, 4, 111);
INSERT INTO TEST_STUDENT VALUES (123549 ,'공유', 87, 3,111);
















