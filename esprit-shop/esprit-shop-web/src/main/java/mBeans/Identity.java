package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Company;
import entities.Customer;
import entities.User;
import services.UserServicesLocal;

@ManagedBean
@SessionScoped
public class Identity {
	private User user = new User();
	private Boolean isLogged = false;
	@EJB
	private UserServicesLocal userServicesLocal;

	public String doLogin() {
		String navigateTo = null;
		User userLoggedIn = userServicesLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			isLogged = true;
			if (userLoggedIn instanceof Company) {
				navigateTo = "/pages/companyHome/manageProducts?faces-redirect=true";
			} else if (userLoggedIn instanceof Customer) {
				navigateTo = "/pages/customerHome/home?faces-redirect=true";
			}
		} else {
			navigateTo = "/horror?faces-redirect=true";
		}
		return navigateTo;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		isLogged = false;
		return "/login";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}
}
