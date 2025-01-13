package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {

    @Override
    public int compare(Address a1, Address a2) {
        // Compare by lastname
        int lastnameComparison = a1.getLastname().compareToIgnoreCase(a2.getLastname());
        if (lastnameComparison != 0) {
            return lastnameComparison;
        }

        // If lastnames are the same, compare by firstname
        int firstnameComparison = a1.getFirstname().compareToIgnoreCase(a2.getFirstname());
        if (firstnameComparison != 0) {
            return firstnameComparison;
        }

        // If firstnames are the same, compare by phonenumber
        int phonenumberComparison = a1.getPhonenumber().compareTo(a2.getPhonenumber());
        if (phonenumberComparison != 0) {
            return phonenumberComparison;
        }

        // If phonenumbers are the same, compare by registrationDate
        int dateComparison = a1.getRegistrationDate().compareTo(a2.getRegistrationDate());
        if (dateComparison != 0) {
            return dateComparison;
        }

        // If all else is the same, compare by ID
        return Integer.compare(a1.getId(), a2.getId());
    }
}