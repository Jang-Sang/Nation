-- PL/SQL 변수
-- 변수는 데이터 임시 저장 영역
-- 저장된 값 조장 가능
-- 저장된 값 반복해서 재사용 가능.

-- 변수 작명]
-- 반드시 문자로 시작
-- 문자, 숫자, 특수문자 포함 가능
-- 변수명 30byte 이하
-- 예약어 포함 불가

-- TYPE 변수 사용

-------------------------------------------
-- 예제1  :  TYPE 변수 사용하여 조회
-- t_emp5 테이블 에서 empno 가 7900 인 사원의 empno, ename, sal 을 조회하여 화면에 출력

-- 일단 테스트용 생성
DROP TABLE t_emp5 CASCADE CONSTRAINT;
CREATE TABLE t_emp5 
AS 
SELECT empno, ename, sal FROM t_emp;

DECLARE
	vno t_emp5.empno%TYPE;
	vname t_emp5.ename%TYPE;
	vsal  t_emp5.sal%TYPE;
BEGIN
	SELECT empno, ename, sal
	INTO vno, vname, vsal
	FROM t_emp5
	WHERE empno=7900;

	DBMS_OUTPUT.PUT_LINE(vno || ' ' || vname || ' ' || vsal);
END;
/

-- ROWTYPE 활용
-- 한개의 레코드 타입을 통째로!

DECLARE
	v_row t_emp5%ROWTYPE;
BEGIN
	SELECT * INTO v_row
	FROM t_emp5
	WHERE empno = 7900;

	DBMS_OUTPUT.PUT_LINE(v_row.empno || ' ' || v_row.ename || ' ' || v_row.sal);
END;
/

-----------------------------------------------------
-- ROWTYPE 변수를 활용한 테이블 -> 테이블 데이터 입력

CREATE TABLE row_test (
	NO NUMBER,
	name varchar2(10),
	hdate DATE
);

CREATE TABLE row_test2
AS
SELECT * FROM row_test;

INSERT INTO row_test VALUES(1, 'AAA', SYSDATE);
INSERT INTO row_test VALUES(2, 'BBB', SYSDATE);
INSERT INTO row_test VALUES(3, 'CCC', SYSDATE);

SELECT * FROM row_test;
SELECT * FROM row_test2;

DECLARE
	v_record row_test%ROWTYPE;
BEGIN
	SELECT * INTO v_record
	FROM row_test
	WHERE NO = 1;

	INSERT INTO row_test2
	VALUES v_record;   -- ROWTYPE 변수로 INSERT
END;
/

-- ---------------------------------
-- ROWTYPE 변수를 활용한 데이터 UPDATE

DECLARE
	v_record row_test%ROWTYPE;
BEGIN
	SELECT * INTO v_record
	FROM row_test
	WHERE NO = 1;
	v_record.name := 'DDD';
	UPDATE row_test2
	SET ROW=v_record    -- ROW 사용하여 
	WHERE NO = 1;
END;
/

COMMIT;





