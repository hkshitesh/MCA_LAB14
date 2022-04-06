import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyDBClass {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=utf8","root","hkshitesh");  			 
			Statement stmt=con.createStatement();	
			int id;
			String name="";
			System.out.println("Enter ID");
			id=sc.nextInt();
			System.out.println("Enter Name");
			name=sc.next();
			String sql="insert into emp value("+id+",'"+name+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);			
			ResultSet rs=stmt.executeQuery("select * from emp");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2));		 
			con.close();  
			
		} 
		catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} 

	}

}
