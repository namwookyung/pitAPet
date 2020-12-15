package svc;

import vo.UserBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.UserDAO;

public class UserViewService {

	public UserBean getUser(String viewId) {
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		UserBean user = userDAO.selectUser(viewId);
		close(con);
		return user;
	}
}
