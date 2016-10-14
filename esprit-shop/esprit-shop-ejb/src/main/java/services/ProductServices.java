package services;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class ProductServices
 */
@Stateless
public class ProductServices implements ProductServicesRemote, ProductServicesLocal {

    /**
     * Default constructor. 
     */
    public ProductServices() {
        // TODO Auto-generated constructor stub
    }

}
