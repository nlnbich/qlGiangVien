package cit.group10.qlGiangvien;


import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cit.group10.qlGiangvien.widgets.*;
import cit.group10.qlGiangvien.constants.*;
import cit.group10.qlGiangvien.databaseConnect.AuthenticateAccount;
import cit.group10.qlGiangvien.databaseConnect.CompletedDatabase;
import cit.group10.qlGiangvien.install.CreateFileInformationDatabase;
import cit.group10.qlGiangvien.install.InstallWindow;

import com.vaadin.Application;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;
import com.vaadin.terminal.ExternalResource;

import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.*;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;

public class QlgiangvienApplication extends Application implements Constants,dbConnect, HttpServletRequestListener{
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ThreadLocal<QlgiangvienApplication> currentApplication = new ThreadLocal<QlgiangvienApplication> ();
	
	
	//for connect database
	public static  String DB_DBNAME ="";
	public static  String DB_USER ="";
	public static  String DB_PASS="" ;
	
	
	
	
//	private static final long serialVersionUID = 1L;
//	private TextField loginField;
//	private PasswordField passwordField;
//	private Button submitButton;	
	private Label lblError= new Label() ;
//	private Link link ;
	
	Window mainWindow ;
	
	
	@Override
	public void init() {
		
		
		try {
			
			CreateFileInformationDatabase check_status = new CreateFileInformationDatabase();
			
			if (CreateFileInformationDatabase.checkInstalled()){
				
				mainWindow = new LoginWindow(); // did install >> login form
				
			}else {
				mainWindow = new InstallWindow() ; // did not install >> install form
				
			}
			
			
			
			
			
			System.out.println("QlgiangvienApplication >> status :"  + DB_DBNAME + DB_USER + DB_PASS);


			
			
			
			//set main window			
			setMainWindow(mainWindow);
			setTheme("qlgiangvientheme");
			setInstance(this);

		} catch (Exception e) {

			System.out.println("QlgiangvienApplication :" + e.toString()) ;
		}
			
	}
	
	public static void setInstance(QlgiangvienApplication application) { 					
		currentApplication.set(application); 		
	  }
	
	public static QlgiangvienApplication getInstance()
    {
        return currentApplication.get ();
    }
	
	@Override
	public void onRequestStart(HttpServletRequest request,
			HttpServletResponse response) {

		QlgiangvienApplication.setInstance(this) ;
		
	}
	@Override
	public void onRequestEnd(HttpServletRequest request,
			HttpServletResponse response) {
		
            currentApplication.remove ();
	}
	
	public void authenticatedUser(String user, String password)
	{
		
		System.out.println("in ql :"+ user+ password) ;

		try 
		{
			Window current = this.getMainWindow() ;
			
			AuthenticateAccount authenticate = new AuthenticateAccount(user, password) ;
			

			String result = authenticate.check() ; 
			System.out.println("re: " +result+"--") ;
			
			if (result.equals(ADMIN_VALUE)) 
			{
				
				this.setUser(user) ;
				AdminFunctions newWindow = new AdminFunctions();
				newWindow.setName("Admin Functions");			
				addWindow(newWindow);
				getMainWindow().open(new ExternalResource(newWindow.getURL()));
				setMainWindow(newWindow);			
				
//				Window w = this.getMainWindow() ;
//				removeWindow(current) ;
				
			}
			else{
				if (result.equals(USER_VALUE))
				{
//					Window w = this.getMainWindow() ;
					
					this.setUser(user) ;
					UserFunctions newWindow = new UserFunctions();
					newWindow.setName("User Function");
					addWindow(newWindow);
					getMainWindow().open(new ExternalResource(newWindow.getURL()));
					setMainWindow(newWindow);
//					removeWindow(current) ;
				}
				else mainWindow.showNotification(Constants.LOGIN_FAIL) ;
				
			}
		
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			mainWindow.showNotification("QlgiangvienApplication class: err in try-cathc ") ;
		}		
	}
	
//	public void logout(){
//		LoginWindow newWindow = new LoginWindow();
////		newWindow.setName("Admin Functions");			
////		addWindow(newWindow);
//		getMainWindow().open(new ExternalResource(newWindow.getURL()));
//		setMainWindow(newWindow);
//		
//	}
	
	public void setNewWindow(Window layoutWindow){
		
		Window current = this.getMainWindow() ;				
		
		addWindow(layoutWindow);
		
		getMainWindow().open(new ExternalResource(layoutWindow.getURL()));
		setMainWindow(layoutWindow);
		
//		removeWindow(current) ;
		
		
	}
	
	
}
