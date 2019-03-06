package com.fms.model.reserveuse;

public class InUse {
	private String usageID;
	private String rStatus;
	private String reserveID;
	private String roomID;
	private String userID;
	private int usedInInterval;
	
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
	public String getReserveID() {
		return reserveID;
	}
	public void setReserveID(String reserveID) {
		this.reserveID = reserveID;
	}
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getUsedInInterval() {
		return usedInInterval;
	}
	public void setUsedInInterval(int usedInInterval) {
		this.usedInInterval = usedInInterval;
	}
	
	

}
