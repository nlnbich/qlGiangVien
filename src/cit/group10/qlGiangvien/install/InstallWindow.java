package cit.group10.qlGiangvien.install ;

import cit.group10.qlGiangvien.AdminFunctions;
import cit.group10.qlGiangvien.LoginWindow;
import cit.group10.qlGiangvien.QlgiangvienApplication;
import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.constants.cInstallDatabase;
import cit.group10.qlGiangvien.databaseConnect.CompletedDatabase;
import cit.group10.qlGiangvien.widgets.*;

import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.BaseTheme;

public class InstallWindow extends Window implements cInstallDatabase {
	

	private static final long serialVersionUID = 1L;	
	
	private Label heading ;
	private TextField dbname, dbuser;
	private PasswordField dbpass;
	private Button submitButton, btnLoginForm;	
	private Label lblInfo ;
	
	private FormLayout formLayout ;
	
	
	
	
	
	
	public InstallWindow() {

		
		setCaption("install") ;		
		
		
		
		
		heading = new Label() ;
		heading.setContentMode(Label.CONTENT_XHTML) ;
		heading.setValue(HEADING) ;	
		
		dbname = new TextField("Ten database", "dbqlGiangvien");
		dbuser = new TextField("User", "root");
		dbpass = new PasswordField("Password ", "root");		
		submitButton = new Button("Apply");
		
		
		
		btnLoginForm= new Button("Go to login page") ;
		btnLoginForm.setStyleName(BaseTheme.BUTTON_LINK) ;
		btnLoginForm.setVisible(false) ;
		formLayout = new FormLayout();
		formLayout.addComponent(dbname);		
		formLayout.addComponent(dbuser);
		formLayout.addComponent(dbpass);
		formLayout.addComponent(submitButton);
		
		
		
		lblInfo = new Label(NOTE) ;
		lblInfo.setContentMode(Label.CONTENT_XHTML) ;
//		submitButton.setDisableOnClick(true) ;
		
		
		
		
		
		
		
		submitButton.addListener(new Button.ClickListener() {			
			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {

				try{
//					submitButton.setValue("Installing database...") ;
//					event.getButton().setValue("Installing...") ;
					CreateFileInformationDatabase.createConfiguretionFile(dbname.getValue().toString(),
							dbuser.getValue().toString(), dbpass.getValue().toString()) ;
					boolean re = CompletedDatabase.create() ;
					
					if (re)
					{
						lblInfo.setValue(MES_SUCCESS) ;
						btnLoginForm.setVisible(true) ;
						formLayout.setVisible(false) ;
						heading.setVisible(false) ;
						
					}
					else 
						lblInfo.setValue(MES_FAIL) ;
						
					
					
					
//					getWindow().showNotification("in click button") ;
//					submitButton.setDisableOnClick(true);
//					submitButton.set
										
				}
				catch(Exception e){ 
					System.out.println("eer in click button"+ e.toString()) ;}
			}
		});
		
		
		
		
		btnLoginForm.addListener(new Button.ClickListener() {			
			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				
				LoginWindow newWindow = new LoginWindow();
				newWindow.setName("Login Form");			
				addWindow(newWindow);
				getApplication().close() ;
//				getApplication().getMainWindow().open(new ExternalResource(newWindow.getURL()));
//				getApplication().setMainWindow(newWindow);
				
				
			
			}
		}) ;

	
		
		
		
		VerticalLayout v = new VerticalLayout() ;		
		v.setImmediate(false);
		v.setWidth(Constants.WIDTH_MAX, Sizeable.UNITS_PIXELS);
		v.setMargin(false);
		v.setSpacing(true);
		v.addComponent(heading) ;
		v.addComponent(formLayout) ;
		v.addComponent(lblInfo);
		v.addComponent(btnLoginForm) ;
		
		HorizontalLayout h = new HorizontalLayout() ;
		h.setWidth("100%") ;
		h.setHeight("300px") ;
		h.addComponent(v) ;
		h.setComponentAlignment(v, Alignment.MIDDLE_CENTER) ;
		h.setSpacing(true) ;
		
	
	
		
		addComponent(new topPanel()) ;		
		addComponent(h) ;
		
		addComponent(new bottom()) ;

	}
	

	

}
