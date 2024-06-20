package swiggy;

import java.util.ArrayList;
import java.util.Scanner;

public class Invoice extends Items 
{
	    final double tax = 0.05; // Tax percentage = 5%
	    final double discount = 0.1; // Discount percentage=10%
        
       ArrayList<Integer> quantity = new ArrayList<>();
       
       public void priceCalculation(swiggyUI s1,Scanner sc,String item,String type)
       {
    	   s1.addItem(item);
    	    int fair = s1.getPrice(item,type);
    	    System.out.println("Enter the quantity : ");
    	   int qty= sc.nextInt();
    	    s1.addQty(qty);
    	    s1.addAmount(qty*fair);
       }
        
       // Add  quantity of each selected item in above ArrayList    
        public void addQty(int quty)
        {
        	quantity.add(quty);
        }
        
        ArrayList<Double> amount = new ArrayList<>();
        
        // Add each selected item price in above Array List       
        public void addAmount(double amt)
        {
        	amount.add(amt);
        }
       
        // Tax calculation
        public double taxPrice(double total)
        {
        	return tax*total;
        }
        
        // Discount calculation       
        public double getDiscount(double amount)
        {
        	return discount*amount;
        }
              
}

