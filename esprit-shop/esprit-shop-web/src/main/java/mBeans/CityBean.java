package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.City;
import services.CityServicesLocal;

@ManagedBean
public class CityBean {
	private City city = new City();
	@EJB
	private CityServicesLocal cityServicesLocal;

	public String doSaveOrUpdateCity() {
		cityServicesLocal.saveOrUpdateCity(city);
		return "";
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
