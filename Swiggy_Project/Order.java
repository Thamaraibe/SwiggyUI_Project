package swiggy;

import java.util.Scanner;

public class Order extends Register{

	
	public void idemOrder(swiggyUI s)
	{
	int next,choice=0;
	boolean Exist = false,billstatus=true;
	String item="";
    Scanner sc = new Scanner(System.in);
   
    do {
    	
    billstatus=true;	
    System.out.println("Enter the hotel name : ");
    String hotel = sc.next();
    
    do
    {
    	
    String type = s.hotelType(hotel);
    
    if(type.equals("Invalid"))
    {
    
        s.hotelList();
        billstatus=false;
        continue;
    }
    
    
    s.displayItems(type);
    
    System.out.println("Enter the item : ");
    item=sc.next();
    Exist = s.isExist(item,type);
    
    if(Exist) 
        s.priceCalculation(s, sc, item, type);
    else 
    {
    	System.out.println("This item is not exits ");
    }
  
    if(!type.equals("Invalid"))
    {
    System.out.println("\nIf you want to select another item then enter 1 other wise 2");
    choice=sc.nextInt();
    }
    
    }while(choice==1);
   
    s.billDisplay(hotel,s,billstatus);
    System.out.println("\nIf you want to continue this application  then enter 1 other wise 2");
    next=sc.nextInt();
    
    }while(next==1);
	}
	
	
	
	
}
