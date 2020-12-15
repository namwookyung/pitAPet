package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.User;
import static db.JdbcUtil.*;

public class LoginDAO {
	
	private static LoginDAO loginDAO;
	private Connection con;
	
	private LoginDAO() {
		
	}
	
	public static LoginDAO getInstance() {
		if(loginDAO == null) {
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public User selectLoginUser(String id, String password) {
		
		User loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM users WHERE id = ? AND password = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginUser = new User();
				loginUser.setId(rs.getString("id"));
				loginUser.setPassword(rs.getString("password"));
				loginUser.setName(rs.getString("name"));
				loginUser.setMobile(rs.getString("mobile"));
				loginUser.setEmail(rs.getString("email"));
				loginUser.setAddress(rs.getString("address"));
			}
		} catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return loginUser;
	}
}
