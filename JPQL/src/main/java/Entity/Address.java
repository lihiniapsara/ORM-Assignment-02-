package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Address {
    @Id
    private int id;
    private String no;
    private String street;
    private String city;
    @ManyToOne
    @JoinColumn(name = "cuId")
    private Customer customer;

    public Address() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address(int id, String no, String street, String city, Customer customer) {
        this.id = id;
        this.no = no;
        this.street = street;
        this.city = city;
        this.customer = customer;
    }
}