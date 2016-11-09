package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.ProductServicesRemote;

public class TestSaveOrUpdatePurchase {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProductServicesRemote productServicesRemote = (ProductServicesRemote) context
				.lookup("esprit-shop-ear/esprit-shop-ejb/ProductServices!services.ProductServicesRemote");

		productServicesRemote.saveOrUpdatePurchase(1, 1, 10);
	}

}
