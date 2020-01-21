//DONE
//All constructors private or protected
interface Vehicle{
	void printClass();
	int timeOfTravel();
}

class Bus implements Vehicle{
	int time;
	Bus(){
		time = 10;
	}
	public void printClass(){
		System.out.print("Bus ");
	}

	public int timeOfTravel(){
		return time;
	}
}

class Ship implements Vehicle{
	int time;
	Ship(){
		time = 6;
	}
	public void printClass(){
		System.out.print("Ship ");
	}

	public int timeOfTravel(){
		return time;
	}
}

class Aeroplane implements Vehicle{
	int time;
	Aeroplane(){
		time = 2;
	}
	public void printClass(){
		System.out.print("Aeroplane ");
	}

	public int timeOfTravel(){
		return time;
	}
}

class Transportation{
	Vehicle vehicle;
	Transportation(String medium){
		if(medium.equals("Water")) vehicle = new Ship();
		else if (medium.equals("Air")) vehicle = new Aeroplane();
		else vehicle = new Bus();
	}

	Vehicle getVehicle(){
		return vehicle;
	}
}

public class ExecuteFactory{
	public static void main(String args[]){
		Transportation t = new Transportation("Land");//creates the object of Bus class
		Vehicle v = t.getVehicle();
		v.printClass();
		System.out.println(v.timeOfTravel());//method of Bus class is called
	}
}
