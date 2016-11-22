package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.User;
import services.UserServicesRemote;

public class TestLogin {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("esprit-shop-ear/esprit-shop-ejb/UserServices!services.UserServicesRemote");

		User user = userServicesRemote.login("c1", "c1");
		System.out.println(user);

	}

}
