package cit.group10.qlGiangvien.widgets;

import java.text.DateFormat;

import cit.group10.qlGiangvien.constants.cTeacherInfo;
import cit.group10.qlGiangvien.databaseConnect.GetDataFromDatabase;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Select;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.VerticalLayout;

public class rightContentAddNewTeacher extends CustomComponent implements cTeacherInfo {

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private TabSheet tabSheet_2;
	@AutoGenerated
	private VerticalLayout tabsheetNghienCuuKH;
	@AutoGenerated
	private Button button_1;
	@AutoGenerated
	private TwinColSelect twinColSelect_1;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_1;
	@AutoGenerated
	private PopupDateField txtNghienCuuNgayKT;
	@AutoGenerated
	private PopupDateField txtNghienCuuNgayThamGia;
	@AutoGenerated
	private VerticalLayout tabsheetAccount;
	@AutoGenerated
	private Button btnDangNhapReset;
	@AutoGenerated
	private PasswordField txtPassword;
	@AutoGenerated
	private TextField txtUserName;
	@AutoGenerated
	private VerticalLayout tabsheetHocHamHocVi;
	@AutoGenerated
	private TabSheet tabSheet_1;
	@AutoGenerated
	private VerticalLayout verticalLayoutHocHam;
	@AutoGenerated
	private Button btnHocHamReset;
	@AutoGenerated
	private PopupDateField txtHocHamNgayDatDuoc;
	@AutoGenerated
	private ComboBox txtTenHocHam;
	@AutoGenerated
	private VerticalLayout verticalLayoutHocVi;
	@AutoGenerated
	private Button btnHocViReset;
	@AutoGenerated
	private TextArea txtHocViDiaChiTruong;
	@AutoGenerated
	private PopupDateField txtHocViNgayKT;
	@AutoGenerated
	private PopupDateField txtHocViNgayBD;
	@AutoGenerated
	private TextField txtTenTruong;
	@AutoGenerated
	private ComboBox txtHocViTen;
	@AutoGenerated
	private VerticalLayout tabsheetCongTac;
	@AutoGenerated
	private Button btnCongTacReset;
	@AutoGenerated
	private VerticalLayout verticalLayoutBoMon;
	@AutoGenerated
	private PopupDateField txtBoMonNgayKT;
	@AutoGenerated
	private PopupDateField txtBoMonNgayBD;
	@AutoGenerated
	private ComboBox txtChucVu;
	@AutoGenerated
	private ComboBox txtBoMon;
	@AutoGenerated
	private ComboBox txtBacLuong;
	@AutoGenerated
	private TextField txtHeSoLuong;
	@AutoGenerated
	private PopupDateField txtCongTacNgayBD;
	@AutoGenerated
	private VerticalLayout tabsheetCoBan;
	@AutoGenerated
	private Button btnThongTInReset;
	@AutoGenerated
	private TextArea txtGhiChu;
	@AutoGenerated
	private TextArea txtDiaChi;
	@AutoGenerated
	private TextField txtThongTinEmail;
	@AutoGenerated
	private TextField txtDienThoai;
	@AutoGenerated
	private PopupDateField txtNgaySinh;
	@AutoGenerated
	private OptionGroup txtGioiTinh;
	@AutoGenerated
	private TextField txtHoTen;
	@AutoGenerated
	private TextField txtMaGV;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Button btnResetAll;
	@AutoGenerated
	private Button btnAdd;
	@AutoGenerated
	private Label label_1;

	
//	Form form ;
	private int func =0 ;
	
	
		public rightContentAddNewTeacher(int function) {
		this.func =function ;
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		
		btnAdd.addListener(new Button.ClickListener() {			
			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {

				try{
					
					if (func==0) getInfo() ;// else 
//						updateInfo() ;
									
				}
				catch(Exception e){ 
					getWindow().showNotification("eer in click button") ;
					System.out.println("rightContentAddNewTeacher:"+e.toString()) ;
					}
			}
		});
		
		
	}
	//===================================================RESET DATA
	private void resetCoBan(){
		
		txtMaGV.setValue(null) ;
		txtHoTen.setValue(null) ;
		txtGioiTinh.select(S_GENDER[0]) ;
		txtNgaySinh.setValue(null) ;
		txtDienThoai.setValue(null) ;
		txtThongTinEmail.setValue(null) ;
		txtDiaChi.setValue(null) ;
		txtGhiChu.setValue(null) ;
	}
	
	private void resetCongTac(){
		
		txtCongTacNgayBD.setValue(null) ;
		txtHeSoLuong.setValue(null) ;
		txtBacLuong.select(S_BACLUONG[0]) ;
//		txtBoMon
		txtChucVu.select(S_CHUCVU[0]) ;
		txtBoMonNgayBD.setValue(null) ;
		txtBoMonNgayKT.setValue(null) ;
	}
	
