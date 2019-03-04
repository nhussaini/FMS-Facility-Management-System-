package com.fms.dal.inspection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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

}
