package by.epamlab.dlx.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Sergei Astapenko on 05.07.2016.
 */
@XmlRootElement(name = "Reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation {
    @XmlElement(name = "Customer")
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Reservation() {
        super();
    }

    public Reservation(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public boolean add(Customer customer) {return customers.add(customer);
    }
}
