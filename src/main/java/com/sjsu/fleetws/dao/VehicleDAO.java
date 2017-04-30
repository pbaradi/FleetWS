package com.sjsu.fleetws.dao;

import java.util.List;

import com.sjsu.fleetws.model.VehicleVO;

public interface VehicleDAO {
	
	public VehicleVO addVehicle(VehicleVO vehicle);
	public VehicleVO updateVehicle(VehicleVO vehicle);
	public List<VehicleVO> getAllVehicles();

}
