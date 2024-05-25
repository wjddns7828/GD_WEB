package com.min.edu.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//TODO 05-01 플레이어 단독 객체

@Data
@Getter
@Setter
public class Player_DTO5 {
	// player Table
	private String player_id;
	private String player_name;
	private String e_player_name;
	private String nickname;
	private String join_yyyy;
	private String position;
	private int back_no;
	private String nation;
	private String birth_date;
	private String solar;
	private int height;
	private int weight;
	
	@Override
	public String toString() {
		return "Player_DTO5 [player_name=" + player_name + ", position=" + position + ", back_no=" + back_no + "]";
	}
	
	
}
