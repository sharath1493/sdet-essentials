package sdetessentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

public class MultipleDBResultstoPOJOtoSingleJSONFile {

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

			JSONArray jsonarr=new JSONArray();


			for(int i=0;i<list.size();i++)
			{
				//Convert java object to json
				Gson g=new Gson();
				String j = g.toJson(list.get(i));
				jsonarr.add(j);

			}

			JSONObject jo=new JSONObject();
			jo.put("data", jsonarr);



			String formattedString=jo.toJSONString().replace("\\\"", "\"");
			formattedString = formattedString.replace("\"{", "{").replace("}\"", "}");
			System.out.println(formattedString);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("Process Completed");

	}

}
