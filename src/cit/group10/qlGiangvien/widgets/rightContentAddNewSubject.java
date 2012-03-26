package cit.group10.qlGiangvien.widgets;

import java.text.DateFormat;

import cit.group10.qlGiangvien.databaseConnect.GetDataFromDatabase;
import cit.group10.qlGiangvien.others.subWindow;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ConversionException;
import com.vaadin.data.Property.ReadOnlyException;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class rightContentAddNewSubject extends CustomComponent {
	
	private static final long serialVersionUID = 1L;

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private Button btThem;
	@AutoGenerated
	private Button btNhaplai;
	@AutoGenerated
	private TextArea txtNgiencuuphattrien;
	@AutoGenerated
	private TextArea txtGiangday;
	@AutoGenerated
	private TextArea txtNhansu;
	@AutoGenerated
	private TextArea txtLichsu;
	@AutoGenerated
	private TextField txtTenMB, txtMaBM;
	@AutoGenerated
	private Label label_1;
	
	private int func =0 ;// 0=insert //1= update
	
	
	public rightContentAddNewSubject(int function) {
		
		this.func = function ;
		
//		btThem.addListener(new Button.ClickListener() {		
//			
//			@Override
//			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
//
//				try{
////					getSubjectData() ;
////					getCongTac() ;
////					getHocVi() ;
////					getHocHam() ;
////					getDangNhap() ;
////					getNghienCuu() ;
//					
//										
//				}
//				catch(Exception e){ 
//					getWindow().showNotification("eer in click button") ;
//					System.out.println("rightContentAddNewTeacher:"+e.toString()) ;
//					}
//			}
//		});
		
		
		
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	//===============================
	void resetValue(){
		
		txtMaBM.setValue("") ;
		txtTenMB.setValue("") ;
		txtLichsu.setValue("") ;
		txtNhansu.setValue("") ;
		txtGiangday.setValue("") ;
		txtNgiencuuphattrien.setValue("") ;
		
	}
	
	private String getSubjectData(){
		
		try {
			String sql = "insert into BoMon values (";
			sql += "'"+ txtMaBM.getValue().toString()+ "' ,";
			sql += "'"+ txtTenMB.getValue().toString()+ "' ," ;
			sql += "'"+ txtLichsu.getValue().toString()+ "' ," ;
			sql += "'"+ txtNhansu.getValue().toString()+ "' ," ;
			sql += "'"+ txtGiangday.getValue().toString()+ "' ," ;
			sql += "'"+ txtNgiencuuphattrien.getValue().toString()+ "' );";
			System.out.println("cong tac : "+sql) ;
			return sql ;
		} catch (Exception e) {
			System.out.println("fightContentAddNewSubject >>getSubjectData :"+ e.toString()) ;
			e.printStackTrace();
			return "" ;
		}
	}
	private String getUpdateSubjectData(){
		String sql;
		try {
			sql = "update BoMon set ";			
		    sql += "TenBM='"+ txtTenMB.getValue().toString()+ "' ," ;
		    sql += "LichSu='"+ txtLichsu.getValue().toString()+ "' ," ;
		    sql += "NhanSu='"+ txtNhansu.getValue().toString()+ "' ," ;
		    sql += "GiangDay='"+ txtGiangday.getValue().toString()+ "'" ;
		    sql += "where MaBM='"+ txtMaBM.getValue().toString()+ "' ;";
//		    sql += "NghienCuuPhatTrien='"+ txtNgiencuuphattrien.getValue().toString()+ "' ,";
//		    sql += " where MaBM = '" + txtMaBM.getValue().toString() + "' ;" ; 
		    System.out.println("Bo mon : "+sql) ;
		    return sql ;
		}   catch (Exception e) {
			
			System.out.println("rightContentAddNewSubject: "+ e.toString()) ;
			return "" ;
		}
	}
		
	public void setUpdateValue(final Item item){
		
		try {
			System.out.println(item.toString()) ;
			txtMaBM.setValue(item.getItemProperty("MaBM").getValue().toString()) ;
			txtTenMB.setValue(item.getItemProperty("TenBM").getValue().toString()) ;
			txtLichsu.setValue(item.getItemProperty("LichSu").getValue().toString()) ;
			txtNhansu.setValue(item.getItemProperty("NhanSu").getValue().toString()) ;
			txtGiangday.setValue(item.getItemProperty("GiangDay").getValue().toString()) ;
			txtNgiencuuphattrien.setValue(item.getItemProperty("NghienCuuPhatTrien").getValue().toString()) ;
		} catch (ReadOnlyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConversionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("621px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("621px");
		
		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("-1px");
		if (func==0)	label_1.setValue("<h1> Thông tin bộ môn</h1>"); else label_1.setValue("<h1>Chinh Sua Thông tin bộ môn</h1>"); 
	
		label_1.setContentMode(3);
		mainLayout.addComponent(label_1);
		
		
		// txtTenMB
		txtMaBM = new TextField();
		txtMaBM.setCaption("Ma bộ môn");
		txtMaBM.setImmediate(false);
		txtMaBM.setWidth("380px");
		txtMaBM.setHeight("24px");		
		if (func==0) txtMaBM.setValue(GetDataFromDatabase.getMaBM()) ; else txtMaBM.setEnabled(false) ; 
		
		mainLayout.addComponent(txtMaBM);
		
		
		
		// txtTenMB
		txtTenMB = new TextField();
		txtTenMB.setCaption("Tên bộ môn");
		txtTenMB.setImmediate(false);
		txtTenMB.setWidth("380px");
		txtTenMB.setHeight("24px");		
		mainLayout.addComponent(txtTenMB);
		
		// txtLichsu
		txtLichsu = new TextArea();
		txtLichsu.setCaption("Lích sử phát triển");
		txtLichsu.setImmediate(false);
		txtLichsu.setWidth("520px");
		txtLichsu.setHeight("-1px");
		mainLayout.addComponent(txtLichsu);
		
		// txtNhansu
		txtNhansu = new TextArea();
		txtNhansu.setCaption("Nhân sự trong môn môn");
		txtNhansu.setImmediate(false);
		txtNhansu.setWidth("520px");
		txtNhansu.setHeight("-1px");
		mainLayout.addComponent(txtNhansu);
		
		// txtGiangday
		txtGiangday = new TextArea();
		txtGiangday.setCaption("Giảng dạy");
		txtGiangday.setImmediate(false);
		txtGiangday.setWidth("520px");
		txtGiangday.setHeight("-1px");
		mainLayout.addComponent(txtGiangday);
		
		// txtNgiencuuphattrien
		txtNgiencuuphattrien = new TextArea();
		txtNgiencuuphattrien.setCaption("Nghiên cứu phát triển");
		txtNgiencuuphattrien.setImmediate(false);
		txtNgiencuuphattrien.setWidth("520px");
		txtNgiencuuphattrien.setHeight("-1px");
		mainLayout.addComponent(txtNgiencuuphattrien);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		mainLayout.addComponent(horizontalLayout_1);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("481px");
		horizontalLayout_1.setHeight("43px");
		horizontalLayout_1.setMargin(false);
		
		// btNhaplai
		btNhaplai = new Button();
		btNhaplai.setCaption("Reset");
		btNhaplai.setImmediate(false);
		btNhaplai.setWidth("-1px");
		btNhaplai.setHeight("-1px");
		horizontalLayout_1.addComponent(btNhaplai);
		btNhaplai.addListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {

				resetValue() ;
			}
		}) ;
		
		
		
		// btThem
		btThem = new Button();
		if (func==0) btThem.setCaption("Thêm"); else btThem.setCaption("Chinh Sua"); 
		btThem.setImmediate(false);
		btThem.setWidth("-1px");
		btThem.setHeight("-1px");
		horizontalLayout_1.addComponent(btThem);
		btThem.addListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				getWindow().showNotification("click") ;
				
				boolean re ;
				
				if (func==0) re=GetDataFromDatabase.executeSqlStatement(getSubjectData()) ;
				else  re=GetDataFromDatabase.executeSqlStatement(getUpdateSubjectData()) ;
//				GetDataFromDatabase.executeSqlStatement(getSubjectData()) ;
				
				
				String content = re ? "thanh cong" : "that bai" ;
				if (re) resetValue() ;
				
				Window subwindow = subWindow.confirmDelete("Xac nhan", content, "Ok") ;
				if (subwindow.getParent() == null) {
		            
		            getWindow().addWindow(subwindow);
		        }
				
				
				
				
				
			}
		}) ;
		
		
		
		return horizontalLayout_1;
	}

}
