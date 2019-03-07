package com.fms.dal.maintenance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fms.dal.DBConnect;
import com.fms.model.maintenance.Maintenance;

public class MaintenanceDAO {
	
	public Maintenance insertMaintenance(String maintenanceID, String type, String maintenanceStart, String maintenanceEnd, double cost, String sStatus, String scheduleID, String mOrderID) {
		
		Maintenance maintenance=new Maintenance();
		
		maintenance.setMaintenanceID(maintenanceID);
		maintenance.setType(type);
		maintenance.setMaintenanceStart(maintenanceStart);
		maintenance.setMaintenanceEnd(maintenanceEnd);
		maintenance.setCost(cost);
		maintenance.setSStatus(sStatus);
		maintenance.setScheduleID(scheduleID);
		maintenance.setMOrderID(mOrderID);
		
		Connection connection=DBConnect.getDatabaseConnection();
		
		try {
			Statement insertStatement=connection.createStatement();
			String insertQuery="INSERT INTO maintenance(MaintenanceID,Type,MaintenanceStart,MaintenanceEnd,Cost,SStatus,ScheduleID,MOrderID)"
					+ " VALUES('"+maintenanceID+"','"+type+"','"+maintenanceStart+"','"+maintenanceEnd+"','"+cost+"','"+sStatus+"','"+scheduleID+"','"+mOrderID+"')";
			insertStatement.executeUpdate(insertQuery);
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		return maintenance;
		
	}
	
	//get maintenance cost by maintenance ID
	public double getMaintenanceCost(String mOrderID) {
		double cost=0.0;
		Connection connection=DBConnect.getDatabaseConnection();
		try {
			Statement selectStatement=connection.createStatement();
			
			String selectQuery="SELECT * FROM maintenance WHERE MOrderID='"+mOrderID+"'";
			
			ResultSet resultSet=selectStatement.executeQuery(selectQuery);
			
			resultSet.next();
		    cost=resultSet.getDouble("Cost");
		    
		    
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		return cost;
	}

}
