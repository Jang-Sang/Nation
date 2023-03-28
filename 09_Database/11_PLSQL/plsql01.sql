-- PL/SQL  :  Procedural Language / SQL
-- 오라클에서 제공하는 프로그래밍 언어
-- 기존 SQL 만으로는 데이터 조작할때 불편했던(?부족한) 부분을
-- PL/SQL 과 함께 활용하여 효과적으로 데이터 다룰수있다
-- 일반적인 절차적 프로그래밍 언어 기능 가짐: 변수, 제어문.. 등..

-- ─────────────────────────────────────────────────────────────────────────────────
-- PL/SQL 은 dbeaver 에서 사용 제한.
-- ※ dbeaver 에서는 CTRL+SHIFT+O 를 눌러서 Output 창을 활성화 하고 쿼리 실행하면 됨.
-- ─────────────────────────────────────────────────────────────────────────────────
-- PL/SQL Block 기본구성
--   1) DECLARE (선언부)     :   변수나 상수 선언
--   2) EXECUTABLE (실행부)  :    제어,반복, 함수정의등 로직 정의
--   3) EXCEPTION (예외처리)  :    실행도중 발생된 에러 처리.

-- ─────────────────────────────────────────────────────────────────────────────────


-- PL/SQL 은 기본적으로 처리된 PL/SQL 결과를 화면에 출력하지 않습니다.
-- 결과를 화면에 출력하려면 미리 사전 작업 필요
SET SERVEROUTPUT ON;   -- 화면 출력 기능 활성화 

-- 화면에 출력하기
BEGIN
	DBMS_OUTPUT.PUT_LINE('hello oracle');
END;
/

BEGIN
	DBMS_OUTPUT.PUT_LINE('hello' || ' ' || TO_CHAR(100 + 200));
END;
/


DECLARE  -- 선언부
	v_age  INTEGER;
	v_name VARCHAR(10);
BEGIN    -- 실행부
	SELECT 10 INTO v_age FROM dual;	  -- SELECT 결과를 변수에 대입
	SELECT 'hong' INTO v_name FROM dual;
	DBMS_OUTPUT.PUT_LINE(v_name || ' ' || TO_CHAR(v_age));
END;
/ -- 마지막에 작성된 PL/SQL 블록 실행 (반복 실행 가능)

DECLARE
	v_age INTEGER;
	v_name VARCHAR(10);
BEGIN
	v_age := 48;   -- 대입연산
	v_name := 'John';	
	DBMS_OUTPUT.PUT_LINE(v_name || ' ' || TO_CHAR(v_age));
END;
/

DECLARE
	vno NUMBER(4);
	vname VARCHAR2(10);	
BEGIN
	SELECT empno, ename INTO vno, vname -- SELECT 결과를 두개 변수에 대입
	FROM t_emp
	WHERE empno = 7900;

	DBMS_OUTPUT.PUT_LINE(vno || ' ' || vname);  
END;
/

-- ─────────────────────────────────────────────────────────────────────────────────
/* PL/SQL 블록 작성시 기본규칙과 권장 사항
  문장은 여러줄 겹칠수 있으나, 키워드는 분리 불가.
 식별자는 " ~ " 로 작성
 문자, 날짜 리터럴은 ' ~ ' 로
 주석은 한줄 주석 ,  복수행 주석
 
 일반적인 오라클 함수(단일행함수)는 블럭내에서 사용 가능하나, 그룹함수, DECODE 함수는 SQL에서만 사용 가능.

*/
-- ─────────────────────────────────────────────────────────────────────────────────


-----------------------------------
-- PL/SQL 내에서 SELECT 문장 사용

/* 예제
t_professor 테이블에서 교수번호가 1001번인 교수의 교수번호와 급여를 조회한후
변수에 저장해서 화면에 출력하기
 */

DECLARE 
	v_profno t_professor.profno%TYPE;
	v_pay    t_professor.pay%TYPE;
