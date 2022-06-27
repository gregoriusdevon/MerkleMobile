package com.merkle.Data.Model.Users;

public class Address{
	private String zipcode;
	private int number;
	private String city;
	private String street;
	private Geolocation geolocation;

	public String getZipcode(){
		return zipcode;
	}

	public int getNumber(){
		return number;
	}

	public String getCity(){
		return city;
	}

	public String getStreet(){
		return street;
	}

	public Geolocation getGeolocation(){
		return geolocation;
	}
}
