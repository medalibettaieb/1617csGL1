package gui;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Product;
import services.ProductServicesRemote;

public class FindAllProductsByCompany {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProductServicesRemote productServicesRemote = (ProductServicesRemote) context
				.lookup("esprit-shop-ear/esprit-shop-ejb/ProductServices!services.ProductServicesRemote");

		List<Product> products=productServicesRemote.findProductsByCompany(4);
		System.out.println(products.size());
	}

}