BEGIN
	SELECT profno, pay INTO v_profno, v_pay
	FROM t_professor
	WHERE profno = 1001;
	DBMS_OUTPUT.PUT_LINE(v_profno || ' 번 교수의 급여는 ' || v_pay || '입니다');
END;
/

-- 입력이 가능하다!
/* 예제2
t_emp2 테이블을 사용하여 사원번호를 입력받아서 사원의 사번과 이름, 생일을 출력하세요
*/

DECLARE
	v_empno t_emp2.empno%TYPE;
	v_name t_emp2.name%TYPE;
	v_birth t_emp2.birthday%TYPE;
BEGIN
	SELECT empno, name, BIRTHDAY 
	INTO v_empno, v_name, v_birth
	FROM t_emp2
	WHERE empno = '&empno';  -- 사용자에게 입력받아서 변수에 할당. &기호 사용

	DBMS_OUTPUT.PUT_LINE(v_empno || ' ' || v_name || ' ' || v_birth);
END;
/

SELECT * FROM t_professor;

/* 예제  
 * 교수번호를 입력받은 수 t_professor 테이블을 조회하여 해당 교수의
 * 교수번호와 교수이름, 학과번호, 입사일을 출력하세요
 */

DECLARE
	v_profno   t_professor.profno%TYPE;
	v_name   t_professor.name%TYPE;
	v_deptno  t_professor.deptno%TYPE;
	v_hdate   t_professor.hiredate%TYPE;
BEGIN
	SELECT profno, name, deptno, hiredate
	INTO v_profno, v_name, v_deptno, v_hdate
	FROM t_professor
	WHERE profno = '&교수번호';

	DBMS_OUTPUT.PUT_LINE(v_profno || ' ' || v_name || ' ' || v_deptno || v_hdate);
END;
/

--------------------------------------------------------------------------------

-- PL/SQL 에서 DML 사용하기
-- INSERT / UPDATE / DELETE

-- 1) INSERT 예제1
--  우선 아래 테이블 + 시퀀스 생성
CREATE TABLE p1_test(
	no NUMBER,
	name varchar2(10)
);
CREATE SEQUENCE p1_seq;

BEGIN
	INSERT INTO P1_TEST 
	VALUES(p1_seq.nextval, 'AAA');
END;
/

SELECT * FROM p1_test;

COMMIT;


-- 2) INSERT 예제2
CREATE TABLE p1_test2(
	no NUMBER,
	name varchar2(10),
	addr varchar2(10)	
);

-- 이제, 사용자로부터 번호(no) , 이름(name), 주소(addr) 값을 입력 받은 후
-- p1_test2 테이블에 입력하는 PL/SQL 문장 작성

SET VERIFY OFF -- &를 이용한 치환변수의 값변화 표시를 OFF 한다 (기본값 ON)


DECLARE
	v_no NUMBER := '&no';
	v_name varchar2(10) := '&name';
	v_addr varchar2(10) := '&addr';
BEGIN 
	INSERT INTO p1_test2
	VALUES(v_no, v_name, v_addr);
END;
/

-- ───────────────────────────────────────────────────────────────────────
-- 중첩된 PL/SLQ 블럭 사용
-- 프로시저를 작성할 경우 블럭 안에 또 다른 블럭을 중첩으로 포함 가능

-- 아래는 과연 실행될까?

DECLARE
	v_first VARCHAR2(5) := 'Outer';
BEGIN		
	DECLARE
		v_second VARCHAR2(5) := 'Inner';
	BEGIN
		DBMS_OUTPUT.PUT_LINE(v_first);  -- 안쪽 블럭에선 바깥쪽 블럭에서 선언한 변수 사용 가능
		DBMS_OUTPUT.PUT_LINE(v_second);
	END;
	DBMS_OUTPUT.PUT_LINE(v_first);
	DBMS_OUTPUT.PUT_LINE(v_second);  -- 에러 발생!
END;
/










