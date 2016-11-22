package services;

import java.util.List;

import javax.ejb.Remote;

import entities.Product;
import entities.User;

@Remote
public interface UserServicesRemote {
	User findUserById(int idUser);

	void deleteUserById(int idUser);

	void deleteUser(User user);

	void saveOrUpadate(User user);

	List<User> findAllUsers();

	void assignProductsToUser(List<Product> products, int idProvider);

	User login(String login, String password);
}
