package com.fms.model.facility;

import java.util.HashSet;
import java.util.Set;

public class Building extends Facility implements IBuilding {
	private String type;
	private int capacity;
	private Set<Phone> phones=new HashSet<Phone>();
	private Set<Room> rooms=new HashSet<Room>();
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Set<Phone> getPhones() {
		return phones;
	}
	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	

}
