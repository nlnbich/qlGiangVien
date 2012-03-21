package cit.group10.qlGiangvien.widgets;

import cit.group10.qlGiangvien.constants.Constants;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public class topPanel extends CustomComponent {

	
	private VerticalLayout mainLayout;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public topPanel() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		mainLayout.setWidth(Constants.WIDTH_MAX, Sizeable.UNITS_PIXELS) ;		
		mainLayout.setStyleName("topPanel") ;
		
//		mainLayout.set

		// TODO add user code here
	}


	private VerticalLayout buildMainLayout() {
		// common part: create layout
//		setStyle("topPanel") ;
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100px");
		mainLayout.setMargin(false);
		
		
		// top-level component properties
		setWidth("100%");
		setHeight("80px");
		
		return mainLayout;
	}

}
