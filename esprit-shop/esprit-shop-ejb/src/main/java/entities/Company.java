package entities;

import entities.User;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Company
 *
 */
@Entity

public class Company extends User implements Serializable {

	
	private String logo;
	private static final long serialVersionUID = 1L;

	public Company() {
		super();
	} 
	
	public Company(String name, String logo) {
		super(name);
		this.logo = logo;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Company [logo=" + logo + "]";
	}
   
}
