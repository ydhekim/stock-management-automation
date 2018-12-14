package io.github.ydhekim.stock_management_automation.dao;

import java.util.ArrayList;

import io.github.ydhekim.stock_management_automation.model.Supplier;

public interface SupplierDAO {
	
	public void insertSupplier(int supplierId, String supplierName, int productId);
	
	public void deleteSupplier(int supplierId);
	
	public void updateSupplier(int supplierId, String supplierName, int productId);
	
	public Supplier getSupplier(int supplierId);
	
	public ArrayList<Supplier> getAllSuppliers(); 

}
