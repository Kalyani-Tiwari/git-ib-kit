//DONE
//Facade Design Pattern Example
//The Base Class of all the menus
class Menus{
String[] starter,deserts, lunch, dinner, breakfast;
}
class VegMenu extends Menus{
	VegMenu(){
		System.out.println("Displaying Veg Menu");
	}
}
class NonVegMenu extends Menus{
	NonVegMenu(){
		System.out.println("Displaying Non-Veg Menu");
	}
}
class Both extends Menus{
	Both(){
		System.out.println("Displaying Veg as well as Non-Veg Menus");
	}
}



interface Hotel{
	public Menus getMenus(); 
}
class NonVegRestaurant implements Hotel{
	public Menus getMenus(){ 
		NonVegMenu nv = new NonVegMenu(); 
		return nv;
	}
}
class VegNonBothRestaurant implements Hotel { 
	public Menus getMenus(){ 
		Both b = new Both(); 
		return b; 
	}
}
class VegRestaurant implements Hotel{ 
	public Menus getMenus(){ 
		VegMenu v = new VegMenu(); 
		return v; 
	} 
}


//HotelKeeper acts as a facade as it hides the complexity of Hotel
class HotelKeeper{ 
	public VegMenu getVegMenu(){
		VegRestaurant v = new VegRestaurant(); 
		VegMenu vegMenu = (VegMenu)v.getMenus(); 
		return vegMenu; 
	}
	
	public NonVegMenu getNonVegMenu(){ 
		NonVegRestaurant v = new NonVegRestaurant(); 
		NonVegMenu NonvegMenu = (NonVegMenu)v.getMenus(); 
		return NonvegMenu; 
	}
	
	public Both getVegNonMenu(){ 
		VegNonBothRestaurant v = new VegNonBothRestaurant(); 
		Both bothMenu = (Both)v.getMenus(); 
		return bothMenu; 
	}	 
} 

public class ExecuteFacadeDP{
	public static void main (String[] args){
		HotelKeeper keeper = new HotelKeeper(); 
		
		VegMenu v = keeper.getVegMenu(); 
		NonVegMenu nv = keeper.getNonVegMenu(); 
		Both b = keeper.getVegNonMenu(); 
	} 
}
