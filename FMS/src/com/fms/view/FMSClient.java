package com.fms.view;

import java.util.HashSet;
import java.util.Set;

import com.fms.model.facility.Building;
import com.fms.model.facility.Phone;
import com.fms.model.facility.Room;
import com.fms.model.facility.service.FacilityService;
import com.fms.model.user.User;
import com.fms.model.user.service.UserService;

public class FMSClient {

	public static void main(String[] args) {
		System.out.println("Facility creation started");
		
		//String facilityID="FA001";
		//String phoneID1="PH001";
		//String phoneID2="PH002";
		//String roomID1="RM001";
		//String roomID2="RM002";
		
		//addBuilding(facilityID,phoneID1,phoneID2,roomID1,roomID2);
		String userID="USR1";
		addUser(userID);
		
		

	}
	
	private static void addBuilding(String facilityID, String phoneID1, String phoneID2, String roomID1, String roomID2) {
		
		System.out.println("Building FacilityID instance Creation started...");
		//create a facility
		Building building=new Building();
		
		building.setFacilityID(facilityID);
		building.setFacilityName("Branch");
		building.setAddress("1804 South Ave.");
		building.setCity("Wheathon");
		building.setState("IL");
		building.setZipCode("60603");
		building.setType("Office");
		building.setCapacity(20);
		
		//create facility phoneNumber
		
		Set<Phone> phones=new HashSet<>();
		Phone phone=new Phone();
		phone.setPhoneID(phoneID1);
		phone.setDescription("VP office phone number");
		phone.setPhoneNumber("123");
		phone.setFacilityID(building.getFacilityID());
		phones.add(phone);
		
		phone=new Phone();
		phone.setPhoneID(phoneID2);
		phone.setDescription("Reception phone number");
		phone.setPhoneNumber("456");
		phone.setFacilityID(building.getFacilityID());
		phones.add(phone);
		
		building.setPhones(phones);
		System.out.println("Building facility phones created");
		
		
		//create rooms inside the building
		Set<Room> rooms=new HashSet<>();
		Room room=new Room();
		room.setRoomID(roomID1);
		room.setType("Conference");
		room.setFacilityID(building.getFacilityID());
		rooms.add(room);
		
		room=new Room();
		room.setRoomID(roomID2);
		room.setType("Training room");
		room.setFacilityID(building.getFacilityID());
		rooms.add(room);
		building.setRooms(rooms);
		System.out.println("Building rooms created");
		
		FacilityService fService=new FacilityService();
		fService.addBuilding(building);
		
		System.out.println("Facility data inserted successfully");
		
		System.out.println("the building is successfully removed? "+fService.removeFacility("FA0001"));
			
	}
	
	private static void addUser(String userID) {
		System.out.println("Adding a new user");
		User user=new User();
		
		user.setUserID(userID);
		user.setName("Nasr");
		user.setPhoneNumber("12345");
		user.setAddress("1219 W Columbia Ave");
		user.setTypeOfUser("Employee");
		
		UserService userService=new UserService();
		userService.addUser(user);
		
	}

}