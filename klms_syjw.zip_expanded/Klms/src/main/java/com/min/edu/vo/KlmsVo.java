package com.min.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class KlmsVo {

	private String player_id;
	private String player_name;
	private String team_id;
	private String position;
	private String nation;
	private int height;
	private String stadium_id;
	private String sche_date;
	private String gubun;
	private String hometeam_id;
	private String awayteam_id;

}
