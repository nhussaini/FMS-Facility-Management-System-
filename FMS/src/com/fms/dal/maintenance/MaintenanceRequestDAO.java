package com.fms.dal.maintenance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

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
	
	//Get maintenance Request
	public MaintenanceRequest getMaintenanceRequest(String mrid) {
		String requestID=mrid;
		String description="";
		String requestDate="";
		String userID="";
		String roomID="";
		String mOrderID="";
		
		Connection connection=DBConnect.getDatabaseConnection();
		try {
			Statement selectStatement=connection.createStatement();
			String selectQuery="SELECT * FROM maintenancereq WHERE RequestID='"+mrid+"'";
			ResultSet resultSet=selectStatement.executeQuery(selectQuery);
			
			resultSet.next();
			
			description=resultSet.getString("Description");
			requestDate=resultSet.getString("RequestDate");
			userID=resultSet.getString("UserID");
			roomID=resultSet.getString("RoomID");
			mOrderID=resultSet.getString("MOrderID");
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		MaintenanceRequest maintenanceRequest=new MaintenanceRequest();
		
		maintenanceRequest.setRequestID(requestID);
		maintenanceRequest.setDescription(description);
		maintenanceRequest.setRequestDate(requestDate);
		maintenanceRequest.setUserID(userID);
		maintenanceRequest.setRoomID(roomID);
		maintenanceRequest.setMorderID(mOrderID);
		
		
		return maintenanceRequest;
		
	}
	
	//Get maintenance request by facility id
	public Set<MaintenanceRequest> getMRequestsByRoomID(String roomID){
		Connection connection=DBConnect.getDatabaseConnection();
		
		Set<MaintenanceRequest> requests=new HashSet<>();
		try {
			Statement selectStatement=connection.createStatement();
			String selectQuery="SELECT * FROM maintenancereq where RoomID='"+roomID+"'";
			ResultSet resultSet=selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String requestID=resultSet.getString("RequestID");
				MaintenanceRequest request=getMaintenanceRequest(requestID);
				if(requests!=null) {
					requests.add(request);
				}
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
		return requests;
	}

}
