package mBeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Product;
import services.ProductServicesLocal;

@ManagedBean
@SessionScoped
public class CartBean {
	private Map<Product, Integer> cartMap = new HashMap<>();
	private Product product = new Product();
	private List<Product> products;
	private Integer quantity;
	private int catMapSize;
	private List<Entry<Product, Integer>> productsInCart;
	@EJB
	private ProductServicesLocal productServicesLocal;

	public void select() {

	}

	public void doAddToCart() {
		if (cartMap.containsKey(product)) {
			cartMap.put(product, cartMap.get(product) + quantity);
		} else {
			cartMap.put(product, quantity);
		}

	}

	public Map<Product, Integer> getCartMap() {
		return cartMap;
	}

	public void setCartMap(Map<Product, Integer> cartMap) {
		this.cartMap = cartMap;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		products = productServicesLocal.findAllProducts();
		System.out.println(products.size());
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Entry<Product, Integer>> getProductsInCart() {
		productsInCart = new ArrayList<>(cartMap.entrySet());
		return productsInCart;
	}

	public void setProductsInCart(List<Entry<Product, Integer>> productsInCart) {
		this.productsInCart = productsInCart;
	}

}