	private void resetHocVi(){
		
		txtHocViTen.select(S_HOCVI[0]) ;
		txtTenTruong.setValue(null) ;
		txtHocViNgayBD.setValue(null) ;
		txtHocViNgayKT.setValue(null) ;
		txtHocViDiaChiTruong.setValue(null) ;
		
	}
	
	private void resetHocHam(){
		
		txtTenHocHam.select(S_HOCHAM[0]) ;
		txtHocHamNgayDatDuoc.setValue(null) ;
		
	}
	
	private void resetDangNhap(){
		
		txtUserName.setValue(null) ;
		txtPassword.setValue(null) ;
	}
	
//	private void resetNghienCuu(){
//		
////		twinColSelect_1
//		txtNghienCuuNgayThamGia.setValue(null) ;
//		txtNghienCuuNgayKT.setValue(null) ;
//	}
	
	
	//===================================================get DATA
	private void getInfo(){
		
		getCoBan();		
		getCongTac();
		getGV_BoMon() ;
//		getHocVi();
//		getHocHam();
//		getDangNhap();
//		getNghienCuu();
		
		
	}
	
	private void updateInfo(){
		
		getUpdateCoBan() ;
		getUpdateCongTac() ;
		getUpdateHocVi() ;
		getUpdateHocHam() ;
		getUpdateDangNhap() ;
		getUpdateNghienCuu() ;

	}
	
	
	private String getCoBan(){
		
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		String sql = "insert into GiangVien values (";
		
		sql += "'" + txtMaGV.getValue().toString() + "' ,";
		sql += "'" + txtHoTen.getValue().toString()  + "' ," ;
		sql += "'" + txtGioiTinh.getValue().toString() + "' ," ;
		
		
		try {
			sql += " '" + dateFormatter.format(txtNgaySinh.getValue()) + "', ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sql += "null" + ",";
		}
				
		sql += "'" + txtDienThoai.getValue().toString() + "' ," ;
		sql += "'" + txtThongTinEmail.getValue().toString() + "' ," ;
		sql += "'" + txtDiaChi.getValue().toString() + "' ,";
		sql += "'" + txtGhiChu.getValue() + "'," ;
		sql += GetDataFromDatabase.getMaQTCT() + ");" ;
		System.out.println("Co ban : "+sql) ;
		return sql ;
	}
	
	private String getUpdateCoBan() {

		String sql;
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		try {

			sql = "update GiangVien set ";

			sql += "MaGV='" + txtMaGV.getValue().toString() + "' ,";
			sql += "HoTen='" + txtHoTen.getValue().toString() + "' ,";
			sql += "GioiTinh='" + txtGioiTinh.getValue().toString() + "' ,";

			try {
				sql += "NgaySinh='"
						+ dateFormatter.format(txtNgaySinh.getValue()) + "', ";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				sql += "NgaySinh" + null + ",";
			}

			sql += "DienThoai='" + txtDienThoai.getValue().toString() + "' ,";
			sql += "Email='" + txtThongTinEmail.getValue().toString() + "' ,";
			sql += "DiaChi='" + txtDiaChi.getValue().toString() + "' ,";
			sql += "GhiChu='" + txtGhiChu.getValue() + "',1 ,1);";

			sql += " where MaGV = '" + txtMaGV.getValue().toString() + "' ;";
			System.out.println(sql);
			return sql;
		} catch (Exception e) {

			System.out.println("rightContentAddNewTeacher: " + e.toString());
			return "";
		}
	}

	private String getCongTac() {

		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		String sql = "insert into QuaTrinhCongTac values (";
		
		sql += GetDataFromDatabase.getMaQTCT() + ",";
		
		
		sql +=  txtHeSoLuong.getValue().toString() + ",";
		sql +=  txtBacLuong.getValue().toString() +  ",";
		try {
			sql += " '" + dateFormatter.format(txtCongTacNgayBD.getValue()) + "' ) ;";
		} catch (Exception e) {
		
			sql += "null" + ") ;";
		}
		
		
		System.out.println("cong tac : " + sql);
		return sql ;
	}
	
	
	private String getGV_BoMon() {

		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		
		String sql = "insert into GiaoVien_BoMon values (";
		
		sql += GetDataFromDatabase.getMaCV() + ",";
		sql += "'" + txtBoMon.getValue().toString() + "' ,";
		sql += "'" + txtMaGV.getValue().toString() + "' ,";
		sql += "'" + txtChucVu.getValue().toString() + "' ,";
		try {
			sql += " '" + dateFormatter.format(txtBoMonNgayBD.getValue()) + "' ,";
		} catch (Exception e) {
		
			sql += "null" + ",";
		}
		try {
			sql += " '" + dateFormatter.format(txtBoMonNgayKT.getValue()) + "' ) ;";
		} catch (Exception e) {
		
			sql += "null" + ");";
		}		
		System.out.println("cong tac : " + sql);
		return sql ;
	}
	
	
	

