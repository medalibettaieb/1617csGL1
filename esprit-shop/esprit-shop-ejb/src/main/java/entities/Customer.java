package entities;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity

public class Customer extends User implements Serializable {

	private Float balance;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}

	public Customer(String name, Float balance) {
		super(name);
		this.balance = balance;
	}

	public Float getBalance() {
		return this.balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [balance=" + balance + "]";
	}

}
