package services;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalculatorService
 */
@Stateless
public class CalculatorService implements CalculatorServiceRemote, CalculatorServiceLocal {

	/**
	 * Default constructor.
	 */
	public CalculatorService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(int a, int b) {
		return a + b;
	}

}
