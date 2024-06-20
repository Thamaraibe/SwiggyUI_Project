package swiggy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

	public boolean login(String username, String password)
	{
		try
	      {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/thamarai","root","thamarai@2003");
			PreparedStatement st=con.prepareStatement("call insertData(?,?,?,?,?,?,?)");
			ResultSet rs=st.executeQuery("select * from Registration");
			while(rs.next())
			{
				String mail=rs.getString(6);
				String psw=rs.getString(7);
				if(mail.equals(username) && psw.equals(password))
					  return true;
			}
		 }
		catch(Exception e) {System.out.println(e);}
		
		return false;
		  
		
	}
	
}
