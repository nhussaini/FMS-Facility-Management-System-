package com.fms.dal.reserveuse;

import java.sql.Connection;
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

}
