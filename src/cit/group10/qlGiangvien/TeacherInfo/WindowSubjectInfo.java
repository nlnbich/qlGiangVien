package cit.group10.qlGiangvien.TeacherInfo;

import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.detailedInfo.researching.ResearchingBean;
import cit.group10.qlGiangvien.widgets.*;


import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;

public class WindowSubjectInfo extends Window implements Constants {
	

	private static final long serialVersionUID = 1L;	

	VerticalLayout rContent  ;
	
	
	
	public WindowSubjectInfo() {

		
		setCaption("Thống tin bộ môn ");//Constants.USER_CAPTION) ;
		
		
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
		Label title = new Label("<center><h1>Thông tin bộ môn <h1></center>", Label.CONTENT_XHTML) ;

		final BeanItemContainer<ResearchingBean> beans = new BeanItemContainer<ResearchingBean>(ResearchingBean.class);

		Table table = new Table("GiangVien",beans) ;
		
		table.setWidth("100%") ;
		table.setPageLength(10) ;
		
		rContent.addComponent(title) ;
		rContent.addComponent(table) ;

		
		
		
		

	}

}

