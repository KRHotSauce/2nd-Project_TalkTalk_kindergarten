-- 기존 테이블 삭제
DROP TABLE content_temp CASCADE CONSTRAINTS;
DROP TABLE board_temp CASCADE CONSTRAINTS;
DROP TABLE prants_temp CASCADE CONSTRAINTS;

-- 새 테이블 생성
CREATE TABLE content_temp (
    content_idx    NUMBER NOT NULL,
    board_info_idx NUMBER NOT NULL,
    user_id        NUMBER NOT NULL,
    writer         VARCHAR2(100) NOT NULL,
    content_name   VARCHAR2(200) NOT NULL,
    content_date   DATE NOT NULL,
    content_image  VARCHAR2(200),
    view_count     NUMBER DEFAULT 1 NOT NULL,
    content_tree   NUMBER NOT NULL,
    CONSTRAINT PK_CONTENT_TEMP PRIMARY KEY (content_idx, board_info_idx)
);

CREATE TABLE board_temp (
    board_info_idx NUMBER NOT NULL,
    board_name     VARCHAR2(100) NOT NULL,
    CONSTRAINT PK_BOARD_TEMP PRIMARY KEY (board_info_idx)
);

CREATE TABLE prants_temp (
    user_id    NUMBER NOT NULL,
    login_id   VARCHAR2(100) NOT NULL,
    password   VARCHAR2(100) NOT NULL,
    email      VARCHAR2(200) NOT NULL,
    name       VARCHAR2(100) NOT NULL,
    user_kind  CHAR(1),
    CONSTRAINT PK_PRANTS_TEMP PRIMARY KEY (user_id)
);

-- Foreign Key 추가
ALTER TABLE content_temp ADD CONSTRAINT FK_board_temp_TO_content_temp_1 
    FOREIGN KEY (board_info_idx)
    REFERENCES board_temp (board_info_idx);

ALTER TABLE content_temp ADD CONSTRAINT FK_prants_temp_TO_content_temp_1 
    FOREIGN KEY (user_id)
    REFERENCES prants_temp (user_id);
    

-- board_temp 테이블에 더미 데이터 추가
INSERT INTO board_temp (board_info_idx, board_name) VALUES (1, '공지사항');
INSERT INTO board_temp (board_info_idx, board_name) VALUES (2, '자유게시판');
INSERT INTO board_temp (board_info_idx, board_name) VALUES (3, '질문답변');
INSERT INTO board_temp (board_info_idx, board_name) VALUES (4, '유치원리뷰');

-- prants_temp 테이블에 더미 데이터 추가
INSERT INTO prants_temp (user_id, login_id, password, email, name, user_kind) 
VALUES (1, 'user1', 'password1', 'user1@example.com', 'User One', 'P');
INSERT INTO prants_temp (user_id, login_id, password, email, name, user_kind) 
VALUES (2, 'user2', 'password2', 'user2@example.com', 'User Two', 'T');
INSERT INTO prants_temp (user_id, login_id, password, email, name, user_kind) 
VALUES (3, 'user3', 'password3', 'user3@example.com', 'User Three', 'P');
INSERT INTO prants_temp (user_id, login_id, password, email, name, user_kind) 
VALUES (4, 'user4', 'password4', 'user4@example.com', 'User Four', 'T');
INSERT INTO prants_temp (user_id, login_id, password, email, name, user_kind) 
VALUES (5, 'user5', 'password5', 'user5@example.com', 'User Five', 'P');
INSERT INTO prants_temp (user_id, login_id, password, email, name, user_kind) 
VALUES (6, 'user6', 'password6', 'user6@example.com', 'User Six', 'T');
INSERT INTO prants_temp (user_id, login_id, password, email, name, user_kind) 
VALUES (7, 'user7', 'password7', 'user7@example.com', 'User Seven', 'P');
INSERT INTO prants_temp (user_id, login_id, password, email, name, user_kind) 
VALUES (8, 'user8', 'password8', 'user8@example.com', 'User Eight', 'T');
INSERT INTO prants_temp (user_id, login_id, password, email, name, user_kind) 
VALUES (9, 'user9', 'password9', 'user9@example.com', 'User Nine', 'P');
INSERT INTO prants_temp (user_id, login_id, password, email, name, user_kind) 
VALUES (10, 'user10', 'password10', 'user10@example.com', 'User Ten', 'T');

-- content_temp 테이블에 더미 데이터 추가
INSERT INTO content_temp (content_idx, board_info_idx, user_id, writer, content_name, content_date, content_image, view_count, content_tree)
VALUES (1, 1, 1, 'User One', '공지사항 1', SYSDATE, NULL, 1, 0);
INSERT INTO content_temp (content_idx, board_info_idx, user_id, writer, content_name, content_date, content_image, view_count, content_tree)
VALUES (2, 1, 2, 'User Two', '공지사항 2', SYSDATE, NULL, 1, 0);
INSERT INTO content_temp (content_idx, board_info_idx, user_id, writer, content_name, content_date, content_image, view_count, content_tree)
VALUES (3, 2, 3, 'User Three', '자유게시판 1', SYSDATE, NULL, 1, 0);
INSERT INTO content_temp (content_idx, board_info_idx, user_id, writer, content_name, content_date, content_image, view_count, content_tree)
VALUES (4, 2, 4, 'User Four', '자유게시판 2', SYSDATE, NULL, 1, 0);
INSERT INTO content_temp (content_idx, board_info_idx, user_id, writer, content_name, content_date, content_image, view_count, content_tree)
VALUES (5, 3, 5, 'User Five', '질문답변 1', SYSDATE, NULL, 1, 0);
INSERT INTO content_temp (content_idx, board_info_idx, user_id, writer, content_name, content_date, content_image, view_count, content_tree)
VALUES (6, 3, 6, 'User Six', '질문답변 2', SYSDATE, NULL, 1, 0);
INSERT INTO content_temp (content_idx, board_info_idx, user_id, writer, content_name, content_date, content_image, view_count, content_tree)
VALUES (7, 4, 7, 'User Seven', '자료실 1', SYSDATE, NULL, 1, 0);
INSERT INTO content_temp (content_idx, board_info_idx, user_id, writer, content_name, content_date, content_image, view_count, content_tree)
VALUES (8, 4, 8, 'User Eight', '자료실 2', SYSDATE, NULL, 1, 0);
INSERT INTO content_temp (content_idx, board_info_idx, user_id, writer, content_name, content_date, content_image, view_count, content_tree)
VALUES (9, 1, 9, 'User Nine', '공지사항 3', SYSDATE, NULL, 1, 0);
INSERT INTO content_temp (content_idx, board_info_idx, user_id, writer, content_name, content_date, content_image, view_count, content_tree)
VALUES (10, 2, 10, 'User Ten', '자유게시판 3', SYSDATE, NULL, 1, 0);

