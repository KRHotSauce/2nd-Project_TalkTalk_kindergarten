DROP TABLE "User";
DROP TABLE "kinder";
DROP TABLE "child";
DROP TABLE "User_child";
DROP TABLE "content";
DROP TABLE "Album";
DROP TABLE "board";
DROP TABLE "payment";

CREATE TABLE "User" (
	"user_id"	varchar2		NOT NULL,
	"password"	varchar2		NOT NULL,
	"email"	varchar2		NOT NULL,
	"user_kind"	char(1)		NOT NULL,
	"name"	varchar2		NOT NULL,
	"nickname"	varchar2		NOT NULL,
	"resi_date"	date		NOT NULL,
	"profile_img"	varchar2		NULL,
	"is_verified"	boolean		NULL
);



CREATE TABLE "kinder" (
	"kinderCode"	number		NOT NULL,
	"officeedu"	varchar2		NULL,
	"subofficeedu"	varchar2		NULL,
	"kindername"	varchar2		NULL,
	"establish"	number		NULL,
	"rppnname"	varchar2		NULL,
	"idgrname"	varchar2		NULL,
	"edate"	date		NULL,
	"odate"	date		NULL,
	"addr"	varchar2		NULL,
	"tel_no"	varchar2		NULL,
	"fax_no"	varchar2		NULL,
	"opertime"	varchar2		NULL,
	"cl_cnt3"	number		NULL,
	"cl_cnt4"	number		NULL,
	"cl_cnt5"	number		NULL,
	"mix_cl_cnt"	number		NULL,
	"sh_cl_cnt"	number		NULL,
	"prmstf_cnt"	number		NULL,
	"ag3fp_cnt"	number		NULL,
	"ag4fp_cnt"	number		NULL,
	"ag5fp_cnt"	number		NULL,
	"mixfp_cnt"	number		NULL,
	"spcnfp_cnt"	number		NULL,
	"pp_cnt3"	number		NULL,
	"pp_cnt4"	number		NULL,
	"pp_cnt5"	number		NULL,
	"mixpp_cnt"	number		NULL,
	"chpp_cnt"	number		NULL,
	"pbnttmng"	number		NULL
);



CREATE TABLE "child" (
	"child_id"	varchar2		NOT NULL,
	"name"	varchar2		NOT NULL,
	"age"	date		NOT NULL,
	"height"	number		NULL,
	"weight"	number		NULL,
	"allergy"	varchar2		NULL,
	"mdi_history"	varchar2		NULL,
	"attendance_date"	date		NULL,
	"check_in_time"	time		NULL,
	"check_out_time"	VARCHAR(255)		NULL
);



CREATE TABLE "content" (
	"content_idx"	number		NOT NULL,
	"board_info_idx"	number		NOT NULL,
	"content_name"	varchar2		NULL,
	"content_writer"	varchar2		NULL,
	"content_date"	date		NULL,
	"content_image"	varchar2		NULL,
	"view_count"	number		NULL,
	"Field"	number		NULL,
	"user_id"	varchar2		NOT NULL
);



CREATE TABLE "board" (
	"board_info_idx"	number		NOT NULL,
	"board_name"	varchar2		NULL
);



CREATE TABLE "payment" (
	"payment_id"	number		NOT NULL,
	"pay_date"	date		NULL,
	"pay_amount"	number		NULL,
	"pay_method"	number		NULL,
	"pay_instrument"	varchar		NULL
);



CREATE TABLE "User_child" (
	"user_id"	varchar2		NOT NULL,
	"child_idx"	varhchar2		NOT NULL,
	"kinderCode"	number		NULL
);



CREATE TABLE "Album" (
	"Key"	number		NOT NULL,
	"img_url"	varchar2		NOT NULL,
	"upload_date"	date		NOT NULL,
	"user_id"	varchar2		NOT NULL,
	"kinder_id"	varchar2		NULL
);

ALTER TABLE "User" ADD CONSTRAINT "PK_USER" PRIMARY KEY (
	"user_id"
);

ALTER TABLE "kinder" ADD CONSTRAINT "PK_KINDER" PRIMARY KEY (
	"kinderCode"
);

ALTER TABLE "child" ADD CONSTRAINT "PK_CHILD" PRIMARY KEY (
	"child_id"
);

ALTER TABLE "content" ADD CONSTRAINT "PK_CONTENT" PRIMARY KEY (
	"content_idx",
	"board_info_idx"
);

ALTER TABLE "board" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
	"board_info_idx"
);

ALTER TABLE "payment" ADD CONSTRAINT "PK_PAYMENT" PRIMARY KEY (
	"payment_id"
);

ALTER TABLE "User_child" ADD CONSTRAINT "PK_USER_CHILD" PRIMARY KEY (
	"user_id",
	"child_idx"
);

ALTER TABLE "Album" ADD CONSTRAINT "PK_ALBUM" PRIMARY KEY (
	"Key"
);

ALTER TABLE "content" ADD CONSTRAINT "FK_board_TO_content_1" FOREIGN KEY (
	"board_info_idx"
)
REFERENCES "board" (
	"board_info_idx"
);

ALTER TABLE "content" ADD CONSTRAINT "FK_User_TO_content_1" FOREIGN KEY (
	"user_id"
)
REFERENCES "User" (
	"user_id"
);

ALTER TABLE "User_child" ADD CONSTRAINT "FK_User_TO_User_child_1" FOREIGN KEY (
	"user_id"
)
REFERENCES "User" (
	"user_id"
);

ALTER TABLE "User_child" ADD CONSTRAINT "FK_child_TO_User_child_1" FOREIGN KEY (
	"child_idx"
)
REFERENCES "child" (
	"child_id"
);

ALTER TABLE "User_child" ADD CONSTRAINT "FK_kinder_TO_User_child_1" FOREIGN KEY (
	"kinderCode"
)
REFERENCES "kinder" (
	"kinderCode"
);

ALTER TABLE "Album" ADD CONSTRAINT "FK_User_TO_Album_1" FOREIGN KEY (
	"user_id"
)
REFERENCES "User" (
	"user_id"
);

ALTER TABLE "Album" ADD CONSTRAINT "FK_kinder_TO_Album_1" FOREIGN KEY (
	"kinder_id"
)
REFERENCES "kinder" (
	"kinderCode"
);

