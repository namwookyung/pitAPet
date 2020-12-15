package svc;

import vo.UserBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.UserDAO;

public class UserLoginService {
	
	public boolean login (UserBean user) {
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		boolean loginResult = false;
		String loginId = userDAO.selectLoginId(user);
		if(loginId != null) {
			loginResult = true;
		}
		close(con);
		return loginResult;
	}
}
