package com.example.demo.board.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;

@Getter
@Entity
@Table(name = "content_temp")
public class ContentsEntity {
	@Id
	@Column(name = "content_idx")
	private Long contentIdx;
	
	@Column(name = "board_info_idx")
	private Long boardInfoIdx;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "writer", nullable = false, length = 100)
	private String writer;

	@Column(name = "content_name", nullable = false, length = 200)
	private String contentName;

	@Column(name = "content_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date contentDate;

	@Column(name = "content_image", length = 200)
	private String contentImage;

	@Column(name = "view_count", nullable = false)
	private Integer viewCount = 1;



}
