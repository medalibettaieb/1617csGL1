package services;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServicesRemote {
	void addUser(User user);

	User findUserById(int idUser);

	void deleteUserById(int idUser);

	void deleteUser(User user);

	void updateUser(User user);
}
