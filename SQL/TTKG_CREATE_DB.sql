-- 테이블 삭제
DROP TABLE Users CASCADE CONSTRAINTS;
DROP TABLE kinder CASCADE CONSTRAINTS;
DROP TABLE child CASCADE CONSTRAINTS;
DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE content CASCADE CONSTRAINTS;
DROP TABLE payment CASCADE CONSTRAINTS;
DROP TABLE Album CASCADE CONSTRAINTS;
DROP TABLE User_child CASCADE CONSTRAINTS;

-- 테이블 생성
CREATE TABLE Users (
    user_id NUMBER NOT NULL,
    login_id VARCHAR2(255) NOT NULL,
    password VARCHAR2(255) NOT NULL,
    user_email VARCHAR2(255) NOT NULL,
    user_kind CHAR(1) NOT NULL,
    user_name VARCHAR2(255) NOT NULL,
    user_nickname VARCHAR2(255) NOT NULL,
    resi_date DATE NOT NULL,
    profile_img VARCHAR2(255) NULL,
    verified NUMBER(1) NOT NULL
);

CREATE TABLE kinder (
    kinderCode VARCHAR2(255) NOT NULL,
    officeedu VARCHAR2(255) NULL,
    subofficeedu VARCHAR2(255) NULL,
    kindername VARCHAR2(255) NULL,
    establish NUMBER NULL,
    rppnname VARCHAR2(255) NULL,
    idgrname VARCHAR2(255) NULL,
    edate DATE NULL,
    odate DATE NULL,
    addr VARCHAR2(255) NULL,
    tel_no VARCHAR2(50) NULL,
    fax_no VARCHAR2(50) NULL,
    opertime VARCHAR2(50) NULL,
    cl_cnt3 NUMBER NULL,
    cl_cnt4 NUMBER NULL,
    cl_cnt5 NUMBER NULL,
    mix_cl_cnt NUMBER NULL,
    sh_cl_cnt NUMBER NULL,
    prmstf_cnt NUMBER NULL,
    ag3fp_cnt NUMBER NULL,
    ag4fp_cnt NUMBER NULL,
    ag5fp_cnt NUMBER NULL,
    mixfp_cnt NUMBER NULL,
    spcnfp_cnt NUMBER NULL,
    pp_cnt3 NUMBER NULL,
    pp_cnt4 NUMBER NULL,
    pp_cnt5 NUMBER NULL,
    mixpp_cnt NUMBER NULL,
    chpp_cnt NUMBER NULL,
    pbnttmng NUMBER NULL
);

CREATE TABLE child (
    child_id NUMBER NOT NULL,
    name VARCHAR2(255) null,
    age DATE,
    height NUMBER NULL,
    weight NUMBER NULL,
    allergy VARCHAR2(255) NULL,
    mdi_history VARCHAR2(255) NULL,
    attendance_date DATE NULL,
    check_in_time VARCHAR2(50) NULL,
    check_out_time VARCHAR2(50) NULL
);

CREATE TABLE content (
    content_idx NUMBER NOT NULL,
    board_info_idx NUMBER NOT NULL,
    content_name VARCHAR2(255) NULL,
    content_writer VARCHAR2(255) NULL,
    content_date DATE NULL,
    content_image VARCHAR2(255) NULL,
    view_count NUMBER NULL,
    Field NUMBER NULL
);

CREATE TABLE board (
    board_info_idx NUMBER NOT NULL,
    board_name VARCHAR2(255) NULL
);

CREATE TABLE payment (
    payment_id NUMBER NOT NULL,
    pay_date DATE NULL,
    pay_amount NUMBER NULL,
    pay_method NUMBER NULL,
    pay_instrument VARCHAR2(255) NULL
);

CREATE TABLE User_child (
    user_id NUMBER NOT NULL,
    child_id NUMBER NOT NULL,
    kinderCode VARCHAR2(255)
);

CREATE TABLE Album (
    album_id NUMBER NOT NULL,
    img_url VARCHAR2(255) NOT NULL,
    upload_date DATE NOT NULL
);

-- 기본 키 제약조건 추가
ALTER TABLE User ADD CONSTRAINT PK_USER PRIMARY KEY (user_id);
ALTER TABLE kinder ADD CONSTRAINT PK_KINDER PRIMARY KEY (kinderCode);
ALTER TABLE child ADD CONSTRAINT PK_CHILD PRIMARY KEY (child_id);
ALTER TABLE content ADD CONSTRAINT PK_CONTENT PRIMARY KEY (content_idx, board_info_idx);
ALTER TABLE board ADD CONSTRAINT PK_BOARD PRIMARY KEY (board_info_idx);
ALTER TABLE payment ADD CONSTRAINT PK_PAYMENT PRIMARY KEY (payment_id);
ALTER TABLE User_child ADD CONSTRAINT PK_USER_CHILD PRIMARY KEY (user_id, child_id);
ALTER TABLE Album ADD CONSTRAINT PK_ALBUM PRIMARY KEY (album_id);

-- 외래 키 제약조건 추가
ALTER TABLE content ADD CONSTRAINT FK_board_TO_content_1 FOREIGN KEY (board_info_idx) REFERENCES board (board_info_idx);
ALTER TABLE User_child ADD CONSTRAINT FK_User_TO_User_child_1 FOREIGN KEY (user_id) REFERENCES User (user_id);
ALTER TABLE User_child ADD CONSTRAINT FK_child_TO_User_child_1 FOREIGN KEY (child_id) REFERENCES child (child_id);
ALTER TABLE User_child ADD CONSTRAINT FK_kinder_TO_User_child_1 FOREIGN KEY (kinderCode) REFERENCES kinder (kinderCode);

-- 시퀀스 생성
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE kinder_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE child_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE content_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE payment_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE album_seq START WITH 1 INCREMENT BY 1;
