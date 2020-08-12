package com.cg.drinkDelight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="cg_vendor")

public class Vendor {

	@Id
	@Column(name="vendor_id")
	private long vendorId;

	
	@Column(name="company_name")
	private String companyName;

	
	@Column(name="address")
	private String address;
	@Column(name="area")
	private String area;

	
	@Column(name="Contact")
	private String Contact;

	
	@Column(name="city")
	private String city;

	
	@Column(name="vendor_Type")
	private String vendorType;

	public Vendor(long vendorId, String companyName, String address, String area, String contact, String city,
			String vendorType) {
		super();
		this.vendorId = vendorId;
		this.companyName = companyName;
		this.address = address;
		this.area = area;
		Contact = contact;
		this.city = city;
		this.vendorType = vendorType;
	}

	public Vendor() {

	}

	@Override
	public String toString() {

		return companyName+""+address+""+area+""+vendorId+""+Contact+""+city+""+vendorType;
	}

	
	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		this.Contact = contact;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}


}

