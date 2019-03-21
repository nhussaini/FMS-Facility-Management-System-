package com.fms.model.reserveuse;

import com.fms.model.facility.Room;

public class InUse implements IInUse{
	private String usageID;
	private String rStatus;
	private int usedInInterval;
	private Room room;
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public String getUsageID() {
		return usageID;
	}
	public void setUsageID(String usageID) {
		this.usageID = usageID;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	public int getUsedInInterval() {
		return usedInInterval;
	}
	public void setUsedInInterval(int usedInInterval) {
		this.usedInInterval = usedInInterval;
	}
	
	

}
