package cit.group10.qlGiangvien.databaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

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

	public static String getMaGV() {

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
					.executeQuery("select max(MaGV) as max from GiangVien ;");

			String re = "";

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

		} catch (Exception ex) {

			System.out.println("UpdateDatabase >> getID: " + ex.getMessage());
			return "GV0001";
		}
	}// end of getIDGiangVien

	public static String getMaQTCT() {

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
					.executeQuery("select max(MaQTCT) as max from QuaTrinhCongTac ;");

			String re = "";

			if (rs.next()) {
				s = rs.getString(1);
				if (s.equals("NULL"))
					s = "0";
			}
			rs.close();
			stmt.close();
			conn.close();

			return String.valueOf((Integer.valueOf(s) + 1));

		} catch (Exception ex) {

			System.out.println("UpdateDatabase >> getID: " + ex.getMessage());
			return "1";
		}
	}// end of getIDGiangVien

	public static String getMaCV() {

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
					.executeQuery("select max(MaCV) as max from GiangVien_BoMon ;");

			String re = "";

			if (rs.next()) {
				s = rs.getString(1);
				if (s.equals("NULL"))
					s = "0";
			}
			rs.close();
			stmt.close();
			conn.close();

			return String.valueOf((Integer.valueOf(s) + 1));

		} catch (Exception ex) {

			System.out.println("UpdateDatabase >> getID: " + ex.getMessage());
			return "1";
		}
	}// end of getMaCV

	public static String getMaBM() {

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

			ResultSet rs = stmt.executeQuery("select max(MaBM) as max from BoMon ;");

			String re = "";

			if (rs.next()) {
				s = rs.getString(1);
				if (s.equals("NULL"))
					s = "BM0000";
			}
			rs.close();
			stmt.close();
			conn.close();

			return increateID(s);

		} catch (Exception ex) {

			System.out.println("UpdateDatabase >> getID: " + ex.getMessage());
			return "BM0001";
		}
	}// end of getMaCV
	
	public static String getMaCTNC() {

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

			ResultSet rs = stmt.executeQuery("select max(MaCTNC) as max from NghienCuuKH ;");

			String re = "";

			if (rs.next()) {
				s = rs.getString(1);
				if (s.equals("NULL"))
					s = "NC0000";
			}
			rs.close();
			stmt.close();
			conn.close();

			return increateID(s);

		} catch (Exception ex) {

			System.out.println("UpdateDatabase >> getID: " + ex.getMessage());
			return "NC0001";
		}
	}// end of getMaCV

	

	static private String increateID(String id) {

		String re = id.substring(0, 2);
		Integer num = Integer.valueOf(id.substring(2));

		String num1 = String.valueOf(num + 1);

		re += ("0000").substring(num1.length()) + num1;

		return re;

	}

	// ===================================== for list
	static public SQLContainer getBoMon() {

		try {

			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(JDBC_DRIVER,
					DB_URL + QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);

			String st_query = "select MaBM, TenBM from BoMon ;";
			FreeformQuery query = new FreeformQuery(st_query, pool, "MaBM");
			SQLContainer result = new SQLContainer(query);

			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}// getBoMon

	static public SQLContainer getDeTai() {

		try {

			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(JDBC_DRIVER,
					DB_URL + QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);

			String st_query = "select MaCTNC, TenCTNC from NghienCuuKH ;";
			FreeformQuery query = new FreeformQuery(st_query, pool, "MaCTNC");
			SQLContainer result = new SQLContainer(query);

			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}// getBoMon

	static public boolean insertGiangVien(List sql) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL
					+ QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);
			// Setting auto commit false
			conn.setAutoCommit(false);
			System.out.println("Databese Connection Done........");
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Error In Connection");
			return false;
		}
		try {
			// Creating Statement
			stmt = conn.createStatement();
			
			
			
			
			java.util.Iterator it=sql.iterator();

	        while(it.hasNext())
	        {
	          String value=(String)it.next();
	          System.out.println("Value :"+value);
	          stmt.executeUpdate(value);
	        }

			conn.commit();
			conn.close();
			stmt.close();
			return true;

		} catch (Exception e) {
			System.out.println("insertGiangVien" +e.toString());
			e.printStackTrace() ;
			return false;
		}
	}//end  of insertGiangVien
	
	
	static public Item getDataGVCoBan(String ma) {

		try {

			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(JDBC_DRIVER,
					DB_URL + QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);

			String st_query = "select * from GiangVien where MaGV='" + ma
					+ "' ;";
			FreeformQuery query = new FreeformQuery(st_query, pool, "MaGV");
			SQLContainer result = new SQLContainer(query);

			Collection c = result.getItemIds();
			if (c.size() < 1) return null ;
			Item item = result.getItem(c.toArray()[0]);
			// Property role = item.getItemProperty(COLLUMM_ROLE) ;
			// System.out.println("get name first : "+ role) ;
			return item;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}// end of getDataGVCoBan
	
	static public Item getDataGVCongTac(String ma) {

		try {

			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(JDBC_DRIVER,
					DB_URL + QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);

			String st_query = "select * from QuaTrinhCongTac where MaGV='" + ma
					+ "' ;";
			FreeformQuery query = new FreeformQuery(st_query, pool, "MaQTCT");
			SQLContainer result = new SQLContainer(query);

			Collection c = result.getItemIds();
			if (c.size() < 1) return null ;
			Item item = result.getItem(c.toArray()[0]);
			// Property role = item.getItemProperty(COLLUMM_ROLE) ;
			// System.out.println("get name first : "+ role) ;
			return item;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}// end of getDataGVCongTac
	static public Item getDataGVBoMon(String ma) {

		try {

			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(JDBC_DRIVER,
					DB_URL + QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);

			String st_query = "select * from GiangVien_BoMon where MaGV='" + ma
					+ "' ;";
			FreeformQuery query = new FreeformQuery(st_query, pool, "MaCV");
			SQLContainer result = new SQLContainer(query);

			Collection c = result.getItemIds();
			if (c.size() < 1) return null ;
			Item item = result.getItem(c.toArray()[0]);
			// Property role = item.getItemProperty(COLLUMM_ROLE) ;
			// System.out.println("get name first : "+ role) ;
			return item;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}// end of getDataGVCoBan
	static public SQLContainer getDataGVHocHam(String ma) {

		try {

			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(JDBC_DRIVER,
					DB_URL + QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);

			String st_query = "select * from GiangVien_HocHam where MaGV='" + ma
					+ "' ;";
			FreeformQuery query = new FreeformQuery(st_query, pool, "MaGVHH");
			SQLContainer result = new SQLContainer(query);

			
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}// end of getDataGVHocHam
	
	static public SQLContainer getDataGVHocVi(String ma) {

		try {

			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(JDBC_DRIVER,
					DB_URL + QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);

			String st_query = "select * from GiangVien_HocVi where MaGV='" + ma
					+ "' ;";
			FreeformQuery query = new FreeformQuery(st_query, pool, "MaGVHV");
			SQLContainer result = new SQLContainer(query);
			
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}// end of getDataGVHocVi
	static public Item getDataGVDangNhap(String ma) {

		try {

			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(JDBC_DRIVER,
					DB_URL + QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);

			String st_query = "select * from Account where MaGV='" + ma	+ "' ;";
			FreeformQuery query = new FreeformQuery(st_query, pool, "accountID");
			SQLContainer result = new SQLContainer(query);

			Collection c = result.getItemIds();
			if (c.size() < 1) return null ;
			
			Item item = result.getItem(c.toArray()[0]);
			// Property role = item.getItemProperty(COLLUMM_ROLE) ;
			// System.out.println("get name first : "+ role) ;
			return item;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}// end of getDataGVCoBan
	
	static public SQLContainer getDataGVNghienCuu(String ma) {

		try {

			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(JDBC_DRIVER,
					DB_URL + QlgiangvienApplication.DB_DBNAME,
					QlgiangvienApplication.DB_USER,
					QlgiangvienApplication.DB_PASS);

			String st_query = "select * from GiangVien_NghienCuuKH where MaGV='" + ma + "' ;";
			FreeformQuery query = new FreeformQuery(st_query, pool, "MaGV, MaCTNC");
			SQLContainer result = new SQLContainer(query);
			
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}// end of getDataGVCoBan
	
	
	
	
	
	
}