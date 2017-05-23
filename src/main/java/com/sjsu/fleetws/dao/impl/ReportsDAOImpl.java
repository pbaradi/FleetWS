package com.sjsu.fleetws.dao.impl;

import java.util.List;

import com.sjsu.fleetws.dao.GeofenceDAO;
import com.sjsu.fleetws.dao.ReportsDAO;
import com.sjsu.fleetws.model.GeofenceVO;
import com.sjsu.fleetws.model.ReportVO;

public class ReportsDAOImpl implements ReportsDAO {

	@Override
	public ReportVO getReports() {
		ReportVO reportVO = new ReportVO();
		GeofenceDAO dao = new GeofenceDAOImpl();
		reportVO.setDriverCount(new DriverDAOImpl().getDriverCount());
		reportVO.setVehicleCount(new VehicleDAOImpl().getVehicleCount());
		List<GeofenceVO> l = dao.getAllGeofences();
		reportVO.setGeofences(l);
		reportVO.setGeofenceCount(l.size());
		return reportVO;
	}

}
