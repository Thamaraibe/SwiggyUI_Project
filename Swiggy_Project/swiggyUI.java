package swiggy;

import java.util.Scanner;

public class swiggyUI extends Invoice {

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	swiggyUI obj=new swiggyUI();
    	//obj.idemOrder(obj);
    	Scanner in=new Scanner(System.in);
    	System.out.println("If you are new to this application then first complete your registeration process and then login otherwise login directly\n1.Register \n2.Login");
    	System.out.println("Enter your choice : ");
    	int choice = in.nextInt();
    	switch(choice)
    	{
    	case 1:
        	obj.customerRegistation();
        	break;
    	case 2:
    		System.out.println("Enter User name:");
        	String user=in.next();
        	System.out.println("Enter password:");
            String passkey=in.next();
            boolean status = obj.login(user,passkey);
            if(status)
            {
        	    System.out.println("Log in successfully");
        	    obj.getData(user, passkey);
            	obj.idemOrder(obj);
            }
            else 
        	    System.out.println("Register properly or check your Username and Password");
            break;
        default:
           System.out.println("Enter valid choice");

    	}
    	
        
        }
	}

