package com.sjsu.fleetws.model;

import java.sql.Timestamp;

public class RestSessionTripVO {
	
	private int sessionTripId;
	private Timestamp startTime;
	private Timestamp endTime;
	private String startLat;
	private String endLat;
	private String startLong;
	private String endLong;
	private RestVehicleVO vehicle;
	
	
	
	public RestSessionTripVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestSessionTripVO(int sessionTripId, Timestamp startTime, Timestamp endTime, String startLat, String endLat,
			String startLong, String endLong) {
		super();
		this.sessionTripId = sessionTripId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startLat = startLat;
		this.endLat = endLat;
		this.startLong = startLong;
		this.endLong = endLong;
	}
	public int getSessionTripId() {
		return sessionTripId;
	}
	public void setSessionTripId(int sessionTripId) {
		this.sessionTripId = sessionTripId;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getStartLat() {
		return startLat;
	}
	public void setStartLat(String startLat) {
		this.startLat = startLat;
	}
	public String getEndLat() {
		return endLat;
	}
	public void setEndLat(String endLat) {
		this.endLat = endLat;
	}
	public String getStartLong() {
		return startLong;
	}
	public void setStartLong(String startLong) {
		this.startLong = startLong;
	}
	public String getEndLong() {
		return endLong;
	}
	public void setEndLong(String endLong) {
		this.endLong = endLong;
	}
	public RestVehicleVO getVehicle() {
		return vehicle;
	}
	public void setVehicle(RestVehicleVO vehicle) {
		this.vehicle = vehicle;
	}
	
	

}
