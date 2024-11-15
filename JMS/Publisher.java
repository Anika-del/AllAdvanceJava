import java.util.*;
import javax.jms.*;
import javax.naming.*;

public Close Publisher
{
public static void main(String args[])throws Exception
{
	
Properties parm = new Properties();
      parm.setProperty("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
      parm.setProperty("java.naming.provider.urt", "t3://localhost:7001");
parm.setProperty("java.naming.security.principal","weblogic");
      parm.setProperty("java.naming.security.credentials", "weblogic15");
InitialContext ctx = new InitialContext(parm);
TopicConnectionFactory topicFactory = (TopicConnectionFactory)ctx.lookup("TopleConnectionFactory3");
TopicConnection conn = topicFactory.createTopicConnection();
conn.start();
TopicSession session = conn.createTopicSession(false, Topic Session.AUTO_ACKNOWLEDGE);
Topic t = (Topic)ctx.lookup("MyTopic3");
TopicPublisher publisher = session.createPublisher(t);
TextMessage txtMsg = session.createTextMessage();
txtMsg.setText("Codesquadz is welcoming u");
publisher.publish(txtMso);

System.out.println("Message Sent Successfully");
session.close();
conn.close();
}
}