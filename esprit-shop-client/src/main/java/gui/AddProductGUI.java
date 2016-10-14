package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Product;
import services.ProductServicesRemote;

public class AddProductGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProductServicesRemote productServicesRemote = (ProductServicesRemote) context
				.lookup("esprit-shop-ear/esprit-shop-ejb/ProductServices!services.ProductServicesRemote");

		Product product = new Product();
		product.setName("saboon");
		product.setPrice(100F);

		productServicesRemote.addProduct(product);
	}

}
