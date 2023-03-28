
--console.log(1 + '1')   -- '11'

-- 묵시적 형변환 (자동 형변환)
SELECT 1 + '1' FROM dual;

SELECT 1 + to_number('1') FROM dual;
-- 묵시적 형변환은 편한것 같지만, 
-- 튜닝에서 뜻하지 않은 성능저하를 가져올수 있다.

SELECT 1 + 'A' FROM dual; -- 에러

-- 명시적 형변환 함수들..

-- TO_CHAR 함수 (날짜 -> 문자)

SELECT
	SYSDATE,
	TO_CHAR(SYSDATE, 'YYYY') 연도4자리,
	TO_CHAR(SYSDATE, 'YY') 연도2자리,
	TO_CHAR(SYSDATE, 'YEAR') 연도영문
FROM dual;

SELECT
	TO_CHAR(SYSDATE, 'MM') 월2자리,
	TO_CHAR(SYSDATE, 'MON') 월3자리,
	TO_CHAR(SYSDATE, 'MONTH') 월전체,
	TO_CHAR(SYSDATE, 'month') 월전체,
	TO_CHAR(SYSDATE, 'Month') 월전체,
	TO_CHAR(SYSDATE, 'Month', 'NLS_DATE_LANGUAGE=KOREAN') 월전체
FROM dual;

SELECT
	TO_CHAR(SYSDATE, 'DD') 일숫자2자리,
	TO_CHAR(SYSDATE, 'DDTH') 몇번째날,
	TO_CHAR(SYSDATE, 'DAY') 요일,
	TO_CHAR(SYSDATE, 'Dy') 요일앞자리
FROM dual;

SELECT 
	TO_CHAR(SYSDATE, 'HH24') 시24hr,
	TO_CHAR(SYSDATE, 'HH')  시12hr,
	TO_CHAR(SYSDATE, 'MI') 분,
	TO_CHAR(SYSDATE, 'SS') 초
FROM dual;

-- #4301
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') 날짜
FROM dual;

SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일" HH24"시"MI"분"SS"초"') 날짜
FROM dual;

-- #4302
-- 실습
-- t_student 테이블의 생일(birthday) 이 3월인 학생의 이름(name) 과 생일(birthday) 를 
-- 다음과 같은 형식으로 출력하세요 (TO_CHAR 사용)

SELECT name, to_char(birthday, 'YYYY-MM-DD') 생일
FROM T_STUDENT 
WHERE to_char(birthday, 'MM') = '03';
SELECT * FROM T_STUDENT;
-- ################################################3
-- TO_CHAR() 함수  - 숫자를 문자로 변환

SELECT 
	1234,
	TO_char(1234),
	TO_char(1234, '99999') "9하나당1자리",
	TO_char(1234, '099999') "빈자리0으로",
	TO_char(1234, '$9999') "빈자리$로",
	TO_char(1234.1278, '9999.99') "소숫점이하 두자리",
	TO_char(1234, '99,999') "천단위 구분기호"
FROM dual;

-- #4303
-- t_professor 테이블에서 101번 학과 교수들의 이름(name), 연봉(pay) 를 출력하세요,
-- 단, 연봉은 (pay * 12) + bonus로 계산하고 천단위 구분기호로 표시하세요.
-- nvl / to_char() 사용
SELECT name 이름 , TO_CHAR((NVL2(BONUS, PAY * 12 +BONUS , PAY*12)),'99,999') 연봉 
FROM T_PROFESSOR WHERE deptno = 101;

-- ########################################################
-- to_number() 함수 :  문자 -> 숫자로 변환

SELECT '123.44', to_number('123.44') FROM dual

-- ####################################################
-- to_date() 함수 : 문자 -> 날짜로 변환

SELECT
	TO_DATE('2022-08-31', 'YYYY-MM-DD') "to_date"
FROM dual;

--#4304
--t_professor 테이블에서 2000년 이전에 입사한 교수명과 입사일,
--현재 연봉과 10% 인상 후 연봉을 출력하세요.
--연봉은 보너스(bonus)를 제외한 pay * 12 로 계산하고
--연봉과 인상후 연봉은 천단위 구분 기호를 추가하여 출력하세요

SELECT 
	NAME , 
	TO_CHAR(HIREDATE , 'YYYY-MM-DD') AS 입사일, 
	TO_CHAR((pay*12), '99,999')  AS 연봉, 
	TO_CHAR(((pay*12)) * 1.1, '99,999')  AS 인상후
FROM T_PROFESSOR 
WHERE to_char(hiredate, 'YYYY') < '2000';
;





