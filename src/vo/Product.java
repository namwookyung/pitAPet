package vo;

public class Product {
	private int p_id;
	private String p_name;
	private int p_price;
	private String p_option;
	private String p_image;
	private String p_content;
	
	public Product(int p_id, String p_name, int p_price, String p_option, String p_image, String p_content) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_option = p_option;
		this.p_image = p_image;
		this.p_content = p_content;
	}
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public String getP_option() {
		return p_option;
	}
	public void setP_option(String p_option) {
		this.p_option = p_option;
	}
	public String getP_image() {
		return p_image;
	}
	public void setP_image(String p_image) {
		this.p_image = p_image;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	
}