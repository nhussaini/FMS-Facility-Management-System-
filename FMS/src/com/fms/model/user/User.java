package com.fms.model.user;

import com.fms.model.maintenance.MaintenanceRequest;
import com.fms.model.reserveuse.Reserve;

public class User implements UserI{
	private String userID;
	private String Name;
	private String phoneNumber;
	private String address;
	private String typeOfUser;
	private Reserve reserve;
	private MaintenanceRequest maintenanceRequest;
	
	public Reserve getReserve() {
		return reserve;
	}
	public void setReserve(Reserve reserve) {
		this.reserve = reserve;
	}
	public MaintenanceRequest getMaintenanceRequest() {
		return maintenanceRequest;
	}
	public void setMaintenanceRequest(MaintenanceRequest maintenanceRequest) {
		this.maintenanceRequest = maintenanceRequest;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

}
