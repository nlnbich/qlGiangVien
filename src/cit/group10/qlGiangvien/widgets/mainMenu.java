package cit.group10.qlGiangvien.widgets;

import cit.group10.qlGiangvien.AdminFunctions;
import cit.group10.qlGiangvien.LoginWindow;
import cit.group10.qlGiangvien.QlgiangvienApplication;
import cit.group10.qlGiangvien.UserFunctions;
import cit.group10.qlGiangvien.constants.*;
import cit.group10.qlGiangvien.detailedInfo.researching.WindowRegistedResearching;
import cit.group10.qlGiangvien.detailedInfo.researching.WindowResearching;
import cit.group10.qlGiangvien.statistics.WindowDetaitheonam;

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
	PERMISSION userRole ;

	
	public mainMenu(PERMISSION userPermission ) {
		
//		this.menuCommand = menuCommand ;
		
		userRole = userPermission ;
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		MenuBar.MenuItem[] item = new MenuBar.MenuItem[5] ;
		MenuBar.MenuItem itemM ;// = new MenuBar.MenuItem() ;
		
		switch(userPermission)
		{
		case ADMIN:
				for (int i=0; i< MAIN_MENU_TEXT_ADMIN[0].length; i++)
				{
					
					itemM = menuMain.addItem(MAIN_MENU_TEXT_ADMIN[0][i], null) ;
					itemM.setIcon(new ThemeResource(MAIN_MENU_TEXT_ADMIN_ICON[i]));
					
					
					for (int j=0; j < MAIN_MENU_TEXT_ADMIN[i+1].length; j++)
						itemM.addItem(MAIN_MENU_TEXT_ADMIN[i+1][j], menuCommand) ;			
				}//end of for
				break ;
		case USER:	
						
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
			
			if (userRole.equals(Constants.PERMISSION.ADMIN)){		
			
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
			
			
			
		
		
//		case 10:
//			newWindow = new WindowResearching();					
//			newWindow.setName(url_parent+selectedItem.getText()) ;					
//			break;
//		case 11:
//			newWindow = new WindowRegistedResearching();					
//			newWindow.setName(url_parent+selectedItem.getText()) ;
//			break ;
		case 13:
			newWindow = new WindowDetaitheonam();					
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
			
			
		default:
			newWindow = new Window();		
////			newWindow.setName(url_parent +selectedItem.getText()) ;
//			QlgiangvienApplication.getInstance().setNewWindow(newWindow) ;					
				
		}//end of switch
		
    	return newWindow ;
    	
    }
  
	}
