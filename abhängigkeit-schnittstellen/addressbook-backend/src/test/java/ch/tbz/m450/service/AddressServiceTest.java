package ch.tbz.m450.service;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    private Address address1;
    private Address address2;

    @BeforeEach
    void setUp() {
        address1 = new Address(1, "John", "Doe", "1234567890", new Date());
        address2 = new Address(2, "Jane", "Smith", "0987654321", new Date());
    }

    @Test
    void saveAddress() {
        // Given
        when(addressRepository.save(any(Address.class))).thenReturn(address1);

        // When
        Address savedAddress = addressService.save(address1);

        // Then
        assertThat(savedAddress).isNotNull();
        assertThat(savedAddress.getId()).isEqualTo(1);
    }

    @Test
    void getAllAddresses() {
        // Given
        when(addressRepository.findAll()).thenReturn(Arrays.asList(address2, address1)); // Return in unsorted order

        // When
        List<Address> addresses = addressService.getAll();

        // Then
        assertThat(addresses).hasSize(2);
        assertThat(addresses.get(0).getId()).isEqualTo(1); // Verify sorting by AddressComparator
        assertThat(addresses.get(1).getId()).isEqualTo(2);
    }

    @Test
    void getAddressById() {
        // Given
        when(addressRepository.findById(1)).thenReturn(Optional.of(address1));

        // When
        Optional<Address> foundAddress = addressService.getAddress(1);

        // Then
        assertThat(foundAddress).isPresent();
        assertThat(foundAddress.get().getId()).isEqualTo(1);
    }

    @Test
    void getAddressByIdNotFound() {
        // Given
        when(addressRepository.findById(99)).thenReturn(Optional.empty());

        // When
        Optional<Address> foundAddress = addressService.getAddress(99);

        // Then
        assertThat(foundAddress).isEmpty();
    }
}