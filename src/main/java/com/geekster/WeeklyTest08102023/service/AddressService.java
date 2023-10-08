package com.geekster.WeeklyTest08102023.service;

import com.geekster.WeeklyTest08102023.model.Address;
import com.geekster.WeeklyTest08102023.repo.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private IAddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public String createAddress(Address address) {
        addressRepository.save(address);
        return "New Address added";
    }

    public String createAddresses(List<Address> addressList) {
        addressRepository.saveAll(addressList);
        return "New Addresses added";
    }

    public Address updateAddress(Long id, Address updatedAddress) {
        Address existingAddress = addressRepository.findById(id).orElse(null);
        if (existingAddress != null) {
            existingAddress.setLandmark(updatedAddress.getLandmark());
            existingAddress.setZipcode(updatedAddress.getZipcode());

            return addressRepository.save(existingAddress);
        }
        return null;
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
