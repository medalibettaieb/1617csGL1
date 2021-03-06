package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Company;
import entities.Customer;
import services.UserServicesRemote;

public class AddUserGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("esprit-shop-ear/esprit-shop-ejb/UserServices!services.UserServicesRemote");

		Customer customer = new Customer();
		customer.setName("salah");
		customer.setBalance(100F);

		Company company = new Company();
		company.setName("sdf");
		company.setLogo("street");

		userServicesRemote.saveOrUpadate(customer);
		userServicesRemote.saveOrUpadate(company);

	}

}
