package cit.group10.qlGiangvien.widgets;

import cit.group10.qlGiangvien.constants.Constants;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.terminal.Sizeable;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class infoUser extends CustomComponent {

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Embedded embedded_1;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private Label label_9;
	@AutoGenerated
	private Label label_8;
	@AutoGenerated
	private Label label_6;
	@AutoGenerated
	private Label label_7;
	@AutoGenerated
	private Label label_5;
	@AutoGenerated
	private Label label_4;
	@AutoGenerated
	private Label label_3;
	@AutoGenerated
	private Label label_2;
	@AutoGenerated
	private Label label_1;
	@AutoGenerated
	private Label lblTitle;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public infoUser() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
//		mainLayout.setWidth(Constants.RIGHT_MENU, Sizeable.UNITS_PIXELS);
		lblTitle.setContentMode(3) ;
		lblTitle.setValue("<h1>Thong Tin Giang Vien</h1>") ;
//		lblTitle.set
		label_1.setValue("Ho va Ten : Nguyen Van A") ;
		label_2.setValue("Ngay sinh : 10-10-1987") ;
		label_3.setValue("Que quan : Can Tho") ;
		label_4.setValue("Dan toc : Kinh") ;
		label_5.setValue("Ton giao : Khong") ;
		label_6.setValue("Dia chi : 3/2 thanh pho Can Tho") ;
		label_7.setValue("Ho va Ten : Nguyen Van A") ;
		label_8.setValue("Ho va Ten : Nguyen Van A") ;
		label_9.setValue("Ho va Ten : Nguyen Van A") ;
		

		// TODO add user code here
	}


	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
	
		
		// lblTitle
		lblTitle = new Label();		
		lblTitle.setImmediate(false);
		lblTitle.setWidth("-1px");
		lblTitle.setHeight("-1px");
		lblTitle.setValue("Label");
		mainLayout.addComponent(lblTitle);
		mainLayout.setComponentAlignment(lblTitle, Alignment.TOP_CENTER);
		
		// horizontalLayout_1
	
		
		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("-1px");
		label_1.setValue("Label");
		mainLayout.addComponent(label_1);
		
		// label_2
		label_2 = new Label();
		label_2.setImmediate(false);
		label_2.setWidth("-1px");
		label_2.setHeight("-1px");
		label_2.setValue("Label");
		mainLayout.addComponent(label_2);
		
		// label_3
		label_3 = new Label();
		label_3.setImmediate(false);
		label_3.setWidth("-1px");
		label_3.setHeight("-1px");
		label_3.setValue("Label");
		mainLayout.addComponent(label_3);
		
		// label_4
		label_4 = new Label();
		label_4.setImmediate(false);
		label_4.setWidth("-1px");
		label_4.setHeight("-1px");
		label_4.setValue("Label");
		mainLayout.addComponent(label_4);
		
		// label_5
		label_5 = new Label();
		label_5.setImmediate(false);
		label_5.setWidth("-1px");
		label_5.setHeight("-1px");
		label_5.setValue("Label");
		mainLayout.addComponent(label_5);
		
		// label_7
		label_7 = new Label();
		label_7.setImmediate(false);
		label_7.setWidth("-1px");
		label_7.setHeight("-1px");
		label_7.setValue("Label");
		mainLayout.addComponent(label_7);
		
		// label_6
		label_6 = new Label();
		label_6.setImmediate(false);
		label_6.setWidth("-1px");
		label_6.setHeight("-1px");
		label_6.setValue("Label");
		mainLayout.addComponent(label_6);
		
		// label_8
		label_8 = new Label();
		label_8.setImmediate(false);
		label_8.setWidth("-1px");
		label_8.setHeight("-1px");
		label_8.setValue("Label");
		mainLayout.addComponent(label_8);
		
		// label_9
		label_9 = new Label();
		label_9.setImmediate(false);
		label_9.setWidth("-1px");
		label_9.setHeight("-1px");
		label_9.setValue("Label");
		mainLayout.addComponent(label_9);
		
		return mainLayout;
	}

}
