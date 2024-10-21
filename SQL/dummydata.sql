
--kinder 더미
INSERT INTO kinder (kinderCode, kindername, addr, establish) VALUES ('K001', '꿈나무 어린이집', '서울특별시 강남구', 2005);
INSERT INTO kinder (kinderCode, kindername, addr, establish) VALUES ('K002', '행복 유치원', '서울특별시 송파구', 2010);
INSERT INTO kinder (kinderCode, kindername, addr, establish) VALUES ('K003', '미래 어린이집', '서울특별시 서초구', 2015);

-- 10월 첫째 주 평일 (10월 1일 ~ 10월 5일)
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, 'K001', 1, '오트밀과 과일', '국내산', TO_DATE('2024-10-01', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, 'K001', 2, '김밥과 미역국', '국내산', TO_DATE('2024-10-02', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, 'K002', 1, '샌드위치와 우유', '국내산', TO_DATE('2024-10-03', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, 'K003', 2, '불고기 덮밥', '국내산', TO_DATE('2024-10-04', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, 'K002', 1, '떡국과 김치', '국내산', TO_DATE('2024-10-05', 'YYYY-MM-DD'));

-- 11월 첫째 주 평일 (11월 1일 ~ 11월 5일)
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, 'K001', 1, '카레라이스', '국내산', TO_DATE('2024-11-01', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, 'K002', 2, '된장찌개와 밥', '국내산', TO_DATE('2024-11-02', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, 'K003', 1, '치킨과 샐러드', '국내산', TO_DATE('2024-11-03', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, 'K002', 2, '잡채와 밥', '국내산', TO_DATE('2024-11-04', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, 'K001', 1, '피자와 스프', '국내산', TO_DATE('2024-11-05', 'YYYY-MM-DD'));

INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K002', TO_DATE('2024-10-22', 'YYYY-MM-DD'), 'Lesson Plan 1 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K001', TO_DATE('2024-11-06', 'YYYY-MM-DD'), 'Lesson Plan 2 for K001');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-11-19', 'YYYY-MM-DD'), 'Lesson Plan 3 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K002', TO_DATE('2024-11-15', 'YYYY-MM-DD'), 'Lesson Plan 4 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-10-31', 'YYYY-MM-DD'), 'Lesson Plan 5 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K001', TO_DATE('2024-10-09', 'YYYY-MM-DD'), 'Lesson Plan 6 for K001');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K002', TO_DATE('2024-10-01', 'YYYY-MM-DD'), 'Lesson Plan 7 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K002', TO_DATE('2024-11-21', 'YYYY-MM-DD'), 'Lesson Plan 8 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K002', TO_DATE('2024-11-25', 'YYYY-MM-DD'), 'Lesson Plan 9 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K001', TO_DATE('2024-11-23', 'YYYY-MM-DD'), 'Lesson Plan 10 for K001');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-10-05', 'YYYY-MM-DD'), 'Lesson Plan 11 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-10-05', 'YYYY-MM-DD'), 'Lesson Plan 12 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-11-12', 'YYYY-MM-DD'), 'Lesson Plan 13 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K001', TO_DATE('2024-11-25', 'YYYY-MM-DD'), 'Lesson Plan 14 for K001');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-11-04', 'YYYY-MM-DD'), 'Lesson Plan 15 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K001', TO_DATE('2024-10-24', 'YYYY-MM-DD'), 'Lesson Plan 16 for K001');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-11-12', 'YYYY-MM-DD'), 'Lesson Plan 17 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K001', TO_DATE('2024-10-13', 'YYYY-MM-DD'), 'Lesson Plan 18 for K001');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K001', TO_DATE('2024-11-10', 'YYYY-MM-DD'), 'Lesson Plan 19 for K001');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-10-29', 'YYYY-MM-DD'), 'Lesson Plan 20 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-11-05', 'YYYY-MM-DD'), 'Lesson Plan 21 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K002', TO_DATE('2024-10-31', 'YYYY-MM-DD'), 'Lesson Plan 22 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K002', TO_DATE('2024-10-01', 'YYYY-MM-DD'), 'Lesson Plan 23 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K002', TO_DATE('2024-10-12', 'YYYY-MM-DD'), 'Lesson Plan 24 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-11-16', 'YYYY-MM-DD'), 'Lesson Plan 25 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-10-25', 'YYYY-MM-DD'), 'Lesson Plan 26 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K001', TO_DATE('2024-11-14', 'YYYY-MM-DD'), 'Lesson Plan 27 for K001');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-10-28', 'YYYY-MM-DD'), 'Lesson Plan 28 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K002', TO_DATE('2024-10-26', 'YYYY-MM-DD'), 'Lesson Plan 29 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, 'K003', TO_DATE('2024-10-08', 'YYYY-MM-DD'), 'Lesson Plan 30 for K003');


INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-01-10', 'YYYY-MM-DD'), 'Notice 1');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-01-15', 'YYYY-MM-DD'), 'Notice 2');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-01-20', 'YYYY-MM-DD'), 'Notice 3');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-02-01', 'YYYY-MM-DD'), 'Notice 4');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-02-05', 'YYYY-MM-DD'), 'Notice 5');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-02-10', 'YYYY-MM-DD'), 'Notice 6');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-02-15', 'YYYY-MM-DD'), 'Notice 7');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-02-20', 'YYYY-MM-DD'), 'Notice 8');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-03-01', 'YYYY-MM-DD'), 'Notice 9');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-03-05', 'YYYY-MM-DD'), 'Notice 10');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 'Notice 11');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-03-15', 'YYYY-MM-DD'), 'Notice 12');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-03-20', 'YYYY-MM-DD'), 'Notice 13');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-03-25', 'YYYY-MM-DD'), 'Notice 14');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-04-01', 'YYYY-MM-DD'), 'Notice 15');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-04-05', 'YYYY-MM-DD'), 'Notice 16');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-04-10', 'YYYY-MM-DD'), 'Notice 17');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-04-15', 'YYYY-MM-DD'), 'Notice 18');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-04-20', 'YYYY-MM-DD'), 'Notice 19');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-04-25', 'YYYY-MM-DD'), 'Notice 20');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, 'K001', TO_DATE('2023-05-01', 'YYYY-MM-DD'), 'Notice 21');




SELECT * FROM NLS_DATABASE_PARAMETERS WHERE PARAMETER = 'NLS_CHARACTERSET';

SELECT * FROM kinder WHERE TRIM(kindercode) = 'K001';

commit;
