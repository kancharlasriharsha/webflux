package com.nisum.domain;

public class Address {

	private String address;

	public Address() {
		super();
	}

	public Address(String address) {
		super();
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return address.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Address other = (Address)obj;
		return address.equals(other.getAddress());
	}
	
	


	
	

}
