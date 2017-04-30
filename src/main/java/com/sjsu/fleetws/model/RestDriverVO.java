package com.sjsu.fleetws.model;

public class RestDriverVO {
	
	private int driverId;
	private String name;
	private String email;
	private String password;
	private int mobile;
	private RestVehicleVO vehicle;
	
	public RestDriverVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestDriverVO(int driverId, String name, String email, String password, int mobile, RestVehicleVO vehicle) {
		super();
		this.driverId = driverId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.vehicle = vehicle;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public RestVehicleVO getVehicle() {
		return vehicle;
	}
	public void setVehicle(RestVehicleVO vehicle) {
		this.vehicle = vehicle;
	}
	
	

}
