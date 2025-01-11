package com.example.Ordermanagment.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "contact_mech")
public class ContactMech {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_mech_id")
    private Integer contactMechId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "street_address", length = 100, nullable = true)
    private String streetAddress;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @Column(name = "state", length = 50, nullable = false)
    private String state;

    @Column(name = "postal_code", length = 20, nullable = false)
    private String postalCode;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "email", length = 100)
    private String email;
    
    public ContactMech()
    {    
    	
    }
    public ContactMech(Integer contactMechId, Customer customer, String streetAddress, String city, String state,
			String postalCode, String phoneNumber, String email) {
		super();
		this.contactMechId = contactMechId;
		this.customer = customer;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

    public Integer getContactMechId() {
        return contactMechId;
    }

    public void setContactMechId(Integer contactMechId) {
        this.contactMechId = contactMechId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
