package sdetessentials;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DBResultstoPOJOClass {

	public static void main(String[] args) {

		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "Sharath@1493");

			Statement stmt=con.createStatement();
			String s="select * from CustomerInfo limit 1";

			ResultSet rs=stmt.executeQuery(s);

			CustomerDetails cd=new CustomerDetails();


			while (rs.next()) {
				String bookname = rs.getString("BookName");
				String purchasedate = rs.getString("PurchasedDate");
				int amount = rs.getInt("Amount");
				String location = rs.getString("Location");


				cd.setBookname(bookname);
				cd.setPurchasedate(purchasedate);
				cd.setAmount(amount);
				cd.setLocation(location);


			}

			System.out.println(cd.getBookname());

			con.close();
			
			//Now Convert the pojo class to Json file
			
			File jsonfile=new File(System.getProperty("user.dir")+"\\customerinfo.json");
			
			ObjectMapper om=new ObjectMapper();
			om.writeValue(jsonfile, cd);
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
