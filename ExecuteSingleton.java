// Static initializer based Java implementation of singleton design pattern 
class Singleton 
{ 
	//Eager instantiation
	private static Singleton obj = new Singleton(); 
	int count;
	
	private Singleton(){
		count = 5;
	} 

	public static Singleton getInstance() 
	{ 
		return obj; 
	} 
	
	public void print(){
		System.out.println(count);
	}
} 

public class ExecuteSingleton{
	public static void main(String args[]){
		Singleton s = Singleton.getInstance();
		s.print();
	}
}
