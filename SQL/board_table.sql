-- 기존 테이블 삭제
DROP TABLE content_temp CASCADE CONSTRAINTS;
DROP TABLE board_temp CASCADE CONSTRAINTS;
DROP TABLE prants_temp CASCADE CONSTRAINTS;

-- 새 테이블 생성
CREATE TABLE content (
    content_idx    NUMBER NOT NULL,
    board_info_idx NUMBER NOT NULL,
    user_id        NUMBER NOT NULL,
    writer         VARCHAR2(100) NOT NULL,
    content_name   VARCHAR2(200) NOT NULL,
    content_date   DATE NOT NULL,
    content_image  VARCHAR2(200),
    view_count     NUMBER DEFAULT 1 NOT NULL,
    content_tree   NUMBER NOT NULL,
    CONSTRAINT PK_CONTENT_TEMP PRIMARY KEY (content_idx)
    );

CREATE TABLE board (
    board_info_idx NUMBER NOT NULL,
    board_name     VARCHAR2(100) NOT NULL,
    CONSTRAINT PK_BOARD_TEMP PRIMARY KEY (board_info_idx)
);

CREATE TABLE Parents (
    user_id    NUMBER NOT NULL,
    login_id   VARCHAR2(100) NOT NULL,
    password   VARCHAR2(100) NOT NULL,
    email      VARCHAR2(200) NOT NULL,
    nickname   VARCHAR2(100) NOT NULL,
    name       VARCHAR2(100) NOT NULL,
    CONSTRAINT PK_PRANTS_TEMP PRIMARY KEY (user_id)
);

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Foreign Key 추가
ALTER TABLE content ADD CONSTRAINT FK_board_TO_content_1 
    FOREIGN KEY (board_info_idx)
    REFERENCES board (board_info_idx);

ALTER TABLE content ADD CONSTRAINT FK_prants_TO_content_1 
    FOREIGN KEY (user_id)
    REFERENCES prants (user_id);
    

-- board_temp 테이블에 더미 데이터 추가
INSERT INTO board_temp (board_info_idx, board_name) VALUES (1, '전체글보기');
INSERT INTO board_temp (board_info_idx, board_name) VALUES (2, '자유게시판');
INSERT INTO board_temp (board_info_idx, board_name) VALUES (3, '질문게시판');
INSERT INTO board_temp (board_info_idx, board_name) VALUES (4, '유치원리뷰');
INSERT INTO board_temp (board_info_idx, board_name) VALUES (5, '아이자랑');

-- prants_temp 테이블에 더미 데이터 추가


-- content_temp 테이블에 더미 데이터 추가


commit;

