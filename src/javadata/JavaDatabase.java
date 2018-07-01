package javadata;

import java.sql.*;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class JavaDatabase {

	public static void main(String[] args) throws Exception {
		int count = 0;
		String YRN;
		PreparedStatement st;
		Connection connection;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the Id: ");
			int id = sc.nextInt();
			System.out.println("enter the name: ");
			String name = sc.next();

			String url = "jdbc:mysql://localhost:3306/sys?autoReconnect=true&useSSL=false";

			String user = "root";
			String password = "admin";
			String query = "insert into student values(?,?)";

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url, user, password);
			st = connection.prepareStatement(query);
			st.setInt(1, id);
			st.setString(2, name);
			int rsCount = st.executeUpdate();

			// ResultSet rs = st.executeQuery();

			System.out.println(rsCount + " rows affected");
			count++;
			// while(rs.next()) {
			//// rs.next();x
			// String name1 = rs.getString(2)+" "+rs.getInt(1);
			// System.out.println(name1);
			// }

			System.out.println("if you want to insert more data (Y/N) :");
			YRN = sc.next();
		} while (YRN.equalsIgnoreCase("y"));
		st.close();
		connection.close();
		System.out.println("Total " + count + " rows affected");

	}
}
