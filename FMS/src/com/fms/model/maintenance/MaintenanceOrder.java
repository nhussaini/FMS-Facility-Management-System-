package com.fms.model.maintenance;

import java.util.HashSet;
import java.util.Set;

public class MaintenanceOrder {
	private String morderID;
	private String orderDate;
	private String mStatus;
	private Set<MaintenanceRequest> maintRequests=new HashSet<>();
	
	public String getMorderID() {
		return morderID;
	}
	public void setMorderID(String morderID) {
		this.morderID = morderID;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getmStatus() {
		return mStatus;
	}
	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}
	public Set<MaintenanceRequest> getMaintRequests() {
		return maintRequests;
	}
	public void setMaintRequests(Set<MaintenanceRequest> maintRequests) {
		this.maintRequests = maintRequests;
	}
	

}
