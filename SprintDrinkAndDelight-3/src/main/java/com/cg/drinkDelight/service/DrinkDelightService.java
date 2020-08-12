package com.cg.drinkDelight.service;

import java.util.List;

import com.cg.drinkDelight.entity.Vendor;
import com.cg.drinkDelight.exception.NoVendorException;

public interface DrinkDelightService {

	public Vendor viewvendor(long vendorId) throws NoVendorException;
	public List<Vendor> viewvendorbyType(String VendorType) throws NoVendorException;
	public List<Vendor> viewvendors() throws NoVendorException;
	public boolean addvendor(Vendor vendor)throws NoVendorException;
	public boolean editvendor(Vendor vendor) throws NoVendorException;
}
