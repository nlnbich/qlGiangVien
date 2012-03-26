package cit.group10.qlGiangvien.databaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.filter.And;
import com.vaadin.data.util.filter.Compare.Equal;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;

import cit.group10.qlGiangvien.QlgiangvienApplication;
import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.constants.dbConnect;

public class GetDataFromDatabase implements dbConnect {

	GetDataFromDatabase(String sql_statement) {

	}

	public static boolean executeSqlStatement(String sql_statement) {

		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL
					+ QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);
			stmt = conn.createStatement();

			int re = stmt.executeUpdate(sql_statement);
			// System.out.println("result when execute slq:"+ re) ;
			stmt.close();
			conn.close();
			if (re > 0)
				return true;
			else
				return false;

		} catch (Exception ex) {

			System.out.println("UpdateDatabase >>execute: " + ex.getMessage());
			return false;
		}

	}// end of func

	public static String getIDGiangVien() {

		Connection conn = null;
		Statement stmt = null;

		String s = "";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL
					+ QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);
			stmt = conn.createStatement();

			ResultSet rs = stmt
					.executeQuery("select max(id) as max from test ;");
			String re = "";// (rs.next())..getString("max") ;

			// ResultSet r1 = rs.next() ;
			if (rs.next()) {
				s = rs.getString(1);
				if (s.equals("NULL"))
					s = "GV0000";

				System.out.println(">>>>>>>>>>>>>>>>>>> " + s + "--"
						+ increateID(s));

			}

			rs.close();
			stmt.close();
			conn.close();
			return increateID(s);
			// if (re >0 ) return true ; else return false ;

		} catch (Exception ex) {

			System.out.println("UpdateDatabase >> getID: " + ex.getMessage());
			return "GV0001";
		}
	}// end of getIDGiangVien

	static private String increateID(String id) {

		String re = id.substring(0, 2);
		Integer num = Integer.valueOf(id.substring(2));

		String num1 = String.valueOf(num + 1);

		re += ("0000").substring(num1.length()) + num1;

		return re;

	}

	static public SQLContainer getBoMon() {

		try {

			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(JDBC_DRIVER,
					DB_URL + QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);

			String st_query = "select MaBM, TenMH from BoMon ;";
			FreeformQuery query = new FreeformQuery(st_query, pool, "MaBM");
			SQLContainer result = new SQLContainer(query);

			return result ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}//getBoMon
	
	
	static public SQLContainer getDeTai() {

		try {

			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(JDBC_DRIVER,
					DB_URL + QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);

			String st_query = "select MaCTNC, TenCTNC from NghienCuuKH ;";
			FreeformQuery query = new FreeformQuery(st_query, pool, "MaCTNC");
			SQLContainer result = new SQLContainer(query);

			return result ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}//getBoMon
	

}