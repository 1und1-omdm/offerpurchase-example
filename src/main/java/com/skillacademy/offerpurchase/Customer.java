package com.skillacademy.offerpurchase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	Long pk;  // primary key

	@Version
	long version;

	String id;
	String name;
	String firstName;

	public Customer(){}

	public Customer(String firstName, String name) {
		this.name = name;
		this.firstName = firstName;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Customer customer = (Customer) o;

		return id != null ? id.equals(customer.id) : customer.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"pk=" + pk +
				", version=" + version +
				", id='" + id + '\'' +
				", name='" + name + '\'' +
				", firstName='" + firstName + '\'' +
				'}';
	}
}
