package cit.group10.qlGiangvien.widgets;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import cit.group10.qlGiangvien.constants.Constants;
import cit.group10.qlGiangvien.databaseConnect.GetDataFromDatabase;
import cit.group10.qlGiangvien.detailedInfo.*;
import cit.group10.qlGiangvien.others.subWindow;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window;

public class rightContentRegistedResearching extends CustomComponent implements Constants {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private Button btnApply, btnReset;
	@AutoGenerated
	private TextArea txtContent;
	
	@AutoGenerated
	private ComboBox comboBoxCap;
	@AutoGenerated
	private PopupDateField txtNgayKT;
	@AutoGenerated
	private PopupDateField txtNgayBD;
	@AutoGenerated
	private TextArea txtName;
	@AutoGenerated
	private Label lblTitle;
	
	private TextField txtMaDeTaiNC;
	private int func =0 ;// 0=insert //1= update

	
	
	public rightContentRegistedResearching(int function) {
		
		this.func = function ;
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		
		btnApply.addListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
//				beans.addBean(new TeacherBean()) ;
				boolean re ;
				if (func ==0 ) re = GetDataFromDatabase.executeSqlStatement(getDataNC()) ;
				else re = GetDataFromDatabase.executeSqlStatement(getUpdateDataNC() );
				
				String content = re ? "thanh cong" : "that bai" ;
				
				Window subwindow = subWindow.confirmDelete("Xac nhan", content, "Ok") ;
				if (subwindow.getParent() == null) {
                    
                    getWindow().addWindow(subwindow);
                }
				
			}
		});
		
		btnReset.addListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
