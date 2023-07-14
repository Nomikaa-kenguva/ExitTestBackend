package com.nagarro.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="servicability")
public class Servicability {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	int id;
	 @Column(name="pincodes")
	int pincodes;
	 @Column(name="estimateddays")
		int estimateddays;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPincodes() {
		return pincodes;
	}
	public void setPincodes(int pincodes) {
		this.pincodes = pincodes;
	}

	public int getEstimateddays() {
		return estimateddays;
	}
	public void setEstimateddays(int estimateddays) {
		this.estimateddays = estimateddays;
	}
	@Override
	public String toString() {
		return "Serviceability [id=" + id + ", pincodes=" + pincodes + ", estimateddays="
				+ estimateddays + "]";
	}
}
