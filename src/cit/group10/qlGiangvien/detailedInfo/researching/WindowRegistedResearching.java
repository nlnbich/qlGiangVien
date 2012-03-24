package cit.group10.qlGiangvien.detailedInfo.researching ;

import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.widgets.*;


import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;

public class WindowRegistedResearching extends Window implements Constants {
	

	private static final long serialVersionUID = 1L;	

	rightContentRegistedResearching rContent  ;
	
	
	
	public WindowRegistedResearching() {

		
		setCaption("dang ky nghien cuu");//Constants.USER_CAPTION) ;
		
		
		HorizontalLayout mainLayout = new HorizontalLayout() ;	
		mainLayout.setImmediate(false);
		mainLayout.setWidth(Constants.WIDTH_MAX, Sizeable.UNITS_PIXELS);
		mainLayout.setMargin(false);
		mainLayout.setSpacing(true);
		
		
		rContent = new rightContentRegistedResearching() ;
		rContent.setWidth("100%") ;
		
		mainLayout.addComponent(new leftSide());
		mainLayout.addComponent(rContent) ;
		mainLayout.setExpandRatio(rContent, 1.0f) ;

		
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
