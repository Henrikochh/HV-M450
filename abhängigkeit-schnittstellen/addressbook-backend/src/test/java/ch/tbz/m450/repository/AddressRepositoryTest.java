package ch.tbz.m450.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AddressRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void shouldFindAddressById() {
        // Given
        Address address = new Address();
        address.setId(1);
        address.setFirstname("John");
        address.setLastname("Doe");
        address.setPhonenumber("1234567890");
        address.setRegistrationDate(new Date());
        entityManager.persist(address);
        entityManager.flush();

        // When
        Optional<Address> found = addressRepository.findById(1);

        // Then
        assertThat(found).isPresent();
        assertThat(found.get().getId()).isEqualTo(1);
        assertThat(found.get().getFirstname()).isEqualTo("John");
        assertThat(found.get().getLastname()).isEqualTo("Doe");
        assertThat(found.get().getPhonenumber()).isEqualTo("1234567890");
        assertThat(found.get().getRegistrationDate()).isNotNull();
    }

    @Test
    void shouldSaveAddress() {
        // Given
        Address address = new Address();
        address.setId(1);
        address.setFirstname("John");
        address.setLastname("Doe");
        address.setPhonenumber("1234567890");
        address.setRegistrationDate(new Date());

        // When
        Address savedAddress = addressRepository.save(address);

        // Then
        assertThat(savedAddress).isNotNull();
        assertThat(savedAddress.getId()).isEqualTo(1);
        assertThat(savedAddress.getFirstname()).isEqualTo("John");
        assertThat(savedAddress.getLastname()).isEqualTo("Doe");
        assertThat(savedAddress.getPhonenumber()).isEqualTo("1234567890");
        assertThat(savedAddress.getRegistrationDate()).isNotNull();
    }

    @Test
    void shouldDeleteAddress() {
        // Given
        Address address = new Address();
        address.setId(1);
        address.setFirstname("John");
        address.setLastname("Doe");
        address.setPhonenumber("1234567890");
        address.setRegistrationDate(new Date());
        entityManager.persist(address);
        entityManager.flush();

        // When
        addressRepository.deleteById(1);

        // Then
        Optional<Address> found = addressRepository.findById(1);
        assertThat(found).isNotPresent();
    }

    @Test
    void shouldUpdateAddress() {
        // Given
        Address address = new Address();
        address.setId(1);
        address.setFirstname("John");
        address.setLastname("Doe");
        address.setPhonenumber("1234567890");
        address.setRegistrationDate(new Date());
        entityManager.persist(address);
        entityManager.flush();

        // When
        Address updatedAddress = addressRepository.findById(1).get();
        updatedAddress.setFirstname("Jane");
        addressRepository.save(updatedAddress);

        // Then
        Address found = addressRepository.findById(1).get();
        assertThat(found.getFirstname()).isEqualTo("Jane");
    }

    @Test
    void shouldReturnEmptyOptionalWhenAddressNotFound() {
        // When
        Optional<Address> found = addressRepository.findById(999);

        // Then
        assertThat(found).isNotPresent();
    }
}