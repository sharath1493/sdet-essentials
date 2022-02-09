package sdetessentials;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DBtoPOJOtoMultipleJSONFiles {

	public static void main(String[] args) {
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "Sharath@1493");

			Statement stmt=con.createStatement();
			String s="select * from CustomerInfo";

			ResultSet rs=stmt.executeQuery(s);


			ArrayList<CustomerDetails> list=new ArrayList<CustomerDetails>();

			while (rs.next()) {
				String bookname = rs.getString("BookName");
				String purchasedate = rs.getString("PurchasedDate");
				int amount = rs.getInt("Amount");
				String location = rs.getString("Location");

				CustomerDetails cd=new CustomerDetails();
				cd.setBookname(bookname);
				cd.setPurchasedate(purchasedate);
				cd.setAmount(amount);
				cd.setLocation(location);

				list.add(cd);


			}


			con.close();

			//Now Convert the pojo class to Json file

			for(int i=0;i<list.size();i++)
			{
				File jsonfile=new File(System.getProperty("user.dir")+"\\customerinfo"+i+".json");

				ObjectMapper om=new ObjectMapper();
				om.writeValue(jsonfile, list.get(i));
			}



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


		System.out.println("Process Completed");

	}

}
