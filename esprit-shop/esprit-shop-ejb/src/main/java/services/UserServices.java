package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Company;
import entities.Product;
import entities.User;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
	}

	@Override
	public User findUserById(int idUser) {
		return entityManager.find(User.class, idUser);
	}

	@Override
	public void deleteUserById(int idUser) {
		entityManager.remove(findUserById(idUser));
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(entityManager.merge(user));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		String jbql = "SELECT u FROM User u";
		Query query = entityManager.createQuery(jbql);
		return query.getResultList();
	}

	@Override
	public void assignProductsToUser(List<Product> products, int idProvider) {
		Company company = (Company) findUserById(idProvider);
		company.linkProductsToThisUser(products);

		saveOrUpadate(company);

	}

	@Override
	public void saveOrUpadate(User user) {
		entityManager.merge(user);
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.login=:param1 AND u.password=:param2");
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("user not found");
		}
		return user;
	}

}
