package com.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="c_id")
	private int id;
	private String name;
	private String city;
	private int pincode;
	
	@OneToMany(mappedBy="customer")
	private Set<OrderDetail> order = new HashSet<OrderDetail>();
    
    //getter..Setter//....

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Set<OrderDetail> getOrder() {
		return order;
	}

	public void setOrder(Set<OrderDetail> order) {
		this.order = order;
	}
	
	
	
	
}
