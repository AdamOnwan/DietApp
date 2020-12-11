package com.onwan.dietapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onwan.dietapp.entities.Address;
import com.onwan.dietapp.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepo;
	

	@Override
	public List<Address> allAddresses() {
		return addressRepo.findAll();
	}

	@Override
	public List<Address> findAddressByEmail(String email) {
		return addressRepo.findByUsersEmail(email);
	}

	@Override
	public Address createAddress(Address address) {
		addressRepo.saveAndFlush(address);
		return address;
	}

	@Override
	public Address updateAddress(Address address, int addressId) {
		Address existing = null;
		Optional<Address> op = addressRepo.findById(addressId);
		if (op.isPresent()) {
			existing = op.get();
			existing.setAddress(address.getAddress());
			existing.setAddress2(address.getAddress2());
			existing.setCity(address.getCity());
			existing.setState(address.getState());
			existing.setPostalCode(address.getPostalCode());
			existing.setCountry(address.getCountry());
			addressRepo.saveAndFlush(existing);
		} else {
			return null;
		}
		return existing;
	}

	@Override
	public boolean delete(int addressId) {
		boolean successful = true;
		if (!addressRepo.existsById(addressId)) {
			return false;
		} else {
			addressRepo.deleteById(addressId);
			return successful;
		}
	}
}
