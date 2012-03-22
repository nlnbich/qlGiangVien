package cit.group10.qlGiangvien.install;

import java.io.*;

import cit.group10.qlGiangvien.QlgiangvienApplication;
import cit.group10.qlGiangvien.constants.dbConnect;

public class CreateFileInformationDatabase implements dbConnect{

	
	public CreateFileInformationDatabase(){
	}
	
	
	public static boolean createConfiguretionFile(String db_name, String user, String pass){
		
		QlgiangvienApplication.DB_DBNAME = db_name ;
		QlgiangvienApplication.DB_USER = user;
		QlgiangvienApplication.DB_PASS = pass ;
		
		
		
		
		File dir = new File(DIR_NAME) ;
		
		
		try{
			
//			InputStreamReader ist
			
			if (!dir.exists())
			{
				boolean re_dir = dir.mkdir() ;
//				dir.set
			
				
				if(re_dir){
					System.out.println("dir success") ;
					createFile(DIR_NAME+"/"+FILE_NAME, db_name, user, pass) ;
				}
				
				else System.out.println("dir fail") ;
			}
			else {
				System.out.println("dir exits") ;
				createFile(DIR_NAME+"/"+FILE_NAME, db_name, user, pass) ;
			}
			
			
			
			
			
		}
		catch( Exception e){
			System.out.println("error in CreateFileInformation :" + e.toString() ) ;
		}
		
		
//		appendStatus(DIR_NAME+"/"+FILE_NAME, "ok") ;
		
		
		
		
		
		return true ;
	}
	
	private static void createFile(String fileName, String dbName, String user, String pass){
		
		try {
//			File file = new File(fileName) ;
//			PrintWriter wrote = new PrintWriter( new FileWriter(file)) ;
////			wrote.println("status") ;
//			wrote.println(dbName) ;
//			wrote.println(user) ;
//			wrote.println(pass) ;
//			wrote.close() ;
			
			BufferedWriter bw= new BufferedWriter(new FileWriter(fileName) );
			bw.write("databaseName=" +dbName) ;
			bw.newLine() ;
			bw.write("userName="+user) ;
			bw.newLine() ;
			bw.write("passWord="+pass) ;
			bw.newLine();
			bw.close();
			
			
			

//			System.out.println ("write done "+ file.getAbsolutePath()) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}//end of createFile
	
	public static void appendStatus(String fileName, String status){
		
		try {
			BufferedWriter bw= new BufferedWriter(new FileWriter(fileName, true) );
			
			bw.append("status="+status) ;
			
			bw.close();
		} catch (IOException e) {
						e.printStackTrace();
		}
	}
	
	public static boolean checkInstalled(){
		
		System.out.println("check the exist of file") ;
		
		String fileName = DIR_NAME+"/"+FILE_NAME ;
		
		try{
			File file = new File(fileName) ;
			if (!file.exists() ) return false ;
			else {
				
				BufferedReader br= new BufferedReader(new FileReader(fileName) );
				
				QlgiangvienApplication.DB_DBNAME = getValueString(br.readLine()) ;
				QlgiangvienApplication.DB_USER = getValueString(br.readLine());
				QlgiangvienApplication.DB_PASS = getValueString(br.readLine()) ;
				String status = getValueString(br.readLine()) ;
				br.close() ;
				System.out.println("status value :"+ status) ;
				if (status.equals("0")) return true ;
				else return false ;
				
			}
			
		}catch (Exception e){
			System.out.println("CreateFileInformation >> checkInstalled :"+ e.toString()) ;
			return false ;
		}
		
	}//end of checkInstalled 
		
	private static String getValueString(String line){
		
		return line.substring(line.indexOf("=")+1).trim() ;
	}
	
	
	
}
