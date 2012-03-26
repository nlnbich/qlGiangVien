package cit.group10.qlGiangvien.statistics;

import java.sql.Connection;

import cit.group10.qlGiangvien.QlgiangvienApplication;
import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.constants.dbConnect;
import cit.group10.qlGiangvien.detailedInfo.researching.ResearchingBean;
import cit.group10.qlGiangvien.widgets.*;



import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;

public class WindowSogiangvientheohochamhocvi extends Window implements Constants,dbConnect {
	

	private static final long serialVersionUID = 1L;	

	VerticalLayout rContent  ;
	
	
	
	public WindowSogiangvientheohochamhocvi() {

		
		setCaption("Thống kê số giảng viên theo học hàm, học vị");//Constants.USER_CAPTION) ;
		
		
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
		Label title = new Label("<center><h1>Thống kê số giảng viên theo học vị<h1></center>", Label.CONTENT_XHTML) ;
		Label title1 = new Label("<center><h1>Thống kê số giảng viên theo học hàm<h1></center>", Label.CONTENT_XHTML) ;

		
		Table table = new Table("thống kê theo học vị") ;
		table.setWidth("100%") ;
		table.setPageLength(10) ;
		rContent.addComponent(title) ;
		rContent.addComponent(table) ;

		Table table1 = new Table("thống kê theo học hàm") ;
		table1.setWidth("100%") ;
		table1.setPageLength(10) ;
		rContent.addComponent(title1) ;
		rContent.addComponent(table1) ;
        try{
           
          
           JDBCConnectionPool pool = new SimpleJDBCConnectionPool(
					 JDBC_DRIVER,DB_URL+QlgiangvienApplication.DB_DBNAME, QlgiangvienApplication.DB_USER, QlgiangvienApplication.DB_PASS);
		 
           // Học vị
           String mysql = "select TenHocVi, count(g.MaGV) as 'Số lượng giảng viên'    from GiangVien g , GiangVien_HocVi h where h.MaGV = g.MaGV group by TenHocVi;" ;
        //   String mysql = "Select TenHocVi,Count(g.MaGV) as 'Mã giảng viên' from GiangVien_HocVi;";
           FreeformQuery query = new FreeformQuery(mysql, pool, "TenHocVi") ;
             SQLContainer container = new SQLContainer(query);
             table.setContainerDataSource(container) ;
          // học hàm 
           String mysql1 = "	select TenHocHam, count(g.MaGV) as 'Số lượng giảng viên'    from GiangVien g , GiangVien_HocHam h where h.MaGV = g.MaGV group by TenHocHam;" ;
            //  String mysql = "Select TenHocVi,Count(g.MaGV) as 'Mã giảng viên' from GiangVien_HocVi;";
              FreeformQuery query1 = new FreeformQuery(mysql1, pool, "TenHocHam") ;
                SQLContainer container1 = new SQLContainer(query1);
                table1.setContainerDataSource(container1) ;
        }
        catch(Exception e){
        	System.out.println("in right Content: "+ e.toString()) ;
        }

		
		
		
		

	}

}
