package cit.group10.qlGiangvien.constants;

public interface dbConnect {
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_USED = "dbqlGiangvien" ;
	static final String DB_URL = "jdbc:mysql://localhost/" ;
	static final String USER = "root";
	static final String PASS = "root";
	
	
	//for authenticateAccount
	static final String st_default ="default" ;

	
	
	
	//for configureated file
	final String DIR_NAME = ".qlGiangvienConfigure" ;
	final String FILE_NAME = "infoDatabase.txt" ;
	
	
	
	
	//for create tables of database
	final String[] CREATE_TABLES ={
	"CREATE TABLE Account(accountID int NOT NULL AUTO_INCREMENT primary key, MaGV char(6) , username nvarchar(20) not null unique, password nvarchar(50) not null, role int not null, createdDate date,"
	+"Constraint GiangVien_Account Foreign key (MaGV) References GiangVien(MaGV) ) ;" ,

	

	"CREATE TABLE BoMon(MaBM char(6) NOT NULL PRIMARY KEY,	TenMH nvarchar(50) NOT NULL unique," +
	" LichSu nvarchar(200),NhanSu nvarchar(200), GiangDay nvarchar(200), NghienCuuPhatTrien nvarchar(200) ) ;" ,

	"CREATE TABLE QuaTrinhCongTac(MaQTCT int NOT NULL AUTO_INCREMENT PRIMARY KEY, HSLuong float NOT NULL, Bac int NOT NULL, NgayBD date NOT NULL) ;" ,

	
	"CREATE TABLE NghienCuuKH(MaCTNC char(6) NOT NULL PRIMARY KEY, TenCTNC nvarchar(200) NOT NULL, LoaiCTNC nvarchar(100) not null, NoiDungTH nvarchar(200), NgayBT date not null, NgayKT date ) ;" ,

//	"CREATE TABLE KhenThuong_KyLuat(MaKTKL int NOT NULL AUTO_INCREMENT primary key, TenKTKL nvarchar(100) NOT NULL, NoiDung nvarchar(200) NOT NULL) ;" ,

	"CREATE TABLE GiangVien(MaGV char(6) NOT NULL PRIMARY KEY, HoTen nvarchar(50) NOT NULL, NgaySinh DateTime NOT NULL, " +
	"GioiTinh nvarchar(3) NOT NULL, DiaChi nvarchar(50) NOT NULL, DienThoai nvarchar(12) NOT NULL, Email nvarchar(50), GhiChu nvarchar(500),"+ 
	"MaQTCT int NOT NULL,"+
	"Constraint QTCT_GiangVien Foreign key (MaQTCT) References QuaTrinhCongTac(MaQTCT)"+	
	");",

	"CREATE TABLE GiangVien_HocHam ( MaGVHH int NOT NULL AUTO_INCREMENT primary key, MaGV char(6)NOT NULL, TenHocHam nvarchar(100) NOT NULL, TGDat Datetime NOT NULL,"+	
	"Constraint GiangVien_GiangVienHocHam Foreign key (MaGV) References GiangVien(MaGV)) ;" ,

	"CREATE TABLE GiangVien_HocVi ( MaGVHV int NOT NULL AUTO_INCREMENT primary key, MaGV char(6) NOT NULL, TenHocVi nvarchar(100) not null, TenTruongDT nvarchar(200) NOT NULL, " +
	"DiaChiTruongDT nvarchar(200),  ThoiGianBD date NOT NULL, ThoiGianKT date not null ,"+	
	"Constraint GiangVien_GiangVienHocVi Foreign key (MaGV) References GiangVien(MaGV) ) ;" ,

	"CREATE TABLE GiangVien_BoMon(MaCV int NOT NULL AUTO_INCREMENT PRIMARY KEY, MaBM	char(6) NOT NULL," +
	" MaGV char(6) NOT NULL, TenCV nvarchar(50) NOT NULL, NgayBD date not null, NgayKT date,"+
	"Constraint GV_GiangVien_BoMon Foreign key (MaGV) References GiangVien(MaGV),"+
	"Constraint BM_GiangVien_BoMon Foreign key (MaBM) References BoMon(MaBM)"+
	") ;" ,

	"CREATE TABLE GiangVien_NghienCuuKH( MaGV char(6) not null, MaCTNC char(6) not null, NgayTG date, " +
	"NgayKT date, primary key( MaGV, MaCTNC),"+
	"Constraint GV_GiangVien_NghienCuuKH Foreign key (MaGV) References GiangVien(MaGV),"+
	"Constraint NC_GiangVien_NghienCuuKH Foreign key (MaCTNC) References NghienCuuKH(MaCTNC) ) ;" };
	 
	
	final String[] INSERT_ACCOUNT ={
	"insert into Account values(1, '00001', 'admin', 'admin', 1, now() ); ",
	"insert into Account values(2, null, 'user', '12345', 0, now() ); "
	};
	
	

}