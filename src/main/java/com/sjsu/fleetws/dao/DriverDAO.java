package com.sjsu.fleetws.dao;

import java.util.List;

import com.sjsu.fleetws.model.DriverVO;

public interface DriverDAO {
	
	public DriverVO addDriver(DriverVO driver);
	public DriverVO updateDriver(DriverVO driver);
	public List<DriverVO> getAllDrivers();

}
