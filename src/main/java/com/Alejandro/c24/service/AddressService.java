package com.Alejandro.c24.service;

import com.Alejandro.c24.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAllAddresses();
    Optional<Address> getAddressById(Long id);
    Address createAddress(Address address);
    Optional<Address> updateAddress(Long id, Address addressDetails);
    boolean deleteAddress(Long id);
}
