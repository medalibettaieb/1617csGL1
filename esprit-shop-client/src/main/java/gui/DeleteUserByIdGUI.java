package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.User;
import services.UserServicesRemote;

public class DeleteUserByIdGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("esprit-shop-ear/esprit-shop-ejb/UserServices!services.UserServicesRemote");

		User userFound = userServicesRemote.findUserById(2);

		userServicesRemote.deleteUserById(2);

	}

}
