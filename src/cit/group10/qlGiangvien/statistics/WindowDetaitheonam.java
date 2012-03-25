package cit.group10.qlGiangvien.statistics;

import java.sql.Connection;

import cit.group10.qlGiangvien.QlgiangvienApplication;
import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.constants.dbConnect;
import cit.group10.qlGiangvien.detailedInfo.researching.ResearchingBean;
import cit.group10.qlGiangvien.widgets.*;


import com.google.gwt.dev.generator.ast.Statement;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;

public class WindowDetaitheonam extends Window implements Constants, dbConnect {
	

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

		Table table = new Table("Thống kê") ;
		
		table.setWidth("100%") ;
		table.setPageLength(10) ;
		
		rContent.addComponent(title) ;
		rContent.addComponent(table) ;
		
		Connection conn = null;
        Statement stmt = null;
        
        try{
            JDBCConnectionPool pool = new SimpleJDBCConnectionPool(
					 JDBC_DRIVER,DB_URL+QlgiangvienApplication.DB_DBNAME, QlgiangvienApplication.DB_USER, QlgiangvienApplication.DB_PASS);
		 

           String mysql = "select MaCTNC,TenCTNC from NghienCuuKH Group by LoaiCTNC;" ;
           FreeformQuery query = new FreeformQuery(mysql, pool, "MaCTNC") ;
           
           SQLContainer container = new SQLContainer(query);
          
           table.setContainerDataSource(container) ;
        }
        catch(Exception e){
        	System.out.println("in right COntent: "+ e.toString()) ;
        }

		
		
		
		

	}

}
