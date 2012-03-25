package cit.group10.qlGiangvien.TeacherInfo ;

import java.sql.Connection;
import java.sql.Statement;

import cit.group10.qlGiangvien.QlgiangvienApplication;
import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.constants.dbConnect;

import cit.group10.qlGiangvien.widgets.*;


import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class WindowManagerSubject extends Window implements Constants, dbConnect {
	

	private static final long serialVersionUID = 1L;	

	HorizontalLayout mainLayout  ;
	VerticalLayout rContentList  ;	
	rightContentAddNewSubject rContentModify ;
	Table table ;
	
	Window subwindow ;
	
	
	
	public WindowManagerSubject() {

		
		setCaption("quan ly bo mon ");//Constants.USER_CAPTION) ;
		
		
		
		
		mainLayout = new HorizontalLayout() ;	
		mainLayout.setImmediate(false);
		mainLayout.setWidth(Constants.WIDTH_MAX, Sizeable.UNITS_PIXELS);
		mainLayout.setMargin(false);
		mainLayout.setSpacing(true);
		
		mainLayout.addComponent(new leftSide());
		
		rContentList = new VerticalLayout() ;
		rContentList.setWidth("100%") ;
		mainLayout.addComponent(rContentList) ;
		mainLayout.setExpandRatio(rContentList, 1.0f) ;
		
		rContentModify = new rightContentAddNewSubject() ;
		rContentModify.setWidth("100%") ;		
		
		
		
				
		

		
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
		Label title = new Label("<center><h1>Danh sách bo mon<h1></center>", Label.CONTENT_XHTML) ;
//		
//		
//		
//		
		

		table = new Table() ;		
		table.setWidth("100%") ;
		table.setPageLength(20) ;
	
		rContentList.addComponent(title) ;
		rContentList.addComponent(table) ;
		
		Connection conn = null;
        Statement stmt = null;
        
        try{
            JDBCConnectionPool pool = new SimpleJDBCConnectionPool(
					 JDBC_DRIVER,DB_URL+QlgiangvienApplication.DB_DBNAME, QlgiangvienApplication.DB_USER, QlgiangvienApplication.DB_PASS);
		 

           String mysql = "SELECT * from BoMon" ;
                    
           FreeformQuery query = new FreeformQuery(mysql, pool, "MaCTNC") ;
           
           SQLContainer container = new SQLContainer(query);
          
           table.setContainerDataSource(container) ;
           
           
           
           
           table.addGeneratedColumn("Chinh Sua", new Table.ColumnGenerator() {
               public Component generateCell(Table source, Object itemId, Object columnId) {
                   Item item = table.getItem(itemId);                   
                   
                   Button btnModify = new Button("Chinh Sua", new Button.ClickListener() {                       
              			@Override
              			public void buttonClick(ClickEvent event) {
              				
//              				rContentList.setVisible(false);
//              				rContentModify.setVisible(true);
              				
              				mainLayout.removeComponent(rContentList) ;
              				mainLayout.addComponent(rContentModify) ;		
              				mainLayout.setExpandRatio(rContentModify, 1.0f) ;
              				
              				
              			}
                      });
                   
                   
                   
                   return btnModify;
               }
           });
           confirmDelete();
           table.addGeneratedColumn("Xoa", new Table.ColumnGenerator() {
               public Component generateCell(Table source, Object itemId, Object columnId) {
                   
//            	   Item item = table.getItem(itemId);      
                   
                   Button btnModify = new Button("Close", new Button.ClickListener() {                       
           			@Override
           			public void buttonClick(ClickEvent event) {
           				
           				if (subwindow.getParent() == null) {
                                                    
                            getWindow().addWindow(subwindow);
                        }
           			}
                   });
                   
                   return btnModify;
               }
           });

           
           
           
           
           
           
           
           
           
           
           
        }
        catch(Exception e){
        	System.out.println("in right COntent: "+ e.toString()) ;
        }
	}//end of container
	
	
	void confirmDelete(){
		
		
		// Create the window...
        subwindow = new Window("Xoa ??");
        // ...and make it modal
        subwindow.setModal(true);

        // Configure the windws layout; by default a VerticalLayout
        VerticalLayout layout = (VerticalLayout) subwindow.getContent();
        layout.setMargin(true);
        layout.setSpacing(true);

        // Add some content; a label and a close-button
        Label message = new Label("Ban co chac chan muon xoa ?");
        subwindow.addComponent(message);

        Button close = new Button("Co", new Button.ClickListener() {
            
			@Override
			public void buttonClick(ClickEvent event) {
				
				(subwindow.getParent()).removeWindow(subwindow);
			}
        });
        // The components added to the window are actually added to the window's
        // layout; you can use either. Alignments are set using the layout
        layout.addComponent(close);
        layout.setComponentAlignment(close, Alignment.TOP_RIGHT);
		
		
	}//end of confirmDelete
	
	
	
	
	

}
