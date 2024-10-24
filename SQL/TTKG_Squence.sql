

drop sequence ALBUM_SEQ;
drop sequence BOARD_SEQ;
drop sequence CHILD_SEQ;
drop sequence CONTENT_SEQ;
drop sequence KINDER_SEQ;
drop sequence PAYMENT_SEQ;
drop sequence USER_ID_SEQ;
drop sequence USER_SEQ;

select * from kinder;



-- User 시퀀스 및 트리거
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE child_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE kinder_album_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE notice_letter_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE meal_plan_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE lesson_plan_monthly_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE kinder_introduction_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE kinder_community_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE class_teacher_seq START WITH 1 INCREMENT BY 1;
create sequence board_idx_seq start with 1 increment by 1;
create sequence comment_idx_seq start with 1 increment by 1;


commit;
