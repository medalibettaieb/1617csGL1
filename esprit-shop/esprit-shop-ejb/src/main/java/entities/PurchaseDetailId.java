package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class PurchaseDetailId implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private int idUser;
	private int idProduct;
	private Date dateOfThePurchase;

	public PurchaseDetailId() {
	}

	public PurchaseDetailId(int idUser, int idProduct) {
		super();
		this.idUser = idUser;
		this.idProduct = idProduct;
		this.dateOfThePurchase = new Date();
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProduct;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseDetailId other = (PurchaseDetailId) obj;
		if (idProduct != other.idProduct)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	public Date getDateOfThePurchase() {
		return dateOfThePurchase;
	}

	public void setDateOfThePurchase(Date dateOfThePurchase) {
		this.dateOfThePurchase = dateOfThePurchase;
	}

}
