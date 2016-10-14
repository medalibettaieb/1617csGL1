package services;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServicesRemote {
	void addUser(User user);
}
