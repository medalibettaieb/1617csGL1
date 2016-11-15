package services;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import entities.Product;
import entities.Store;

@Local
public interface StoreServicesLocal {
	void exposeProductsInStore(List<Product> products, int storeId);

	Store findStoreById(int storeId);

	Map<Store, Integer> findTotalQuantitySoldOfProductInEachStore(int productId);
}
