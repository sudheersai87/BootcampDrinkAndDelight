package com.cg.drinkDelight.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drinkDelight.dao.DrinkDelightDao;
import com.cg.drinkDelight.entity.Vendor;
import com.cg.drinkDelight.exception.NoVendorException;
import com.cg.drinkDelight.util.VendorConstants;

@Service
@Transactional
public class ServiceImpl implements DrinkDelightService{

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private DrinkDelightDao dao;
	
	@Override
	public Vendor viewvendor(long vendorId) throws NoVendorException{
		
		  Vendor vendor = dao.viewVendor(vendorId); 
		  if(vendor==null ) 
			  throw new NoVendorException(VendorConstants.VENDORID_DOES_NOT_EXIST); 
		  return vendor;
		 
		/* return dao.viewvendor(vendorId); */
	}

	@Override
	public List<Vendor> viewvendorbyType(String VendorType) throws NoVendorException {
		List<Vendor> plist = dao.viewVendorbyType(VendorType);
		if(plist.isEmpty())
			throw new NoVendorException(VendorConstants.VENDOR_TYPE_DOES_NOT_EXIST);
		plist.sort((v1,v2)->v1.getVendorType().compareTo(v2.getVendorType()));
		return plist;
	}

	@Override
	public List<Vendor> viewvendors() throws NoVendorException {
		List<Vendor> plst = dao.viewVendors();
		if(plst.isEmpty())
			throw new NoVendorException(VendorConstants.VENDOR_DOES_NOT_EXIST);
		return plst;
	}

	@Override
	public boolean addvendor(Vendor vendor) throws NoVendorException {
		return dao.addVendor(vendor);

	}

	@Override
	public boolean editvendor(Vendor vendor) {
		return dao.editVendor(vendor);
	}

	
	
}
