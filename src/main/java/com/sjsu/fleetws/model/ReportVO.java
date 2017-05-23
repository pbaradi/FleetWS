package com.sjsu.fleetws.model;

import java.util.List;

public class ReportVO {
	
	private Long vehicleCount;
	private Long driverCount;
	private int geofenceCount;
	private List<GeofenceVO> geofences;
	
	public ReportVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportVO(Long vehicleCount, Long driverCount, int geofenceCount, List<GeofenceVO> geofences) {
		super();
		this.vehicleCount = vehicleCount;
		this.driverCount = driverCount;
		this.geofenceCount = geofenceCount;
		this.geofences = geofences;
	}
	public Long getVehicleCount() {
		return vehicleCount;
	}
	public void setVehicleCount(Long vehicleCount) {
		this.vehicleCount = vehicleCount;
	}
	public Long getDriverCount() {
		return driverCount;
	}
	public void setDriverCount(Long driverCount) {
		this.driverCount = driverCount;
	}
	public int getGeofenceCount() {
		return geofenceCount;
	}
	public void setGeofenceCount(int geofenceCount) {
		this.geofenceCount = geofenceCount;
	}
	public List<GeofenceVO> getGeofences() {
		return geofences;
	}
	public void setGeofences(List<GeofenceVO> geofences) {
		this.geofences = geofences;
	}
}
