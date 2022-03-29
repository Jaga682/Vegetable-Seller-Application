package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Bean.Cusbean;
import Bean.Vegbean;


public class Customerdaoimpl implements Customerdao {

	@Override
	public void displayCusbean(Cusbean cusbean) {
		List< Vegbean> list=new LinkedList<Vegbean>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vegetable","root","root");
			Statement statement=con.createStatement();
			ResultSet set=statement.executeQuery("SELECT * FROM `vegetable`.`vege`");
			Vegbean bean=null;
			while(set.next())
			{
				bean=new Vegbean();
				bean.setId(set.getInt(1));
				bean.setQuantity(set.getInt(2));
				bean.setDesc(set.getString(3));
				bean.setCost(set.getFloat("cost"));
				list.add(bean);
			}
			int size=list.size();
			System.out.println("Size value="+size);
			int id[]=new int[size];
			int quan[]=new int[size];
			float cost[]=new float[size];
			int i=0;
			for(Vegbean beans:list)
			{
				
				id[i]=beans.getId();
				quan[i]=beans.getQuantity();
				cost[i]=beans.getCost();
				System.out.print(beans.getId()+"         ");
				System.out.print(beans.getQuantity()+" 			");
				System.out.print(beans.getDesc()+"					 ");
				System.out.println(beans.getCost()+"					 ");
				System.out.println(cost[i]+" at position="+i);
				i++;
			}
			float billsum=0;
			Scanner sc=new Scanner(System.in);
			float bill=0.0f;
			System.out.println("How many items you want to pursase");
				int itemcount=sc.nextInt();
				for(int ii=0;ii<itemcount;ii++)
				{
				System.out.println("Please enter item id to purchase");
			
			System.out.println("Enter your item id");
				int iid=sc.nextInt();
				iid=iid-1;
				System.out.println("Enter your item quantity");
				float quantity=sc.nextFloat();
				if(quan[iid]>quantity)
				{
				System.out.println(bill);
			 bill=bill+quantity*cost[iid];
			Statement statement2=con.createStatement();
			System.out.println("Beans="+quan[iid]);
			float fbean=quan[iid]-quantity;
			
			
			 System.out.println("Quantity="+quantity+"Cost="+cost[iid]);
			 billsum=billsum+bill;
			 System.out.println("Your bill is ="+bill);
			 iid=iid+1;
				String queryUpdate="UPDATE `vegetable`.`vege` SET `quantity`='"+fbean+"' WHERE `id`='"+iid+"'";
				statement2.executeUpdate(queryUpdate);
				}
				else
				{
					System.out.println("Item not in stock");
					ii--;
					
				}
				}
			//System.out.println(billsum);
			
			 //System.out.println("Your bill is ="+bill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}

}
