package com.fms.dal.maintenance;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.fms.dal.DBConnect;
import com.fms.model.maintenance.MaintenanceOrder;

public class MaintenanceOrderDAO {
	
	public MaintenanceOrder insertMaintenanceOrder(String morderID, String orderDate, String mStatus) {
		
		MaintenanceOrder maintenanceOrder=new MaintenanceOrder();
		maintenanceOrder.setMorderID(morderID);
		maintenanceOrder.setOrderDate(orderDate);
		maintenanceOrder.setmStatus(mStatus);
		
		Connection connection=DBConnect.getDatabaseConnection();
		
		try {
			Statement insertStatement=connection.createStatement();
			String insertQuery="INSERT INTO maintenanceorder(MOrderID,Orderdate,MStatus)"
					+ "Values('"+morderID+"','"+orderDate+"','"+mStatus+"')";
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
		return maintenanceOrder;
	}

}
