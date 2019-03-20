package com.fms.dal.facility;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

import com.fms.dal.DBConnect;
import com.fms.model.facility.Room;

public class RoomDAO {
	
	public Set<Room> insertRoomInfos(Set<Room> rooms,String facilityID){
		Connection connection=DBConnect.getDatabaseConnection();
		
		try {
			Statement insertStatement=connection.createStatement();
			Iterator<Room> roomIterator=rooms.iterator();
			
			while(roomIterator.hasNext()) {
				Room currentRoom=roomIterator.next();
				
				String insertQuery="INSERT INTO room(RoomID,RoomType,FacilityID)"
						+"VALUES('"+currentRoom.getRoomID()+"','"+currentRoom.getType()+"','"+facilityID+"')";
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
		return rooms;
	}
	
	//remove the rooms of a building
	public void deleteRooms(String fid) {
		Connection connection=DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement=connection.createStatement();
			
			String deleteQuery="DELETE FROM room WHERE FacilityID='"+fid+"'";
			deleteStatement.executeUpdate(deleteQuery);
			
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
