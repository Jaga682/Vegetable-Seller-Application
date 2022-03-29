package Controller;

import java.util.Scanner;

import Bean.Vegbean;
import Model.Vegetabledaoimpl;

public class VegetableMain {

	public static void main(String[] args) {

		
		Vegetabledaoimpl vegetabledaoimpl=new Vegetabledaoimpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter your data");
		System.out.println("Amount of quantity");
		//int id=sc.nextInt();
		int quantity=sc.nextInt();
		String desc=sc.next();
		float price=sc.nextFloat(); 
		Vegbean bean=new Vegbean();
	
		bean.setCost(price);
		bean.setQuantity(quantity);
		bean.setDesc(desc);
		
		if(vegetabledaoimpl.addVegbean(bean))
		{
			System.out.println("Vegetable added to stock");
			System.out.println("Enter y for adding more stock");
			char choice=sc.next().charAt(0);
			if(choice=='y')
			{
				VegetableMain.main(args);
			}
			else
			{
			System.exit(1);
			}
		}
		else
		{
			System.out.println("Vegetable not added to stock");
			VegetableMain.main(args);
		}
		System.out.println("Flow ended");

	}

}
