package com.sifi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UnitDao {
	
	public static ResultSet findUnitByName(Connection con, String name) throws Exception {
		String sql = "select * from unit where name = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		return pstmt.executeQuery();
	}
}
