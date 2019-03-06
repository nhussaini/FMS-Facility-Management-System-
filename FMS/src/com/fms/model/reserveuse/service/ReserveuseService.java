package com.fms.model.reserveuse.service;

import com.fms.dal.reserveuse.InUseDAO;
import com.fms.dal.reserveuse.ReserveDAO;
import com.fms.model.reserveuse.InUse;
import com.fms.model.reserveuse.Reserve;

public class ReserveuseService {
	ReserveDAO reserveDAO=new ReserveDAO();
	InUseDAO inUseDAO=new InUseDAO();
	
	
	public void assingFacilityToUse(InUse inUse) {
		try {
			inUseDAO.insertInUse(inUse.getUsageID(), inUse.getrStatus(), inUse.getReserveID(), inUse.getRoomID(), inUse.getRoomID(), inUse.getUsedInInterval());
		}catch (Exception se) {
		      System.err.println("FacilityFacilityUsageService: Threw a Exception adding Facility Usage.");
		      System.err.println(se.getMessage());
		}
		
	}
	
	//Insert facility reservation
	public void addReservation(Reserve reserve) {
		try {
			reserveDAO.insertReservation(reserve.getReserveID(), reserve.getDateFrom(), reserve.getDateTo(), reserve.getUserID(), reserve.getrStatus(), reserve.getRoomID());
		}catch (Exception se) {
		      System.err.println("FacilityReservationService: Threw a Exception Reserving Facility.");
		      System.err.println(se.getMessage());
		}
	}

}
