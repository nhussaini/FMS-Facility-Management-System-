package com.fms.dal.maintenance;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.fms.dal.DBConnect;
import com.fms.model.maintenance.MaintenanceSchedule;


public class MaintenanceScheduleDAO {
	
	//insert maintenance schedule
	public MaintenanceSchedule insertMaintenanceSchedule(String scheduleID, String dateFrom, String dateTo, String morderID) {
		MaintenanceSchedule maintenanceSchedule=new MaintenanceSchedule();
		
		maintenanceSchedule.setScheduleID(scheduleID);
		maintenanceSchedule.setDateFrom(dateFrom);
		maintenanceSchedule.setDateTo(dateTo);
		maintenanceSchedule.setMorderID(morderID);
		
		Connection connection=DBConnect.getDatabaseConnection();
		
		try {
			Statement insertStatement=connection.createStatement();
			String insertQuery="INSERT INTO maintenanceSchedule(ScheduleID,DateFrom,DateTo,MOrderID)"
					+ "VALUES ('"+scheduleID+"','"+dateFrom+"','"+dateTo+"','"+morderID+"')";
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
		return maintenanceSchedule;
		
		
	}

}
