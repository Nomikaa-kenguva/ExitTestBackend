package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entitys.Products;
import com.nagarro.service.ProductsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	

    private final ProductsService productService;
	
    
    @Autowired
    public ProductController( ProductsService productService) {
        this.productService = productService;
    }
    
	@GetMapping("/products/{productname}")
	public ResponseEntity<List<Products>> getProductsByProductName(@PathVariable("productname") String productname){
		List<Products> list=this.productService.getProductsByName(productname);
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(list);
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}	
	}
	@GetMapping("/products")
	public  ResponseEntity<List<Products>> getAllProducts(){
		List<Products> list=this.productService.getAllProducts();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		 return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/product/{brand}")
	public ResponseEntity<List<Products>> getProductsByBrand(@PathVariable("brand") String brand){
		List<Products> list=this.productService.getProductsByBrand(brand);
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		 return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/produc/{productcode}")
	public ResponseEntity<List<Products>> getProductsByProductCode(@PathVariable("productcode") int productcode){
		List<Products> products=this.productService.getProductByProductCode(productcode);
		if(products==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		 return new ResponseEntity<>(products, HttpStatus.OK);
	}
}