	private String getUpdateCongTac() {
		String sql1;
		DateFormat dateFormatter1 = DateFormat
				.getDateInstance(DateFormat.SHORT);

		sql1 = "update QuaTrinhCongTac set ";

		sql1 += "HSLuong='" + txtHeSoLuong.getValue().toString() + "' ,";
		sql1 += "Bac='" + txtBacLuong.getValue().toString() + "' ,";

		try {
			sql1 += "NgayBD='"
					+ dateFormatter1.format(txtCongTacNgayBD.getValue())
					+ "', ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sql1 += "NgayBD" + null + ",";
		}
		System.out.println("cong tac : " + sql1);
		// return sql1 ;
		// txtBoMon
		String sql2;
		DateFormat dateFormatter2 = DateFormat
				.getDateInstance(DateFormat.SHORT);

		sql2 = "update GiangVien_BoMon set ";

		sql2 += "TenCV='" + txtChucVu.getValue().toString() + "' ,";
		try {
			sql2 += "NgayBD='"
					+ dateFormatter2.format(txtBoMonNgayBD.getValue()) + "', ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sql2 += "NgayBD" + null + ",";
		}
		try {
			sql1 += "NgayKT='"
					+ dateFormatter2.format(txtBoMonNgayKT.getValue()) + "', ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sql2 += "NgayKT" + null + ",";
		}
		System.out.println("cong tac : " + sql2);
		return sql1 + sql2;
	}

	private String getHocVi() {

		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		String sql = "insert into GiangVien_HocVi values(MaGV, TenHocVi, ) (";

		sql += GetDataFromDatabase.getMaGV_HV() + ",";
		sql += "'" + txtMaGV.getValue().toString() + "' ,";
		sql += "'" + txtHocViTen.getValue().toString() + "' ,";
		sql += "'" + txtTenTruong.getValue().toString() + "' ,";
		sql += "'" + txtHocViDiaChiTruong.getValue().toString() + "' ,";

		try {
			sql += " ' " + dateFormatter.format(txtHocViNgayBD.getValue())
					+ " ', ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sql += "null" + ",";
		}

		try {
			sql += " ' " + dateFormatter.format(txtHocViNgayKT.getValue())
					+ " ' );";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sql += "null" + ");";
		}
		
		System.out.println("Hoc vi : " + sql);
		return sql;

	}

	private String getUpdateHocVi() {

		String sql;
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		try {

			sql = "update GiangVien_HocVi set ";

			sql += "TenHocVi='" + txtHocViTen.getValue().toString() + "' ,";
			sql += "TenTruongDT='" + txtTenTruong.getValue().toString() + "' ,";

			try {
				sql += "ThoiGianBD=' "
						+ dateFormatter.format(txtHocViNgayBD.getValue())
						+ " ', ";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				sql += "ThoiGianBD=" + null + ",";
			}

			try {
				sql += "ThoiGianKT=' "
						+ dateFormatter.format(txtHocViNgayKT.getValue())
						+ " ', ";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				sql += "ThoiGianKT" + null + ",";
			}
			sql += "DiaChiTruongDT='"
					+ txtHocViDiaChiTruong.getValue().toString() + "' ,";
			System.out.println("Hoc vi : " + sql);
			return sql;
		} catch (Exception e) {

			System.out.println("rightContentAddNewTeacher: " + e.toString());
			return "";
		}
	}

	//
	private String getHocHam() {
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		String sql = "insert into GiangVien_HocHam values (";

		sql += "'" + txtTenHocHam.getValue().toString() + "' ,";

		try {
			sql += " ' "
					+ dateFormatter.format(txtHocHamNgayDatDuoc.getValue())
					+ " ', ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sql += "null" + ",";
		}

		System.out.println("Hoc ham : " + sql);
		return sql;

	}

	private String getUpdateHocHam() {

		String sql;
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		try {

			sql = "update GiangVien_HocHam set ";

			sql += "TenHocHam='" + txtTenHocHam.getValue().toString() + "' ,";

			try {
				sql += "TGDat=' "
						+ dateFormatter.format(txtHocHamNgayDatDuoc.getValue())
						+ " ', ";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				sql += "null" + ",";
			}

			System.out.println("Hoc ham : " + sql);
			return sql;
		} catch (Exception e) {

			System.out.println("rightContentAddNewTeacher: " + e.toString());
			return "";
		}
	}

	//
	private String getDangNhap() {

		String sql = "insert into Account values (";

		sql += "'" + txtUserName.getValue().toString() + "' ,";
		sql += "'" + txtPassword.getValue().toString() + "' ,";
		System.out.println("Dang nhap : " + sql);
		return sql;
	}

