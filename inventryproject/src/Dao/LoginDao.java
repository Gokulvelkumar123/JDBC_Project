package Dao;

import java.sql.*;

import ConnectionManager.ConnectionManager;
import Model.Login;
public class LoginDao 
{
	public boolean validate(Login login) throws ClassNotFoundException, SQLException
	{
		String username=login.getUsername();
		String password=login.getPassword();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con=conm.establishConnection();
		
		//Statement class
		Statement st = con.createStatement();
		
		//ResultSet class
		ResultSet rt=st.executeQuery("select * from Login");
		while(rt.next()) {
			if(username.equals(rt.getString("username"))&&password.equals(rt.getString("password")))
			{
				conm.closeConnection();
				return true;
			}
		}
			conm.closeConnection();
			return false;
	}
	
}