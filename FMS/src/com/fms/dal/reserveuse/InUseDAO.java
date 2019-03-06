package com.fms.dal.reserveuse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fms.dal.DBConnect;
import com.fms.model.reserveuse.InUse;

public class InUseDAO {
	//Add facility usage
	public InUse insertInUse(String usageID, String rStatus, String reserveID, String roomID, String userID, int usedInInterval) {
		
		InUse inUse=new InUse();
		
		inUse.setUsageID(usageID);
		inUse.setrStatus(rStatus);
		inUse.setReserveID(reserveID);
		inUse.setRoomID(roomID);
		inUse.setUserID(userID);
		inUse.setUsedInInterval(usedInInterval);
		
		Connection connection=DBConnect.getDatabaseConnection();
		
		try {
			Statement insertStatement=connection.createStatement();
			String insertQuery="INSERT INTO inuse(UsageID,Rstatus,ReserveID,RoomID,UserID,UsedInInterval)"
					+"VALUES('"+usageID+"','"+rStatus+"','"+reserveID+"','"+roomID+"','"+userID+"','"+usedInInterval+"')";
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
		return inUse;
		
	}
	
	public int getFacilityIntervalUsage(String rid) {
		Connection connection=DBConnect.getDatabaseConnection();
		try {
			Statement selectStatement=connection.createStatement();
			String selectQuery="SELECT * FROM inuse where RoomID='"+rid+"'";
			ResultSet resultSet=selectStatement.executeQuery(selectQuery);
			resultSet.next();
			int usedInInterval=resultSet.getInt("UsedInInterval");
			return usedInInterval;
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		return 0;
	}
	
	//List actual facility usage
	public InUse getActualFacilityUsage(String rid) {
		String usageID="";
		String rStatus="";
		String reserveID="";
		String roomID=rid;
		String userID="";
		int usedInInterval=0;
		
		Connection connection=DBConnect.getDatabaseConnection();
		try {
			Statement selectStatement=connection.createStatement();
			String selectQuery="SELECT * FROM inuse WHERE RoomID='"+rid+"'";
			ResultSet resultSet=selectStatement.executeQuery(selectQuery);
			resultSet.next();
			
			usageID=resultSet.getString("UsageID");
			rStatus=resultSet.getString("Rstatus");
			reserveID=resultSet.getString("ReserveID");
			userID=resultSet.getString("UserID");
			usedInInterval=resultSet.getInt("UsedInInterval");
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		InUse inUse=new InUse();
		
		inUse.setUsageID(usageID);
		inUse.setrStatus(rStatus);
		inUse.setReserveID(reserveID);
		inUse.setRoomID(roomID);
		inUse.setUserID(userID);
		inUse.setUsedInInterval(usedInInterval);
		
		return inUse;
	}
	
	//Vacate facility
	public void vacateFacility(String rid) {
		String status="vacant";
		Connection connection=DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement=connection.createStatement();
			String updateQuery="UPDATE inuse SET Rstatus='"+status+"' WHERE RoomID='"+rid+"'";
			updateStatement.executeUpdate(updateQuery);
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
