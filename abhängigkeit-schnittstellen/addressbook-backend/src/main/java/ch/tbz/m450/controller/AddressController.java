package ch.tbz.m450.controller;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // Get all addresses
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAll();
        return ResponseEntity.ok(addresses);
    }

    // Get a single address by ID
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable int id) {
        Optional<Address> address = addressService.getAddress(id);
        if (address.isPresent()) {
            return ResponseEntity.ok(address.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Create a new address
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address createdAddress = addressService.save(address);
        return ResponseEntity.status(201).body(createdAddress); // HTTP 201 for resource creation
    }

    // Update an existing address
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable int id, @RequestBody Address addressDetails) {
        Optional<Address> existingAddress = addressService.getAddress(id);
        if (existingAddress.isPresent()) {
            Address updatedAddress = existingAddress.get();
            updatedAddress.setFirstname(addressDetails.getFirstname());
            updatedAddress.setLastname(addressDetails.getLastname());
            updatedAddress.setPhonenumber(addressDetails.getPhonenumber());
            updatedAddress = addressService.save(updatedAddress);
            return ResponseEntity.ok(updatedAddress);
        }
        return ResponseEntity.notFound().build();
    }
}