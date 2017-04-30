package com.sjsu.fleetws.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Driver")
public class DriverVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int driverId;
	private String name;
	private String email;
	private String password;
	private int mobile;
	private VehicleVO vehicle;
	
	public DriverVO(int driverId, String name, String email, String password, int mobile, VehicleVO vehicle) {
		super();
		this.driverId = driverId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.vehicle = vehicle;
	}
	
	public DriverVO() {
		super();
	}
	
	@Id
    @Column(name = "driver_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="email", nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="password", nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="mobile", nullable=false)
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public VehicleVO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleVO vehicle) {
		this.vehicle = vehicle;
	}
	
	public String toString(){
		return "Name:"+name+" email:"+email+" password:"+password+" mobile:"+mobile;
	}

	
}
