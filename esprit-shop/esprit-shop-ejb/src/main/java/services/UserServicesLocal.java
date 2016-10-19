package services;

import java.util.List;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserServicesLocal {
	void addUser(User user);

	User findUserById(int idUser);

	void deleteUserById(int idUser);

	void deleteUser(User user);

	void updateUser(User user);

	List<User> findAllUsers();
}
