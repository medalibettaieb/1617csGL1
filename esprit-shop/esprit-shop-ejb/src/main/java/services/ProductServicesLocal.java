package services;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import entities.Product;

@Local
public interface ProductServicesLocal {
	void saveOrUpdateProduct(Product product);

	Product findProductById(int idProduct);

	void addProductWithCompany(Product product, int idCompany);

	void updateProduct(Product product);

	void saveOrUpdatePurchase(int idCustomer, int idProduct, Integer quantity);

	Map<Product, Integer> findToTalQuantitySoldOfProductByStore(int storeId);

	List<Product> findProductsByCompany(int companyId);

	void deleteProduct(int productId);

	List<Product> findAllProducts();
}
