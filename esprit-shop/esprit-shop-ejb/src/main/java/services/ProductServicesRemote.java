package services;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import entities.Product;

@Remote
public interface ProductServicesRemote {
	void saveOrUpdateProduct(Product product);

	void addProductWithCompany(Product product, int idCompany);

	void updateProduct(Product product);

	void saveOrUpdatePurchase(int idCustomer, int idProduct, Integer quantity);

	Product findProductById(int idProduct);

	Map<Product, Integer> findToTalQuantitySoldOfProductByStore(int storeId);

	List<Product> findProductsByCompany(int companyId);

	void deleteProduct(int productId);
}
