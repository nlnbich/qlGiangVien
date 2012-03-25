package cit.group10.qlGiangvien.databaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import cit.group10.qlGiangvien.QlgiangvienApplication;
import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.constants.dbConnect;

public class UpdateDatabase implements dbConnect {
	
	
	
	UpdateDatabase(String sql_statement){		
		
	}	
	
	public boolean executeSqlStatement(String sql_statement){
		
		Connection conn = null;
		Statement stmt = null;
		
		
		
		 try{
				  
				 Class.forName("com.mysql.jdbc.Driver");

				 conn = DriverManager.getConnection(DB_URL+QlgiangvienApplication.DB_DBNAME, QlgiangvienApplication.DB_USER, QlgiangvienApplication.DB_PASS);
				 stmt = conn.createStatement();
			     
			     int re =stmt.executeUpdate(sql_statement) ;
			     System.out.println("result when execute slq:"+ re) ;	
			     stmt.close();
			     conn.close();
			     if (re >0 ) return true ; else return false ;
			         
		} catch(Exception ex){
			       
				System.out.println("UpdateDatabase : " + ex.getMessage());
				return false ;
		}
		
		
		
		
	}//end of func
	
}
