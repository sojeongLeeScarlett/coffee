package kr.or.dgit.coffee_application;

import java.util.Properties;

import kr.or.dgit.coffee_application.ui.CoffeeUI;
import kr.or.dgit.erp_application.jdbc.DBcon;
import kr.or.dgit.erp_application.jdbc.LoadProperties;

public class TestMain {
	public static void main(String[] args) {
		CoffeeUI main = new CoffeeUI();
		main.setVisible(true);
		main.setBounds(100, 100, 500, 300);
		
		
	}
	
	private static void TestDBconnection() {
		DBcon dbCon = DBcon.getInstance();
		System.out.println(dbCon);
		
		dbCon =  DBcon.getInstance();
		System.out.println(dbCon);
		
		LoadProperties lp = new LoadProperties();
		Properties pro = lp.getProperties();
		
		System.out.printf("user %s : password %s%n",
				pro.getProperty("user"),pro.getProperty("password"));
	}
}
