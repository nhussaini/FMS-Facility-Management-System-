package com.fms.model.facility.service;

import com.fms.dal.facility.BuildingDAO;
import com.fms.model.facility.Building;

public class FacilityService {
	private BuildingDAO buildingDAO=new BuildingDAO();
	
	public Building addBuilding(Building building) {
		try {
			return buildingDAO.insertBuildingInfo(building.getFacilityID(), building.getFacilityName(), building.getAddress(), building.getCity(), building.getState(), building.getZipCode(), building.getType(), building.getCapacity(), building.getPhones(), building.getRooms());
		}catch (Exception se) {
		      System.err.println("FacilityService: Threw a Exception adding Facility.");
		      System.err.println(se.getMessage());
		    }
			return null;// why is this return null here?
	}
	
	//Romve a building facility
	public String removeFacility(String facilityID) {
		try {
			buildingDAO.deleteBuilding(facilityID);
			return "Ok";
		} catch (Exception se) {
		      System.err.println("FacilityService: Threw a Exception deleting a Facility.");
		      System.err.println(se.getMessage());
		    }
		return null;
	}

}
