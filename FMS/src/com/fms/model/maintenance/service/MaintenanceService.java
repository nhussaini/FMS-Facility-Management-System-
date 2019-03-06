package com.fms.model.maintenance.service;

import com.fms.dal.maintenance.MaintenanceRequestDAO;
import com.fms.model.maintenance.MaintenanceRequest;

public class MaintenanceService {
	private MaintenanceRequestDAO maintenanceRequestDAO=new MaintenanceRequestDAO();
	
	//Insert new maintenanceRequest
	public void addMaintenanceRequest(MaintenanceRequest request) {
		try {
			maintenanceRequestDAO.insertMaintenanceRequest(request.getRequestID(), request.getDescription(), request.getRequestDate(), request.getUserID(), request.getRoomID());
		} catch (Exception se) {
		      System.err.println("FacilityMaintenanceService: Threw a Exception adding Maintenance Request.");
		      System.err.println(se.getMessage());
		    }
	}

}
