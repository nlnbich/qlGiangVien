package cit.group10.qlGiangvien.databaseConnect;

import java.sql.*;
import javax.sql.*;
import java.sql.Connection;

import java.sql.SQLException;

import cit.group10.qlGiangvien.constants.dbConnect;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;

public class CompletedDatabase implements dbConnect {

	public CompletedDatabase() {

	}

	public void create() {

		System.out.println("start create database ");

		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("start program");

			Connection conn = null;
			Statement stmt = null;

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			
			stmt = conn.createStatement();
			String sql;
			
			String counttb = "select count(*) as num "
					+ "from information_schema.tables where table_schema='mydb' ";

			ResultSet rs = stmt.executeQuery(counttb);
			// rs.next() ;
			//
			//
			// rs.getInt("num") ;

			// while(rs.next()){ //Hiển thị kết quả câu lệnh Select
			// int id = rs.getInt("num");
			// // String name = rs.getString("name");
			// // int age = rs.getInt("age");
			//
			// System.out.println("ID: " + id);
			// // System.out.println(", Last: " + last);
			// }//while

			System.out
					.println("number of tables:" + rs.getInt("num") + counttb);

			rs.close(); // Đóng cơ sở dữ liệu
			stmt.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}

	}

}
