package services;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import entities.Product;
import entities.Store;

@Remote
public interface StoreServicesRemote {
	void exposeProductsInStore(List<Product> products, int storeId);

	Store findStoreById(int storeId);

	Map<Store, Integer> findTotalQuantitySoldOfProductInEachStore(int productId);
}
