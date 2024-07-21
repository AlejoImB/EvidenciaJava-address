package com.Alejandro.c24.service;

import com.Alejandro.c24.entity.Address;
import com.Alejandro.c24.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectgigMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllAddresses() {
        addressService.getAllAddresses();
        verify(addressRepository, times(1)).findAll();
    }

    @Test
    public void testGetAddressById() {
        Long id = 1L;
        Address address = new Address();
        when(addressRepository.findById(id)).thenReturn(Optional.of(address));

        Optional<Address> foundAddress = addressService.getAddressById(id);

        assertTrue(foundAddress.isPresent());
        assertEquals(foundAddress.get(), address);
        verify(addressRepository, times(1)).findById(id);
    }

    @Test
    public void testCreateAddress() {
        Address address = new Address();
        when(addressRepository.save(address)).thenReturn(address);

        Address createdAddress = addressService.createAddress(address);

        assertEquals(createdAddress, address);
        verify(addressRepository, times(1)).save(address);
    }

    @Test
    public void testUpdateAddress() {
        Long id = 1L;
        Address existingAddress = new Address();
        Address addressDetails = new Address();
        addressDetails.setStreet("Updated Street");
        addressDetails.setCity("Updated City");
        addressDetails.setState("Updated State");
        addressDetails.setZipCode("Updated ZipCode");

        when(addressRepository.findById(id)).thenReturn(Optional.of(existingAddress));
        when(addressRepository.save(existingAddress)).thenReturn(existingAddress);

        Optional<Address> updatedAddress = addressService.updateAddress(id, addressDetails);

        assertTrue(updatedAddress.isPresent());
        assertEquals(updatedAddress.get().getStreet(), addressDetails.getStreet());
        assertEquals(updatedAddress.get().getCity(), addressDetails.getCity());
        assertEquals(updatedAddress.get().getState(), addressDetails.getState());
        assertEquals(updatedAddress.get().getZipCode(), addressDetails.getZipCode());
        verify(addressRepository, times(1)).findById(id);
        verify(addressRepository, times(1)).save(existingAddress);
    }

    @Test
    public void testDeleteAddress() {
        Long id = 1L;
        Address address = new Address();
        when(addressRepository.findById(id)).thenReturn(Optional.of(address));

        boolean isDeleted = addressService.deleteAddress(id);

        assertTrue(isDeleted);
        verify(addressRepository, times(1)).findById(id);
        verify(addressRepository, times(1)).delete(address);
    }

    @Test
    public void testDeleteAddress_NotFound() {
        Long id = 1L;
        when(addressRepository.findById(id)).thenReturn(Optional.empty());

        boolean isDeleted = addressService.deleteAddress(id);

        assertFalse(isDeleted);
        verify(addressRepository, times(1)).findById(id);
        verify(addressRepository, times(0)).delete(any(Address.class));
    }
}
