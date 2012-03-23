package cit.group10.qlGiangvien.statistics;

import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.detailedInfo.researching.ResearchingBean;
import cit.group10.qlGiangvien.widgets.*;


import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;

public class WindowDetaitheonam extends Window implements Constants {
	

	private static final long serialVersionUID = 1L;	

	VerticalLayout rContent  ;
	
	
	
	public WindowDetaitheonam() {

		
		setCaption("Thống kê đề tài theo năm");//Constants.USER_CAPTION) ;
		
		
		HorizontalLayout mainLayout = new HorizontalLayout() ;	
		mainLayout.setImmediate(false);
		mainLayout.setWidth(Constants.WIDTH_MAX, Sizeable.UNITS_PIXELS);
		mainLayout.setMargin(false);
		mainLayout.setSpacing(true);
		
		mainLayout.addComponent(new leftSide());
		rContent = new VerticalLayout() ;
		rContent.setWidth("100%") ;
				
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
		
		
		//--------------------bl
		Label title = new Label("<center><h1>Thống kê đề tài theo năm<h1></center>", Label.CONTENT_XHTML) ;

		final BeanItemContainer<ResearchingBean> beans = new BeanItemContainer<ResearchingBean>(ResearchingBean.class);

		Table table = new Table("Thống kê",beans) ;
		
		table.setWidth("100%") ;
		table.setPageLength(10) ;
		
		rContent.addComponent(title) ;
		rContent.addComponent(table) ;

		
		
		
		

	}

}
