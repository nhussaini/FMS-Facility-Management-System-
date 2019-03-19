package com.fms.model.inspection.service;

import java.util.Set;

import com.fms.dal.inspection.InspectionDAO;
import com.fms.model.inspection.Inspection;

public class InspectionService {
	private Inspection inspection;
	
	public Inspection getInspection() {
		return inspection;
	}

	public void setInspection(Inspection inspection) {
		this.inspection = inspection;
	}

	private InspectionDAO inspectionDAO=new InspectionDAO();
	
	public void addInspections(Set<Inspection> inspections) {
		try {
			inspectionDAO.insertInspectionInfo(inspections);
		}catch(Exception se){
			 System.err.println("InspectionAddService: Threw a Exception Adding Facility Inspections.");
		      System.err.println(se.getMessage());
		}
	}
	
	public Set<Inspection> listInspections(){
		try {
			Set<Inspection> inspections=inspectionDAO.getBuildingInspections();
			return inspections;
		}catch(Exception se){
			 System.err.println("InspectionService: Threw a Exception retrieving Facility Inspections.");
		      System.err.println(se.getMessage());
	}
	return null;	
	}
}
