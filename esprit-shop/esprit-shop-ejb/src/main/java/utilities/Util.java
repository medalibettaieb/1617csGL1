package utilities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Category;
import entities.City;
import entities.Company;
import entities.Customer;
import entities.Product;
import entities.Store;
import services.ProductServicesLocal;
import services.UserServicesLocal;

/**
 * Session Bean implementation class Util
 */
@Singleton
@LocalBean
@Startup
public class Util {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private UserServicesLocal userServicesLocal;
	@EJB
	private ProductServicesLocal productServicesLocal;

	/**
	 * Default constructor.
	 */
	public Util() {
	}

	@PostConstruct
	public void initDB() {
		City city = new City("jupiter");

		Store store = new Store("storeOne");
		Store store2 = new Store("storeTow");
		Store store3 = new Store("storeThree");

		List<Store> stores = new ArrayList<>();
		stores.add(store);
		stores.add(store2);
		stores.add(store3);

		city.linkStoresToThisCity(stores);

		Customer customer = new Customer();
		customer.setName("salah");
		customer.setBalance(100F);

		Company company = new Company();
		company.setName("sdf");
		company.setLogo("street");

		Category category = new Category();
		category.setName("labsa");

		Category category2 = new Category();
		category2.setName("mawad tandhif");

		Product product = new Product("saboon", 10F);
		product.setCategory(category2);
		Product product2 = new Product("chleka", 15F);
		product2.setCategory(category);
		Product product3 = new Product("sabbat", 20F);
		product3.setCategory(category);

		List<Product> products = new ArrayList<>();
		products.add(product);
		products.add(product2);
		products.add(product3);

		company.linkProductsToThisUser(products);

		userServicesLocal.saveOrUpadate(customer);
		userServicesLocal.saveOrUpadate(company);

		entityManager.merge(city);
	}
}
