package com.sjsu.fleetws.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Geofence")
public class GeofenceVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int fenceId;
    private double north;
    private double south;
    private double east;
    private double west;
    private int vehiclesCount;
    
	public GeofenceVO(int fenceId, double north, double south, double east, double west, int vehiclesCount) {
		super();
		this.fenceId = fenceId;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.vehiclesCount = vehiclesCount;
	}
	
	public GeofenceVO(){
		super();
	}
	
	@Id
    @Column(name = "fence_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getFenceId() {
		return fenceId;
	}

	public void setFenceId(int fenceId) {
		this.fenceId = fenceId;
	}

	@Column(name = "north")
	public double getNorth() {
		return north;
	}

	public void setNorth(double north) {
		this.north = north;
	}
	
	@Column(name = "south")
	public double getSouth() {
		return south;
	}

	public void setSouth(double south) {
		this.south = south;
	}
	
	@Column(name = "east")
	public double getEast() {
		return east;
	}

	public void setEast(double east) {
		this.east = east;
	}

	@Column(name = "west")
	public double getWest() {
		return west;
	}

	public void setWest(double west) {
		this.west = west;
	}
	
	@Column(name = "vehicles_count")
	public int getVehiclesCount() {
		return vehiclesCount;
	}

	public void setVehiclesCount(int vehiclesCount) {
		this.vehiclesCount = vehiclesCount;
	}
	
}
