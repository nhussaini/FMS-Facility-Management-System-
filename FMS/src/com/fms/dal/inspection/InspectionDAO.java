package com.fms.dal.inspection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.fms.dal.DBConnect;
import com.fms.model.inspection.Inspection;

public class InspectionDAO {
	
	public Set<Inspection> insertInspectionInfo(Set<Inspection> inspections) {
		Connection connection=DBConnect.getDatabaseConnection();
		
		try {
			Statement insertStatement=connection.createStatement();
			
			Iterator<Inspection> inspectionIterator=inspections.iterator();
			
			while(inspectionIterator.hasNext()) {
				Inspection currentInspection=inspectionIterator.next();
				
				String insertQuery="INSERT INTO inspection(InspectionID,DateFrom,DateTo,UserID,FacilityID,InspectionType)"
						+"VALUES('"+currentInspection.getInspectionID()+"','"+currentInspection.getDateFrom()+"','"+currentInspection.getDateTo()+"','"+currentInspection.getUserID()+"','"+currentInspection.getFacilityID()+"','"+currentInspection.getInspectionType()+"')";
				insertStatement.executeUpdate(insertQuery);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		return inspections;
	}
	
	//Retrieve all inspections for a facility
	
	public Set<Inspection> getBuildingInspections(){
		Connection connection=DBConnect.getDatabaseConnection();
		
		Set<Inspection>inspections=new HashSet<>();
		
		try {
			Statement selectStatement=connection.createStatement();
			String selectQuery="SELECT * FROM inspection";
			ResultSet resultSet=selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String inspectionID=resultSet.getString("InspectionID");
				String dateFrom=resultSet.getString("DateFrom");
				String dateTo=resultSet.getString("DateTo");
				String userID=resultSet.getString("UserID");
				String facilityID=resultSet.getString("FacilityID");
				String inspectionType=resultSet.getString("InspectionType");
				
				Inspection inspection=new Inspection();
				
				inspection.setInspectionID(inspectionID);
				inspection.setDateFrom(dateFrom);
				inspection.setDateTo(dateTo);
				inspection.setUserID(userID);
				inspection.setFacilityID(facilityID);
				inspection.setInspectionType(inspectionType);
				
				inspections.add(inspection);
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		return inspections;
	}

}
