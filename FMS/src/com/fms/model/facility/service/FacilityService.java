package com.fms.model.facility.service;

import com.fms.dal.facility.BuildingDAO;
import com.fms.dal.facility.RoomDAO;
import com.fms.model.facility.Building;
import com.fms.model.facility.Room;

public class FacilityService {
	
	private Building building;
	
	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	private BuildingDAO buildingDAO=new BuildingDAO();
	private RoomDAO roomDAO=new RoomDAO();
	
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
	//Get Room By IDy
			public Room getRoomByID(String rid) {
				
				try {
					Room room = roomDAO.getRoomByID(rid);
			    	return room;
			    } catch (Exception se) {
			      System.err.println("FacilityService: Threw a Exception retrieving Room.");
			      System.err.println(se.getMessage());
			    }
				return null;
			}
		

}
