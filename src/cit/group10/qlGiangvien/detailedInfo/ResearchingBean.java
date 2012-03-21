package cit.group10.qlGiangvien.detailedInfo;

import java.io.Serializable;

public class ResearchingBean implements Serializable {
	
	private String id ;
	private String name ;
	private String content ;
	private String started_day ;
	private String ended_day ;
	private String who_with ;
	private String status ;
	
	
	public ResearchingBean(){
		
		this.id = "DT0001" ;
		this.name= "Sameple text" ;
		this.content="Sameple text";
		this.started_day="Sameple text" ;
		this.ended_day= "Sameple text" ;
		this.who_with = "Sameple text";
		this.status ="Sameple text" ;
		
		
	}
	
	public ResearchingBean(String id, String name, String content, String started_day, String ended_day,
			String who_width, String status){
		this.id = id ;
		this.name= name ;
		this.content=content;
		this.started_day=started_day ;
		this.ended_day= ended_day ;
		this.who_with = who_width ;
		this.status =status ;
	}
	
	public String getID(){ return id;}
	public String getName(){ return name;}
	public String getContent(){ return content;}
	public String getStarted_day(){ return started_day;}
	public String getEnded_day(){ return ended_day;}
	public String getWho_with(){ return who_with;}
	public String getStatus(){ return status;}
	
	
	public void setID(String st){ this.id=st ;}
	public void setName(String st){ this.name=st ;}
	public void setContent(String st){ this.content=st ;}
	public void setStarted_day(String st){ this.started_day=st ;}
	public void setEnded_day(String st){ this.ended_day=st ;}
	public void setWho_with(String st){ this.who_with=st ;}
	public void setStatus(String st){ this.status=st ;}
	

}


//public class Bean implements Serializable {

