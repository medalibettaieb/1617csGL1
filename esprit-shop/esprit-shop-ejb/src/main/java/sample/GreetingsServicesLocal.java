package sample;

import javax.ejb.Local;

@Local
public interface GreetingsServicesLocal {
	String sayAhla(String name);
}
