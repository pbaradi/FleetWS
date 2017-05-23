package com.sjsu.fleetws.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle")
public class VehicleVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int vehicleId;
	private String licenceNumber;
	private String manufacturer;
	private String model;
	private String vehicleType;
	private String deviceId;
	private DriverVO driver;
	private Set<SessionTripVO> sessionTripVOs;
	
	public VehicleVO() {
		super();
	}
	
	public VehicleVO(int vehicleId, String licenceNumber, String manufacturer, String model, String vehicleType, String deviceId, DriverVO driver) {
		super();
		this.vehicleId = vehicleId;
		this.licenceNumber = licenceNumber;
		this.manufacturer = manufacturer;
		this.model = model;
		this.vehicleType = vehicleType;
		this.deviceId = deviceId;
		this.driver = driver;
	}
	
	@Id
    @Column(name = "vehicle_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	@Column(name="licence", nullable=false)
	public String getLicenceNumber() {
		return licenceNumber;
	}
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	
	@Column(name="manufacturer")
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Column(name="model")
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@Column(name="vehicle_type")
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@OneToOne(mappedBy = "vehicle", cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	public DriverVO getDriver() {
		return driver;
	}

	public void setDriver(DriverVO driver) {
		this.driver = driver;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle", cascade=CascadeType.ALL)
	public Set<SessionTripVO> getSessionTripVOs() {
		return sessionTripVOs;
	}

	public void setSessionTripVOs(Set<SessionTripVO> sessionTripVOs) {
		this.sessionTripVOs = sessionTripVOs;
	}

	@Column(name="device_id")
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}
