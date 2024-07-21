package com.Alejandro.c24.service;

import com.Alejandro.c24.entity.Address;
import com.Alejandro.c24.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> updateAddress(Long id, Address addressDetails) {
        return addressRepository.findById(id).map(address -> {
            address.setStreet(addressDetails.getStreet());
            address.setCity(addressDetails.getCity());
            address.setState(addressDetails.getState());
            address.setZipCode(addressDetails.getZipCode());
            return addressRepository.save(address);
        });
    }

    @Override
    public boolean deleteAddress(Long id) {
        return addressRepository.findById(id).map(address -> {
            addressRepository.delete(address);
            return true;
        }).orElse(false);
    }
}
