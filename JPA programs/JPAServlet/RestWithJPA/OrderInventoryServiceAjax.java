package my;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.QueryParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam; 
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Response;
import mypack.Customer;
import javax.persistence.Persistence;

@Path("/order-inventory1")
public class OrderInventoryServiceAjax {

@POST
@Path("/order")
@Produces(MediaType.TEXT_PLAIN)
// @Produces(MediaType.APPLICATION_JSON)
public Response getUserById(@FormParam("custid") String custid,
                            @FormParam("fname") String fname,
                            @FormParam("lname") String lname) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("codesquadz");
    EntityManager manager = factory.createEntityManager();
    EntityTransaction t = manager.getTransaction();
    t.begin();

    Customer cust = new Customer();
    cust.setId(Integer.parseInt(custid));
    cust.setFirstName(fname);
    cust.setLastName(lname);
    manager.persist(cust);

    t.commit();
    manager.close();

    String responsel = "record added successfully";

    return Response.status(200).entity(responsel).build();
}


}
