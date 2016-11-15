package services;

import javax.ejb.Remote;

import entities.City;

@Remote
public interface CityServicesRemote {
	void saveOrUpdateCity(City city);
}
