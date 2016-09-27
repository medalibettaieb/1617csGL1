package sample;

import javax.ejb.Stateless;

@Stateless
public class GreetingsServices implements GreetingsServicesRemote, GreetingsServicesLocal {

	@Override
	public String sayAhla(String name) {
		return "ahla w sahla ya : " + name;
	}

}
