package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;
import vo.Product;

public class ProdDAO {

	Connection con;
	private static ProdDAO boardDAO;
	
	private ProdDAO() {
		
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public static ProdDAO getInstance() {
		
		if(boardDAO == null) {
			boardDAO = new ProdDAO();
		}
		return boardDAO;
	}
	
	public ArrayList<Product> selectProdList() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> prodList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM product");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				prodList = new ArrayList<Product>();
				
				do {
					prodList.add(new Product(
							rs.getInt("p_id")
							,rs.getString("p_name")
							,rs.getInt("p_price")
							,rs.getString("p_option")
							,rs.getString("p_image")
							,rs.getString("p_content")));
				} while (rs.next());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return prodList;
	}
	
	public Product selectDog(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM product WHERE id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				product = new Product(
						rs.getInt("p_id")
						,rs.getString("p_name")
						,rs.getInt("p_price")
						,rs.getString("p_option")
						,rs.getString("p_image")
						,rs.getString("p_content"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return product;
	}
	
	public int insertProd(Product product) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "INSERT INTO product VALUES(prod_seq.nextval,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getP_name());
			pstmt.setInt(2, product.getP_price());
			pstmt.setString(3, product.getP_option());
			pstmt.setString(4, product.getP_image());
			pstmt.setString(5, product.getP_content());
			insertCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
}
