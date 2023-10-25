-- ###########################################################
-- (1) INITCAP 함수
-- 첫글자만 대문자로 출력하고 나머지는 전부 소문자로 출력하는 함수
-- 문법: INITCAP (문자열 또는 칼럼명)

SELECT 'pretty girl', INITCAP('pretty girl') 
FROM dual;

-- #4102
SELECT INITCAP(id) "ID"
FROM t_student WHERE deptno1 = 201;

--###########################################################
-- (2) LOWER 함수
-- 입력되는 값을 전부 소문자로 변경하여 출력
-- 문법: LOWER(문자열 또는 칼럼명)

-- (3) UPPER 함수
-- 문법: UPPER(문자열 또는 칼럼명)
-- 입력되는 값을 전부 대문자로 변경하여 출력

-- #4103 
-- t_student 테이블 : 1전공(deptno1) 이 201번인 학생들의 
-- ID를 이름과 함께 소문자, 대문자로 출력 / upper() 사용

SELECT name 이름, id,
	lower(id) 소문자, upper(id) 대문자
FROM t_student WHERE deptno1 = 201;

-- ###########################################################
-- (4) LENGTH / LENGTHB 함수
-- 입력된 문자열의 길이(바이트수)를 계산해주는 함수

-- 문법: LENGTH(문자열 또는 컬럼명) / LENGTHB(문자열 또는 컬럼명)

-- #4104
-- t_student 테이블 : 
-- ID가 9글자 이상인 학생들의 
-- 이름과 ID 와 글자수 출력 / length() 사용

SELECT name 이름, ID, length(id) 글자수
FROM t_student
WHERE LENGTH(id) >= 9  -- 단일행함수는 WHERE 조건절에서 사용 가능
;

-- #4015
SELECT name 이름, length(name) 문자개수, LENGTHB(name) 바이트
FROM t_student WHERE deptno1 = 201;

-- ###########################################################
-- (5) CONCAT 함수 ( || 연산자와 동일 )
-- 문법 : CONCAT ('문자열1', '문자열2')

-- #4106
-- t_professor 테이블 :  101번 학과 (deptno) 의 교수들의 이름(name)과 직급(position)을 
-- 하나의 컬럼으로 출력하세요.  컬럼명은 "교수님명단" / concat() 사용 

SELECT concat(name, POSITION) "교수님명단",  name || POSITION, concat(concat('a', 'b'), 'c')
FROM t_professor
WHERE deptno = 101;

-- s###########################################################
-- (6) SUBSTR 함수 
-- 구문: SUBSTR( ‘문자열’ 또는 컬럼명,   시작위치,  추출할 글자수 )
-- 문자열에서 특정 길이의 문자를 추출할 때 사용하는 함수
-- 시작위치, 음수 가능.
-- ★ 시작 인덱스가 1부터 시작한다 (오라클의 문자열 인덱스는 1부터 시작) 

-- SUBSTR 사용예
SELECT substr('ABCDE', 2, 3) FROM dual;
SELECT substr('ABCDE', 20, 3) FROM dual; -- NULL (에러 아니다)
SELECT substr('ABCDE', 4, 2) FROM dual;
SELECT substr('ABCDE', -2, 2) FROM dual;  -- DE

-- #4107
SELECT name, substr(jumin, 1, 6) "생년월일"
FROM t_student WHERE deptno1 = 101;

-- 실습
-- #4018
SELECT NAME , SUBSTR(JUMIN, 1, 6) "생년월일" 
FROM T_STUDENT 
WHERE SUBSTR(JUMIN, 3, 2) = '08'
;

-- #4019
SELECT name, jumin
FROM T_STUDENT WHERE GRADE = 4 AND SUBSTR(JUMIN, 7, 1) = 2

--###########################################################
-- (8) INSTR 함수
-- 주어진 문자열이나 칼럼에서 특정 글자의 위치를 찾아주는 함수

-- 문법: INSTR('문자열', 찾는문자열, 시작위치, 몇번째등장?);

-- INSTR 사용예
SELECT INSTR('A*B*C*', '*', 1, 1) FROM dual;  -- 2
SELECT INSTR('A*B*C*', '*') FROM dual;
SELECT INSTR('A*B*C*', '*', 1, 2) FROM dual;  -- 4
SELECT INSTR('A*B*C*', '*', 3, 2) FROM dual;  -- 6
SELECT INSTR('A*B*C*', '*', -4, 1) FROM dual;  -- 2 음수위치부터 찾기 시작하면 음의 방향으로 검색 진행
SELECT INSTR('A*B*C*', '*', -4, 2) FROM dual;  -- 0  못찾으면 0 리턴
SELECT INSTR('A*B*C*', '*', -2, 2) FROM dual;  -- 2

