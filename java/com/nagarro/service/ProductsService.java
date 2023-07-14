package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.entitys.Products;
import com.nagarro.repository.ProductsRepository;

@Component
public class ProductsService {
	
	@Autowired
	ProductsRepository ProductRepo;

	public List<Products> getProductsByName(String productname){
		List<Products> products=(List<Products>) this.ProductRepo.findByproductname(productname);
		return products;
	}
	
	public List<Products> getAllProducts(){
		List<Products> products=(List<Products>) this.ProductRepo.findAll();
		return products;
	}
	public List<Products> getProductsByBrand(String brand){
		List<Products> products=(List<Products>)this.ProductRepo.findBybrand(brand);
		return products;
	}
	public List<Products> getProductByProductCode(int productcode) {
		List<Products> products=this.ProductRepo.findByproductcode(productcode);
		return products;
	}
}
