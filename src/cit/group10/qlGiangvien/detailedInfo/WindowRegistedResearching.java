package cit.group10.qlGiangvien.detailedInfo ;

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
		
		
		//--------------------bl
//		Label title = new Label("<center><h1>Danh sach de tai<h1></center>", Label.CONTENT_XHTML) ;
////		
////		
////		
////		
//		final BeanItemContainer<ResearchingBean> beans = new BeanItemContainer<ResearchingBean>(ResearchingBean.class);
//
//		Table table = new Table("de tai",beans) ;
//		table.setWidth("100%") ;
//		table.setPageLength(10) ;
//		
////		ResearchingBean(String id, String name, String content, String started_day, String ended_day,
////				String who_width, String status){
//		
//		for (int i=0; i< 100; i++)		
//			beans.addBean(new ResearchingBean()) ;
//		
//		rContent.addComponent(title) ;
//		rContent.addComponent(table) ;

		
		
		

	}

}
