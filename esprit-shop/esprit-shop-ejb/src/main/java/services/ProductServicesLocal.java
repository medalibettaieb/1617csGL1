package services;

import javax.ejb.Local;

import entities.Product;

@Local
public interface ProductServicesLocal {
	void addProduct(Product product);

	Product findProductById(int idProduct);
}
