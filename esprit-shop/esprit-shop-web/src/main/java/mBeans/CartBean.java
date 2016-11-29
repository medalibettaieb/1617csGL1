package mBeans;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Product;
import services.ProductServicesLocal;

@ManagedBean
@SessionScoped
public class CartBean {
	private Map<Product, Integer> cartMap = new HashMap<>();
	private int productId;
	private Integer quantity;
	private int catMapSize;
	@EJB
	private ProductServicesLocal productServicesLocal;

	public void addToCart(Product product, Integer quantity) {
		cartMap.put(product, quantity);
	}

	public void doAddToCart() {
		Product product = productServicesLocal.findProductById(productId);
		cartMap.put(product, quantity);
	}

	public Map<Product, Integer> getCartMap() {
		return cartMap;
	}

	public void setCartMap(Map<Product, Integer> cartMap) {
		this.cartMap = cartMap;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public int getCatMapSize() {
		catMapSize = cartMap.size();
		return catMapSize;
	}

	public void setCatMapSize(int catMapSize) {
		this.catMapSize = catMapSize;
	}

}
