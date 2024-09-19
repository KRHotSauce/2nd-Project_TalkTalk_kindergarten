package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BOARD_TEMP")
public class BoardInfoEntity {


	@Id
	Long board_info_idx;
	
	String board_name;
	
	
	public Long getBoard_info_idx() {
		return board_info_idx;
	}
	public void setBoard_info_idx(Long board_info_idx) {
		this.board_info_idx = board_info_idx;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}    
	
	
	
}
