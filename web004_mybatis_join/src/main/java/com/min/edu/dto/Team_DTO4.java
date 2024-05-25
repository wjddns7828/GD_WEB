package com.min.edu.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//TODO 04-01 Team단독 객체

@Data
@Getter
@Setter

public class Team_DTO4 {
	// team Table
	private String team_id;
	private String region_name;
	private String team_name;
	private String e_team_name;
	private String orig_yyyy;
	private String stadium_id;
	private String zip_code1;
	private String zip_code2;
	private String address;
	private String ddd;
	private String tel;
	private String fax;
	private String homepage;
	private String owner;
	private String stadium_name;
	private int foreigner_count;
	
	@Override
	public String toString() {
		return "Team_DTO4 [region_name=" + region_name + ", team_name=" + team_name + ", address=" + address
				+ ", homepage=" + homepage + "]";
	}
		
	
	
}
