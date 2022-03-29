package Controller;

import java.util.Scanner;

import Bean.Cusbean;
import Model.Customerdaoimpl;

public class CustomerMain {

	public static void main(String[] args) {
		Customerdaoimpl customerdaoimpl=new Customerdaoimpl();
		Cusbean cusbean=new Cusbean();
		customerdaoimpl.displayCusbean(cusbean);
		

	}

}
