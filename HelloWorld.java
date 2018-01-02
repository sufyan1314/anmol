package beanimplementaion;

public class HelloWorld 
{
	String message;

	public void getMessage() {
		System.out.println("Your Message : " + message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public void init()
	{
		System.out.println("Your Init Method: ");
	}
	public void destroy()
	{
		System.out.println("Your Destroy Method: ");
	}

}
