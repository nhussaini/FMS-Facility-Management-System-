package com.fms.model.reserveuse.service;

import com.fms.dal.reserveuse.InUseDAO;
import com.fms.dal.reserveuse.ReserveDAO;
import com.fms.model.facility.Room;
import com.fms.model.reserveuse.InUse;
import com.fms.model.reserveuse.Reserve;
import com.fms.model.user.User;

public class ReserveuseService {
	ReserveDAO reserveDAO=new ReserveDAO();
	InUseDAO inUseDAO=new InUseDAO();
	
	
	public void assingFacilityToUse(InUse inUse, Reserve reserve, User user, Room room) {
		try {
			inUseDAO.insertInUse(inUse.getUsageID(), inUse.getrStatus(), reserve.getReserveID(), room.getRoomID(), user.getUserID(), inUse.getUsedInInterval());
		}catch (Exception se) {
		      System.err.println("FacilityFacilityUsageService: Threw a Exception adding Facility Usage.");
		      System.err.println(se.getMessage());
		}
		
	}
	
	//Insert facility reservation
	public void addReservation(Reserve reserve, User user, Room room) {
		try {
			reserveDAO.insertReservation(reserve.getReserveID(), reserve.getDateFrom(), reserve.getDateTo(), user.getUserID(), reserve.getrStatus(), room.getRoomID());
		}catch (Exception se) {
		      System.err.println("FacilityReservationService: Threw a Exception Reserving Facility.");
		      System.err.println(se.getMessage());
		}
	}
	
	public int getFacilityIntervalUsage(String rid) {
		try {
			return inUseDAO.getFacilityIntervalUsage(rid);
		} catch (Exception se) {
		      System.err.println("FacilityintervalUsageService: Threw a Exception retrieving Facility Interval Usage.");
		      System.err.println(se.getMessage());
		    }
		return 0;
	}
	
	//List actual facility usage
	public InUse getActualFacilityUsage(String rid) {
		try {
			InUse inUse=inUseDAO.getActualFacilityUsage(rid);
			return inUse;
		} catch (Exception se) {
		      System.err.println("FacilityActualUsageService: Threw a Exception retrieving Actual Facility Usage.");
		      System.err.println(se.getMessage());
		    }
		return null;
	}
	
	//Vacate Facility
	public void vacateFacility(String rid) {
		try {
			inUseDAO.vacateFacility(rid);
			reserveDAO.cancelReservation(rid);
		} catch (Exception se) {
		      System.err.println("VacateFacilityService: Threw a Exception retrieving Vacate Facility.");
		      System.err.println(se.getMessage());
		    }
	}
	

}
