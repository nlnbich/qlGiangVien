package cit.group10.qlGiangvien.TeacherInfo ;

import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.widgets.*;


import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;

public class WindowAddTeacher extends Window implements Constants {
	

	private static final long serialVersionUID = 1L;	

	rightContentAddTeacher rContent  ;
	
	
	
	public WindowAddTeacher() {

		
		setCaption("Thông tin giảng viên ");//Constants.USER_CAPTION) ;
		
		
		HorizontalLayout mainLayout = new HorizontalLayout() ;	
		mainLayout.setImmediate(false);
		mainLayout.setWidth(Constants.WIDTH_MAX, Sizeable.UNITS_PIXELS);
		mainLayout.setMargin(false);
		mainLayout.setSpacing(true);
		
		
		rContent = new rightContentAddTeacher() ;
		rContent.setWidth("100%") ;
		
		mainLayout.addComponent(new leftSide(PERMISSION.USER));
		mainLayout.addComponent(rContent) ;
		mainLayout.setExpandRatio(rContent, 1.0f) ;

		
		VerticalLayout v = new VerticalLayout() ;
		v.setWidth("100%") ;
		v.setStyleName("bl-mainContent") ;
		v.addComponent(mainLayout) ;
		v.setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER) ;
			
		addComponent(new topLogin()) ;
		addComponent(new topPanel()) ;		
		addComponent(new mainMenu(PERMISSION.USER)) ;
		addComponent(v) ;		
		addComponent(new bottom()) ;
		
		

		
		
		

	}

}
