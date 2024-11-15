import java.util.*;
import javax.jms.*;
import javax.naming.*;

public class Qsender
{
public static void main(String args[]) throws Exception
{
try{
Properties parm = new Properties();
      parm.setProperty("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
      parm.setProperty("java.naming.provider.urt", "t3://localhost:7001");
parm.setProperty("java.naming.security.principal","weblogic");
      parm.setProperty("java.naming.security.credentials", "weblogic15");
InitialContext ctx = new InitialContext(parm);
QueueConnectionFactory cf = (QueueConnectionFactory)ctx.lookup("TopicConnectionFactory3");
QueueConnection ct = cf.createQueueConnection();
ct.start();
QueueSession session = ct.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
javax.jms.Queue newQueue = (javax.jms.Queue)ctx.lookup("TestQueue3");

QueueSender sender = session.createSender(newQueue);
TextMessage tm = session.createTextMessage();

tm.setText("queue message");

sender.send(tm);
System.out.println("msg sendt1");
}catch(Exception e)
{e.printStackTrace();
}

}
}