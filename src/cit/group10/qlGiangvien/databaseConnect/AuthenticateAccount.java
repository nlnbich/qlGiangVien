package cit.group10.qlGiangvien.databaseConnect;


import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.constants.dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import com.sun.org.apache.xpath.internal.operations.Equals;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.filter.And;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;
import com.vaadin.data.util.filter.Compare.Equal ;



public class AuthenticateAccount implements dbConnect {
	
	
	private final String TABLE_ACCOUNT ="account" ;
	
	
	
	private String user_name ;
	private String password ;
	
	public AuthenticateAccount(){
		
		user_name = st_default ;
		password = st_default ;
		
	}
	
	public AuthenticateAccount(String username, String password){
		
		this.user_name = username ;
		this.password = password ;		
	}
	
	public String check(){ //return the role of user
		
		System.out.println("info :"+ user_name+ password) ;
		try {
			
			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(
					 JDBC_DRIVER,DB_URL, USER, PASS);
		 
			String st_query = "select * from account where username='"+user_name+"' and password='"+password+"';";
			FreeformQuery query = new FreeformQuery(st_query, pool, "userID");
			SQLContainer result = new SQLContainer(query) ;

			
			System.out.println("re count :"+ result.size()+ st_query) ;
			

//			 SQLContainer result = new SQLContainer(tq);
			 
			 
			 result.addContainerFilter(
					 new And( new Equal("username", user_name),
					          new Equal("password", password) ) );
			 System.out.println("re count :"+ result.size()) ;
			 
			 Collection c = result.getItemIds(); 
	         Item item = result.getItem(c.toArray()[0]) ;
	         Property role = item.getItemProperty(COLLUMM_ROLE) ;
	         System.out.println("get name first : "+ role) ;
			 
			 

			 if (result.size() >0 )
			 {
				 if (role.toString().equals(ADMIN_VALUE)) return "admin" ;
				 else return "user" ;
				 
			 }
			 else 
				 return "";
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "" ;
		}
	}// bl-end of check
	
	static public int countTables(){
				
		int num = 0 ;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("start program");

			Connection conn = null;
			Statement stmt = null;

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			
			String sql = "select count(*) as num "
					+ "from information_schema.tables where table_schema='mydb' ";

			ResultSet rs = stmt.executeQuery(sql);
			rs.next() ;
			num = rs.getInt("num") ;

			 
			System.out.println("number of tables:" + num);

			rs.close(); // Đóng cơ sở dữ liệu
			stmt.close();
			conn.close();
			return num ;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			return 0 ;
		}

		
		
		
		
		
	}

}
