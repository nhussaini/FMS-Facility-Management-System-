package com.fms.model.maintenance;

public class Maintenance {
	private String maintenanceID;
	private String type;
	private String maintenanceStart;
	private String maintenanceEnd;
	private double cost;
	private String SStatus;
	private String scheduleID;
	private String MOrderID;
	
	public String getMaintenanceID() {
		return maintenanceID;
	}
	public void setMaintenanceID(String maintenanceID) {
		this.maintenanceID = maintenanceID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMaintenanceStart() {
		return maintenanceStart;
	}
	public void setMaintenanceStart(String maintenanceStart) {
		this.maintenanceStart = maintenanceStart;
	}
	public String getMaintenanceEnd() {
		return maintenanceEnd;
	}
	public void setMaintenanceEnd(String maintenanceEnd) {
		this.maintenanceEnd = maintenanceEnd;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getSStatus() {
		return SStatus;
	}
	public void setSStatus(String sStatus) {
		SStatus = sStatus;
	}
	public String getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getMOrderID() {
		return MOrderID;
	}
	public void setMOrderID(String mOrderID) {
		MOrderID = mOrderID;
	}
	
	

}
