package com.cg.drinkDelight.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="cg_inventory")
public class InventoryTxn  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="inventory_id")
	private long inventoryId;

	@Column(name="quantity")
	private int qty;

	@Column(name="Date_of_txn")
	private LocalDate dateOfTxn;

	@Column(name="text_type", length=25)
	private String txtType;

	@ManyToOne
	@JoinColumn(name="product_id",referencedColumnName = "product_Id")
	private Product prod = new Product();

	@ManyToOne
	@JoinColumn(name="vendor_id",referencedColumnName = "vendor_id")
	private Vendor vendor = new Vendor();



	public InventoryTxn(long inventoryId, int qty, LocalDate dateOfTxn, String txtType) {
		super();
		this.inventoryId = inventoryId;
		this.qty = qty;
		this.dateOfTxn = dateOfTxn;
		this.txtType = txtType;
	}

	public InventoryTxn() {
		super();
	}

	public long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public LocalDate getDateOfTxn() {
		return dateOfTxn;
	}

	public void setDateOfTxn(LocalDate dateOfTxn) {
		this.dateOfTxn = dateOfTxn;
	}

	public String getTxtType() {
		return txtType;
	}

	public void setTxtType(String txtType) {
		this.txtType = txtType;
	}

	public Product getProd() {
		return prod;
	}
	
	public void setProd(Product prod) {
		this.prod = prod;
	}
	
	public Vendor getVendor() {
		return vendor;
	}
	
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	

}


