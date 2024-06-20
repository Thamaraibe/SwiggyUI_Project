package swiggy;

public class Hotel extends Bill{
	
	String veghotels[] = {"Srinivas", "SriDevi", "AyyarBhavan", "BalajiBhavan", "Murugan"};
	String nonveghotels[] = {"SS", "KatharBahai", "Pandiyan"};
	
	// Display all the hotel names
	public void hotelList(String hotel[])
	{   
		int n=1;
		for(String i : hotel)
		{
			System.out.println(n+"."+i);
			n++;
		}
	}
	
	// Check weather the item is present in Veg hotel menu
	public boolean searchInVegHotels(String hotel)
	{
		for(String name : veghotels)
		{
			if(name.equalsIgnoreCase(hotel))
				return true;
		}
	
		return false;
		
	}
	
	// Check weather the item is present in Non veg hotel menu
	public boolean searchInNonvegHotels(String hotel)
	{
		for(String name : nonveghotels)
		{
			if(name.equalsIgnoreCase(hotel))
				return true;
		}
		return false;
	}
	
	// To find the hotel type Veg or Nonveg or Invalid
	public String hotelType(String hotel)
	{
		if(searchInVegHotels(hotel))
			return "veg";
		else if(searchInNonvegHotels(hotel))
		    return "nonveg";
		return "Invalid";
		
	}
	
	// Call the hotelList() method with its corresponding menu name
	public void hotelList()
	{
	    	System.out.println("This hotel is not exist");
	    	System.out.println("This hotel are available in Veg type");
	        hotelList(veghotels);
	    	System.out.println("This hotel are avaiable in Non veg type");
	        hotelList(nonveghotels);
	    
	}
	
	
	

}
