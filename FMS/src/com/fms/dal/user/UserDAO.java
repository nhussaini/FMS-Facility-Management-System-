package com.fms.dal.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.fms.dal.DBConnect;
import com.fms.model.user.User;

public class UserDAO {
	
	public User insertUser(String userID, String name, String phoneNumber, String address, String typeOfUser) {
		
		User user=new User();
		
		user.setUserID(userID);
		user.setName(name);
		user.setPhoneNumber(phoneNumber);
		user.setAddress(address);
		user.setTypeOfUser(typeOfUser);
		
		Connection connection=DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement=connection.createStatement();
			
			String insertQuery="INSERT INTO user(UserID,Name,PhoneNumber,Address,TypeOfUser)"+
			"VALUES('"+userID+"','"+name+"','"+phoneNumber+"','"+address+"','"+typeOfUser+"')";
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
		return user;
		
	}
}
