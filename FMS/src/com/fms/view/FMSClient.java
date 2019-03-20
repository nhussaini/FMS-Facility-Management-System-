package com.fms.view;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fms.model.facility.Building;
import com.fms.model.facility.Phone;
import com.fms.model.facility.Room;
import com.fms.model.facility.service.FacilityService;
import com.fms.model.inspection.Inspection;
import com.fms.model.inspection.service.InspectionService;
import com.fms.model.maintenance.Maintenance;
import com.fms.model.maintenance.MaintenanceOrder;
import com.fms.model.maintenance.MaintenanceRequest;
import com.fms.model.maintenance.MaintenanceSchedule;
import com.fms.model.maintenance.service.MaintenanceService;
import com.fms.model.reserveuse.InUse;
import com.fms.model.reserveuse.Reserve;
import com.fms.model.reserveuse.service.ReserveuseService;
import com.fms.model.user.User;
import com.fms.model.user.service.UserService;

public class FMSClient {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("META-INF/app-context.xml");
		System.out.println("***************** Application Context instantiated! ******************");
		
		System.out.println("Facility creation started");
		
		String facilityID="FA005";
		String phoneID1="PH007";
		String phoneID2="PH008";
		String roomID1="RM007";
		String roomID2="RM008";
		
		Building building=addBuilding(facilityID,phoneID1,phoneID2,roomID1,roomID2, context);
		
		//Making a new user
		String userID="USR2";
		//User user=addUser(userID, context);
		
		//Adding a new inpsection
		String inspectionID="IN3";
		//addInspections(inspectionID,building, context);
		
		//Adding Reservation
		String reserveID="RE1";
		String usageID="US1";
		
		//addReservationUse(reserveID,userID,roomID2,usageID);
		
		//Adding maintenanceRequest
		String requestID="MR1";
		
		//Set<MaintenanceRequest> reqsts = addMainReq(requestID, userID, roomID2);
		
		//Adding maintenance Order
		String morderID="MO1";
		//addMaintOrder(morderID, reqsts);
		
		//add a maintenance schedule
		String scheduleID="SC1";
		
		//addmaintSchedule(scheduleID,morderID);
		
		//Add a maintenance
		String maintenanceID="MN1";
		
		//addMaintenace(maintenanceID, morderID, scheduleID);
		
