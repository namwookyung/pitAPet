package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.ProdDAO;
import vo.Product;

public class ProdViewService {

	public Product getProdView(int p_id) {
		Connection con = getConnection();
		ProdDAO prodDAO = ProdDAO.getInstance();
		prodDAO.setConnection(con);
		
		Product product = prodDAO.selectProd(p_id);
		close(con);
		return product;
	}
}
