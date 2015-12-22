package gb.vo;

import java.util.Date;

public class Board {
	private int bno;
	private String email;
	private String pwd;
	private String content;
	private Date creDate;
	private Date modDate;
	
	public int getNo(){
		return bno;
	}
	
	public Board setNo(int bno){
		this.bno = bno;
		return this;
	}
	
	public String getEmail(){
		return email;
	}
	
	public Board setEmail(String email){
		this.email = email;
		return this;
	}
	
	public String getPwd(){
		return pwd;
	}
	
	public Board setPwd(String pwd){
		this.pwd = pwd;
		return this;
	}
	
	public String getContent(){
		return content;
	}
	
	public Board setContent(String content){
		this.content = content;
		return this;
	}
	
	public Date getModDate(){
		return modDate;
	}
	
	public Board setModDate(Date modDate){
		this.modDate = modDate;
		return this;
	}
	
	public Date getCreDate(){
		return creDate;
	}
	
	public Board setCreDate(Date creDate){
		this.creDate = creDate;
		return this;
	}

}
