INSERT INTO kinder (kinderCode, officeedu, subofficeedu, kindername, establish, rppnname, idgrname, edate, odate, addr, tel_no, fax_no, opertime, cl_cnt3, cl_cnt4, cl_cnt5, mix_cl_cnt, sh_cl_cnt, prmstf_cnt, ag3fp_cnt, ag4fp_cnt, ag5fp_cnt, mixfp_cnt, spcnfp_cnt, pp_cnt3, pp_cnt4, pp_cnt5, mixpp_cnt, chpp_cnt, pbnttmng)
VALUES ('TBD', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);







INSERT INTO User (user_id, login_id, password, user_email, user_kind, user_name, user_nickname, resi_date, profile_img, verified)
VALUES (user_seq.NEXTVAL, 'user1', 'password1', 'user1@example.com', 'P', 'John Doe', 'johnd', SYSDATE, 'profile1.png', 1);

INSERT INTO User (user_id, login_id, password, user_email, user_kind, user_name, user_nickname, resi_date, profile_img, verified)
VALUES (user_seq.NEXTVAL, 'user2', 'password2', 'user2@example.com', 'T', 'Jane Smith', 'janes', SYSDATE, 'profile2.png', 0);



INSERT INTO kinder (kinderCode, officeedu, subofficeedu, kindername, establish, rppnname, idgrname, edate, odate, addr, tel_no, fax_no, opertime, cl_cnt3, cl_cnt4, cl_cnt5, mix_cl_cnt, sh_cl_cnt, prmstf_cnt, ag3fp_cnt, ag4fp_cnt, ag5fp_cnt, mixfp_cnt, spcnfp_cnt, pp_cnt3, pp_cnt4, pp_cnt5, mixpp_cnt, chpp_cnt, pbnttmng)
VALUES ('undefined', 'Office1', 'Sub1', 'Kinder1', 1, 'Person1', 'ID1', SYSDATE, SYSDATE, 'Address1', '123-4567', '123-4568', '09:00-18:00', 10, 20, 15, 5, 3, 10, 5, 6, 7, 2, 1, 3, 4, 5, 2, 2);

INSERT INTO kinder (kinderCode, officeedu, subofficeedu, kindername, establish, rppnname, idgrname, edate, odate, addr, tel_no, fax_no, opertime, cl_cnt3, cl_cnt4, cl_cnt5, mix_cl_cnt, sh_cl_cnt, prmstf_cnt, ag3fp_cnt, ag4fp_cnt, ag5fp_cnt, mixfp_cnt, spcnfp_cnt, pp_cnt3, pp_cnt4, pp_cnt5, mixpp_cnt, chpp_cnt, pbnttmng)
VALUES (kinder_seq.NEXTVAL, 'Office2', 'Sub2', 'Kinder2', 2, 'Person2', 'ID2', SYSDATE, SYSDATE, 'Address2', '234-5678', '234-5679', '08:00-17:00', 15, 25, 12, 4, 2, 12, 6, 8, 5, 3, 2, 2, 4, 3, 1, 3);


INSERT INTO child (child_id, name, age, height, weight, allergy, mdi_history, attendance_date, check_in_time, check_out_time)
VALUES (child_seq.NEXTVAL, 'Child1', TO_DATE('2018-05-01', 'YYYY-MM-DD'), 110, 20, 'None', 'None', SYSDATE, '08:00', '16:00');

INSERT INTO child (child_id, name, age, height, weight, allergy, mdi_history, attendance_date, check_in_time, check_out_time)
VALUES (child_seq.NEXTVAL, 'Child2', TO_DATE('2017-08-12', 'YYYY-MM-DD'), 105, 18, 'Dairy', 'Asthma', SYSDATE, '09:00', '15:30');


INSERT INTO content (content_idx, board_info_idx, content_name, content_writer, content_date, content_image, view_count, Field)
VALUES (content_seq.NEXTVAL, 1, 'Content1', 'Writer1', SYSDATE, 'img1.png', 100, 1);

INSERT INTO content (content_idx, board_info_idx, content_name, content_writer, content_date, content_image, view_count, Field)
VALUES (content_seq.NEXTVAL, 2, 'Content2', 'Writer2', SYSDATE, 'img2.png', 150, 2);


INSERT INTO board (board_info_idx, board_name)
VALUES (board_seq.NEXTVAL, 'Notice');

INSERT INTO board (board_info_idx, board_name)
VALUES (board_seq.NEXTVAL, 'Event');


INSERT INTO payment (payment_id, pay_date, pay_amount, pay_method, pay_instrument)
VALUES (payment_seq.NEXTVAL, SYSDATE, 50000, 1, 'Credit Card');

INSERT INTO payment (payment_id, pay_date, pay_amount, pay_method, pay_instrument)
VALUES (payment_seq.NEXTVAL, SYSDATE, 70000, 2, 'Bank Transfer');


INSERT INTO User_child (user_id, child_id, kinderCode)
VALUES (1, 1, 1);

INSERT INTO User_child (user_id, child_id, kinderCode)
VALUES (2, 2, 2);


INSERT INTO Album (album_id, img_url, upload_date)
VALUES (album_seq.NEXTVAL, 'album1.png', SYSDATE);

INSERT INTO Album (album_id, img_url, upload_date)
VALUES (album_seq.NEXTVAL, 'album2.png', SYSDATE);

