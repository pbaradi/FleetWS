package com.sjsu.fleetws.model;

import java.util.Set;

public class RestVehicleVO {
	
	private int vehicleId;
	private String licenceNumber;
	private String manufacturer;
	private String model;
	private String vehicleType;
	private String deviceId;
	private RestDriverVO driver;
	private Set<RestSessionTripVO> sessionTripVOs;
	
	public RestVehicleVO() {
		super();
	}
	public RestVehicleVO(int vehicleId, String licenceNumber, String manufacturer, String model, String vehicleType,
			String deviceId, RestDriverVO driver) {
		super();
		this.vehicleId = vehicleId;
		this.licenceNumber = licenceNumber;
		this.manufacturer = manufacturer;
		this.model = model;
		this.vehicleType = vehicleType;
		this.deviceId = deviceId;
		this.driver = driver;
	}
	
	public RestVehicleVO(int vehicleId, String licenceNumber, String manufacturer, String model, String vehicleType,
			String deviceId, RestDriverVO driver, Set<RestSessionTripVO> sessionTripVOs) {
		super();
		this.vehicleId = vehicleId;
		this.licenceNumber = licenceNumber;
		this.manufacturer = manufacturer;
		this.model = model;
		this.vehicleType = vehicleType;
		this.deviceId = deviceId;
		this.driver = driver;
		this.sessionTripVOs = sessionTripVOs;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getLicenceNumber() {
		return licenceNumber;
	}
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public RestDriverVO getDriver() {
		return driver;
	}
	public void setDriver(RestDriverVO driver) {
		this.driver = driver;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public Set<RestSessionTripVO> getSessionTripVOs() {
		return sessionTripVOs;
	}
	public void setSessionTripVOs(Set<RestSessionTripVO> sessionTripVOs) {
		this.sessionTripVOs = sessionTripVOs;
	}
	
	

}
