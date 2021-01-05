package com.sifi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashSet;

import com.sifi.model.Unit;
import com.sifi.util.DbUtil;

public class UnitGet {
	
	private static DbUtil dbUtil = new DbUtil();

	public static Unit getUnitByName(String name) {
		Unit unit = new Unit();
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = UnitDao.findUnitByName(con, name);
			while (rs.next()) { 
				
				unit.alias     = "";
				unit.name      = rs.getString("name");
				unit.cost      = rs.getInt("cost");
				unit.scale     = rs.getInt("scale");
				unit.c_scale   = rs.getInt("scale");
				unit.shield    = rs.getInt("shield");
				unit.c_shield  = rs.getInt("shield");
				unit.uhp       = rs.getInt("uhp");
				unit.c_uhp     = rs.getInt("uhp");
				unit.mana      = rs.getInt("mana");
				unit.c_mana    = rs.getInt("mana");
				unit.speed     = rs.getInt("speed");
				String ga_     = rs.getString("ga");
				unit.ga = ga_.charAt(0);
				unit.armor     = rs.getInt("armor");
				String hl_     = rs.getString("hl");
				String bm_     = rs.getString("bm");
				unit.hl = hl_.charAt(0);
				unit.bm = bm_.charAt(0);
				unit.g_lb      = rs.getInt("g_lb");
				unit.g_hb      = rs.getInt("g_hb");
				unit.g_lm      = rs.getInt("g_lm");
				unit.g_hm      = rs.getInt("g_hm");
				unit.g_freq    = rs.getInt("g_freq");
				unit.g_range   = rs.getInt("g_range");
				int mark       = rs.getInt("g_aoe");
				unit.g_aoe = mark == 0? false : true;
				unit.a_lb      = rs.getInt("a_lb");
				unit.a_hb      = rs.getInt("a_hb");
				unit.a_lm      = rs.getInt("a_lm");
				unit.a_hm      = rs.getInt("a_hm");
				unit.a_freq    = rs.getInt("a_freq");
				unit.a_range   = rs.getInt("a_range");
				mark           = rs.getInt("g_aoe");
				unit.a_aoe = mark == 0? false : true;
				
				unit.skills = new HashSet<>();
				SkillGet.getSkillsByUnitName(name, unit.skills);
				
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
		return unit;
	}
}
