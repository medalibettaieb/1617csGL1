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
import services.CityServicesLocal;
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
	private CityServicesLocal cityServicesLocal;
	@EJB
	private ProductServicesLocal productServicesLocal;

	/**
	 * Default constructor.
	 */
	public Util() {
	}

	@PostConstruct
	public void initDB() {
		// create users
		Customer customer = new Customer("salah", 500F);
		customer.setLogin("c1");
		customer.setPassword("c1");
		Customer customer2 = new Customer("emna", 600F);
		customer2.setLogin("c2");
		customer2.setPassword("c2");
		Customer customer3 = new Customer("sofiene", 400F);
		customer3.setLogin("c3");
		customer3.setPassword("c3");

		// create 3 companies
		Company company = new Company();
		company.setName("ABC");
		company.setLogo("street");
		company.setLogin("COM1");
		company.setPassword("COM1");

		Company company2 = new Company();
		company2.setName("SmartOne");
		company2.setLogo("teck");
		company2.setLogin("COM2");
		company2.setPassword("COM2");

		Company company3 = new Company();
		company3.setName("SelfMarcket");
		company3.setLogo("you");
		company3.setLogin("COM3");
		company3.setPassword("COM3");

		// create Products
		Product product = new Product("chleka", 10F);
		product.setCategory(Category.LABSA);

		Product product2 = new Product("saboun", 15F);
		product2.setCategory(Category.MAWAD_TANDHIF);

		Product product3 = new Product("tajine", 20F);
		product3.setCategory(Category.MEKLA);

		Product product4 = new Product("ma9rouna", 25F);
		product4.setCategory(Category.MEKLA);

		// link products to companies
		List<Product> products = new ArrayList<>();
		products.add(product);
		products.add(product2);

		company.linkProductsToThisUser(products);

		List<Product> products2 = new ArrayList<>();
		products2.add(product3);

		company2.linkProductsToThisUser(products2);

		List<Product> products3 = new ArrayList<>();
		products3.add(product4);

		company3.linkProductsToThisUser(products3);

		// create 2 cities
		City city = new City("eastSide");
		City city2 = new City("ouestSide");

		// create 3 stores
		Store store = new Store("storeOne");
		Store store2 = new Store("storeTow");
		Store store3 = new Store("storeThree");

		// link stores to cities
		List<Store> stores = new ArrayList<>();
		stores.add(store);
		stores.add(store2);

		List<Store> stores2 = new ArrayList<>();
		stores2.add(store3);

		city.linkStoresToThisCity(stores);
		city2.linkStoresToThisCity(stores2);

		// ............................

		userServicesLocal.saveOrUpadate(customer);
		userServicesLocal.saveOrUpadate(customer2);
		userServicesLocal.saveOrUpadate(customer3);

		userServicesLocal.saveOrUpadate(company);
		userServicesLocal.saveOrUpadate(company2);
		userServicesLocal.saveOrUpadate(company3);

		cityServicesLocal.saveOrUpdateCity(city);
		cityServicesLocal.saveOrUpdateCity(city2);
	}
}
