import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
public static String login="root";
public static String _pass= "super3";
public static String db_link= "jdbc:mysql://localhost:3306";static Scanner sc = new Scanner(System.in);
public static String db_selected="";	
public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("Introduce opcion:");		
		System.out.println("1: Create DB");
		System.out.println("2: Use DB");		
		System.out.println("3: Create Table");
		System.out.println("0: EXIT");
		
		String input= sc.nextLine();
		
		while(!input.equals("0")) {
			switch (input) {
			case "1": 
				createDB();
				break;

			case "2": 
				useDB();
				break;
				
			case "3": 
				createTable();
				break;
			
			
			}
			System.out.println("Introduce opcion:");		
			System.out.println("1: Create DB");
			System.out.println("2: Use DB");		
			System.out.println("3: Create Table");
			System.out.println("0: EXIT");
			input= sc.nextLine();
			
		}
		
		

	}
	private static void createTable() {
	// TODO Auto-generated method stub
		System.out.println("Dime el nombre de la tabla");
		
		String name= sc.nextLine();
		
		try {
			
			Connection cn= DriverManager.getConnection(db_link+"/"+db_selected, login, _pass);
			PreparedStatement ps=null;
			try {

				 ps= cn.prepareStatement("CREATE TABLE "+name+" (Id integer not null, name VARCHAR(255), color VARCHAR(255), PRIMARY KEY(Id))");
					
					int value = ps.executeUpdate();
					
					System.out.println(value);
	        } 
	            catch (SQLException a) {
	           System.err.println(a);
	        }finally {
				try {
					if(ps != null)
						ps.close();
					if(cn != null)
						cn.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			//int value = ps.executeUpdate();
			
			//System.out.println(value);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
}
	private static void useDB() {
	// TODO Auto-generated method stub
		System.out.println("Dime el nombre de la db a usar prro");
		
		String name= sc.nextLine();
		
		try {
			db_selected=name;
			Connection cn= DriverManager.getConnection(db_link+"/"+db_selected, login, _pass);
			ResultSet rs=null;
			try {

	            DatabaseMetaData dbmd = cn.getMetaData();
	            String[] types = {"TABLE"};
	            rs = dbmd.getTables("", "", "", null);
	            if(rs.next()) {
	            while (rs.next()) {
	                System.out.println(rs.getString("TABLE_NAME"));
	            }}else {
	            	System.err.println("NO HAY NA");
	            }
	        } 
	            catch (SQLException a) {
	           System.err.println(a);
	        }finally {
				try {
					if(rs != null)
						rs.close();
					if(cn != null)
						cn.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			//int value = ps.executeUpdate();
			
			//System.out.println(value);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
}
	private static void createDB() {
		// TODO Auto-generated method stub
		
		System.out.println("Dime el nombre prro");
		
		String name= sc.nextLine();
		Connection cn=null;PreparedStatement ps= null;
		try {
			//db_selected=name;
			cn = DriverManager.getConnection(db_link, login, _pass);
			
			 ps= cn.prepareStatement("CREATE DATABASE "+name);
			
			int value = ps.executeUpdate();
			
			System.out.println(value);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(cn != null)
					cn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		
	}

}}
