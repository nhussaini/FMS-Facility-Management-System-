package com.fms.model.user;

import com.fms.model.maintenance.MaintenanceRequest;
import com.fms.model.reserveuse.Reserve;

public interface UserI {
	public String getUserID(); 
	public void setUserID(String userID);
	public String getName();
	public void setName(String name);
	public String getPhoneNumber();
	public void setPhoneNumber(String phoneNumber);
	public String getAddress();
	public void setAddress(String address);
	public String getTypeOfUser();
	public void setTypeOfUser(String typeOfUser);
	public Reserve getReserve();
	public void setReserve(Reserve reserve);
	public MaintenanceRequest getMaintenanceRequest();
	public void setMaintenanceRequest(MaintenanceRequest maintenanceRequest);
	

}
