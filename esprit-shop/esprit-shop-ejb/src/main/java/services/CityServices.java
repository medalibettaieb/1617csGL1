package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.City;

/**
 * Session Bean implementation class CityServices
 */
@Stateless
public class CityServices implements CityServicesRemote, CityServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CityServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveOrUpdateCity(City city) {
		entityManager.merge(city);
	}

}