		//otherMethods(roomID2);
		
		
		
		
		
		

	}
	
	private static Building addBuilding(String facilityID, String phoneID1, String phoneID2, String roomID1, String roomID2, ApplicationContext context) {
		
		//System.out.println("Building FacilityID instance Creation started...");
		System.out.println("Building FacilityID instance Creation started using Spring...");
		FacilityService facilityService=(FacilityService) context.getBean("facilityService");
		//create a facility
		//Building building=new Building();
		Building building=facilityService.getBuilding();
		
		building.setFacilityID(facilityID);
		building.setFacilityName("Main branch");
		building.setAddress("1219 W Columbia Ave");
		building.setCity("Chicago");
		building.setState("IL");
		building.setZipCode("60603");
		building.setType("Office");
		building.setCapacity(50);
		
		//create facility phoneNumber
		
		Set<Phone> phones=new HashSet<>();
		//Phone phone=new Phone();
		Phone phone=(Phone) context.getBean("phone");
		phone.setPhoneID(phoneID1);
		phone.setDescription("IT Room No.");
		phone.setPhoneNumber("111");
		phones.add(phone);
		
		phone=new Phone();
		phone.setPhoneID(phoneID2);
		phone.setDescription("Kitchen No.");
		phone.setPhoneNumber("222");
		phones.add(phone);
		
		building.setPhones(phones);
		System.out.println("Building facility phones created");
		
		
		//create rooms inside the building
		Set<Room> rooms=new HashSet<>();
		//Room room=new Room();
		Room room= (Room) context.getBean("room");
		room.setRoomID(roomID1);
		room.setType("Seminar");
		rooms.add(room);
		
		room=new Room();
		room.setRoomID(roomID2);
		room.setType("Training room");
		rooms.add(room);
		building.setRooms(rooms);
		System.out.println("Building rooms created");
		
		//FacilityService fService=new FacilityService();
		facilityService.addBuilding(building);
		
		System.out.println("Facility data inserted successfully");
		
		//System.out.println("the building is successfully removed? "+fService.removeFacility("FA0001"));
		return building;
			
	}
	
	private static User addUser(String userID, ApplicationContext context) {
		System.out.println("Adding a new user");
		//User user=new User();
		UserService userService=(UserService) context.getBean("userService");
		User user=userService.getUser();
		
		user.setUserID(userID);
		user.setName("Mohd");
		user.setPhoneNumber("5555");
		user.setAddress("1219 W Columbia Ave");
		user.setTypeOfUser("Manager");
		
		//UserService userService=new UserService();
		userService.addUser(user);
		return user;
		
	}
	
	private static void addInspections(String inspectionID, Building building, ApplicationContext context) {
		InspectionService inspectionService=(InspectionService) context.getBean("inspectionService");
		Inspection inspection=inspectionService.getInspection();
		
		Set<Inspection> inspections=new HashSet<>();
		
		//Inspection inspection=new Inspection();
		Building iBuilding=inspection.getBuilding();
		iBuilding=building;
		
		inspection.setInspectionID(inspectionID);
		inspection.setDateFrom("2019/03/19");
		inspection.setDateTo("2019/03/22");
		inspection.setFacilityID(iBuilding.getFacilityID());
		inspection.setInspectionType("bathroom");
		inspection.setBuilding(iBuilding);
		inspection.setInspectedBy("Ali");
		
		inspections.add(inspection);
		
		inspectionService.addInspections(inspections);
		System.out.println("inspection added");
		
		//List inspections
//		System.out.println("list of inspections: ");
//		Set<Inspection> listinspections=iService.listInspections();
//		for(Inspection i:listinspections) {
//			System.out.println("InspectionID: "+i.getInspectionID());
//			System.out.println("InpsectionType: "+i.getInspectionType());
//		}
		
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
		//mService.addMaintenanceRequest(request);
		
		System.out.println("MaintenanceRequest added");
		return requests;
	}
	
	public static void addMaintOrder(String morderID, Set<MaintenanceRequest> requests) {
		MaintenanceOrder morder=new MaintenanceOrder();
		morder.setMorderID(morderID);
		morder.setOrderDate("2019/03/06");
		morder.setmStatus("filled");
		morder.setMaintRequests(requests);
		
		MaintenanceService mService=new MaintenanceService();
		//mService.addMaintenanceOrder(morder);
		
		for(MaintenanceRequest r:requests) {
			mService.UpdateRequest(r.getRequestID(),morderID);
		}
		
	}
	
	//adding maintenance schedule
	public static void addmaintSchedule(String scheduleID, String morderID) {
		
		MaintenanceSchedule schedule=new MaintenanceSchedule();
		
		schedule.setScheduleID(scheduleID);
		schedule.setDateFrom("2019/03/07");
		schedule.setDateTo("2019/03/08");
		schedule.setMorderID(morderID);
		
		MaintenanceService mService=new MaintenanceService();
		mService.addMaintenanceSchedule(schedule);
		
		
		
	}
	
	//adding a maintenance
	public static void addMaintenace(String maintenanceID, String morderID, String scheduleID) {
		
		Maintenance maintenance=new Maintenance();
		
		maintenance.setMaintenanceID(maintenanceID);
		maintenance.setType("Engineering");
		maintenance.setMaintenanceStart("2019/03/07");
		maintenance.setMaintenanceEnd("2019/03/07");
		maintenance.setCost(100.75);
		maintenance.setSStatus("In progess");
		maintenance.setScheduleID(scheduleID);
		maintenance.setMOrderID(morderID);
		
		MaintenanceService mService= new MaintenanceService();
		mService.addMaintenace(maintenance);
		System.out.println("maintenance added");
		
	}
	
	public static void otherMethods(String roomID2) {
		MaintenanceService mService=new MaintenanceService();
		System.out.println("Total Cost of the Facility: " + mService.maintenanceCostForFacility(roomID2));
	}

}
