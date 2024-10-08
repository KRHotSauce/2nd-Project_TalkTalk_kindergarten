CREATE TABLE boards (
   board_idx   NUMBER(38)      NOT NULL,
   category   VARCHAR2(255)  NOT NULL,
   title   VARCHAR2(255)      NULL,
   body   VARCHAR2(255)      NULL,
   author   VARCHAR2(255)      NULL,
   created_at   TIMESTAMP       NULL,
   last_modified_at   TIMESTAMP    NULL,
   image   VARCHAR2(255)      NULL,
   view_count   NUMBER(38)      NULL,
   user_idx   NUMBER(38)      NOT NULL
);
CREATE TABLE comments (
    comment_idx NUMBER(38) NOT NULL,
   created_at   TIMESTAMP       NULL,
   last_modified_at   TIMESTAMP    NULL,
    body VARCHAR2(255) NOT NULL,
    user_idx NUMBER(38) NOT NULL,
    board_idx NUMBER(38) NOT NULL
);
ALTER TABLE boards ADD CONSTRAINT PK_BOARDS PRIMARY KEY (
   board_idx
);

ALTER TABLE comments ADD CONSTRAINT PK_COMMENTS PRIMARY KEY (
   comment_idx
);
