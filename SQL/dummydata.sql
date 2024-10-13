
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

INSERT INTO users (
    USER_IDX, LOGIN_ID, PASSWORD, USER_EMAIL, USER_KIND, USER_NAME, 
    USER_NICKNAME, RESI_DATE, KINDERCODE
) VALUES (
    USER_SEQ.nextval, 'dummy1234', 'test1234!', 'john.doe@example.com', 1, 
    'John Doe', 'Johnny', TO_DATE('2023-10-14', 'YYYY-MM-DD'), 'K001'
);


SELECT * FROM NLS_DATABASE_PARAMETERS WHERE PARAMETER = 'NLS_CHARACTERSET';

SELECT * FROM kinder WHERE TRIM(kindercode) = 'K001';
