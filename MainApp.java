package beanimplementaion;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp 
{
	private static AbstractApplicationContext ap;

	public static void main(String args[])
	{
		ap = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld objA=(HelloWorld)ap.getBean("helloWorld");
		objA.setMessage("I'm object A");
	    objA.getMessage();
	    ap.registerShutdownHook();
	    objA.getMessage();
	}

}
