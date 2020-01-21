//Template method Design Pattern example
//DONE
abstract class WebContainer{
	String req;
	//'final' template method so that it can't be overridden..
	final void process(){
		init();
		System.out.println("Returning " + service() + " to the browser");
		destroy();
	}
	abstract void init();
	abstract String service();
	abstract void destroy();
}

class Servlet extends WebContainer{
//implementing abstract methods
	public void init(){
		System.out.println("Initialising Servlet");
	}
	
	public String service(){
		return "Servlet response";
	}

	public void destroy(){
		System.out.println("Servlet Destroy..");
	}
}

class Jsp extends WebContainer{
//implementing abstract methods
	public void init(){
		System.out.println("Initialising JSP");
	}

	public String service(){
		return "JSP dynamic response";
	}

	public void destroy(){
		System.out.println("inside jsp_destroy..");
	}
}

public class ExecuteTemplateDP{
	public static void main(String args[]){
		//process followed is same for both classes but implementations are specific to the class and are respectively called 
		WebContainer s = new Servlet();
		s.process();

		s = new Jsp();
		s.process(); 
	}

}
