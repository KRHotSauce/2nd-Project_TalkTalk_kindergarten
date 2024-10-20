-- 기존 테이블 삭제
drop table "User" cascade constraints;
DROP TABLE Users CASCADE CONSTRAINTS;
DROP TABLE CHILD CASCADE CONSTRAINTS;
DROP TABLE ALBUM CASCADE CONSTRAINTS;
DROP TABLE class_teacher CASCADE CONSTRAINTS;
DROP TABLE kinderDetail CASCADE CONSTRAINTS;
DROP TABLE TT_boards CASCADE CONSTRAINTS;
DROP TABLE User_child CASCADE CONSTRAINTS;
DROP TABLE TT_comments CASCADE CONSTRAINTS;
DROP TABLE kinder_album CASCADE CONSTRAINTS;
DROP TABLE notice_letter CASCADE CONSTRAINTS;
DROP TABLE lesson_plan_monthly CASCADE CONSTRAINTS;
DROP TABLE kinder_community CASCADE CONSTRAINTS;
DROP TABLE meal_plan CASCADE CONSTRAINTS;
DROP TABLE kinder_introduction CASCADE CONSTRAINTS;
DROP TABLE kinder CASCADE CONSTRAINTS;

ALTER TABLE Users DROP COLUMN kinder_code;

-- 테이블 생성
CREATE TABLE Users (
    user_idx NUMBER PRIMARY KEY,
    login_id VARCHAR2(255),
    password VARCHAR2(255),
    user_email VARCHAR2(255),
    user_kind NUMBER(1),
    user_name VARCHAR2(255),
    user_nickname VARCHAR2(255),
    resi_date DATE,
    kinderCode VARCHAR2(255)
);

CREATE TABLE kinderDetail (
    kinderCode VARCHAR2(255) PRIMARY KEY,
    officeedu VARCHAR2(255),
    subofficeedu VARCHAR2(255),
    kindername VARCHAR2(255),
    establish VARCHAR2(255),
    rppnname VARCHAR2(255),
    idgrname VARCHAR2(255),
    edate DATE,
    odate DATE,
    addr VARCHAR2(255),
    tel_no VARCHAR2(255),
    fax_no VARCHAR2(255),
    hpaddr VARCHAR2(255),
    opertime VARCHAR2(255),
    cl_cnt3 NUMBER,
    cl_cnt4 NUMBER,
    cl_cnt5 NUMBER,
    mix_cl_cnt NUMBER,
    sh_cl_cnt NUMBER,
    prmstf_cnt NUMBER,
    ag3fp_cnt NUMBER,
    ag4fp_cnt NUMBER,
    ag5fp_cnt NUMBER,
    mixfp_cnt NUMBER,
    spcnfp_cnt NUMBER,
    pp_cnt3 NUMBER,
    pp_cnt4 NUMBER,
    pp_cnt5 NUMBER,
    mixpp_cnt NUMBER,
    chpp_cnt NUMBER,
    pbnttmng NUMBER
);

CREATE TABLE child (
    child_idx NUMBER PRIMARY KEY,
    child_name VARCHAR2(255) NOT NULL,
    child_birth DATE NOT NULL
);

CREATE TABLE TT_boards (
    board_idx NUMBER(38) PRIMARY KEY,
    category VARCHAR2(255),
    title VARCHAR2(255),
    body VARCHAR2(255),
    author VARCHAR2(255),
    created_at TIMESTAMP,
    last_modified_at TIMESTAMP,
    image VARCHAR2(255),
    view_count NUMBER(38),
    user_idx NUMBER NOT NULL
);

CREATE TABLE User_child (
    user_idx NUMBER NOT NULL,
    child_idx NUMBER NOT NULL,
    kinderCode VARCHAR2(255),
    PRIMARY KEY (user_idx, child_idx)
);

CREATE TABLE TT_comments (
    comment_idx NUMBER(38) PRIMARY KEY,
    created_at TIMESTAMP,
    last_modified_at TIMESTAMP,
    body VARCHAR2(255),
    board_idx NUMBER(38) NOT NULL,
    user_idx NUMBER NOT NULL
);

CREATE TABLE kinder_album (
    album_idx NUMBER(38) PRIMARY KEY,
    album_title VARCHAR2(255),
    album_url VARCHAR2(255),
    created_at TIMESTAMP,
    kinderCode VARCHAR2(255) NOT NULL,
    album_type NUMBER
);

COMMENT ON COLUMN kinder_album.album_type IS '유치원전경사진/아이사진 등 구분';

CREATE TABLE notice_letter (
    letter_idx NUMBER PRIMARY KEY,
    kinderCode VARCHAR2(255) NOT NULL,
    notice_date DATE,
    body VARCHAR2(255)
);

