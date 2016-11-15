package services;

import javax.ejb.Local;

import entities.City;

@Local
public interface CityServicesLocal {
	void saveOrUpdateCity(City city);
}
