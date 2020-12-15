package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.LoginDAO;
import vo.User;

public class LoginService {
	
	public User getLoginUser(String id, String password) {
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection con = getConnection();
		loginDAO.setConnection(con);
		User loginUser = loginDAO.selectLoginUser(id, password);
		close(con);
		return loginUser;
	}
}
