package swiggy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class Register extends Login{

	public void customerRegistation()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter First Name:");
	    String fn=in.next();
	    System.out.println("Enter Last Name:");
	    String ln=in.next();
	    System.out.println("Enter your address:");
	    String address=in.next();
	    System.out.println("Enter your E-mail:");
	    String mail=in.next();
	    System.out.println("Enter your Mobile Number:");
	    String mobileno=in.next();
	    System.out.println("Enter Password:");
	    String password=in.next();
	    
      try
      {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/thamarai","root","thamarai@2003");
		PreparedStatement st=con.prepareStatement("call insertData(?,?,?,?,?,?,?)");
		int i=1;
		ResultSet rs=st.executeQuery("select * from Registration");
		while(rs.next())
		{
			i=rs.getInt(1);
		}
		st.setInt(1, ++i);
		st.setString(2,fn);
		st.setString(3,ln);
		st.setString(4,address);
		st.setString(5,mobileno);
		st.setString(6,mail);
		st.setString(7, password);
		st.execute();
		System.out.println("Register successfully");
		con.close();
		}
      catch(Exception e) {System.out.println(e);}
	    
	    
		
	}
	
}
