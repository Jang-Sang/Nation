
-- #6203
-- t_student 테이블과 t_exam01 시험성적 테이블, t_credit 학점 테이블을 조회하여 
-- 학생들의 이름과 점수와 학점을 출력하세요

SELECT * FROM t_exam01;
SELECT * FROM T_CREDIT;

-- #6203
-- ORACLE
SELECT s.name "학생이름", e.total "점수", h.grade "학점"
FROM t_student s, t_exam01 e, t_credit h 
WHERE s.studno = e.STUDNO AND e.total BETWEEN h.MIN_POINT  AND h.MAX_POINT 
;

-- ANSI
SELECT s.name "학생이름", e.total "점수", h.grade "학점"
FROM t_student s
	JOIN t_exam01 e ON s.studno = e.STUDNO
	JOIN t_credit h ON e.total BETWEEN h.MIN_POINT  AND h.MAX_POINT
;

-- #6204
-- t_customer 와 t_gift 테이블 join : 
--자기 포인트(c_point) 보다 낮은 포인트의 상품 중 
--한가지를 선택할수 있다고 할때 
--'산악용자전거'를 선택할 수 있는 
--고객명(c_name)과 포인트(c_point), 
--상품명(g_name)을 출력하세요

SELECT * FROM T_CUSTOMER; 
SELECT * FROM t_gift;

-- ORACLE
SELECT c.c_name "고객명", c.c_point "POINT", g.g_name "경품명"
FROM t_customer c, t_gift g
WHERE 
	g.g_start <= c.c_point
	AND 
	g.g_name = '산악용자전거'
;
-- ANSI
SELECT c.c_name "고객명", c.c_point "POINT", g.g_name "경품명"
FROM t_customer c 
	JOIN t_gift g ON g.g_start <= c.c_point
WHERE 
	g.g_name = '산악용자전거'
;

-- #6205
--t_emp2, t_post 테이블 join : 
--사원들의 이름(name)과 나이, 현재직급(post), 예상직급을 출력하세요. 
--예상직급은 나이로 계산하며 해당 나이가 받아야 하는 직급을 의미합니다. 
--나이는 오늘(SYSDATE)을 기준으로 하되 소수점 이하는 절삭하여 계산하세요
--t_emp2 의 직급(post) 은 null 허용함에 주의
--** 나이계산은 어떻게?  :  (현재연도 - 생년월일연도) + 1, 
--	SYSDATE, TO_CHAR() 사용

SELECT * FROM t_emp2;
SELECT * FROM t_post;

SELECT 
	e.name "이름",
	(TO_CHAR(SYSDATE,'YYYY')- TO_CHAR(e.BIRTHDAY,'YYYY') + 1) "현재나이",
	NVL(e.post, ' ') "현재직급",
	p.post "예상직급"
FROM t_emp2 e, t_post p
WHERE 
	(TO_CHAR(SYSDATE,'YYYY')- TO_CHAR(e.BIRTHDAY,'YYYY') + 1)  -- 직원(e)의 현재 나이 
	BETWEEN p.s_age AND p.e_age;

-- #6210
--t_professor 테이블 : 교수번호, 교수이름, 입사일, 
--그리고 자신보다 입사일 빠른 사람의 인원수를 출력하세요, 
--단 자신보다 입사일이 빠른 사람수를 오름차순으로 출력하세요
--hint: left outer 사용 
--         / 그룹함수 사용

-- 우선 자신보다 입사일 빠른 사람들을 SELECT

SELECT a.profno "교수번호", a.name "교수명", a.hiredate "입사일", b.name "빨리입사한 교수님", b.hiredate "그분 입사일" 
FROM t_professor a
	LEFT OUTER JOIN t_professor b ON b.HIREDATE < a.hiredate
;

-- GROUP BY
SELECT 
	a.profno "교수번호", a.name "교수명", 
	TO_CHAR(a.hiredate, 'YYYY-MM-DD') "입사일",
	count(b.hiredate) "빠른사람"
FROM t_professor a
	LEFT OUTER JOIN t_professor b ON b.HIREDATE < a.hiredate
GROUP BY 
	a.profno, a.name, a.hiredate
ORDER BY "빠른사람"
;







