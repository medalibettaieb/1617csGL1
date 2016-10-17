package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public void addUser(User user) {
		entityManager.persist(user);
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

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

}
