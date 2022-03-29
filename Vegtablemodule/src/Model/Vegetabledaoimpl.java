package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Bean.Vegbean;


public class Vegetabledaoimpl implements Vegetabledao {

	@Override
	public boolean addVegbean(Vegbean vegbean) {
		
//		List< Vegbean> vbean=new LinkedList<Vegbean>();
//		vbean.add(bean);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vegetable","root","root");
			java.sql.Statement statement=con.createStatement();
			statement.executeUpdate("INSERT into vege(`quantity`,`desc`,`cost`) Values('"+ vegbean.getQuantity()+"','"+vegbean.getDesc()+"','"+ vegbean.getCost()+"')");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return false;	
	}

}
