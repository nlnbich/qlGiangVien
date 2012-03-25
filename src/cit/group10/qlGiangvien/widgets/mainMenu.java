package cit.group10.qlGiangvien.widgets;

import cit.group10.qlGiangvien.AdminFunctions;
import cit.group10.qlGiangvien.LoginWindow;
import cit.group10.qlGiangvien.QlgiangvienApplication;
import cit.group10.qlGiangvien.UserFunctions;
import cit.group10.qlGiangvien.TeacherInfo.WindowAddNewSubject;
import cit.group10.qlGiangvien.TeacherInfo.WindowAddNewTeacher;
import cit.group10.qlGiangvien.TeacherInfo.WindowImportData;
import cit.group10.qlGiangvien.TeacherInfo.WindowProfileInfo;
import cit.group10.qlGiangvien.TeacherInfo.WindowSubjectInfo;
import cit.group10.qlGiangvien.TeacherInfo.WindowUpdateDelete;
import cit.group10.qlGiangvien.TeacherInfo.WindowWorkInfo;
import cit.group10.qlGiangvien.constants.*;
import cit.group10.qlGiangvien.detailedInfo.researching.WindowRegistedResearching;
import cit.group10.qlGiangvien.detailedInfo.researching.WindowResearching;
import cit.group10.qlGiangvien.searching.WindowTimtheobomon;
import cit.group10.qlGiangvien.searching.WindowTimtheohochamhocvi;
import cit.group10.qlGiangvien.searching.WindowTimtheoten;
import cit.group10.qlGiangvien.statistics.WindowDetaitheonam;
import cit.group10.qlGiangvien.statistics.WindowSogiangvientheohochamhocvi;
import cit.group10.qlGiangvien.statistics.WindowSogiangvientheotungbomon1;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Sizeable;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


public class mainMenu extends CustomComponent implements Constants {
	
	private static final long serialVersionUID = 1L;

	private VerticalLayout mainLayout;	
	public MenuBar menuMain;
//	private Command menuCommand ; 
	int userRole=0 ;

	
	public mainMenu() {
		
//		this.menuCommand = menuCommand ;
		
		try{
		
		userRole =Integer.valueOf( QlgiangvienApplication.getInstance().getUser().toString().substring(0, 1) );
		} catch(Exception e){
			userRole =0 ;
		}
		
		 
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		MenuBar.MenuItem[] item = new MenuBar.MenuItem[5] ;
		MenuBar.MenuItem itemM ;// = new MenuBar.MenuItem() ;
		
		switch(userRole)
		{
		case 1:
				for (int i=0; i< MAIN_MENU_TEXT_ADMIN[0].length; i++)
				{
					
					itemM = menuMain.addItem(MAIN_MENU_TEXT_ADMIN[0][i], null) ;
					itemM.setIcon(new ThemeResource(MAIN_MENU_TEXT_ADMIN_ICON[i]));
					
					
					for (int j=0; j < MAIN_MENU_TEXT_ADMIN[i+1].length; j++)
						itemM.addItem(MAIN_MENU_TEXT_ADMIN[i+1][j], menuCommand) ;			
				}//end of for
				break ;
		case 0:	
						
			for (int i=0; i< MAIN_MENU_TEXT_USER[0].length; i++)
			{				
				if (i==0) itemM = menuMain.addItem(MAIN_MENU_TEXT_USER[0][i], menuCommand) ;
				else itemM = menuMain.addItem(MAIN_MENU_TEXT_USER[0][i], null) ;
				itemM.setIcon(new ThemeResource(MAIN_MENU_TEXT_USER_ICON[i]));
				for (int j=0; j < MAIN_MENU_TEXT_USER[i+1].length; j++)
					itemM.addItem(MAIN_MENU_TEXT_USER[i+1][j], menuCommand) ;			
			}
			break ;
		}		
	}//end of constructor

	
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth(Constants.WIDTH_MAX, Sizeable.UNITS_PIXELS);
		mainLayout.setHeight("40px");
		mainLayout.setMargin(false);
		
	
		// menuMain
		menuMain = new MenuBar();
		menuMain.setImmediate(false);
		menuMain.setWidth("100%");
		menuMain.setHeight("100.0%");
		mainLayout.addComponent(menuMain);
		
