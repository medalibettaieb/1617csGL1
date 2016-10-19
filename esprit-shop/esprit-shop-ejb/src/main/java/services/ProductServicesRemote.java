package services;

import javax.ejb.Remote;

import entities.Product;

@Remote
public interface ProductServicesRemote {
	void addProduct(Product product);

	void addProductWithCompany(Product product, int idCompany);

}
