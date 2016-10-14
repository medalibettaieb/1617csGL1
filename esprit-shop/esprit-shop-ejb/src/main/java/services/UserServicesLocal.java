package services;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserServicesLocal {
	void addUser(User user);
}
