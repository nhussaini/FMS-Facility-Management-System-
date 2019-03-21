package com.fms.model.reserveuse;

import com.fms.model.facility.Room;

public interface IInUse {
	public String getUsageID();
	public void setUsageID(String usageID);
	public String getrStatus();
	public void setrStatus(String rStatus);
	public int getUsedInInterval();
	public void setUsedInInterval(int usedInInterval);
	public Room getRoom();
	public void setRoom(Room room);
	

}
