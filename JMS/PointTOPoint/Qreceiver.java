import java.util.*;
import javax.jms.*;
import javax.naming.*;

public class Qreceiver
{
public static void main(String args[]) throws Exception
{
try{
	javax.jms.Queue queue1=null;
	QueueConnectionFactory tcf=null;
	QueueConnection tc=null;
	
Properties parm = new Properties();
      parm.setProperty("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
      parm.setProperty("java.naming.provider.urt", "t3://localhost:7001");
parm.setProperty("java.naming.security.principal","weblogic");
      parm.setProperty("java.naming.security.credentials", "weblogic15");
InitialContext ctx = new InitialContext(parm);
 tcf = (QueueConnectionFactory)ctx.lookup("TopicConnectionFactory3");
 tc = tcf.createQueueConnection();
tc.start();
QueueSession session = tc.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
queue1 = (javax.jms.Queue)ctx.lookup("testQueue3");


QueueReceiver ts = session.createReceiver(queue1);
ts.setMessageListener(new MyMessageListener());
 while(true)
 {
Thread.sleep(1000);
 }
}catch(Exception e)
{
System.out.print("1" +e);
}}
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
 String str= txtMsg.getText();
 System.out.println(str);
}
else
System.out.println("Message in Unknown Format");
}
catch(JMSException e)
{}
}
 }