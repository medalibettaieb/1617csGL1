package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import entities.Product;
import services.ProductServicesLocal;

@ManagedBean
@ViewScoped
public class ProductBean {
	private List<Product> products = new ArrayList<>();
	@EJB
	private ProductServicesLocal productServicesLocal;
	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	public List<Product> getProducts() {
		products = productServicesLocal.findProductsByCompany(identity.getUser().getId());
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

}
