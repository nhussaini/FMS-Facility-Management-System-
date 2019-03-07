package com.fms.model.maintenance.service;

import com.fms.dal.maintenance.MaintenanceOrderDAO;
import com.fms.dal.maintenance.MaintenanceRequestDAO;
import com.fms.model.maintenance.MaintenanceOrder;
import com.fms.model.maintenance.MaintenanceRequest;

public class MaintenanceService {
	private MaintenanceRequestDAO maintenanceRequestDAO=new MaintenanceRequestDAO();
	private MaintenanceOrderDAO maintenanceOrderDAO=new MaintenanceOrderDAO();
	
	//Insert new maintenanceRequest
	public void addMaintenanceRequest(MaintenanceRequest request) {
		try {
			maintenanceRequestDAO.insertMaintenanceRequest(request.getRequestID(), request.getDescription(), request.getRequestDate(), request.getUserID(), request.getRoomID());
		} catch (Exception se) {
		      System.err.println("FacilityMaintenanceService: Threw a Exception adding Maintenance Request.");
		      System.err.println(se.getMessage());
		    }
	}
	
	//Update request order id
	public void UpdateRequest(String requestID, String morderID) {
		try {
			maintenanceRequestDAO.updateRequest(requestID, morderID);
		} catch (Exception se) {
		      System.err.println("FacilityMaintenanceService: Threw a Exception Updating Maintenance Request.");
		      System.err.println(se.getMessage());
		    }
		
	}
	
	//Insert new maintenance order
	public void addMaintenanceOrder(MaintenanceOrder order) {
		try {
		maintenanceOrderDAO.insertMaintenanceOrder(order.getMorderID(), order.getOrderDate(), order.getmStatus());
	} catch (Exception se) {
	      System.err.println("FacilityMaintenanceService: Threw a Exception adding Maintenance Order.");
	      System.err.println(se.getMessage());
	    }
		
	}
	

}
