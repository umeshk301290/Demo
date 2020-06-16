package com.example.demo.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Column(name = "addressid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long addressid;
	@Column(name = "distric")
	String distric;
	@Column(name = "postcode")
	String postcode;
	@ManyToOne
	@JoinColumn(name = "adid",referencedColumnName = "id")
	ClientData data;
	public Long getAddressid() {
		return addressid;
	}
	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}
	public String getDistric() {
		return distric;
	}
	public void setDistric(String distric) {
		this.distric = distric;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public ClientData getData() {
		return data;
	}
	public void setData(ClientData data) {
		this.data = data;
	}
	
}
