package io.github.ydhekim.stock_management_automation.dao;

import java.util.ArrayList;

import io.github.ydhekim.stock_management_automation.model.Supplier;

public interface SupplierDAO {

	void deleteSuppliert(int supplierId);

	Supplier getSupplier(int supplierId);

	void insertSupplier(int supplierId, int productId, String supplierName);

	void updateSupplier(int supplierId, int productId, String supplierName);

	ArrayList<Supplier> getAllSupliers();

}
