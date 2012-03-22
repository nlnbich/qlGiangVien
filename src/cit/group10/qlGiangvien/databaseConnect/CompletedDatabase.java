package cit.group10.qlGiangvien.databaseConnect;

import java.sql.*;
import javax.sql.*;
import java.sql.Connection;

import java.sql.SQLException;

import cit.group10.qlGiangvien.QlgiangvienApplication;
import cit.group10.qlGiangvien.constants.dbConnect;
import cit.group10.qlGiangvien.install.CreateFileInformationDatabase;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;

public class CompletedDatabase implements dbConnect {

	public CompletedDatabase() {

	}

	public static boolean create() {

		System.out.println("start create database ");

		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("start create :"+DB_URL+QlgiangvienApplication.DB_DBNAME
					+"--"+QlgiangvienApplication.DB_USER
					+"--"+QlgiangvienApplication.DB_PASS);

			Connection conn = null;
			Statement stmt = null;
			
			System.out.println("user:"+ QlgiangvienApplication.DB_USER + "--") ;
			System.out.println("user:"+ QlgiangvienApplication.DB_PASS + "--") ;

			conn = DriverManager.getConnection(DB_URL+QlgiangvienApplication.DB_DBNAME
					, QlgiangvienApplication.DB_USER, QlgiangvienApplication.DB_PASS);
			
			stmt = conn.createStatement();
			
			
			//delete all old tables ;			
			DatabaseMetaData dbm = conn.getMetaData() ;
			String[] type = {"TABLE"} ;
			ResultSet rs1 = dbm.getTables(null, null, "%", type) ;
			System.out.println("talbe name ") ;
			int re_del =0 ;
			while (rs1.next()){
				String tb = rs1.getString("TABLE_NAME") ;
				System.out.println(tb) ;
				re_del += stmt.executeUpdate("drop table "+tb) ;
			}
			rs1.close() ;
			if (re_del >0) {
				System.out.println("loi khi xoa tat ca bang") ;
				CreateFileInformationDatabase.appendStatus(DIR_NAME+"/"+FILE_NAME, String.valueOf(1) ) ;
				return false;
			}
			
			
			// create new tables		
			int re_sql2 =0 ;
			
			for (int i=0 ; i< CREATE_TABLES .length ; i++){				
				re_sql2 += stmt.executeUpdate(CREATE_TABLES[i]) ;
			}		
			if (re_sql2 > 0) return false ;
			
			//insert account for admin
			int re_sql3 =0 ;
			for (int j=0 ; j< INSERT_ACCOUNT .length ; j++){				
				re_sql3 += stmt.executeUpdate(INSERT_ACCOUNT[j]) ;
			}
			
			CreateFileInformationDatabase.appendStatus(DIR_NAME+"/"+FILE_NAME, String.valueOf(re_sql2) ) ; 
			System.out.println("result of create table : "+ re_sql2) ;
			
			stmt.close();
			conn.close();
			
			if (re_sql3 < INSERT_ACCOUNT.length) return false ;
			return true ;
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("CompletedDatabase >> create :"+e.toString());
			CreateFileInformationDatabase.appendStatus(DIR_NAME+"/"+FILE_NAME, String.valueOf(1) ) ;
			return false ;
		}

	}

}
