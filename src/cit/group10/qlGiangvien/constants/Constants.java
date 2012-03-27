
package cit.group10.qlGiangvien.constants;

import java.util.Arrays;
import java.util.List;


public interface Constants {
	
	
	//for main menu and left menu
	
	//user
	static final String[][] MAIN_MENU_TEXT_USER ={ 
			{"Trang chủ", "Thông tin giảng viên"},
			{},			
			{},
			{}			
		};
	static final String[] MAIN_MENU_TEXT_USER_ICON ={"img/home.png", "img/personal.png", "img/research.png"};
			
	
	//admin
	static final String[][] MAIN_MENU_TEXT_ADMIN={ 
		{"Trang chủ", "Quản lý giảng viên", "Đề tài nghiên cứu","Thống kê"},
		{},			
		{"Thêm giảng viên", "Cập nhật/Xóa giảng viên", "Quản lý bộ môn", "Import thông tin giảng viên"},
		{"Danh sách đề tài", "Đăng ký đề tài mới"},
		{"Số đề tài trong thực hiện", "Số giảng viên theo từng bộ môn", "Số giảng viên theo học hàm, học vị"}		
	};
	static final String[] MAIN_MENU_TEXT_ADMIN_ICON ={"img/home.png", "img/personal.png","img/research.png", "img/statistics.png"};
	

	
	
	static enum LEFT_MEN_INDEX{USER, ADMIN, INFO, SEARCH, STATISTICS } ; 
	
	static final String[] USER_INFO_LIST ={"Thông tin cá nhân", "Thông tin giảng dạy", "Thông tin học hàm, học vị"} ;
	
	
	
	
	
	//caption
	static final String MAIN_CAPTION = "Thông tin giảng viên" ;
	static final String ADMIN_CAPTION = "Thông tin quản lý" ;
	static final String USER_CAPTION = "Thông tin giảng viên" ;
	
	
	
	
	
	
	static final int WIDTH_MAX = 1100 ;
	static final int WIDTH_LEFT_MENU = 280 ;

	
	
	//top panel
	static final String LOGOUT = "Thoát" ;
	static final String SETTING = "Cài đặt cá nhân" ;
	
	
	//bottom
	static final String BOTTOM_LINE1 = "Khoa Công Nghệ Thông Tin & Truyền Thông" ;
	static final String BOTTOM_LINE2 = "Nhóm 10 - Hệ Thống Thông Tin K17";
	static final String BOTTOM_LINE3 = "2011-2012";
	static final String DESIGN_BY = "Design by : Group 10 Cao Học Hệ Thống Thông Tin K17-2012";
	
	
	//login page
	static final String TITLE_LOGIN = "<h1>Đăng nhập hệ thống</h1>" ;
	static final String NEW_PASSWORD = "Quên mật khẩu" ;
	static final String LOGIN_FAIL = "Thông tin sai. Vui lòng thử lại" ;
	
	
	
	// user's role
	static enum PERMISSION{ USER, ADMIN} ;
	
	
	
	public static final String[] S_PHAMVI =new String[] {"Cap Truong", "Cap Tinh/Thanh Pho", "Cap Bo"} ;
	public static final List<String> LIST_PHAMVI = Arrays.asList(S_PHAMVI);
	
	
	
	
	
	//title of window
//	static final String W_
	
	
	

}