-- #4110
SELECT name, tel, instr(tel, ')', 1, 1) "위치"
FROM t_student WHERE deptno1 = 101;

-- [실습] #4111
-- t_student 테이블 : 1전공이 101 인 학생의 이름과 전화번호, 지역번호를 출력하세요. 
-- 지역번호는 숫자만!  / substr(), instr() 사용

 SELECT name, tel, substr(tel, 1, instr(tel, ')') -1) AS 지역번호
 FROM t_student 
 WHERE deptno1 = 101;

-- ###########################################################
-- (9) LPAD 함수
-- (10) RPAD 함수

-- 문법: LPAD('문자열', 자릿수, 채움문자)

-- LPAD/RPAD 사용예
SELECT
	'abcd',
	LPAD('abcd', 10, '#-') LPAD함수,
	RPAD('abcd', 10, '#-') RPAD함수	
FROM dual;

-- #4112
SELECT id, LPAD(id, 10, '$') LPAD예제, LPAD(id, 10, ' ') 
FROM t_student
WHERE deptno1 = 101;

-- [실습] #4113
-- t_dept2 테이블 :  부서명 (dname) 을 다음과 같이 결과가 나오도록 쿼리 작성
-- 총 10글자로 출력하되, 좌측 빈자리는 숫자로 채우기.
-- 한글 한글자를 2글자 취급함

SELECT 
	LPAD(dname, 10, '1234567890') LPAD연습 
FROM 
	t_dept2;

-- ###########################################################
-- LTRIM() 함수 RTRIM() 함수

-- LTRIM/RTRIM/TRIM 사용예
SELECT
	'   슈퍼슈퍼슈가맨   ',
	LTRIM('   슈퍼슈퍼슈가맨   ') LTRIM,
	RTRIM('   슈퍼슈퍼슈가맨   ') RTRIM,
	TRIM('   슈퍼슈퍼슈가맨   ') TRIM
FROM dual;

SELECT
	LTRIM('슈퍼슈퍼슈가맨', '슈퍼') LTRIM
FROM dual;

-- #4117
--  p_dept2 테이블에서 부서명(dname) 을 출력하되 오른쪽 끝에 ‘부’ 라는 글자는 제거하고 출력하세요.

SELECT RTRIM(dname, '부') RTRIM
FROM t_dept2;


-- ###########################################################
-- REPLACE() 함수 
-- 문법: REPLACE('문자열', '문자1', '문자2');
-- ‘문자열’ 에서 ‘문자1’ 이 있으면 ‘문자2’ 로 치환.

-- REPLACE 사용예
SELECT REPLACE('슈퍼맨 슈퍼걸', '슈퍼', '파워') REPLACE
FROM dual;

SELECT 'ab cd ef', 
	REPLACE('ab cd ef', ' ', '')
FROM dual;

-- #4118 
-- t_student 테이블에서 102번 학과(deptno1) 의 학생들의 이름을 출력하되 
-- 성 부분은 ‘#’  으로 표시되게 출력하세요 / replace() , substr()사용

SELECT REPLACE (name, SUBSTR(name, 1, 1), '#') "학생"
FROM T_STUDENT WHERE DEPTNO1 = 102;

SELECT REPLACE ('우영우', SUBSTR('우영우', 1, 1), '#') "학생"
FROM T_STUDENT WHERE DEPTNO1 = 102;

SELECT '#' || substr('우영우', 2)
FROM dual;

-- [실습] #4121
-- t_student 테이블에서 다음 과 같이 1전공(deptno1) 이 102번인 학생들의 
-- 이름(name) 과 전화번호(tel), 
-- 전화번호에서 국번 부분만 ‘#’ 처리하여 출력하세요.  
-- 단 모든 국번은 3자리로 간주합니다.
-- 힌트) replace() / substr() / instr() 사용

SELECT name, tel, 
   REPLACE(tel, SUBSTR(tel, INSTR(tel, ')')+1 , 3), '###') AS 전화번호
FROM T_STUDENT
WHERE DEPTNO1 = 102
;

