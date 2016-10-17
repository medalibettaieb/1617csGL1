package gui;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.User;
import services.UserServicesRemote;

public class FindAllUsersGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("esprit-shop-ear/esprit-shop-ejb/UserServices!services.UserServicesRemote");

		List<User> users = userServicesRemote.findAllUsers();
		for (User u : users) {
			System.out.println(u.getName());
		}

	}

}
