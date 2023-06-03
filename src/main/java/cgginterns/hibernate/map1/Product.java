package cgginterns.hibernate.map1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@Column(name = "product_id")
	private int productId;
	@Column(name = "product_name")
	private String productName;
	@ManyToOne
    private Brand brand;
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
