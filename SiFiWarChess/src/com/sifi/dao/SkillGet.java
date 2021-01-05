package com.sifi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Set;

import com.sifi.util.DbUtil;
import com.sifi.model.Skill;

public class SkillGet {
	
	private static DbUtil dbUtil = new DbUtil();

	public static void getSkillsByUnitName(String unitname, Set<Skill> skills) {
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = SkillDao.findSkillByUnitName(con, unitname);
			while (rs.next()) {
				Skill skill = new Skill();
				
				skill.skill          = rs.getString("skill");
				skill.type           = rs.getString("type");
				skill.period         = rs.getInt("period");
				skill.manacost       = rs.getInt("manacost");
				skill.cold_t         = rs.getInt("cold_t");
				skill.cur_cold_t     = rs.getInt("cold_t");
				String attrs         = rs.getString("attributes");
				skill.setAttributes(attrs);
				String dgrs          = rs.getString("degree");
				skill.setDegree(dgrs);
				skill.tar_type       = rs.getString("tar_type");
				skill.s_range        = rs.getInt("s_range");
				int mark             = rs.getInt("aoe");
				skill.aoe = mark == 0 ? false : true;
				
				skills.add(skill);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
