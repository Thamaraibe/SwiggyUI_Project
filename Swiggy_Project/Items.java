package swiggy;

import java.util.ArrayList;

public class Items extends Hotel
{
    // Veg item list with its price
	String vegmenu[] = {"Idly:30", "Dosa:20", "Poori:30", "Chappathi:30", "Pongal:30", "FullMeals:100", "MiniMeals:75"};
	
	// Non veg item list with its price
	String nonvegmenu[] = {"Biriyani:150", "Parota:70", "ChikenFriedrice:100", "ChikenNoodles:130", "MatenBiriyani:230", "FishFry:100", "Shawarma:90"};
	
	// Display the menu
	public void getItems(String itempresent[]) 
	{
		System.out.println("----------------MENU----------------");
		System.out.println("ITEM               PRICE");
		for(int i = 0; i<itempresent.length; i++)
		{
			String items[]=itempresent[i].split(":");
			System.out.println(items[0]+"              "+items[1]);
		}
		System.out.println("------------------------------------");

	}
	
	//  Call getItems() based on hotel type
	public void displayItems(String type)
	{
		if(type.equals("veg"))
	    	getItems(vegmenu);
	    else
	        getItems(nonvegmenu);
	}
	
	ArrayList<String> selectedItem = new ArrayList<>();
	
	// Add the selected items in above Array List
	public void addItem(String name)
	{
		selectedItem.add(name);
	}
	
	// Check weather the item is present or not
	public boolean isExist(String item, String hoteltype)
	{   
		if(hoteltype.equalsIgnoreCase("veg"))
		{
		for(String i : vegmenu)
		{
			String arr[]=i.split(":");
			if(arr[0].equalsIgnoreCase(item))
				 return true;
		}
		}
		else 
		{
			for(String i : nonvegmenu)
			{
				String arr[] = i.split(":");
				if(arr[0].equalsIgnoreCase(item))
					  return true;
			}
		}
		
		
		return false;
		
	}
	
	// Get the price of selected item
	public int getPrice(String itemname,String hoteltype)
	{
	     if(hoteltype.equalsIgnoreCase("veg"))
	     {
	    	 for(String item : vegmenu)
	    	 {
	    		String price[] = item.split(":");
	    		 if(price[0].equalsIgnoreCase(itemname))
	    			 return Integer.parseInt(price[1]);
	    	 }
	 
	     }
	     else
	     {
	    	 for(String item : nonvegmenu)
	    	 {
	    		 String price[]=item.split(":");
	    		 if(price[0].equalsIgnoreCase(itemname))
	    			 return Integer.parseInt(price[1]);
	    	 }
	     }
		return 0;
		
	}

	}
