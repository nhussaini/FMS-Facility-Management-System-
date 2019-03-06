package com.fms.dal.reserveuse;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.fms.dal.DBConnect;
import com.fms.model.reserveuse.Reserve;

public class ReserveDAO {
	
	//Insert reservation
	public Reserve insertReservation(String reserveID, String dateFrom, String dateTo, String userID, String rStatus, String roomID) {
		Reserve reserve=new Reserve();
		
		reserve.setReserveID(reserveID);
		reserve.setDateFrom(dateFrom);
		reserve.setDateTo(dateTo);
		reserve.setUserID(userID);
		reserve.setrStatus(rStatus);
		reserve.setRoomID(roomID);
		
		Connection connection=DBConnect.getDatabaseConnection();
		try{
		Statement insertStatement=connection.createStatement();
		String insertQuery="INSERT INTO reserve(ReserveID,DateFrom, DateTo,UserID,Rstatus,RoomID)"
				+"VALUES('"+reserveID+"','"+dateFrom+"','"+dateTo+"','"+userID+"','"+rStatus+"','"+roomID+"')";
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
		return reserve;
	}

}