	private String getUpdateDangNhap() {

		String sql;
		sql = "update Account set ";
		try {

			sql += "username='" + txtUserName.getValue().toString() + "' ,";
			sql += "password='" + txtPassword.getValue().toString() + "' ,";
			System.out.println("Dang nhap : " + sql);
			return sql;
		} catch (Exception e) {
			System.out.println("rightContentAddNewTeacher: " + e.toString());
			return "";
		}
	}

	//
	private String getNghienCuu() {
		//
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		String sql = "insert into GiangVien_NghienCuuKH values (";
		try {
			sql += "' "
					+ dateFormatter.format(txtNghienCuuNgayThamGia.getValue())
					+ " ', ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sql += "null" + ",";
		}
		try {
			sql += " ' " + dateFormatter.format(txtNghienCuuNgayKT.getValue())
					+ " ', ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sql += "null" + ",";
		}
		System.out.println("Nghien cuu : " + sql);
		return sql;
	}

	private String getUpdateNghienCuu() {
		//
		String sql;
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		try {

			sql = "update GiangVien_NghienCuuKH set ";
			try {
				sql += "NgayTG=' "
						+ dateFormatter.format(txtNghienCuuNgayThamGia
								.getValue()) + " ', ";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				sql += "null" + ",";
			}
			try {
				sql += "NgayKT=' "
						+ dateFormatter.format(txtNghienCuuNgayKT.getValue())
						+ " ', ";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				sql += "null" + ",";
			}
			System.out.println("Nghien cuu : " + sql);
			return sql;
		} catch (Exception e) {

			System.out.println("rightContentAddNewTeacher: " + e.toString());
			return "";
		}
	}

	
	//===================================================for build interface

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("-1px");
		
		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("100.0%");
		label_1.setHeight("50px");
		
		if (func==0) label_1.setValue("<h1> Them Thong Tin Giang Vien</h1>");
		else label_1.setValue("<h1> Chinh Sua Thong Tin Giang Vien</h1>");
		
		label_1.setContentMode(3);
		mainLayout.addComponent(label_1);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		mainLayout.addComponent(horizontalLayout_2);
		
		// tabSheet_2
		tabSheet_2 = buildTabSheet_2();
		mainLayout.addComponent(tabSheet_2);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("100.0%");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(true);
		
		// btnAdd
		btnAdd = new Button();
		btnAdd.setCaption("Them Giang Vien");
		btnAdd.setImmediate(true);
		btnAdd.setWidth("-1px");
		btnAdd.setHeight("-1px");
		horizontalLayout_2.addComponent(btnAdd);
		
		// btnResetAll
		btnResetAll = new Button();
		btnResetAll.setCaption("Reset All");
		btnResetAll.setImmediate(true);
		btnResetAll.setWidth("-1px");
		btnResetAll.setHeight("-1px");
		horizontalLayout_2.addComponent(btnResetAll);
		
