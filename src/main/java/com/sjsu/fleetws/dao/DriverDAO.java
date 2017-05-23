package com.sjsu.fleetws.dao;

import java.util.List;

import com.sjsu.fleetws.model.DriverVO;

public interface DriverDAO {
	
	public DriverVO addDriver(DriverVO driver);
	public DriverVO updateDriver(DriverVO driver);
	public List<DriverVO> getAllDrivers();
	public DriverVO login(String email, String password);
	public Long getDriverCount();
	public List<DriverVO> addDrivers(List<DriverVO> drivers);
}
