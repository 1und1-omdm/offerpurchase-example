package com.skillacademy.offerpurchase;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Contract implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	Long pk;  // primary key

	@Version
	long version;

	String id;
	String customerId;
	String product;

	public Contract(){}

	public Contract(String customerId, String product) {
		this.customerId = customerId;
		this.product = product;
	}

	public Long getPk() {
		return pk;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getcustomerId() {
		return customerId;
	}

	public void setcustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Contract customer = (Contract) o;

		return id != null ? id.equals(customer.id) : customer.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Contract{" +
				"pk=" + pk +
				", version=" + version +
				", id='" + id + '\'' +
				", customerId='" + customerId + '\'' +
				", product='" + product + '\'' +
				'}';
	}
}
