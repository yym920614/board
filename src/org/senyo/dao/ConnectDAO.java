package org.senyo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.zerock.domain.BoardVO;

abstract class ConnectDAO implements SQLExecutor {

	// TODO Auto-generated method stub
	protected Connection con = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	public void execute() throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.0.25:3306/bit88?useSSL=false",
					"makemoney", "makemoney");

			doExecute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}

		}

	}

}
