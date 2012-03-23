package cit.group10.qlGiangvien ;

import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.widgets.*;

import com.vaadin.Application;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;

public class AdminSetting extends Window implements Constants {
	

	private static final long serialVersionUID = 1L;	
	private mainMenu mm ;
	infoUser rightContent  ;
	
	
	
	public AdminSetting() {
//		setSizeFull() ;
//		if (this.getApplication().getUser().equals(null)) this.getApplication().close() ;
		setCaption(Constants.USER_CAPTION) ;
		
		
		HorizontalLayout mainLayout = new HorizontalLayout() ;	
		mainLayout.setImmediate(false);
		mainLayout.setWidth(Constants.WIDTH_MAX, Sizeable.UNITS_PIXELS);
		mainLayout.setMargin(false);
		mainLayout.setSpacing(true);
		
		mainLayout.addComponent(new leftSide());
		rightContent = new infoUser() ;
		rightContent.setWidth("100%") ;
		
		
		mainLayout.addComponent(rightContent) ;
		mainLayout.setExpandRatio(rightContent, 1.0f) ;

		
		VerticalLayout v = new VerticalLayout() ;
		v.setWidth("100%") ;
		v.setStyleName("bl-mainContent") ;
		v.addComponent(mainLayout) ;
		v.setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER) ;
		
	
		addComponent(new topLogin()) ;
		addComponent(new topPanel()) ;
		
		addComponent(new mainMenu()) ;
		addComponent(v) ;		
		addComponent(new bottom()) ;

	}
	

	

}
