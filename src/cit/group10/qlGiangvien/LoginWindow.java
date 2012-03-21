package cit.group10.qlGiangvien ;

import cit.group10.qlGiangvien.constants.Constants;

import cit.group10.qlGiangvien.widgets.*;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class LoginWindow extends Window implements Constants{
	
	private static final long serialVersionUID = 1L;
	private TextField loginField;
	private PasswordField passwordField;
	private Button submitButton;	
	private Label lblError ;
	private Link link ;
	
	
	
	public LoginWindow() {
		
		Label heading = new Label() ;
		heading.setContentMode(Label.CONTENT_XHTML) ;
		heading.setValue(TITLE_LOGIN) ;	
		
		loginField = new TextField("Login", "user");
		passwordField = new PasswordField("Password", "12345");
		submitButton = new Button("Submit");
		lblError = new Label(" ") ; 
		link = new Link("Quen mat khau ?", null) ;
					
		FormLayout formLayout = new FormLayout();
		formLayout.addComponent(loginField);		
		formLayout.addComponent(passwordField);
		formLayout.addComponent(lblError);
		formLayout.addComponent(submitButton);
		formLayout.addComponent(link);
		formLayout.addComponent(lblError);
		
		VerticalLayout loginForm = new VerticalLayout() ;
		loginForm.setWidth("-1px") ;
		loginForm.addComponent(heading) ;
		loginForm.addComponent(formLayout) ;
		

		VerticalLayout center = new VerticalLayout() ;
		center.setHeight("450px") ;
		center.addComponent(loginForm) ;
		center.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER) ;
		
		
//		submitButto
		
//			submitButton.addListener(this) ;
		

		submitButton.addListener(new Button.ClickListener() {			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {

				try{
					System.out.println("in login :"+(String)loginField.getValue()+ (String)passwordField.getValue()) ;
					QlgiangvienApplication.getInstance().authenticatedUser((String)loginField.getValue(), (String)passwordField.getValue());
					getWindow().showNotification("in click button") ;
										
				}
				catch(Exception e){ getWindow().showNotification("eer in click button") ;}
			}
		});
		
		
		addComponent(new topPanel()) ;		
		addComponent(center) ;
		addComponent(new bottom()) ;
	}

	
	

}
