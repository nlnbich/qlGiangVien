package cit.group10.qlGiangvien ;

import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.constants.Constants.PERMISSION;
import cit.group10.qlGiangvien.widgets.*;

import com.vaadin.Application;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;

public class AdminFunctions extends Window {
	
	
	public AdminFunctions() {
		
//		if (this.getApplication().getUser().equals(null)) this.getApplication().close() ;
		
		setCaption(Constants.ADMIN_CAPTION) ;
		
		HorizontalLayout mainLayout = new HorizontalLayout() ;	
		mainLayout.setImmediate(false);
		mainLayout.setWidth(Constants.WIDTH_MAX, Sizeable.UNITS_PIXELS);
		mainLayout.setMargin(false);
		mainLayout.setSpacing(true);
		

		mainLayout.addComponent(new leftSide(PERMISSION.ADMIN));
		rightContentSample info = new rightContentSample() ;
		info.setWidth("100%") ;
		mainLayout.addComponent(info) ;
		mainLayout.setExpandRatio(info, 1.0f) ;

		
		VerticalLayout v = new VerticalLayout() ;
		v.setWidth("100%") ;
		v.setStyleName("bl-mainContent") ;
		v.addComponent(mainLayout) ;
		v.setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER) ;
		
		
		addComponent(new topLogin()) ;
		addComponent(new topPanel()) ;
		addComponent(new mainMenu(PERMISSION.ADMIN)) ;
		addComponent(v) ;		
		addComponent(new bottom()) ;
		
		
		
		
		
	}

}
