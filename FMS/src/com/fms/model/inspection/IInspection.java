package com.fms.model.inspection;

import com.fms.model.facility.Building;

public interface IInspection {
	//public String getInspectionID();
	//public void setInspectionID(String inspectionID);
	//public String getDateFrom();
	//public void setDateFrom(String dateFrom);
	//public String getDateTo();
	//public void setDateTo(String dateTo);
	//public String getInspectionType();
	//public void setInspectionType(String inspectionType);
	//public String getFacilityID();
	//public void setFacilityID(String facilityID);
	//public String getInspectedBy();
	//public void setInspectedBy(String inspectedBy);
	public Building getBuilding();
	public void setBuilding(Building building);

}
