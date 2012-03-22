package cit.group10.qlGiangvien.constants;

public interface dbConnect {
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_USED = "dbqlGiangvien" ;
	static final String DB_URL = "jdbc:mysql://localhost/" ;
	static final String USER = "root";
	static final String PASS = "root";
	
	
	//for authenticateAccount
	static final String st_default ="default" ;
	static final String COLLUMM_ROLE = "role" ;
	static final String ADMIN_VALUE = "admin" ;
	static final String USER_VALUE = "user" ;
	
	
	//for configureated file
	final String DIR_NAME = ".qlGiangvienConfigure" ;
	final String FILE_NAME = "infoDatabase.txt" ;
	
	
	
	
	//for create tables of database
	final String[] CREATE_TABLES ={
	"create table account(userID nvarchar(5) primary key, username varchar(20) not null unique, password varchar(20) not null, role varchar(20) not null) ;",
	"create table hocVi(maHV nvarchar(5) primary key, tenHV varchar(50) not null ) ;",
	"create table boMon(maBM nvarchar(5) primary key, tenBM varchar(50) not null, maKhoa varchar(5) not null) ;",
	"create table noiDaoTao( maDT nvarchar(5) primary key, tenTruong varchar(50) not null, diaChi varchar(50) not null ) ;",
	"create table giangVien_HocVi( maHV nvarchar(5), maGV nvarchar(5), maNDT varchar(5), thogianDT datetime );",
	"create table quaTrinhCongTac( maQTCT nvarchar(5), HSLuong float, bac int, namCT datetime) ;",
	"create table hocHam( maHH nvarchar(5) primary key, tenHH varchar(50) not null) ;",
	"create table chucVu( maCV nvarchar(5)primary key, tenCV varchar(50) not null ) ;",
	"create table loaiGV( maLoaiGV nvarchar(5) primary key, tenLoaiGV varchar(50) not null ) ;",
	"create table nghienCuuKH( maDTNC nvarchar(5) primary key, tenDTNC varchar(200) not null ) ;",
	"create table khenThuongKyLuat( maKTKL nvarchar(5) primary key, tenKTKL varchar(80) not null, hinhThuc varchar(200) not null) ;" };
	
	final String[] INSERT_ACCOUNT ={
	"insert into account values('00001', 'admin', 'admin', 'admin'); ",
	"insert into account values('00002', 'user', '12345', 'user'); "
	};
	
	

}
