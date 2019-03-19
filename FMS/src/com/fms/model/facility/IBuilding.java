package com.fms.model.facility;

import java.util.Set;

public interface IBuilding {
	public String getFacilityID();
	public void setFacilityName(String facilityName);
	public String getAddress();
	public void setAddress(String address);
	public String getCity();
	public void setCity(String city);
	public String getState();
	public void setState(String state);
	public String getZipCode();
	public void setZipCode(String zipcode);
	public Set<Phone> getPhones();
	public void setPhones(Set<Phone> phones);
	public Set<Room> getRooms();
	public void setRooms(Set<Room> rooms);
	

}
