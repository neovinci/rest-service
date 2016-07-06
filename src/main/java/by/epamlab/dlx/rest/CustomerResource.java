package by.epamlab.dlx.rest;

import by.epamlab.dlx.beans.Customer;
import by.epamlab.dlx.utilities.CustomerUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import java.util.List;

/**
 * Created by Sergei Astapenko on 04.07.2016.
 */

@Path("/customer")
public class CustomerResource {

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @GET
    public List<Customer> getCustomers() {
        return CustomerUtil.getCustomers();
    }

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    @GET
    public Customer getCustomer(@PathParam("id") String id) {
        return CustomerUtil.getCustomer(id);
    }



    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    @DELETE
    public Response delCustomer(@PathParam("id") String id) {
        return CustomerUtil.delCustomer(id);
    }

    @Consumes (MediaType.APPLICATION_FORM_URLENCODED)
    @POST
    public Response addCustomer(@FormParam("firstname")String firstName,
                                @FormParam("lastname")String lastName,
                                @FormParam("phonenumber")String phoneNumber,
                                @FormParam("email")String emailAddress) {
        return CustomerUtil.addCustomer(firstName, lastName, phoneNumber, emailAddress);
    }

    @Consumes (MediaType.APPLICATION_FORM_URLENCODED)
    @PUT
    public Response updateCustomer(@FormParam("id")String customerDocID,
                                @FormParam("firstname")String firstName,
                                @FormParam("lastname")String lastName,
                                @FormParam("phonenumber")String phoneNumber,
                                @FormParam("email")String emailAddress) {
        return CustomerUtil.updateCustomer(customerDocID, firstName, lastName, phoneNumber, emailAddress);
    }


}
