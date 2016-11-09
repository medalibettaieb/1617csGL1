package services;

import javax.ejb.Remote;

import entities.Product;

@Remote
public interface ProductServicesRemote {
	void addProduct(Product product);

	void addProductWithCompany(Product product, int idCompany);

	void updateProduct(Product product);

	void saveOrUpdatePurchase(int idCustomer, int idProduct, Integer quantity);

	Product findProductById(int idProduct);

}
