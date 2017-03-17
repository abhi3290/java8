package com.abhi.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Abhishek on 2/6/2017.
 */
public class OptionalApp {

	public static void main(String[] args) throws AddressNotFound {
		Customer customer = new Customer();

		Address address = null;
		Optional<Address> addressOptional = Optional.of(address);
		Address returnedAddress = addressOptional.orElse(new Address("asd"));

		Address address1 = addressOptional.orElseThrow(AddressNotFound::new);
		addressOptional.orElseGet(() -> new Address("AHMEDABAD"));

	}

	public static String getData(Optional<Address> addressOptional) throws NoSuchElementException {
		if(addressOptional.isPresent()) {
			String city = addressOptional.get().getCity();
		}
		return null;
	}
}

class Customer {
	private Optional<Address> addressOptional;

	public Optional<Address> getAddressOptional() {
		return addressOptional;
	}

	public void setAddressOptional(Optional<Address> addressOptional) {
		this.addressOptional = addressOptional;
	}
}

class Address {
	private String streetNo;
	private String city;
	private String state;

	public Address(String city) {
		this.city = city;
	}
	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}

class AddressNotFound extends Exception {

}