//				beans.addBean(new TeacherBean()) ;
				resetDataNC() ;
				
			}
		});
		
		
		
		
		
	}
	
	//=============================RESET AND GET DATA
	
	private void resetDataNC(){
		
		txtMaDeTaiNC.setValue(null);
		txtName.setValue(null);
		txtNgayKT.setValue(null);
		txtNgayBD.setValue(null);
		txtContent.setValue(null);
		comboBoxCap.select(S_PHAMVI[0]);
		
		
	}
	
	private String getDataNC(){
		
		String sql;
		try {
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			sql = "insert into NghienCuuKH values (";
			sql += "'" + txtMaDeTaiNC.getValue().toString() + "' ," ;
			sql += "'" + txtName.getValue().toString() + "',";
			sql += "'" + comboBoxCap.getValue().toString() + "' ," ;
			sql +=  "'" +  txtContent.getValue().toString() + "',";
			
			try {
				sql += " ' " + dateFormatter.format(txtNgayBD.getValue()) + " ', ";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				sql += "null" + ",";
			}			
			
			try {
				sql +=" ' " + dateFormatter.format(txtNgayKT.getValue())  ;
			} catch (Exception e) {
				sql += "null" ;
			}
			
			
			sql += "); " ;
			
			
			
			
			System.out.println(sql) ;
			return sql ;
		} catch (Exception e) {
			
			System.out.println("rightContentRegistedResearching: "+ e.toString()) ;
			return "" ;
		}
	}//end of getDataNoiDung
	
	private String getUpdateDataNC(){
		
		String sql;
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		try {
			
			sql = "update NghienCuuKH set ";
			
//			sql += ;
			sql += "TenCTNC='" + txtName.getValue().toString() + "',";
			sql += "LoaiCTNC='" + comboBoxCap.getValue().toString() + "' ," ;
			sql +=  "NoiDungTH='" +  txtContent.getValue().toString() + "',";
			
			try {
				sql += "NgayBT='" + dateFormatter.format(txtNgayBD.getValue()) + "', ";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				sql += "NgayBT=" + null + ",";
			}			
			
			try {
				sql +="NgayKT= '" + dateFormatter.format(txtNgayKT.getValue()) +"' " ;
			} catch (Exception e) {
				sql += "NgayKT="+"null" ;
			}
			
			
			sql += " where MaCTNC = '" + txtMaDeTaiNC.getValue().toString() + "' ;" ; 
			
			
			
			
			System.out.println(sql) ;
			return sql ;
		} catch (Exception e) {
			
			System.out.println("rightContentRegistedResearching: "+ e.toString()) ;
			return "" ;
		}
	}//end of getDataNoiDung
	
	
	
	
	
	public void setUpdateValue(final Item item){
		
		try{
		System.out.println(item.toString()) ;
		txtMaDeTaiNC.setValue(item.getItemProperty("MaCTNC").getValue().toString()) ;//.item.getItemProperty("MaNCKH").getValue().toString() ;		
		txtName.setValue(item.getItemProperty("TenCTNC").getValue().toString());
//		txtNgayKT.setValue(item.getItemProperty("NgayKT").getValue().toString());
//		txtNgayBD.setValue(item.getItemProperty("NgayBD").getValue().toString());
		txtNgayKT.setValue("1999-12-12");
		txtContent.setValue(item.getItemProperty("NoiDungTH").getValue().toString());
		comboBoxCap.select(item.getItemProperty("LoaiCTNC").getValue().toString());
		}
		catch(Exception e){
			System.out.println("rightContentRegistedResearching :"+ e.toString()) ;
		}
		
		
//		System.out.print() ;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("632px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("632px");
		
		// lblTitle
		lblTitle = new Label();
		lblTitle.setImmediate(false);
		lblTitle.setWidth("-1px");
		lblTitle.setHeight("-1px");
		if (func==0) lblTitle.setValue("<center><h1>Dang ky de tai nghien cuu</h1></center>");
		else lblTitle.setValue("<center><h1>Chinh sua thong tin de tai nghien cuu</h1></center>");
		lblTitle.setContentMode(3);
		mainLayout.addComponent(lblTitle);
		
		
		//txtMaDeTaiNC
		txtMaDeTaiNC= new TextField();
		
		if (func==1) txtMaDeTaiNC.setEnabled(false) ; else txtMaDeTaiNC.setValue(GetDataFromDatabase.getMaCTNC()) ;
		txtMaDeTaiNC.setCaption("Ma de tai");
		txtMaDeTaiNC.setImmediate(false);
		txtMaDeTaiNC.setWidth("100.0%");
		txtMaDeTaiNC.setHeight("-1px");
		mainLayout.addComponent(txtMaDeTaiNC);
		
		
		
		// txtName
		txtName = new TextArea();
		txtName.setCaption("Ten de tai");
		txtName.setImmediate(false);
		txtName.setWidth("100.0%");
		txtName.setHeight("65px");
		mainLayout.addComponent(txtName);
		
		// popupDateStartedDay
		txtNgayBD = new PopupDateField();
		txtNgayBD.setCaption("Ngay Bat Dau :");
		txtNgayBD.setImmediate(false);
		txtNgayBD.setWidth("300px");
		txtNgayBD.setHeight("-1px");
		txtNgayBD.setInvalidAllowed(false);
		txtNgayBD.setValue(new java.util.Date());
//		txtNgayKT.setDateFormat("yyyy-MM-dd");
//		txtNgayBD.addListener(this);
		mainLayout.addComponent(txtNgayBD);
		
		
		
		
		// popupDateEndedDay
		txtNgayKT = new PopupDateField();
		txtNgayKT.setCaption("Ngay Ket Thuc :");
		txtNgayKT.setImmediate(false);
		txtNgayKT.setWidth("300px");
		txtNgayKT.setHeight("-1px");
		txtNgayKT.setInvalidAllowed(false);
//		txtNgayKT.setDateFormat(dateFormat)
//		txtNgayKT.setDateFormat("yyyy-MM-dd");
		mainLayout.addComponent(txtNgayKT);
		
		
		// comboBoxStatus
		comboBoxCap = new ComboBox("Pham Vi :", LIST_PHAMVI);
		comboBoxCap.select(S_PHAMVI[0]) ;
//		comboBoxCap.setCaption("Status :");
		comboBoxCap.setImmediate(false);
		comboBoxCap.setWidth("300px");
		comboBoxCap.setHeight("-1px");
		mainLayout.addComponent(comboBoxCap);
		
		
		// txtContent
		txtContent = new TextArea();
		txtContent.setCaption("Noi dung thuc hien");
		txtContent.setImmediate(false);
		txtContent.setWidth("100.0%");
		txtContent.setHeight("-1px");
		mainLayout.addComponent(txtContent);
		
		// btnApply
		btnApply = new Button();
		if (func ==0) btnApply.setCaption("Them De Tai");
		else btnApply.setCaption("Cap Nhat Thong Tin");
		btnApply.setImmediate(true);
		btnApply.setWidth("100px");
		btnApply.setHeight("-1px");
		mainLayout.addComponent(btnApply);
		
		
		//btnReset
		btnReset = new Button();
		btnReset.setCaption("Reset");
		btnReset.setImmediate(true);
		btnReset.setWidth("100px");
		btnReset.setHeight("-1px");
		mainLayout.addComponent(btnReset);
		
		return mainLayout;
	}


	

}
