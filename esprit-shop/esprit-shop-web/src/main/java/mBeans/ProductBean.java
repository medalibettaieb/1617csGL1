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
	private Boolean displayF1 = true;
	private Boolean displayF2 = false;

	private Product product = new Product();
	private List<Product> products = new ArrayList<>();
	@EJB
	private ProductServicesLocal productServicesLocal;
	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	public List<Product> getProducts() {
		products = productServicesLocal.findProductsByCompany(identity.getUser().getId());
		return products;
	}

	public void select() {
		displayF1 = false;
		displayF2 = true;
	}

	public void cancel() {
		displayF1 = true;
		displayF2 = false;
		product = new Product();
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

	public Boolean getDisplayF1() {
		return displayF1;
	}

	public void setDisplayF1(Boolean displayF1) {
		this.displayF1 = displayF1;
	}

	public Boolean getDisplayF2() {
		return displayF2;
	}

	public void setDisplayF2(Boolean displayF2) {
		this.displayF2 = displayF2;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
