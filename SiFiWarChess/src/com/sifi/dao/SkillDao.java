package com.sifi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SkillDao {
	
	public static ResultSet findSkillByUnitName(Connection con, String unitname) throws Exception {
		String sql = "select * from skill where name = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, unitname);
		return pstmt.executeQuery();
	}
}
