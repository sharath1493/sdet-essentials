package sdetessentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDatafromDatabase {

	public static void main(String[] args) {

		/*
		 * Steps for reading the data from database
		 * 1. Create Connection
		 * 2. Create Statement
		 * 3. Execute Statement
		 * 4. Store the data and read
		 */


		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "Sharath@1493");

			Statement stmt=con.createStatement();
			String s="select * from CustomerInfo limit 1";

			ResultSet rs=stmt.executeQuery(s);


			while (rs.next()) {
				String bookname = rs.getString("BookName");
				String purchasedate = rs.getString("PurchasedDate");
				int amount = rs.getInt("Amount");
				String location = rs.getString("Location");
				System.out.println(bookname + "	" + purchasedate + "	" + amount+"	"+location);
			}

			con.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
