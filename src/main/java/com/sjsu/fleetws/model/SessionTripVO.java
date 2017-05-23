package com.sjsu.fleetws.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Session_Trip")
public class SessionTripVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int sessionTripId;
	private Timestamp startTime;
	private Timestamp endTime;
	private String startLat;
	private String endLat;
	private String startLong;
	private String endLong;
	private VehicleVO vehicle;
	
	public SessionTripVO() {
		super();
	}
	
	public SessionTripVO(int sessionTripId, Timestamp startTime, Timestamp endTime, String startLat, String endLat,
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "session_trip_id", unique = true, nullable = false)
	public int getSessionTripId() {
		return sessionTripId;
	}
	public void setSessionTripId(int sessionTripId) {
		this.sessionTripId = sessionTripId;
	}
	
	@Column(name="start_time")
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	
	@Column(name="end_time")
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	@Column(name="start_latitude")
	public String getStartLat() {
		return startLat;
	}
	public void setStartLat(String startLat) {
		this.startLat = startLat;
	}
	
	@Column(name="end_latitude")
	public String getEndLat() {
		return endLat;
	}
	public void setEndLat(String endLat) {
		this.endLat = endLat;
	}
	
	@Column(name="start_longitude")
	public String getStartLong() {
		return startLong;
	}
	public void setStartLong(String startLong) {
		this.startLong = startLong;
	}
	
	@Column(name="end_longitude")
	public String getEndLong() {
		return endLong;
	}
	public void setEndLong(String endLong) {
		this.endLong = endLong;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="vehicle_id", nullable=false)
	public VehicleVO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleVO vehicle) {
		this.vehicle = vehicle;
	}
}
