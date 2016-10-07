package services;

import javax.ejb.Remote;

@Remote
public interface CalculatorServiceRemote {
	int add(int a, int b);

}
