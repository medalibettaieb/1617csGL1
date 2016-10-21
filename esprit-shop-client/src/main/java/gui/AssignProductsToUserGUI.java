package gui;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Product;
import services.UserServicesRemote;

public class AssignProductsToUserGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("esprit-shop-ear/esprit-shop-ejb/UserServices!services.UserServicesRemote");

		List<Product> products = new ArrayList<Product>();

		Product product = new Product("sabbat", 10F);
		Product product2 = new Product("chlaka", 15F);

		products.add(product);
		products.add(product2);

		userServicesRemote.assignProductsToUser(products, 2);
	}

}
