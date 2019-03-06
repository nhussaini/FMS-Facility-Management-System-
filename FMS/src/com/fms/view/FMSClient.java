package com.fms.view;

import java.util.HashSet;
import java.util.Set;


import com.fms.model.facility.Building;
import com.fms.model.facility.Phone;
import com.fms.model.facility.Room;
import com.fms.model.facility.service.FacilityService;
import com.fms.model.inspection.Inspection;
import com.fms.model.inspection.service.InspectionService;
import com.fms.model.maintenance.MaintenanceRequest;
import com.fms.model.maintenance.service.MaintenanceService;
import com.fms.model.reserveuse.InUse;
import com.fms.model.reserveuse.Reserve;
import com.fms.model.reserveuse.service.ReserveuseService;
import com.fms.model.user.User;
import com.fms.model.user.service.UserService;

public class FMSClient {

	public static void main(String[] args) {
		System.out.println("Facility creation started");
		
		String facilityID="FA001";
		String phoneID1="PH001";
		String phoneID2="PH002";
		String roomID1="RM001";
		String roomID2="RM002";
		
		//addBuilding(facilityID,phoneID1,phoneID2,roomID1,roomID2);
		
		//Making a new user
		String userID="USR1";
		//addUser(userID);
		
		//Adding a new inpsection
		String inspectionID="IN2";
		//addInspection(inspectionID,userID,facilityID);
		
		//Adding Reservation
		String reserveID="RE1";
		String usageID="US1";
		
		addReservationUse(reserveID,userID,roomID2,usageID);
		
		//Adding maintenanceRequest
		String requestID="MR1";
		
		Set<MaintenanceRequest> reqsts = addMainReq(requestID, userID, roomID2);
		
		
		
		
		

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
	
	private static void addInspection(String inspectionID, String userID, String facilityID) {
		Set<Inspection> inspections=new HashSet<>();
		
		Inspection inspection=new Inspection();
		
		inspection.setInspectionID(inspectionID);
		inspection.setDateFrom("2019/04/04");
		inspection.setDateTo("2019/04/11");
		inspection.setUserID(userID);
		inspection.setFacilityID(facilityID);
		inspection.setInspectionType("bathroom");
		
		inspections.add(inspection);
		
		InspectionService iService=new InspectionService();
		iService.addInspections(inspections);
		System.out.println("inspection added");
		
		//List inspections
		System.out.println("list of inspections: ");
		Set<Inspection> listinspections=iService.listInspections();
		for(Inspection i:listinspections) {
			System.out.println("InspectionID: "+i.getInspectionID());
			System.out.println("InpsectionType: "+i.getInspectionType());
		}
		
	}
	
	//Adding a reservation
	private static void addReservationUse(String reserveID,String userID,String roomID2,String usageID) {
		//Reserve reserve=new Reserve();
		
		//reserve.setReserveID(reserveID);
		//reserve.setDateFrom("2019/04/05");
		//reserve.setDateTo("2019/04/10");
		//reserve.setUserID(userID);
		//reserve.setRoomID(roomID2);
		//reserve.setrStatus("reserved");
		
		ReserveuseService ruService=new ReserveuseService();
		//ruService.addReservation(reserve);
		
		//InUse inUse=new InUse();
		
		//inUse.setUsageID(usageID);
		//inUse.setReserveID(reserveID);
		//inUse.setRoomID(roomID2);
		//inUse.setUserID(userID);
		//inUse.setrStatus("occupied");
		//inUse.setUsedInInterval(0);
		//ruService.assingFacilityToUse(inUse);
		//System.out.println("Reserve and Use happened");
		
		System.out.println("Facility Used In Interval: 0-false 1-true ");
		System.out.println(ruService.getFacilityIntervalUsage(roomID2));
		
		System.out.println("Facility Actual Usage: UsageIS's ");
		System.out.println(ruService.getActualFacilityUsage(roomID2).getUsageID());
		
		System.out.println("facility vacated");
		ruService.vacateFacility(roomID2);
		
	}
	
	public static Set<MaintenanceRequest> addMainReq(String requestID, String userID, String roomID2){
		
		MaintenanceRequest request=new MaintenanceRequest();
		
		Set<MaintenanceRequest> requests=new HashSet<>();
		
		request.setRequestID(requestID);
		request.setDescription("bathroom shower");
		request.setRequestDate("2019/03/06");
		request.setUserID(userID);
		request.setRoomID(roomID2);
		
		requests.add(request);
		
		MaintenanceService mService=new MaintenanceService();
		mService.addMaintenanceRequest(request);
		
		System.out.println("MaintenanceRequest added");
		return requests;
		
		
		
		
		
	}

}
