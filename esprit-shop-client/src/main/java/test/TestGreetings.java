package test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import sample.GreetingsServicesRemote;

public class TestGreetings {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();

		String jndiName = "esprit-shop-ear/esprit-shop-ejb/GreetingsServices!sample.GreetingsServicesRemote";
		GreetingsServicesRemote proxy = (GreetingsServicesRemote) context.lookup(jndiName);

		System.out.println(proxy.sayAhla("daly"));

	}
}
