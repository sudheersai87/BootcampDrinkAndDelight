package com.cg.drinkDelight.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.drinkDelight.entity.Vendor;
import com.cg.drinkDelight.exception.NoVendorException;
import com.cg.drinkDelight.service.DrinkDelightService;

@RestController
public class VendorController {
	Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

	@Autowired
	private DrinkDelightService ser;
	
	@CrossOrigin()
	@GetMapping("/search/{vendortype}")
	public List<Vendor> displayVendors(@PathVariable("vendortype")String vendortype) throws NoVendorException{
		logger.info("searching the vendor by vendorType");
		return ser.viewvendorbyType(vendortype);
	}
	
	@CrossOrigin(origins = {"http://localhost:4200"})
	@GetMapping("/viewvendor/{vendorId}")
	public Vendor viewvendor(@PathVariable("vendorId")long vendorId) throws NoVendorException 
	{
		logger.info("searching the vendor by vendorId");

		return ser.viewvendor(vendorId);
	}
	
	@CrossOrigin(origins = {"http://localhost:4200"})
	@GetMapping("/viewvendors")
	public List<Vendor> viewvendors() throws NoVendorException {
		logger.info("Display Vendors list");

		return ser.viewvendors();
	}
	
	@CrossOrigin(origins = {"http://localhost:4200"})
	@PostMapping("/addvendor")
	public boolean addvendor(@RequestBody Vendor vendor) throws NoVendorException {
		
		return ser.addvendor(vendor);
	}
	
	@CrossOrigin(origins = {"http://localhost:4200"})
	@PutMapping("/editvendor")
	public boolean editvendor(@RequestBody Vendor vendor) throws NoVendorException {
		return ser.editvendor(vendor);
	}

}
