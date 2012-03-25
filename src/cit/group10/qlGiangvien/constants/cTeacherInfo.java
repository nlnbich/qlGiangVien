package cit.group10.qlGiangvien.constants;

import java.util.Arrays;
import java.util.List;


public interface cTeacherInfo {
	
	public static final String[] S_GENDER =new String[] {"Nam", "Nu"} ;
	public static final List<String> LIST_GENDER = Arrays.asList(S_GENDER);
	
	public static final String[] S_BACLUONG= new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"} ;
	public static final List<String> LIST_BACLUONG = Arrays.asList(S_BACLUONG);
	
	
	public static final String[] S_CHUCVU =new String[] {"Truong Bo Mon", "Pho Bo Mon", "Giang Vien Chinh", "Giang Vien","Thu Viec"};
	public static final List<String> LIST_CHUCVU = Arrays.asList(S_CHUCVU);
	
	public static final String[] S_HOCHAM =new String[] {"Giao Su", "Pho Giao Su"} ;
	public static final List<String> LIST_HOCHAM = Arrays.asList(S_HOCHAM);
	
	public static final String[] S_HOCVI = new String[] {"He Trung Cap", "He Cao Dang", "Cu Nhan/Ky Su", "Thac Si", "Tien Si"} ;
	public static final List<String> LIST_HOCVI = Arrays.asList(S_HOCVI);
	
	
	
	
	public static final List<String> IMPORT_SELECT_CHOICES = Arrays.asList(new String[] {
            "Berlin", "Brussels", "Helsinki", "Madrid", "Oslo", "Paris",
            "Stockholm" });
//	
//	public static final List<String> IMPORT_SELECT_CHOICES = Arrays.asList(new String[] {
//            "Berlin", "Brussels", "Helsinki", "Madrid", "Oslo", "Paris",
//            "Stockholm" });
//	
//	
//	public static final List<String> IMPORT_SELECT_CHOICES = Arrays.asList(new String[] {
//            "Berlin", "Brussels", "Helsinki", "Madrid", "Oslo", "Paris",
//            "Stockholm" });
	
	
	
	

	

}
