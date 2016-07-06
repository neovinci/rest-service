package by.epamlab.dlx.beans;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by Sergei Astapenko on 05.07.2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer", propOrder = {
        "email",
        "phone"
})
public class Customer {
    @XmlAttribute(name = "CustomerDocID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String customerDocID;

    @XmlAttribute(name = "FirstName", required = true)
    private String FirstName;

    @XmlAttribute(name = "LastName", required = true)
    private String lastName;

    @XmlAttribute(name = "Sequence", required = true)
    private String sequence;

    @XmlElement(name = "Email", required = true)
    private Email email;

    @XmlElement(name = "Phone", required = true)
    private Phone phone;

    public Customer() {
    }

    public Customer(String customerDocID, String firstName, String lastName, String sequence, Email email, Phone phone) {
        this.customerDocID = customerDocID;
        FirstName = firstName;
        this.lastName = lastName;
        this.sequence = sequence;
        this.email = email;
        this.phone = phone;
    }

    public String getCustomerDocID() {
        return customerDocID;
    }

    public void setCustomerDocID(String customerDocID) {
        this.customerDocID = customerDocID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return customerDocID.equals(customer.customerDocID);

    }

    @Override
    public int hashCode() {
        return customerDocID.hashCode();
    }
}
