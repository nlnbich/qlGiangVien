
package cit.group10.qlGiangvien.constants;


public interface Constants {
	
	
	//for main menu and left menu
	
	//user
	static final String[][] MAIN_MENU_TEXT_USER ={ 
			{"Trang chu", "Thong tin giang vien", "De tai nghien cuu"},
			{},			
			{"Thong tin ca nhan", "Thong tin cong tac","Thong tin hoc ham, hoc vi", "Thong tin bo mon", "Khen thuong, ky luat"},
			{"De tai da lam", "Dang ky de tai moi"}			
		};
	static final String[] MAIN_MENU_TEXT_USER_ICON ={"img/home.png", "img/personal.png", "img/research.png"};
			
	
	//admin
	static final String[][] MAIN_MENU_TEXT_ADMIN={ 
		{"Trang chu", "Thong tin giang vien", "De tai nghien cuu","Thong ke", "Tim kiem" },
		{},			
		{"Thong tin ca nhan", "Thong tin cong tac","Thong tin hoc ham, hoc vi", "Thong tin bo mon", "Khen thuong, ky luat"},
		{"Danh sach de tai", "Dang ky de tai moi"},
		{"So de tai trong thang", "So de tai trong nam", "Giang vien theo tung bo mon", "Giang vien theo hoc ham, hoc vi"},
		{"Theo ten", "Theo ma so", "Bo mon", "Don vi cong tac"}
	};
	static final String[] MAIN_MENU_TEXT_ADMIN_ICON ={"img/home.png", "img/personal.png","img/research.png", "img/statistics.png", "img/search.png"};
	
	
	
	
	
	
	
	
	static enum LEFT_MEN_INDEX{USER, ADMIN, INFO, SEARCH, STATISTICS } ; 
	
	static final String[] USER_INFO_LIST ={"Thong tin ca nhan", "Thong tin giang day", "Thong tin hoc ham, hoc vi"} ;
	
	
	
	
	
	//caption
	static final String MAIN_CAPTION = "Thong tin giang vien" ;
	static final String ADMIN_CAPTION = "Thong tin quan ly" ;
	static final String USER_CAPTION = "Thong tin giang vien" ;
	
	
	
	
	
	
	static final int WIDTH_MAX = 1100 ;
	static final int WIDTH_LEFT_MENU = 280 ;

	
	
	//top panel
	static final String LOGOUT = "Thoat" ;
	static final String SETTING = "Cai dat ca nhan" ;
	
	
	//bottom
	static final String BOTTOM_LINE1 = "Khoa Cong Nghe Thong Tin & Truyen Thong" ;
	static final String BOTTOM_LINE2 = "Nhom 10 - He Thong Thong Tin K17";
	static final String BOTTOM_LINE3 = "2011-2012";
	static final String DESIGN_BY = "Design by : Group 10 Cao Hoc He Thong Thong Tin K17-2012";
	
	
	//login page
	static final String TITLE_LOGIN = "<h1>Dang nhap he thong</h1>" ;
	static final String NEW_PASSWORD = "Quen mat khau" ;
	static final String LOGIN_FAIL = "Thong tin sai. Vui long thu lai" ;
	
	
	
	// user's role
	static enum PERMISSION{ USER, ADMIN} ;
	
	
	
	
	//title of window
//	static final String W_
	
	
	

}
