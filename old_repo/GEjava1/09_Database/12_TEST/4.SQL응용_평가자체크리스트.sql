-- 다음 요구사항의 procedure 를 작성하세요

-- t_emp2 테이블의 사원들중 특정 직위(post) 의 사원들의 급여(pay) 의
-- 인상예상분을 출력하는 procedure 를 작성합니다

-- procedure명: inc_pay
-- 입력: (직위, 인상분) 
--     인상분은 0.0 이상. ex: 0.1 이면 10% 인상
-- 출력내용: "이름", "직위", "인상후급여" 

-- 실행 예)
-- SQL> EXEC inc_pay('과장', 0.15);
-- 천만득 과장 64400000
-- 유관순 과장 58650000
-- 최일도 과장 57500000
-- 이윤나 과장 56350000

-- ↓ procedure 를 작성하세요

CREATE OR REPLACE PROCEDURE inc_pay(
	v_post IN t_emp2.post%TYPE,
	v_inc IN NUMBER
)
IS
	CURSOR c_emp
	IS
		SELECT name, post, pay * (1 + v_inc) "인상분"
		FROM t_emp2
		WHERE post = v_post
		ORDER BY "인상분" DESC;
BEGIN
	FOR r_emp IN c_emp
	LOOP
		DBMS_OUTPUT.PUT_LINE(r_emp.name || ' ' || r_emp.post || ' ' || r_emp.인상분);
	END LOOP;	
END;
/



































