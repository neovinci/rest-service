package by.epamlab.dlx.utilities;

import by.epamlab.dlx.beans.Customer;
import by.epamlab.dlx.beans.Email;
import by.epamlab.dlx.beans.Phone;
import by.epamlab.dlx.beans.Reservation;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sergei Astapenko on 06.07.2016.
 */
public class CustomerUtil {
    private final static Comparator<Customer> COMP_BY_ID = new Comparator<Customer>() {
        public int compare(Customer one, Customer two) {
            return one.getCustomerDocID().compareTo(two.getCustomerDocID());
        }
    };

    public static ArrayList<Customer> getCustomers() {
        Reservation reservation = null;
        FileReader in = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Reservation.class);
            Unmarshaller u = context.createUnmarshaller();
            in = new FileReader("d:/reservation.xml");
            reservation = (Reservation) u.unmarshal(in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return reservation.getCustomers();
    }

    public static Customer getCustomer(String id) {
        ArrayList<Customer> customers = getCustomers();
        if(getCustomerIndex(id) < 0) {
            return new Customer("NOT FOUND", "NOT FOUND", "NOT FOUND", "NOT FOUND", null, null);
        } else {
            return customers.get(getCustomerIndex(id));
        }
    }

    public static Response delCustomer(String id) {
        ArrayList<Customer> customers = getCustomers();
        if(getCustomerIndex(id) < 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Customer with CustomerDocID = " + id + " not found")
                    .type(MediaType.TEXT_PLAIN_TYPE).build();
        } else {
            customers.remove(getCustomerIndex(id));
            try {
                saveCustomers(customers);
            } catch (Exception e) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Saving ERROR Customer")
                        .type(MediaType.TEXT_PLAIN_TYPE).build();
            }
            return Response.ok().build();
        }
    }

    public static Response addCustomer (String firstName, String lastName, String phoneNumber, String emailAddress) {
        ArrayList<Customer> customers = getCustomers();
        Email email = new Email(true, emailAddress, "1.EAT", "1", "SYNCHED");
        Phone phone = new Phone(true, phoneNumber, "5.PTT", "1", "SYNCHED");
        String currentID = getNextID(customers);
        Customer customer = new Customer(currentID,firstName, lastName, "1", email, phone);
        customers.add(customer);
        try {
            saveCustomers(customers);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Saving ERROR Customer")
                    .type(MediaType.TEXT_PLAIN_TYPE).build();
        }
        return Response.ok().build();
    }

    public static Response updateCustomer(String customerDocID, String firstName, String lastName, String phoneNumber
            , String emailAddress) {
        ArrayList<Customer> customers = getCustomers();
        if(getCustomerIndex(customerDocID) < 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Customer with CustomerDocID = " + customerDocID
                    + " not found").type(MediaType.TEXT_PLAIN_TYPE).build();
        } else {
            customers.get(getCustomerIndex(customerDocID)).setFirstName(firstName);
            customers.get(getCustomerIndex(customerDocID)).setLastName(lastName);
            customers.get(getCustomerIndex(customerDocID)).getEmail().setEmailAddress(emailAddress);
            customers.get(getCustomerIndex(customerDocID)).getPhone().setPhoneNumber(phoneNumber);
            try {
                saveCustomers(customers);
            } catch (Exception e) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Saving ERROR Customer with id = "
                        + customerDocID).type(MediaType.TEXT_PLAIN_TYPE).build();
            }
            return Response.ok().build();
        }
    }

    private static void saveCustomers(ArrayList<Customer> customers) throws IOException, JAXBException {
        FileOutputStream out = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Reservation.class);
            Marshaller m = context.createMarshaller();
            Reservation reservation = new Reservation();
            reservation.setCustomers(customers);
            out = new FileOutputStream("d:/reservation.xml");
            m.marshal(reservation, out);
        } finally {
            out.close();
        }
    }

    private static Reservation readReservation() throws JAXBException, IOException {
        Reservation reservation = null;
        FileReader in = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Reservation.class);
            Unmarshaller u = context.createUnmarshaller();
            in = new FileReader("d:/reservation.xml");
            reservation = (Reservation) u.unmarshal(in);
        } finally {
            in.close();
        }
        return reservation;
    }

    private static int getCustomerIndex(String id) {
        ArrayList<Customer> customers = getCustomers();
        sortCustomer(customers);
        int index = Collections.binarySearch(customers, new Customer(id, null, null, null, null, null), COMP_BY_ID);

        return index;
    }

    private static String getNextID(ArrayList<Customer> customers) {
        sortCustomer(customers);
        String lastID = customers.get(customers.size() - 1).getCustomerDocID();
        String nextID = "id" + (Integer.parseInt(lastID.substring(2)) + 1);
        return nextID;
    }

    private static void sortCustomer(ArrayList<Customer> customers) {
        Collections.sort(customers, COMP_BY_ID);
    }
}
