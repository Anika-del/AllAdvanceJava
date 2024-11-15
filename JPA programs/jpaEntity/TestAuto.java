рEntityManag
Import javax.persistence EntityManagerF import javax.persistence.Entity Transaction, import javax.persistence.Persistence, Import javax.persistence.Query;
public class TestAuto

 public static void main(String[] args)

EntityManager manger=factory.createEntityManager(); Entity Transaction t=manger.getTransaction();

EntityManagerFactory factory = Persistence.createEntityManagerFactory("appsquadza
t.begin();
Person p1=new Person("lalu1","yadav1");
Person p2=new Person("rabari", "yadav");
System.out.println("persisting entities....");
manger.persist(p1);
manger.persist(p2):
