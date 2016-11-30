package services;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Company;
import entities.Product;
import entities.PurchaseDetail;
import entities.User;

/**
 * Session Bean implementation class ProductServices
 */
@Stateless
public class ProductServices implements ProductServicesRemote, ProductServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private UserServicesLocal userServicesLocal;

	/**
	 * Default constructor.
	 */
	public ProductServices() {
	}

	@Override
	public void addProductWithCompany(Product product, int idCompany) {
		Company company = (Company) userServicesLocal.findUserById(idCompany);
		product.setProvider(company);

		updateProduct(product);

	}

	@Override
	public void updateProduct(Product product) {
		entityManager.merge(product);
	}

	@Override
	public void saveOrUpdatePurchase(int idCustomer, int idProduct, Integer quantity) {
		User customer = userServicesLocal.findUserById(idCustomer);
		Product product = findProductById(idProduct);
		PurchaseDetail purchaseDetail = new PurchaseDetail(quantity, customer, product);
		entityManager.merge(purchaseDetail);

	}

	@Override
	public Product findProductById(int idProduct) {
		return entityManager.find(Product.class, idProduct);
	}

	@Override
	public void saveOrUpdateProduct(Product product) {
		entityManager.merge(product);

	}

	@Override
	public Map<Product, Integer> findToTalQuantitySoldOfProductByStore(int storeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findProductsByCompany(int companyId) {
		Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.provider.id=:param");
		query.setParameter("param", companyId);
		return query.getResultList();
	}

	@Override
	public void deleteProduct(int productId) {
		entityManager.remove(findProductById(productId));

	}

	@Override
	public List<Product> findAllProducts() {
		return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
	}
}
