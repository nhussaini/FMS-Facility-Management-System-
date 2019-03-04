package com.fms.dal.facility;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

import com.fms.dal.DBConnect;
import com.fms.model.facility.Phone;

public class PhoneDAO {
	
	public Set<Phone> insertPhoneInfos(Set<Phone> phones){
		Connection connection=DBConnect.getDatabaseConnection();
		try {
			
		Statement insertStatement=connection.createStatement();
		Iterator<Phone> phoneIterator=phones.iterator();
		
		while(phoneIterator.hasNext()) {
			Phone currentPhone=phoneIterator.next();
			String insertQury="INSERT INTO phone(PhoneID, PhoneNumber,Description,FacilityID)"
					+"VALUES('"+currentPhone.getPhoneID()+"','"+currentPhone.getPhoneNumber()+"','"+currentPhone.getDescription()+"','"+currentPhone.getFacilityID()+"')";
		insertStatement.executeUpdate(insertQury);  
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
		return phones;	
	}
	
	public void deletePhone(String fid){
		Connection connection=DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement=connection.createStatement();
			String deleteQuery="DELETE FROM phone WHERE FacilityID='"+fid+"'";
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
