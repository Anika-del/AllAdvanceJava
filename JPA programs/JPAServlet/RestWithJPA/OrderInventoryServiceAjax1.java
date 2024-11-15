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

@Path("/order-inventory2")
public class OrderInventoryServiceAjax1 {

    @GET
    @Path("/order")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getUserById1(@QueryParam("custid") Integer custid) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("codesquadz");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction t = manager.getTransaction();
        t.begin();

        Customer cust = manager.find(Customer.class, custid);

        t.commit();
        manager.close();

        return cust;
    }
}




/*http://localhost:7002/JsonRestful/rest/order-inventory2/order/custin1001/   */