package com.cg.drinkDelight.dao;

import java.util.List;

import com.cg.drinkDelight.entity.Vendor;

public interface DrinkDelightDao {

	public Vendor viewVendor(long vendorId);
	public List<Vendor> viewVendors();
	public List<Vendor> viewVendorbyType(String VendorType);
	public boolean addVendor(Vendor vendor);
	public boolean editVendor(Vendor vendor);
}
