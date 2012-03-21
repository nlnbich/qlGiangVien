package cit.group10.qlGiangvien.constants;

public interface dbConnect {
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/dbqlGiangvien";;
	static final String USER = "root";
	static final String PASS = "root";
	
	
	//for authenticateAccount
	static final String st_default ="default" ;
	static final String COLLUMM_ROLE = "role" ;
	static final String ADMIN_VALUE = "admin" ;
	static final String USER_VALUE = "user" ;
	
	

}
