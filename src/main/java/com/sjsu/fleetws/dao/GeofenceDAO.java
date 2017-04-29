package com.sjsu.fleetws.dao;

import java.util.List;

import com.sjsu.fleetws.model.GeofenceVO;

public interface GeofenceDAO {

	public GeofenceVO saveGeofence(GeofenceVO gf);
	public GeofenceVO updateGeofence(GeofenceVO gf);
	public List<GeofenceVO> getAllGeofences();

}
