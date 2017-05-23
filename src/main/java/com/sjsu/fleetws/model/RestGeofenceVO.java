package com.sjsu.fleetws.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

public class RestGeofenceVO {
	
	private int fenceId;
    private double north;
    private double south;
    private double east;
    private double west;
	private List<Link> links = new ArrayList<Link>();
	
	public RestGeofenceVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestGeofenceVO(int fenceId, double north, double south, double east, double west) {
		super();
		this.fenceId = fenceId;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}
	
	public int getFenceId() {
		return fenceId;
	}
	public void setFenceId(int fenceId) {
		this.fenceId = fenceId;
	}
	public double getNorth() {
		return north;
	}
	public void setNorth(double north) {
		this.north = north;
	}
	public double getSouth() {
		return south;
	}
	public void setSouth(double south) {
		this.south = south;
	}
	public double getEast() {
		return east;
	}
	public void setEast(double east) {
		this.east = east;
	}
	public double getWest() {
		return west;
	}
	public void setWest(double west) {
		this.west = west;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
