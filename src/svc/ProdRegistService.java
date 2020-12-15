package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.ProdDAO;
import vo.Product;

public class ProdRegistService {

	public boolean registProd(Product product) {
		ProdDAO prodDAO = ProdDAO.getInstance();
		Connection con = getConnection();
		prodDAO.setConnection(con);
		boolean isRegistSuccess = false;
		int insertCount = prodDAO.insertProd(product);
		
		if(insertCount>0) {
			commit(con);
			inRegistSuccess=true;
		} else {
			rollback(con);
		}
		
		close(con);
		return isRegistSuccess;
	}
}
