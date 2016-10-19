package services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Company;
import entities.Product;

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
	public void addProduct(Product product) {
		entityManager.persist(product);
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

}