CREATE TABLE meal_plan (
    meal_idx NUMBER PRIMARY KEY,
    kinderCode VARCHAR2(255) NOT NULL,
    kind NUMBER,
    meal_info VARCHAR2(255),
    origin VARCHAR2(255),
    meal_date DATE
);

COMMENT ON COLUMN meal_plan.kind IS '조식/중식/석식/간식';

CREATE TABLE lesson_plan_monthly (
    lessonplan_idx NUMBER PRIMARY KEY,
    kinderCode VARCHAR2(255) NOT NULL,
    lesson_date DATE,
    body VARCHAR2(255)
);

CREATE TABLE kinder_introduction (
    intro_idx NUMBER PRIMARY KEY,
    kinderCode VARCHAR2(255) NOT NULL,
    description VARCHAR2(255),
    principal_message VARCHAR2(255)
);

CREATE TABLE kinder (
    kinderCode VARCHAR2(255) PRIMARY KEY,
    kindername VARCHAR2(255),
    addr VARCHAR2(255),
    establish varchar2(255)
);

CREATE TABLE kinder_community (
    board_idx NUMBER(38) PRIMARY KEY,
    title VARCHAR2(255),
    body VARCHAR2(255),
    author VARCHAR2(255),
    created_at TIMESTAMP,
    last_modified_at TIMESTAMP,
    view_count NUMBER(38),
    user_idx NUMBER NOT NULL,
    kinderCode VARCHAR2(255) NOT NULL
);

CREATE TABLE class_teacher (
    teacher_idx NUMBER PRIMARY KEY,
    class_name VARCHAR2(255),
    kinderCode VARCHAR2(255) NOT NULL
);

-- 외래키 설정
ALTER TABLE Users ADD CONSTRAINT FK_kinder_TO_User FOREIGN KEY (kinderCode) REFERENCES kinder (kinderCode);
ALTER TABLE kinderDetail ADD CONSTRAINT FK_kinder_TO_kinderDetail FOREIGN KEY (kinderCode) REFERENCES kinder (kinderCode);
ALTER TABLE TT_boards ADD CONSTRAINT FK_User_TO_TT_boards FOREIGN KEY (user_idx) REFERENCES Users (user_idx);
ALTER TABLE User_child ADD CONSTRAINT FK_User_TO_User_child FOREIGN KEY (user_idx) REFERENCES Users (user_idx);
ALTER TABLE User_child ADD CONSTRAINT FK_child_TO_User_child FOREIGN KEY (child_idx) REFERENCES child (child_idx);
ALTER TABLE User_child ADD CONSTRAINT FK_kinder_TO_User_child FOREIGN KEY (kinderCode) REFERENCES kinder (kinderCode);
ALTER TABLE TT_comments ADD CONSTRAINT FK_TT_boards_TO_TT_comments FOREIGN KEY (board_idx) REFERENCES TT_boards (board_idx);
ALTER TABLE TT_comments ADD CONSTRAINT FK_User_TO_TT_comments FOREIGN KEY (user_idx) REFERENCES Users (user_idx);
ALTER TABLE kinder_album ADD CONSTRAINT FK_kinder_TO_kinder_album FOREIGN KEY (kinderCode) REFERENCES kinder (kinderCode);
ALTER TABLE notice_letter ADD CONSTRAINT FK_kinder_TO_notice_letter FOREIGN KEY (kinderCode) REFERENCES kinder (kinderCode);
ALTER TABLE meal_plan ADD CONSTRAINT FK_kinder_TO_meal_plan FOREIGN KEY (kinderCode) REFERENCES kinder (kinderCode);
ALTER TABLE lesson_plan_monthly ADD CONSTRAINT FK_kinder_TO_lesson_plan_monthly FOREIGN KEY (kinderCode) REFERENCES kinder (kinderCode);
ALTER TABLE kinder_introduction ADD CONSTRAINT FK_kinder_TO_kinder_introduction FOREIGN KEY (kinderCode) REFERENCES kinder (kinderCode);
ALTER TABLE kinder_community ADD CONSTRAINT FK_User_TO_kinder_community FOREIGN KEY (user_idx) REFERENCES Users (user_idx);
ALTER TABLE kinder_community ADD CONSTRAINT FK_kinder_TO_kinder_community FOREIGN KEY (kinderCode) REFERENCES kinder (kinderCode);
ALTER TABLE class_teacher ADD CONSTRAINT FK_User_TO_class_teacher FOREIGN KEY (teacher_idx) REFERENCES Users (user_idx);
ALTER TABLE class_teacher ADD CONSTRAINT FK_kinder_TO_class_teacher FOREIGN KEY (kinderCode) REFERENCES kinder (kinderCode);

--이후 수정사항 (컬럼추가 제약조건 추가 등등)

--child에 kindercode추가
alter table child add kindercode varchar2(255);
alter table child add constraint FK_kinder_TO_CHILD FOREIGN KEY (kindercode) references kinder (kindercode);


commit;