		return horizontalLayout_2;
	}

	@AutoGenerated
	private TabSheet buildTabSheet_2() {
		// common part: create layout
		tabSheet_2 = new TabSheet();
		tabSheet_2.setImmediate(true);
		tabSheet_2.setWidth("100.0%");
		tabSheet_2.setHeight("-1px");
		
		// tabsheetCoBan
		tabsheetCoBan = buildTabsheetCoBan();
		tabSheet_2.addTab(tabsheetCoBan, "*Thong tin co ban", null);
		
		// tabsheetCongTac
		tabsheetCongTac = buildTabsheetCongTac();
		tabSheet_2.addTab(tabsheetCongTac, "*Thong tin cong tac ", null);
		
		// tabsheetHocHamHocVi
		tabsheetHocHamHocVi = buildTabsheetHocHamHocVi();
		tabSheet_2.addTab(tabsheetHocHamHocVi, "*Hoc Ham, Hoc Vi", null);
		
		// tabsheetAccount
		tabsheetAccount = buildTabsheetAccount();
		tabSheet_2.addTab(tabsheetAccount, "*Thong tin dang nhap", null);
		
		// tabsheetNghienCuuKH
		tabsheetNghienCuuKH = buildTabsheetNghienCuuKH();
		tabSheet_2.addTab(tabsheetNghienCuuKH, "Nghien Cuu Khoa Hoc", null);
		
		return tabSheet_2;
	}

	@AutoGenerated
	private VerticalLayout buildTabsheetCoBan() {
		// common part: create layout
		tabsheetCoBan = new VerticalLayout();
		tabsheetCoBan.setImmediate(false);
		tabsheetCoBan.setWidth("100.0%");
		tabsheetCoBan.setHeight("-1px");
		tabsheetCoBan.setMargin(true);
		tabsheetCoBan.setSpacing(true);
		
		// txtMaGV
		txtMaGV = new TextField();
		txtMaGV.setCaption("Ma Giang Vien:");
		txtMaGV.setImmediate(false);
		txtMaGV.setWidth("481px");
		txtMaGV.setHeight("-1px");
		if (func==0) txtMaGV.setValue(GetDataFromDatabase.getMaGV()) ; 
		tabsheetCoBan.addComponent(txtMaGV);
		
		// txtHoTen
		txtHoTen = new TextField();
		txtHoTen.setCaption("Ho Ten :");
		txtHoTen.setImmediate(false);
		txtHoTen.setWidth("481px");
		txtHoTen.setHeight("-1px");
		txtHoTen.setSecret(false);
		tabsheetCoBan.addComponent(txtHoTen);
		
		
				
		
		// txtGioiTinh
		txtGioiTinh = new OptionGroup("Gioi Tinh :", LIST_GENDER);
		txtGioiTinh.select(S_GENDER[0]) ;
		txtGioiTinh.setImmediate(false);
		txtGioiTinh.setWidth("-1px");
		txtGioiTinh.setHeight("-1px");
		tabsheetCoBan.addComponent(txtGioiTinh);
		
		// txtNgaySinh
		txtNgaySinh = new PopupDateField();
		txtNgaySinh.setImmediate(false);
		txtNgaySinh.setWidth("481px");
		txtNgaySinh.setHeight("-1px");
		txtNgaySinh.setInvalidAllowed(false);
		tabsheetCoBan.addComponent(txtNgaySinh);
		
		// txtDienThoai
		txtDienThoai = new TextField();
		txtDienThoai.setCaption("Dien Thoai :");
		txtDienThoai.setImmediate(false);
		txtDienThoai.setWidth("481px");
		txtDienThoai.setHeight("-1px");
		txtDienThoai.setSecret(false);
		tabsheetCoBan.addComponent(txtDienThoai);
		
		// txtThongTinEmail
		txtThongTinEmail = new TextField();
		txtThongTinEmail.setCaption("Email :");
		txtThongTinEmail.setImmediate(false);
		txtThongTinEmail.setWidth("481px");
		txtThongTinEmail.setHeight("-1px");
		txtThongTinEmail.setSecret(false);
		tabsheetCoBan.addComponent(txtThongTinEmail);
		
		// txtDiaChi
		txtDiaChi = new TextArea();
		txtDiaChi.setCaption("Dia Chi :");
		txtDiaChi.setImmediate(false);
		txtDiaChi.setWidth("481px");
		txtDiaChi.setHeight("-1px");
		tabsheetCoBan.addComponent(txtDiaChi);
		
		// txtGhiChu
		txtGhiChu = new TextArea();
		txtGhiChu.setCaption("Ghi Chu :");
		txtGhiChu.setImmediate(false);
		txtGhiChu.setWidth("481px");
		txtGhiChu.setHeight("-1px");
		tabsheetCoBan.addComponent(txtGhiChu);
		
		// btnThongTInReset
		btnThongTInReset = new Button();
		btnThongTInReset.setCaption("Reset");
		btnThongTInReset.setImmediate(true);
		btnThongTInReset.setWidth("-1px");
		btnThongTInReset.setHeight("-1px");
		tabsheetCoBan.addComponent(btnThongTInReset);
		
		return tabsheetCoBan;
	}

	@AutoGenerated
	private VerticalLayout buildTabsheetCongTac() {
		// common part: create layout
		tabsheetCongTac = new VerticalLayout();
		tabsheetCongTac.setImmediate(false);
		tabsheetCongTac.setWidth("100.0%");
		tabsheetCongTac.setHeight("-1px");
		tabsheetCongTac.setMargin(true);
		tabsheetCongTac.setSpacing(true);
		
		// txtCongTacNgayBD
		txtCongTacNgayBD = new PopupDateField();
		txtCongTacNgayBD.setCaption("Thoi Diem Tham Gia Cong Tac :");
		txtCongTacNgayBD.setImmediate(false);
		txtCongTacNgayBD.setWidth("499px");
		txtCongTacNgayBD.setHeight("-1px");
		txtCongTacNgayBD.setInvalidAllowed(false);
		txtCongTacNgayBD.setRequired(true);
		tabsheetCongTac.addComponent(txtCongTacNgayBD);
		
		// txtHeSoLuong
		txtHeSoLuong = new TextField();
		txtHeSoLuong.setCaption("He So Luong :");
		txtHeSoLuong.setImmediate(false);
		txtHeSoLuong.setWidth("499px");
		txtHeSoLuong.setHeight("-1px");
		txtHeSoLuong.setRequired(true);
		txtHeSoLuong.setSecret(false);
		tabsheetCongTac.addComponent(txtHeSoLuong);
		
		// txtBacLuong
		txtBacLuong = new ComboBox("Bac Luong", LIST_BACLUONG);
		txtBacLuong.select(S_BACLUONG[0]) ;
//		txtBacLuong.setCaption("Bac Luong :");
		txtBacLuong.setImmediate(false);
		txtBacLuong.setWidth("499px");
		txtBacLuong.setHeight("-1px");
		tabsheetCongTac.addComponent(txtBacLuong);
		
		// verticalLayoutBoMon
		verticalLayoutBoMon = buildVerticalLayoutBoMon();
		tabsheetCongTac.addComponent(verticalLayoutBoMon);
		
		// btnCongTacReset
		btnCongTacReset = new Button();
		btnCongTacReset.setCaption("Reset");
		btnCongTacReset.setImmediate(true);
		btnCongTacReset.setWidth("-1px");
		btnCongTacReset.setHeight("-1px");
		tabsheetCongTac.addComponent(btnCongTacReset);
		
		return tabsheetCongTac;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayoutBoMon() {
		// common part: create layout
		verticalLayoutBoMon = new VerticalLayout();
		verticalLayoutBoMon.setImmediate(false);
		verticalLayoutBoMon.setWidth("-1px");
		verticalLayoutBoMon.setHeight("-1px");
		verticalLayoutBoMon.setMargin(false);
		
		// txtBoMon
		txtBoMon = new ComboBox("Bo Mon Cong Tac :",GetDataFromDatabase.getBoMon());
		txtBoMon.setItemCaptionPropertyId("TenMH");
		txtBoMon.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);

		
		
		
		
//		txtBoMon.setCaption("Bo Mon Cong Tac :" );
		txtBoMon.setImmediate(false);
		txtBoMon.setWidth("499px");
		txtBoMon.setHeight("-1px");
		txtBoMon.setRequired(true);
//		txtBoMon.setContainerDataSource(GetDataFromDatabase.getBoMon()) ;
		verticalLayoutBoMon.addComponent(txtBoMon);
		
		// txtChucVu
		txtChucVu = new ComboBox("Chuc Vu :", LIST_CHUCVU);
		txtChucVu.select(S_CHUCVU[0]) ;
//		txtChucVu.setCaption("Chuc Vu :");
		txtChucVu.setImmediate(false);
		txtChucVu.setWidth("499px");
		txtChucVu.setHeight("-1px");
		txtChucVu.setRequired(true);
		verticalLayoutBoMon.addComponent(txtChucVu);
		
		// txtBoMonNgayBD
		txtBoMonNgayBD = new PopupDateField();
		txtBoMonNgayBD.setCaption("Ngay bat dau :");
		txtBoMonNgayBD.setImmediate(false);
		txtBoMonNgayBD.setWidth("499px");
		txtBoMonNgayBD.setHeight("-1px");
		txtBoMonNgayBD.setInvalidAllowed(false);
		txtBoMonNgayBD.setRequired(true);
		verticalLayoutBoMon.addComponent(txtBoMonNgayBD);
		
		// txtBoMonNgayKT
		txtBoMonNgayKT = new PopupDateField();
		txtBoMonNgayKT.setCaption("Ngay Ket thuc :");
		txtBoMonNgayKT.setImmediate(false);
		txtBoMonNgayKT.setWidth("499px");
		txtBoMonNgayKT.setHeight("-1px");
		txtBoMonNgayKT.setInvalidAllowed(false);
		verticalLayoutBoMon.addComponent(txtBoMonNgayKT);
		
		return verticalLayoutBoMon;
	}

	@AutoGenerated
	private VerticalLayout buildTabsheetHocHamHocVi() {
		// common part: create layout
		tabsheetHocHamHocVi = new VerticalLayout();
		tabsheetHocHamHocVi.setImmediate(false);
		tabsheetHocHamHocVi.setWidth("100.0%");
		tabsheetHocHamHocVi.setHeight("100.0%");
		tabsheetHocHamHocVi.setMargin(true);
		tabsheetHocHamHocVi.setSpacing(true);
		
		// tabSheet_1
		tabSheet_1 = buildTabSheet_1();
		tabsheetHocHamHocVi.addComponent(tabSheet_1);
		
		return tabsheetHocHamHocVi;
	}

	@AutoGenerated
	private TabSheet buildTabSheet_1() {
		// common part: create layout
		tabSheet_1 = new TabSheet();
		tabSheet_1.setImmediate(true);
		tabSheet_1.setWidth("100.0%");
		tabSheet_1.setHeight("100.0%");
		
		// verticalLayoutHocVi
		verticalLayoutHocVi = buildVerticalLayoutHocVi();
		tabSheet_1.addTab(verticalLayoutHocVi, "Hoc Vi", null);
		
		// verticalLayoutHocHam
		verticalLayoutHocHam = buildVerticalLayoutHocHam();
		tabSheet_1.addTab(verticalLayoutHocHam, "Hoc Ham", null);
		
		return tabSheet_1;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayoutHocVi() {
		// common part: create layout
		verticalLayoutHocVi = new VerticalLayout();
		verticalLayoutHocVi.setImmediate(false);
		verticalLayoutHocVi.setWidth("100.0%");
		verticalLayoutHocVi.setHeight("-1px");
		verticalLayoutHocVi.setMargin(true);
		verticalLayoutHocVi.setSpacing(true);
		
		// txtHocViTen
		txtHocViTen = new ComboBox("Hoc Vi Dat Duoc :", LIST_HOCVI);
		txtHocViTen.select(S_HOCVI[0]) ;
//		txtHocViTen.setCaption("Hoc Vi Dat Duoc :");
		txtHocViTen.setImmediate(false);
		txtHocViTen.setWidth("462px");
		txtHocViTen.setHeight("-1px");
		txtHocViTen.setRequired(true);
		verticalLayoutHocVi.addComponent(txtHocViTen);
		
		// txtTenTruong
		txtTenTruong = new TextField();
		txtTenTruong.setCaption("Ten Truong da hoc :");
		txtTenTruong.setImmediate(false);
		txtTenTruong.setWidth("462px");
		txtTenTruong.setHeight("-1px");
		txtTenTruong.setRequired(true);
		txtTenTruong.setSecret(false);
		verticalLayoutHocVi.addComponent(txtTenTruong);
		
		// txtHocViNgayBD
		txtHocViNgayBD = new PopupDateField();
		txtHocViNgayBD.setCaption("Ngay Bat Dau :");
		txtHocViNgayBD.setImmediate(false);
		txtHocViNgayBD.setWidth("462px");
		txtHocViNgayBD.setHeight("-1px");
		txtHocViNgayBD.setInvalidAllowed(false);
		txtHocViNgayBD.setRequired(true);
		verticalLayoutHocVi.addComponent(txtHocViNgayBD);
		
		// txtHocViNgayKT
		txtHocViNgayKT = new PopupDateField();
		txtHocViNgayKT.setCaption("Ngay Ket Thuc :");
		txtHocViNgayKT.setImmediate(false);
		txtHocViNgayKT.setWidth("462px");
		txtHocViNgayKT.setHeight("-1px");
		txtHocViNgayKT.setInvalidAllowed(false);
		txtHocViNgayKT.setRequired(true);
		verticalLayoutHocVi.addComponent(txtHocViNgayKT);
		
		// txtHocViDiaChiTruong
		txtHocViDiaChiTruong = new TextArea();
		txtHocViDiaChiTruong.setCaption("Dia Chi Truong");
		txtHocViDiaChiTruong.setImmediate(false);
		txtHocViDiaChiTruong.setWidth("462px");
		txtHocViDiaChiTruong.setHeight("-1px");
		txtHocViDiaChiTruong.setRequired(true);
		verticalLayoutHocVi.addComponent(txtHocViDiaChiTruong);
		
		// btnHocViReset
		btnHocViReset = new Button();
		btnHocViReset.setCaption("Button");
		btnHocViReset.setImmediate(true);
		btnHocViReset.setWidth("-1px");
		btnHocViReset.setHeight("-1px");
		verticalLayoutHocVi.addComponent(btnHocViReset);
		
		return verticalLayoutHocVi;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayoutHocHam() {
		// common part: create layout
		verticalLayoutHocHam = new VerticalLayout();
		verticalLayoutHocHam.setCaption("Hoc Ham");
		verticalLayoutHocHam.setImmediate(false);
		verticalLayoutHocHam.setWidth("100.0%");
		verticalLayoutHocHam.setHeight("-1px");
		verticalLayoutHocHam.setMargin(true);
		verticalLayoutHocHam.setSpacing(true);
		
		// txtTenHocHam
		txtTenHocHam = new ComboBox("Hoc Ham Dat Duoc :", LIST_HOCHAM);
		txtHocViTen.select(S_HOCHAM[0]) ;
		txtTenHocHam.setCaption("Hoc Ham Dat Duoc :");
		txtTenHocHam.setImmediate(false);
		txtTenHocHam.setWidth("462px");
		txtTenHocHam.setHeight("-1px");
		txtTenHocHam.setRequired(true);
		verticalLayoutHocHam.addComponent(txtTenHocHam);
		
		// txtHocHamNgayDatDuoc
		txtHocHamNgayDatDuoc = new PopupDateField();
		txtHocHamNgayDatDuoc.setCaption("Thoi Gian Duoc Phong Tang :");
		txtHocHamNgayDatDuoc.setImmediate(false);
		txtHocHamNgayDatDuoc.setWidth("462px");
		txtHocHamNgayDatDuoc.setHeight("-1px");
		txtHocHamNgayDatDuoc.setInvalidAllowed(false);
		txtHocHamNgayDatDuoc.setRequired(true);
		verticalLayoutHocHam.addComponent(txtHocHamNgayDatDuoc);
		
		// btnHocHamReset
		btnHocHamReset = new Button();
		btnHocHamReset.setCaption("Button");
		btnHocHamReset.setImmediate(false);
		btnHocHamReset.setWidth("-1px");
		btnHocHamReset.setHeight("-1px");
		verticalLayoutHocHam.addComponent(btnHocHamReset);
		
		return verticalLayoutHocHam;
	}

	@AutoGenerated
	private VerticalLayout buildTabsheetAccount() {
		// common part: create layout
		tabsheetAccount = new VerticalLayout();
		tabsheetAccount.setImmediate(false);
		tabsheetAccount.setWidth("100.0%");
		tabsheetAccount.setHeight("100.0%");
		tabsheetAccount.setMargin(true);
		tabsheetAccount.setSpacing(true);
		
		// txtUserName
		txtUserName = new TextField();
		txtUserName.setCaption("Tai khoan dang nhap :");
		txtUserName.setImmediate(false);
		txtUserName.setWidth("481px");
		txtUserName.setHeight("-1px");
		txtUserName.setRequired(true);
		txtUserName.setSecret(false);
		tabsheetAccount.addComponent(txtUserName);
		
		// txtPassword
		txtPassword = new PasswordField();
		txtPassword.setCaption("Mat khau dang nhap :");
		txtPassword.setImmediate(false);
		txtPassword.setWidth("481px");
		txtPassword.setHeight("-1px");
		txtPassword.setRequired(true);
		tabsheetAccount.addComponent(txtPassword);
		
		// btnDangNhapReset
		btnDangNhapReset = new Button();
		btnDangNhapReset.setCaption("Reset");
		btnDangNhapReset.setImmediate(true);
		btnDangNhapReset.setWidth("-1px");
		btnDangNhapReset.setHeight("-1px");
		tabsheetAccount.addComponent(btnDangNhapReset);
		
		return tabsheetAccount;
	}

	@AutoGenerated
	private VerticalLayout buildTabsheetNghienCuuKH() {
		// common part: create layout
		tabsheetNghienCuuKH = new VerticalLayout();
		tabsheetNghienCuuKH.setImmediate(false);
		tabsheetNghienCuuKH.setWidth("100.0%");
		tabsheetNghienCuuKH.setHeight("100.0%");
		tabsheetNghienCuuKH.setMargin(true);
		tabsheetNghienCuuKH.setSpacing(true);
		
		// horizontalLayout_1
		horizontalLayout_1 = buildHorizontalLayout_1();
		tabsheetNghienCuuKH.addComponent(horizontalLayout_1);
		
		// twinColSelect_1
		twinColSelect_1 = new TwinColSelect();
		twinColSelect_1.setContainerDataSource(GetDataFromDatabase.getDeTai()) ;
		twinColSelect_1.setItemCaptionPropertyId("TenCTNC");
		twinColSelect_1.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);

		twinColSelect_1.setCaption("Chon De Tai Dang Ky Thuc Hien :");
		twinColSelect_1.setImmediate(false);
		twinColSelect_1.setWidth("100.0%");
		twinColSelect_1.setHeight("-1px");
		twinColSelect_1.setRequired(true);
		tabsheetNghienCuuKH.addComponent(twinColSelect_1);
		tabsheetNghienCuuKH.setComponentAlignment(twinColSelect_1,
				new Alignment(20));
		
		// button_1
		button_1 = new Button();
		button_1.setCaption("Button");
		button_1.setImmediate(false);
		button_1.setWidth("-1px");
		button_1.setHeight("-1px");
		tabsheetNghienCuuKH.addComponent(button_1);
		
		return tabsheetNghienCuuKH;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_1() {
		// common part: create layout
		horizontalLayout_1 = new HorizontalLayout();
		horizontalLayout_1.setImmediate(false);
		horizontalLayout_1.setWidth("100.0%");
		horizontalLayout_1.setHeight("-1px");
		horizontalLayout_1.setMargin(false);
		
		// txtNghienCuuNgayThamGia
		txtNghienCuuNgayThamGia = new PopupDateField();
		txtNghienCuuNgayThamGia.setCaption("Ngay Tham Gia :");
		txtNghienCuuNgayThamGia.setImmediate(false);
		txtNghienCuuNgayThamGia.setWidth("401px");
		txtNghienCuuNgayThamGia.setHeight("-1px");
		txtNghienCuuNgayThamGia.setInvalidAllowed(false);
		txtNghienCuuNgayThamGia.setRequired(true);
		horizontalLayout_1.addComponent(txtNghienCuuNgayThamGia);
		
		// txtNghienCuuNgayKT
		txtNghienCuuNgayKT = new PopupDateField();
		txtNghienCuuNgayKT.setCaption("Ngay Ket Thuc :");
		txtNghienCuuNgayKT.setImmediate(false);
		txtNghienCuuNgayKT.setWidth("390px");
		txtNghienCuuNgayKT.setHeight("-1px");
		txtNghienCuuNgayKT.setInvalidAllowed(false);
		horizontalLayout_1.addComponent(txtNghienCuuNgayKT);
		
		return horizontalLayout_1;
	}

}
