--미림유치원 1ecec08d-0ca8-b044-e053-0a32095ab044

TRUNCATE TABLE Users CASCADE;
TRUNCATE TABLE boards CASCADE ;
TRUNCATE TABLE CHILD CASCADE ;
TRUNCATE TABLE ALBUM CASCADE ;
TRUNCATE TABLE class_teacher CASCADE ;
TRUNCATE TABLE kinderDetail CASCADE ;
TRUNCATE TABLE TT_boards CASCADE ;
TRUNCATE TABLE User_child CASCADE ;
TRUNCATE TABLE TT_comments CASCADE ;
TRUNCATE TABLE kinder_album CASCADE ;
TRUNCATE TABLE notice_letter CASCADE ;
TRUNCATE TABLE lesson_plan_monthly CASCADE ;
TRUNCATE TABLE kinder_community CASCADE ;
TRUNCATE TABLE meal_plan CASCADE ;
TRUNCATE TABLE kinder_introduction CASCADE ;
TRUNCATE TABLE kinder CASCADE ;



INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-22', 'YYYY-MM-DD'), 'Lesson Plan 1 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-06', 'YYYY-MM-DD'), 'Lesson Plan 2 for 1ecec08d-0ca8-b044-e053-0a32095ab044');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-19', 'YYYY-MM-DD'), 'Lesson Plan 3 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-15', 'YYYY-MM-DD'), 'Lesson Plan 4 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-31', 'YYYY-MM-DD'), 'Lesson Plan 5 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-09', 'YYYY-MM-DD'), 'Lesson Plan 6 for 1ecec08d-0ca8-b044-e053-0a32095ab044');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-01', 'YYYY-MM-DD'), 'Lesson Plan 7 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-21', 'YYYY-MM-DD'), 'Lesson Plan 8 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-25', 'YYYY-MM-DD'), 'Lesson Plan 9 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-23', 'YYYY-MM-DD'), 'Lesson Plan 10 for 1ecec08d-0ca8-b044-e053-0a32095ab044');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-05', 'YYYY-MM-DD'), 'Lesson Plan 11 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-05', 'YYYY-MM-DD'), 'Lesson Plan 12 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-12', 'YYYY-MM-DD'), 'Lesson Plan 13 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-25', 'YYYY-MM-DD'), 'Lesson Plan 14 for 1ecec08d-0ca8-b044-e053-0a32095ab044');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-04', 'YYYY-MM-DD'), 'Lesson Plan 15 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-24', 'YYYY-MM-DD'), 'Lesson Plan 16 for 1ecec08d-0ca8-b044-e053-0a32095ab044');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-12', 'YYYY-MM-DD'), 'Lesson Plan 17 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-13', 'YYYY-MM-DD'), 'Lesson Plan 18 for 1ecec08d-0ca8-b044-e053-0a32095ab044');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-10', 'YYYY-MM-DD'), 'Lesson Plan 19 for 1ecec08d-0ca8-b044-e053-0a32095ab044');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-29', 'YYYY-MM-DD'), 'Lesson Plan 20 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-05', 'YYYY-MM-DD'), 'Lesson Plan 21 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-31', 'YYYY-MM-DD'), 'Lesson Plan 22 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-01', 'YYYY-MM-DD'), 'Lesson Plan 23 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-12', 'YYYY-MM-DD'), 'Lesson Plan 24 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-16', 'YYYY-MM-DD'), 'Lesson Plan 25 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-25', 'YYYY-MM-DD'), 'Lesson Plan 26 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-11-14', 'YYYY-MM-DD'), 'Lesson Plan 27 for 1ecec08d-0ca8-b044-e053-0a32095ab044');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-28', 'YYYY-MM-DD'), 'Lesson Plan 28 for K003');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-26', 'YYYY-MM-DD'), 'Lesson Plan 29 for K002');
INSERT INTO lesson_plan_monthly (lessonplan_idx, kinderCode, lesson_date, body) VALUES (LESSON_PLAN_MONTHLY_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2024-10-08', 'YYYY-MM-DD'), 'Lesson Plan 30 for K003');


INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-01-10', 'YYYY-MM-DD'), 'Notice 1');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-01-15', 'YYYY-MM-DD'), 'Notice 2');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-01-20', 'YYYY-MM-DD'), 'Notice 3');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-02-01', 'YYYY-MM-DD'), 'Notice 4');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-02-05', 'YYYY-MM-DD'), 'Notice 5');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-02-10', 'YYYY-MM-DD'), 'Notice 6');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-02-15', 'YYYY-MM-DD'), 'Notice 7');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-02-20', 'YYYY-MM-DD'), 'Notice 8');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-03-01', 'YYYY-MM-DD'), 'Notice 9');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-03-05', 'YYYY-MM-DD'), 'Notice 10');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-03-10', 'YYYY-MM-DD'), 'Notice 11');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-03-15', 'YYYY-MM-DD'), 'Notice 12');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-03-20', 'YYYY-MM-DD'), 'Notice 13');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-03-25', 'YYYY-MM-DD'), 'Notice 14');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-04-01', 'YYYY-MM-DD'), 'Notice 15');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-04-05', 'YYYY-MM-DD'), 'Notice 16');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-04-10', 'YYYY-MM-DD'), 'Notice 17');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-04-15', 'YYYY-MM-DD'), 'Notice 18');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-04-20', 'YYYY-MM-DD'), 'Notice 19');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-04-25', 'YYYY-MM-DD'), 'Notice 20');
INSERT INTO notice_letter (letter_idx, kinderCode, notice_date, body) 
VALUES (notice_letter_seq.NEXTVAL, '1ecec08d-0ca8-b044-e053-0a32095ab044', TO_DATE('2023-05-01', 'YYYY-MM-DD'), 'Notice 21');

INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 된장찌개, 닭갈비, 김치', '국내산', TO_DATE('2024-10-01', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 미역국, 제육볶음, 깍두기', '국내산', TO_DATE('2024-10-02', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 콩나물국, 오징어볶음, 무생채', '국내산', TO_DATE('2024-10-03', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 소고기무국, 고등어조림, 나물', '국내산', TO_DATE('2024-10-04', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 계란국, 떡갈비, 열무김치', '국내산', TO_DATE('2024-10-07', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 생선찌개, 고추장불고기, 김', '국내산', TO_DATE('2024-10-08', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 북어국, 순두부찌개, 파김치', '국내산', TO_DATE('2024-10-09', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 갈비탕, 두부조림, 무나물', '국내산', TO_DATE('2024-10-10', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 콩비지찌개, 고등어구이, 오이무침', '국내산', TO_DATE('2024-10-11', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 육개장, 닭튀김, 참나물무침', '국내산', TO_DATE('2024-10-14', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 된장찌개, 닭갈비, 김치', '국내산', TO_DATE('2024-10-15', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 미역국, 제육볶음, 깍두기', '국내산', TO_DATE('2024-10-16', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 콩나물국, 오징어볶음, 무생채', '국내산', TO_DATE('2024-10-17', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 소고기무국, 고등어조림, 나물', '국내산', TO_DATE('2024-10-18', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 계란국, 떡갈비, 열무김치', '국내산', TO_DATE('2024-10-21', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 생선찌개, 고추장불고기, 김', '국내산', TO_DATE('2024-10-22', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 북어국, 순두부찌개, 파김치', '국내산', TO_DATE('2024-10-23', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 갈비탕, 두부조림, 무나물', '국내산', TO_DATE('2024-10-24', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 콩비지찌개, 고등어구이, 오이무침', '국내산', TO_DATE('2024-10-25', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 육개장, 닭튀김, 참나물무침', '국내산', TO_DATE('2024-10-28', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 된장찌개, 닭갈비, 김치', '국내산', TO_DATE('2024-10-29', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 미역국, 제육볶음, 깍두기', '국내산', TO_DATE('2024-10-30', 'YYYY-MM-DD'));
INSERT INTO meal_plan (meal_idx, kinderCode, kind, meal_info, origin, meal_date) 
VALUES (MEAL_PLAN_SEQ.nextval, '1ecec08d-0ca8-b044-e053-0a32095ab044', 1, '밥, 콩나물국, 오징어볶음, 무생채', '국내산', TO_DATE('2024-10-31', 'YYYY-MM-DD'));

commit;







