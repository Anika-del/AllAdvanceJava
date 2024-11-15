import java.util.*;
import javax.jms.*;
import javax.naming.*;

public class Subscriber
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
TopicConnectionFactory topicFactory = (TopicConnectionFactory)ctx.lookup("TopleConnectionFactory3");
TopicConnection conn = topicFactory.createTopicConnection();
conn.start();
TopicSession session = conn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
Topic t = (Topic)ctx.lookup("MyTopic3");

TopicSubscriber sub=session.createSubscriber(t);
sub.setMessageListener(new MyMessageListener());
 while(true)
 {
Thread.sleep(1000);
 }
 }catch(Exception e){
System.out.println(e);
 }
}
}
class MyMessageListener implements MessageListener
{
public void onMessage(Message msg)
{
 try
{
if(msg instanceof TextMessage)
{
TextMessage txtMsg = (TextMessage)msg;
String str = txtMsg.getText();
System.out.println(str);
}
else
	System.out.println("Message is auanknown Format");
}
catch(JMSException e)
{}
}
}