-- ────────────────────────────────────────────────────────────
-- #05
-- 테이블: t_student, t_professor, t_department
-- 질의사항: 
--      '모든' 교수님 목록을 출력하려 합니다.
--
-- 출력컬럼 : [지도교수번호][지도교수이름][지도교수학과명][지도학생수]
-- 정렬: 지도학생수가 많은 순으로 (내림차순), 그리고 지도교수이름 순 (오름차순)
-- 출력예시: https://docs.google.com/presentation/d/1yRKE20j6qwZBUjeOMoYzgNIBLJkGtzs6gQJNjQXKypQ/edit#slide=id.g14b31bc663c_0_81
-- ↓ 쿼리를 작성하세요
	
SELECT p.profno "지도교수번호", p.name "지도교수이름", d.dname "지도교수학과명", count(s.name) "지도학생수"
FROM t_professor p 
	LEFT OUTER JOIN t_student s ON p.profno = s.profno
	JOIN t_department d ON p.deptno = d.DEPTNO 
GROUP BY p.profno, p.name, d.dname
ORDER BY "지도학생수" DESC, "지도교수이름" ASC
;

-- subquery 로 하면?
SELECT  p.profno "지도교수번호", p.name "지도교수이름", d.dname "지도교수학과명",
		(SELECT count(*) FROM t_student WHERE profno = p.profno) "지도학생수"
FROM t_professor p, t_department d 
WHERE p.deptno = d.deptno  
ORDER BY "지도학생수" DESC, "지도교수이름" ASC
;




-- ────────────────────────────────────────────────────────────
-- #06
-- 테이블: t_emp2, t_dept2
-- 질의사항: 
--     지역(AREA)별로 근무하는 직원들의 직원수와 직원들의 평균나이를 계산하세요
--     나이는 '현재날짜' 기준으로 계산합니다
--     평균나이는 소숫점 1자리까지 출력
-- 출력컬럼: [지역명][직원수][평균나이]
-- 정렬: 평균나이 내림차순
-- 출력예시: https://docs.google.com/presentation/d/1yRKE20j6qwZBUjeOMoYzgNIBLJkGtzs6gQJNjQXKypQ/edit#slide=id.g14b31bc663c_0_74
-- ↓ 쿼리를 작성하세요

SELECT d.area "지역명", count(e.NAME) "직원수", 
		round(avg(to_char(sysdate, 'YYYY') - to_char(e.BIRTHDAY, 'YYYY') + 1), 1) "평균나이" 
FROM t_emp2 e, t_dept2 d
WHERE e.deptno = d.dcode
GROUP BY d.area
ORDER BY "평균나이" DESC
;







-- ────────────────────────────────────────────────────────────
-- #07
-- 테이블: t_student, t_department, t_exam01, t_credit
-- 질의사항: 
--   학과별로 이번 시험 등급자 분포를 알아보고자 합니다
-- 출력컬럼: [학과명][등급][학생수] 
-- 정렬: 학과명 오름차순, 등급 오름차순
-- 출력예시: https://docs.google.com/presentation/d/1yRKE20j6qwZBUjeOMoYzgNIBLJkGtzs6gQJNjQXKypQ/edit#slide=id.g14b31bc663c_0_57  
-- ↓ 쿼리를 작성하세요

SELECT d.dname "학과명", c.grade "등급", count(e.TOTAL) "학생수" 
FROM t_student s, T_EXAM01 e, T_CREDIT c, T_DEPARTMENT d
WHERE s.studno = e.studno 
	AND e.total BETWEEN c.MIN_POINT AND c.MAX_POINT
	AND s.deptno1 = d.DEPTNO 
GROUP BY d.dname, c.grade
ORDER BY "학과명" ASC, "등급" ASC
;

















