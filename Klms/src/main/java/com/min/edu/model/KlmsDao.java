package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.KlmsVo;

public interface KlmsDao {

	public int player_add(KlmsVo vo); 
	public int team_FCheck(String team_id);
	public int team_delete(KlmsVo vo);
	public int schedule_add(KlmsVo vo);
	public boolean schedule_update(KlmsVo vo);
	public List<KlmsVo> Fplayer_select(KlmsVo vo);

	public boolean player_update(Map<String, Object>map);
	public int player_delete(Map<String, Object>map);
    public List<KlmsVo> player_tallFw(String position);
}
