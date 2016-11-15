package services;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Product;
import entities.Store;

/**
 * Session Bean implementation class StoreServices
 */
@Stateless
public class StoreServices implements StoreServicesRemote, StoreServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private ProductServicesLocal productServicesLocal;

	/**
	 * Default constructor.
	 */
	public StoreServices() {
	}

	@Override
	public void exposeProductsInStore(List<Product> products, int storeId) {
		Store store=findStoreById(storeId);
		for (Product p : products) {
			p.setStore(store);
			productServicesLocal.saveOrUpdateProduct(p);
		}
	}

	@Override
	public Store findStoreById(int storeId) {
		return entityManager.find(Store.class, storeId);
	}

	@Override
	public Map<Store, Integer> findTotalQuantitySoldOfProductInEachStore(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
