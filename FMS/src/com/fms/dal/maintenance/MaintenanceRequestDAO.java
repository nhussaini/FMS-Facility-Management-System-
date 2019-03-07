package com.fms.dal.maintenance;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.fms.dal.DBConnect;
import com.fms.model.maintenance.MaintenanceRequest;

public class MaintenanceRequestDAO {
	
	public MaintenanceRequest insertMaintenanceRequest(String requestID, String description, String requestDate,String userID, String roomID) {
		MaintenanceRequest maintenanceRequest=new MaintenanceRequest();
		
		maintenanceRequest.setRequestID(requestID);
		maintenanceRequest.setDescription(description);
		maintenanceRequest.setUserID(userID);
		maintenanceRequest.setRoomID(roomID);
		
		Connection connection=DBConnect.getDatabaseConnection();
		
		try {
			Statement insertStatement=connection.createStatement();
			String insertQuery="INSERT INTO maintenancereq(RequestID,Description,RequestDate,UserID,RoomID)"
					+ "VALUES('"+requestID+"','"+description+"','"+requestDate+"','"+userID+"','"+roomID+"')";
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
		return maintenanceRequest;
	}
	
	//This method updates the request order id
	public void updateRequest(String requestID, String morderID) {
		Connection connection=DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement=connection.createStatement();
			String insertQuery="UPDATE maintenancereq SET MOrderID='"+morderID+"' WHERE RequestID='"+requestID+"'";
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
	}

}
