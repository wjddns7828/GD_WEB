package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.KlmsVo;

public interface KlmsDao {

	public int player_add(Map<String, Object>map); 
	public int player_update(Map<String, Object>map);
	public int player_delete(Map<String, Object>map);
	public List<KlmsVo> Fplayer_select(String nation);
	public List<KlmsVo> player_tallFw(String position);
}
