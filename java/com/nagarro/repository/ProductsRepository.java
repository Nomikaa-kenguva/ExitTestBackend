package com.nagarro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.entitys.Products;

public interface ProductsRepository extends CrudRepository<Products, Integer>{
	public List<Products> findByproductname(String productname);
	public List<Products> findBybrand(String brand);
	public List<Products> findByproductcode(int productcode);
}
