package com.sjsu.fleetws.model;

public class RestVehicleVO {
	
	private int vehicleId;
	private String licenceNumber;
	private String manufacturer;
	private String model;
	private String vehicleType;
	private RestDriverVO driver;
	
	public RestVehicleVO() {
		super();
	}
	public RestVehicleVO(int vehicleId, String licenceNumber, String manufacturer, String model, String vehicleType,
			RestDriverVO driver) {
		super();
		this.vehicleId = vehicleId;
		this.licenceNumber = licenceNumber;
		this.manufacturer = manufacturer;
		this.model = model;
		this.vehicleType = vehicleType;
		this.driver = driver;
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

}
