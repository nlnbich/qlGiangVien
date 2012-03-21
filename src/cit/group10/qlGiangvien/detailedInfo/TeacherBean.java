package cit.group10.qlGiangvien.detailedInfo;

import java.io.Serializable;

public class TeacherBean implements Serializable {
	
	private String id ;
	private String fullname ;	
	private String department ;
	private String degree ;
	private String position ;
	
	
	
	public TeacherBean(){
		
		this.id = "DT0001" ;
		this.fullname= "Sameple text" ;
		this.position="Sameple text";
		this.department="Sameple text" ;
		this.degree= "Sameple text" ;
		
		
		
	}
	
	public TeacherBean(String id, String name, String content, String started_day, String ended_day,
			String who_width, String status){
		this.id = id ;
		this.fullname= name ;
		this.position=content;
		this.department=started_day ;
		this.degree= ended_day ;
		
	}
	
	public String getID(){ return id;}
	public String getFullName(){ return fullname;}
	public String getPosition(){ return position;}
	public String getDepartment(){ return department;}
	public String getDegree(){ return degree;}
	
	
	public void setID(String st){ this.id=st ;}
	public void setFullName(String st){ this.fullname=st ;}
	public void setPosition(String st){ this.position=st ;}
	public void setDepartment(String st){ this.department=st ;}
	public void setDegree(String st){ this.degree=st ;}
	
	

}


//public class Bean implements Serializable {

