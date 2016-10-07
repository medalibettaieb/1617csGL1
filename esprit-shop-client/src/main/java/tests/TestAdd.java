package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.CalculatorServiceRemote;

public class TestAdd {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			CalculatorServiceRemote proxy = (CalculatorServiceRemote) context
					.lookup("esprit-shop-ear/esprit-shop-ejb/CalculatorService!services.CalculatorServiceRemote");

			System.out.println(proxy.add(1, 3));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
