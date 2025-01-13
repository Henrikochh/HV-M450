package ch.tbz.m450.controller;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AddressController.class)
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService addressService;

    private Address address1;
    private Address address2;

    @BeforeEach
    void setUp() {
        address1 = createSampleAddress(1);
        address2 = createSampleAddress(2);
    }

    private Address createSampleAddress(int id) {
        Address address = new Address();
        address.setId(id);
        address.setFirstname("John");
        address.setLastname("Doe");
        address.setPhonenumber("1234567890");
        address.setRegistrationDate(new Date());
        return address;
    }

    @Test
    void shouldCreateAddress() throws Exception {
        Mockito.when(addressService.save(Mockito.any(Address.class))).thenReturn(address1);

        mockMvc.perform(post("/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "firstname": "John",
                                "lastname": "Doe",
                                "phonenumber": "1234567890"
                            }
                        """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstname", is("John")))
                .andExpect(jsonPath("$.lastname", is("Doe")))
                .andExpect(jsonPath("$.phonenumber", is("1234567890")));
    }

    @Test
    void shouldGetAllAddresses() throws Exception {
        Mockito.when(addressService.getAll()).thenReturn(List.of(address1, address2));

        mockMvc.perform(get("/address"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].firstname", is("John")))
                .andExpect(jsonPath("$[1].id", is(2)));
    }

    @Test
    void shouldGetAddressById() throws Exception {
        Mockito.when(addressService.getAddress(1)).thenReturn(Optional.of(address1));

        mockMvc.perform(get("/address/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstname", is("John")))
                .andExpect(jsonPath("$.lastname", is("Doe")))
                .andExpect(jsonPath("$.phonenumber", is("1234567890")));
    }

    @Test
    void shouldReturn404WhenAddressNotFound() throws Exception {
        Mockito.when(addressService.getAddress(1)).thenReturn(Optional.empty());

        mockMvc.perform(get("/address/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldUpdateAddress() throws Exception {
        Address updatedAddress = createSampleAddress(1);
        updatedAddress.setFirstname("Updated Name");

        Mockito.when(addressService.getAddress(1)).thenReturn(Optional.of(address1));
        Mockito.when(addressService.save(Mockito.any(Address.class))).thenReturn(updatedAddress);

        mockMvc.perform(put("/address/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "firstname": "Updated Name",
                                "lastname": "Doe",
                                "phonenumber": "1234567890"
                            }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstname", is("Updated Name")))
                .andExpect(jsonPath("$.lastname", is("Doe")))
                .andExpect(jsonPath("$.phonenumber", is("1234567890")));
    }
}