package swiggy;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.*;
//import com.mysql.cj.xdevapi.Statement;

public class Bill extends Order{

	static int userid;
	static String name;
	static String location;
	static String phoneno;
	static String mail;
	
	public void getData(String username,String password)
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/thamarai","root","thamarai@2003");
		Statement s=con.createStatement();
	    ResultSet rs=s.executeQuery("select * from Registration");
	    mail=username;
	    while(rs.next())
	    {
	    	String user=rs.getString(6);
	    	String ps=rs.getString(7);
	    	if(user.equals(username) && password.equals(ps))
	    	{
	    		userid=rs.getInt(1);
	    		name = rs.getString(2)+" "+rs.getString(3);
	    		location = rs.getString(4);
	    		phoneno = rs.getString(5);	    		
	    	}
	    }
	    }
		catch(Exception e) {System.out.println(e);}
	}
	
	
	
	
	// Display the Bill
	public void billDisplay(String hotel, swiggyUI ob,boolean status)
	{      
		if(status) {
		    Date d = new Date();
		    System.out.println("------------------------Bill-----------------------");
		    System.out.println("\tUser Id   : "+userid);
		    System.out.println("\tUser Name : "+name);
		    System.out.println("\tAddress   : "+location);
		    System.out.println("\tPhone Number : "+phoneno);
		    System.out.println("\tE-Mail    : "+mail);
	        System.out.println("\tHotel Name : "+hotel.toUpperCase());
	        System.out.println("\tOrder Time : "+d);
	        System.out.println("\tDelivery Time : With in 1 hour");
	        System.out.println("\n\tItemname     "+"Quantity     "+"Price");
	        for(int i=0;i<ob.quantity.size();i++)
	        {
	        System.out.println("\t"+ob.selectedItem.get(i).toUpperCase()+"     "+"     "+ob.quantity.get(i)+"     "+ob.amount.get(i));
	        int a=ob.amount.get(i).intValue();
	    	dbConnection(hotel,ob.selectedItem.get(i),ob.quantity.get(i).intValue(),a);
            }
	        double totalamount=0;
	        for(Double i:ob.amount)
	        	totalamount+=i;
	        double tax1=ob.taxPrice(totalamount);
	        double discount1=ob.getDiscount(totalamount);
	        System.out.println("");
	        System.out.println("                               Tax Amount:"+tax1);
	        System.out.println("                               Discount Amount:"+discount1);
	        System.out.println("                               Total Amount:"+(totalamount-discount1+tax1));
	        System.out.println("----------------------------------------------------");
	        
		}
		
		ob.quantity=new ArrayList<>();
		ob.amount=new ArrayList<>();
		ob.selectedItem=new ArrayList<>();
		
	 }
	
	 static int sno=100;
	
	 public int idgeneration(PreparedStatement p)
	 {
		try
		{
		ResultSet rs=p.executeQuery("select * from swiggy");
		while(rs.next())
		{
			sno=rs.getInt(1);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return sno;
	 }
	
	// Finally add the Hotel name, Item selected, its Quantity and Amount into Swiggy database
	 public void dbConnection(String hotelname,String itemname,int quantity,int amount)
	 {
		try
		
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/thamarai","root","thamarai@2003");
		PreparedStatement st=con.prepareStatement("call insertValue2(?,?,?,?,?,?,?,?,?)");
		int i=idgeneration(st);
		if(sno==i)  
			 i++;
		st.setInt(1, i++);
		st.setInt(2, userid);
		st.setString(3, name);
		st.setString(4, location);
		st.setString(5, hotelname);
		st.setString(6, itemname);
		st.setInt(7,quantity);
		st.setInt(8, amount);
		st.setString(9, phoneno);
		st.execute();
		con.close();
		}
		catch(Exception e) {System.out.println(e);}
		
	  }
	
	
	
	
}
