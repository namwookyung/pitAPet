package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.ProdDAO;
import vo.Product;

public class ProdListService {

	public ArrayList<Product> getProd() {
		ProdDAO prodDAO = ProdDAO.getInstance();
		Connection con = getConnection();
		prodDAO.setConnection(con);
		ArrayList<Product> prodList = prodDAO.selectProdList();
		close(con);
		return prodList;
	}
}
