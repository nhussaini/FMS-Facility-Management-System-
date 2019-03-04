package com.fms.dal;

public class DBConfig {
	//Credential will be created as instance
	private String username;
	private String password;
	private String databaseURL;
	private String databaseName;
	
	DBConfig(){
		username="root";
		password="";
		databaseURL="jdbc:mysql://localhost:3306";
		databaseName="fms1";
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getDatabaseURL() {
		return databaseURL+"/"+getDatabaseName();
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
	

}
