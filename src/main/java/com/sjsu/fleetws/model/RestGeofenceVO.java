package com.sjsu.fleetws.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

public class RestGeofenceVO {
	
	private int fenceId;
    private double gLat;
    private double gLng;
    private double radius;
	private List<Link> links = new ArrayList<Link>();
	
	public RestGeofenceVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestGeofenceVO(int fenceId, double gLat, double gLng, double radius) {
		super();
		this.fenceId = fenceId;
		this.gLat = gLat;
		this.gLng = gLng;
		this.radius = radius;
	}
	
	public int getFenceId() {
		return fenceId;
	}
	public void setFenceId(int fenceId) {
		this.fenceId = fenceId;
	}
	public double getgLat() {
		return gLat;
	}
	public void setgLat(double gLat) {
		this.gLat = gLat;
	}
	public double getgLng() {
		return gLng;
	}
	public void setgLng(double gLng) {
		this.gLng = gLng;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
