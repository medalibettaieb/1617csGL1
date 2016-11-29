package gui;

import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Category;
import services.UserServicesRemote;

public class TestCategory {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("esprit-shop-ear/esprit-shop-ejb/UserServices!services.UserServicesRemote");

		List<Category> list = Arrays.asList(Category.values());
		System.out.println(list.size());

	}

}
