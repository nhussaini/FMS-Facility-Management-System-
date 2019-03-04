package com.fms.dal.facility;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import com.fms.dal.DBConnect;
import com.fms.model.facility.Building;
import com.fms.model.facility.Phone;
import com.fms.model.facility.Room;

public class BuildingDAO {
	
	private PhoneDAO phoneDAO=new PhoneDAO();
	private RoomDAO roomDAO=new RoomDAO();
	
	//insert the data of a building
	 public Building insertBuildingInfo(String facilityID, String facilityName, String address,String city, String state, String zipCode, String type,int capacity, Set<Phone> phones, Set<Room> rooms) {
		 
		 Building building=new Building();
		 
		 building.setFacilityID(facilityID);
		 building.setFacilityName(facilityName);
		 building.setAddress(address);
		 building.setCity(city);
		 building.setState(state);
		 building.setZipCode(zipCode);
		 building.setType(type);
		 building.setCapacity(capacity);
		 building.setPhones(phones);
		 building.setRooms(rooms);
		 
		 Connection connection=DBConnect.getDatabaseConnection();
		  
		 try {
			 Statement insertStatement=connection.createStatement();
			 String insertQuery = "INSERT INTO BUILDING(FacilityID,FacilityName,Address,City,State,ZipCode,Type,Capacity)"
					 +"VALUES('"+facilityID+"','"+facilityName+"','"+address+"','"+city+"','"+state+"','"+zipCode+"','"+type+"','"+capacity+"')";
			 insertStatement.executeUpdate(insertQuery);
			 
			 phoneDAO.insertPhoneInfos(building.getPhones());
			 roomDAO.insertRoomInfos(building.getRooms());
			 
			 
			 
			 
		 }catch(SQLException se) {
				se.printStackTrace();
			}finally {
				if(connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {}
				}
			}
		 return building;
	 }
	 
	 //Remove a facility
	 public void deleteBuilding(String fid) {
		 Connection connection=DBConnect.getDatabaseConnection();
		 
		 try {
			 Statement deleteStatement=connection.createStatement();
			 
			 phoneDAO.deletePhone(fid);
			 roomDAO.deleteRooms(fid);
			 
			 String deleteQuery="DELETE FROM building WHERE FacilityID='"+fid+"'";
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
