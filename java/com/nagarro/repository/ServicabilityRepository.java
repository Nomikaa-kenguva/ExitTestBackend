package com.nagarro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.entitys.Servicability;

public interface ServicabilityRepository extends CrudRepository<Servicability,Integer>{
	public List<Servicability> findBypincodes(int pincodes);
}