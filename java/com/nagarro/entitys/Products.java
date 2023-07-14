package com.nagarro.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productcode")
	private int productcode;
	private String brand;
	private String productname;
	private String price;
	private String description;
	private String  productimage;
	
	public Products() {
		super();
	}
	public Products(int productcode, String brand, String productname, String price, String description, String image) {
		super();
		this.productcode = productcode;
		this.brand = brand;
		this.productname = productname;
		this.price = price;
		this.description = description;
		this.productimage = image;
	}
	public String getImage() {
		return productimage;
	}
	public void setImage(String image) {
		this.productimage = image;
	}
	public int getProductcode() {
		return productcode;
	}
	public void setProductcode(int productcode) {
		this.productcode = productcode;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Products [productcode=" + productcode + ", brand=" + brand + ", productname=" + productname + ", price="
				+ price + ", description=" + description + "]";
	}
}
