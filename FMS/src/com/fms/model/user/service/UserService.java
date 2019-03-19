package com.fms.model.user.service;

import com.fms.dal.user.UserDAO;
import com.fms.model.user.User;

public class UserService {
	private User user;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private UserDAO userDAO=new UserDAO();
	
	//Insert a new user
	public void addUser(User user) {
		
		try {
			userDAO.insertUser(user.getUserID(), user.getName(), user.getPhoneNumber(), user.getAddress(), user.getTypeOfUser());
		} catch (Exception se) {
		      System.err.println("FacilityUserService: Threw a Exception adding User.");
		      System.err.println(se.getMessage());
		    }
	}
	

}
