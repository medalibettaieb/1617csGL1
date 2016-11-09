package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: PurchaseDetail
 *
 */
@Entity

public class PurchaseDetail implements Serializable {
	@EmbeddedId
	private PurchaseDetailId purchaseDetailId;
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", updatable = false, insertable = false)
	private User customer;

	@ManyToOne
	@JoinColumn(name = "idProduct", referencedColumnName = "id", updatable = false, insertable = false)
	private Product product;
	private static final long serialVersionUID = 1L;

	public PurchaseDetail() {
		super();
	}

	public PurchaseDetail(Integer quantity, User customer, Product product) {
		super();
		this.quantity = quantity;
		this.customer = customer;
		this.product = product;
		this.purchaseDetailId = new PurchaseDetailId(customer.getId(), product.getId());

	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PurchaseDetailId getPurchaseDetailId() {
		return purchaseDetailId;
	}

	public void setPurchaseDetailId(PurchaseDetailId purchaseDetailId) {
		this.purchaseDetailId = purchaseDetailId;
	}

}
