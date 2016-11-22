package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Company;
import entities.Customer;
import entities.User;
import services.UserServicesLocal;

@ManagedBean
@SessionScoped
public class Identity {
	private User user = new User();
	@EJB
	private UserServicesLocal userServicesLocal;

	public String doLogin() {
		String navigateTo = null;
		User userLoggedIn = userServicesLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			if (userLoggedIn instanceof Company) {
				navigateTo = "/pages/companyHome/home";
			} else if (userLoggedIn instanceof Customer) {
				navigateTo = "/pages/customerHome/home";
			}
		} else {
			navigateTo = "/horror";
		}
		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
