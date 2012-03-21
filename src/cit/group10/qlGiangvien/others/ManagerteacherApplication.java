package cit.group10.qlGiangvien.others;
//package cit.group10.qlGiangvien.others ;
//
//
//
//import cit.group10.qlGiangvien.constants.Constants;
//
//import cit.group10.qlGiangvien.widgets.*;
//import com.vaadin.Application;
//import com.vaadin.terminal.ExternalResource;
//import com.vaadin.terminal.Sizeable;
//import com.vaadin.ui.*;
//import com.vaadin.ui.Button.ClickEvent;
//import com.vaadin.ui.LoginForm.LoginEvent;
//
//public class ManagerteacherApplication extends Application {
//	
//	
//	
//	Window mainWindow  ;
//	
//	
//	private TextField loginField;
//	private PasswordField passwordField;
//	private Button submitButton;	
//	private Label lblError ;
//	private Link link ;
//	@Override
//	public void init() {
//		
////		setTheme("testvaadintheme");
//		mainWindow = new Window(Constants.MAIN_CAPTION);
////		mainWindow = new AdminFunctions();
////		mainWindow = new UserFunctions();
//		setMainWindow(mainWindow);
//		mainWindow.setWidth(Constants.WIDTH_MAX, Sizeable.UNITS_PIXELS);
////		mainWindow.setWidth(width, unit)
//		
//		
//		
//		loginField = new TextField("Login", "admin");
//		passwordField = new PasswordField("Password");
//		submitButton = new Button("Submit");
//		lblError = new Label("") ; 
//		link = new Link("Quen mat khau ?", null) ;
//		
//		
//		
//		FormLayout formLayout = new FormLayout();
//		
//		formLayout.addComponent(loginField);		
//		formLayout.addComponent(passwordField);
//		formLayout.addComponent(lblError);
//		formLayout.addComponent(submitButton);
//		formLayout.addComponent(link);
//		formLayout.addComponent(lblError);
//		
//		
//		
//		
//			
//		mainWindow.addComponent(new topPanel()) ;		
//		mainWindow.addComponent(formLayout) ;
//		
////		mainWindow.
//		mainWindow.addComponent(new bottom()) ;
//		
//		
//
//		
////		Button submitButton= new Button("click me") ;
//		submitButton.addListener(new Button.ClickListener() {
//			
//			public void buttonClick(ClickEvent event) {
//				
//				authenticatedUser((String)loginField.getValue(), (String)passwordField.getValue()) ;
//				
//			}
//		});
//
//
//	}
//
//	
//	private void authenticatedUser(String u, String p)
//	{
////		lblLoginFail.setValue("content:" + u+p) ;
//		int flag =0 ;
//		
//		
//		if (u.equals("admin") && p.equals("admin")) 
//		{
//			AdminFunctions newWindow = new AdminFunctions();
//			newWindow.setName("Admin Functions");
//			addWindow(newWindow);
//			getMainWindow().open(new ExternalResource(newWindow.getURL()));
//			setMainWindow(newWindow);			
//		}
//		else
//			if (u.equals("user") && p.equals("12345")){
//				UserFunctions newWindow = new UserFunctions();
//				newWindow.setName("User Function");
//				addWindow(newWindow);
//				getMainWindow().open(new ExternalResource(newWindow.getURL()));
//				setMainWindow(newWindow);
//			}
//			else lblError.setValue(Constants.LOGIN_FAIL) ;
//		
//
//		
//		
//	}
//	
//
//	
//	
//	
//	///======================
//	private void openAnotherWindowTest(){
//		AdminFunctions newWindow = new AdminFunctions();
//		  newWindow.setName("another");
//		  addWindow(newWindow);
//		  getMainWindow().open(new ExternalResource(newWindow.getURL()));
//		  setMainWindow(newWindow);
//		}
//	
//	
//
//}
