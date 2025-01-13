package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressComparatorTest {

    private Address address1;
    private Address address2;
    private AddressComparator comparator;

    @BeforeEach
    void setUp() {
        comparator = new AddressComparator();

        // Set up sample addresses
        address1 = new Address();
        address1.setId(1);
        address1.setFirstname("John");
        address1.setLastname("Doe");
        address1.setPhonenumber("1234567890");
        address1.setRegistrationDate(new Date(1672531200000L)); // Jan 1, 2023

        address2 = new Address();
        address2.setId(2);
        address2.setFirstname("Jane");
        address2.setLastname("Smith");
        address2.setPhonenumber("0987654321");
        address2.setRegistrationDate(new Date(1672617600000L)); // Jan 2, 2023
    }

    @Test
    void shouldCompareByLastname() {
        address1.setLastname("Anderson");
        address2.setLastname("Brown");
        int result = comparator.compare(address1, address2);
        assertTrue(result < 0, "Lastname comparison failed: 'Anderson' should come before 'Brown'");
    }

    @Test
    void shouldCompareByFirstnameWhenLastnameIsSame() {
        address1.setLastname("Doe");
        address2.setLastname("Doe");
        address1.setFirstname("Alice");
        address2.setFirstname("Bob");
        int result = comparator.compare(address1, address2);
        assertTrue(result < 0, "Firstname comparison failed: 'Alice' should come before 'Bob'");
    }

    @Test
    void shouldCompareByPhonenumberWhenNamesAreSame() {
        address1.setLastname("Doe");
        address2.setLastname("Doe");
        address1.setFirstname("John");
        address2.setFirstname("John");
        address1.setPhonenumber("123");
        address2.setPhonenumber("456");
        int result = comparator.compare(address1, address2);
        assertTrue(result < 0, "Phonenumber comparison failed: '123' should come before '456'");
    }

    @Test
    void shouldCompareByRegistrationDateWhenAllElseIsSame() {
        address1.setLastname("Doe");
        address2.setLastname("Doe");
        address1.setFirstname("John");
        address2.setFirstname("John");
        address1.setPhonenumber("1234567890");
        address2.setPhonenumber("1234567890");
        address1.setRegistrationDate(new Date(1672531200000L)); // Jan 1, 2023
        address2.setRegistrationDate(new Date(1672617600000L)); // Jan 2, 2023

        int result = comparator.compare(address1, address2);
        assertTrue(result < 0, "Registration date comparison failed: Jan 1, 2023 should come before Jan 2, 2023");
    }

    @Test
    void shouldCompareByIdWhenAllElseIsSame() {
        address1.setLastname("Doe");
        address2.setLastname("Doe");
        address1.setFirstname("John");
        address2.setFirstname("John");
        address1.setPhonenumber("1234567890");
        address2.setPhonenumber("1234567890");
        address1.setRegistrationDate(new Date(1672531200000L)); // Same date
        address2.setRegistrationDate(new Date(1672531200000L)); // Same date
        address1.setId(1);
        address2.setId(2);

        int result = comparator.compare(address1, address2);
        assertTrue(result < 0, "ID comparison failed: ID 1 should come before ID 2");
    }
}