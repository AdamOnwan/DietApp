package com.onwan.dietapp.services;

import java.util.List;

import com.onwan.dietapp.entities.Address;

public interface AddressService {

	List<Address> allAddresses();

	List<Address> findAddressByEmail(String email);

	Address createAddress(Address address);

	Address updateAddress(Address address, int addressId);

	boolean delete(int addressId);

}
