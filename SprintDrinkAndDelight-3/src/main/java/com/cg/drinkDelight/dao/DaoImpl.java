package com.cg.drinkDelight.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.drinkDelight.entity.Vendor;

@Repository

public class DaoImpl implements DrinkDelightDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Vendor viewVendor(long vendorId) {
		return em.find(Vendor.class , vendorId);
	}

	@Override
	public List<Vendor> viewVendors() {
		String jpql= "from Vendor v ";
		TypedQuery<Vendor> query = em.createQuery(jpql, Vendor.class);
		return query.getResultList();
		
	}

	@Override
	public List<Vendor> viewVendorbyType(String VendorType) {
		String jpql = "from Vendor v where lower(v.vendorType) = lower(:vtype)";
		TypedQuery<Vendor> query = em.createQuery(jpql, Vendor.class);
		query.setParameter("vtype", VendorType);
		return query.getResultList();

	}

	@Override
	public boolean addVendor(Vendor vendor) {
		em.persist(vendor);
		return true;
	}

	@Override
	public boolean editVendor(Vendor vendor) {
		em.merge(vendor);
		return true;
	}


}