		return mainLayout;
	}//bl-end of buildMainLayout 
	
	public Command menuCommand = new Command() {
        
		
		@Override
		public void menuSelected(MenuItem selectedItem) {
			
			Window newWindow ;
			
			if (userRole==1){		
			
				newWindow=menuAdminClickFunction(selectedItem) ;
			}			
			else{		
				newWindow=menuUserClickFunction(selectedItem) ;
			}	
			
			
			
			if ( !getApplication().getMainWindow().equals(newWindow) )
				QlgiangvienApplication.getInstance().setNewWindow(newWindow) ;
			
			
			
			getWindow().showNotification("in user Action " + selectedItem.getText()
					+ selectedItem.getId() +"--"
					+ getApplication().getMainWindow().getClass()					
					);
			
		}
		
    };
    
    
    private Window menuAdminClickFunction(MenuItem selectedItem){
    	
    	String url_parent = "admin/" ; //bl-use to assign name for url
    	Window newWindow ;
    	switch(selectedItem.getId()){
		case 1:
			newWindow = new AdminFunctions();					
			newWindow.setName(url_parent+selectedItem.getText()) ;					
			break;
			
		case 4:
			newWindow = new WindowAddNewTeacher();					
			newWindow.setName(url_parent+selectedItem.getText()) ;					
			break;
		case 5:
			newWindow = new WindowUpdateDelete();					
			newWindow.setName(url_parent+selectedItem.getText()) ;					
			break;
		case 6:
			newWindow = new WindowAddNewSubject();					
			newWindow.setName(url_parent+selectedItem.getText()) ;					
			break;
		case 7:
			newWindow = new WindowImportData();					
			newWindow.setName(url_parent+selectedItem.getText()) ;					
			break;
//		case 8:
//			newWindow = new WindowDiscipline_RewardInfo();					
//			newWindow.setName(url_parent+selectedItem.getText()) ;					
//			break;
		case 9:
//			newWindow = new WindowResearching();					
//			newWindow.setName(url_parent+selectedItem.getText()) ;					
//			break;
		case 10:
			newWindow = new WindowRegistedResearching();					
			newWindow.setName(url_parent+selectedItem.getText()) ;
			break ;
		case 12:
			newWindow = new WindowDetaitheonam();					
			newWindow.setName(url_parent+selectedItem.getText()) ;
			break ;
		case 13:
			newWindow = new WindowSogiangvientheotungbomon1();					
			newWindow.setName(url_parent+selectedItem.getText()) ;
			break ;	
		case 14:
			newWindow = new WindowSogiangvientheohochamhocvi();					
			newWindow.setName(url_parent+selectedItem.getText()) ;
			break ;		
		case 15:
			newWindow = new WindowTimtheoten();					
			newWindow.setName(url_parent+selectedItem.getText()) ;
			break ;		
		case 16:
			newWindow = new WindowTimtheobomon();					
			newWindow.setName(url_parent+selectedItem.getText()) ;
			break ;	
		case 17:
			newWindow = new WindowTimtheohochamhocvi();					
			newWindow.setName(url_parent+selectedItem.getText()) ;
			break ;		
			
		default:
			newWindow = new AdminFunctions();		
//			newWindow.setName(url_parent +selectedItem.getText()) ;
//			QlgiangvienApplication.getInstance().setNewWindow(newWindow) ;					
				
		}//end of switch
    	return newWindow ;
		
    }
    
   private Window menuUserClickFunction(MenuItem selectedItem){
    	
    	String url_parent = "user/" ; //bl-use to assign name for url
    	Window newWindow ;
//    	final int i = MAIN_MENU_TEXT_USER[0].length+MAIN_MENU_TEXT_USER[1].length+0 ;
    	switch(selectedItem.getId()){
    	case 1:
    	case 2:
			newWindow = new UserFunctions();					
			newWindow.setName(url_parent+selectedItem.getText()) ;					
			break;
		case 10:
			newWindow = new WindowResearching();					
			newWindow.setName(url_parent+selectedItem.getText()) ;					
			break;
		case 11:
			newWindow = new WindowRegistedResearching();					
			newWindow.setName(url_parent+selectedItem.getText()) ;
			break ;
			
		default:
			newWindow = new WindowRegistedResearching();					
			newWindow.setName(url_parent+selectedItem.getText()) ;	
		}//end of switch
		
    	return newWindow ;
    	
    }
  
	}
