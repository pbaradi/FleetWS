package com.sjsu.fleetws.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.sjsu.fleetws.dao.VehicleLogDAO;
import com.sjsu.fleetws.model.VehicleLogVO;
import com.sjsu.fleetws.util.Constants;

public class VehicleLogDAOImpl implements VehicleLogDAO {
	
	private Cluster cluster;
	private Session session;

	private void getInstance(){
		cluster = Cluster.builder().addContactPoint(Constants.CASSANDRA_ADDRESS).build();
		session = cluster.connect(Constants.CASSANDRA_KEYSPACE);
	}
	
	@Override
	public List<VehicleLogVO> getVehicleLog(){
		List<VehicleLogVO> vehicleLogs = new ArrayList<>();
		getInstance();
		ResultSet results = session.execute("select * from fleetapp_vehicle_log");
		for (Row row : results) {
			vehicleLogs.add(new VehicleLogVO(row.getString("vehicle_log_rpm"), row.getString("vehicle_log_speed"), row.getDouble("vehicle_log_latitude"), row.getDouble("vehicle_log_longitude"), row.getTimestamp("vehicle_log_time").toString(), row.getString("vehicle_log_vehicle_id"), row.getString("vehicle_log_fuel_level"), row.getString("vehicle_log_oil_level"), row.getString("vehicle_log_temperature"), row.getString("vehicle_log_miles"), row.getString("vehicle_log_mileage"), row.getString("vehicle_log_engine_coolant_temp")));
			//System.out.format("%s %f %f\n", row.getString("vehicle_log_vehicle_id"), row.getDouble("vehicle_log_latitude"), row.getDouble("vehicle_log_longitude"));
		}
		close();
		return vehicleLogs;
	}
	
	private void close(){
		session.close();
		cluster.close();
	}

}
