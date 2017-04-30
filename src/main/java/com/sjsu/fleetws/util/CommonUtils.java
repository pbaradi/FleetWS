package com.sjsu.fleetws.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sjsu.fleetws.model.DriverVO;
import com.sjsu.fleetws.model.RestDriverVO;
import com.sjsu.fleetws.model.RestVehicleVO;
import com.sjsu.fleetws.model.VehicleVO;

public class CommonUtils {

	public static VehicleVO vehicleRestVoToVo(RestVehicleVO restVO){
		DriverVO driverVO = null;
		VehicleVO vehicleVO = new VehicleVO(restVO.getVehicleId(),restVO.getLicenceNumber(),restVO.getManufacturer(),restVO.getModel(),restVO.getVehicleType(), driverVO);
		if(restVO.getDriver() != null){
			RestDriverVO driver = restVO.getDriver();
			driverVO = new DriverVO(driver.getDriverId(),driver.getName(),driver.getEmail(),driver.getPassword(),driver.getMobile(),null);
		}
		vehicleVO.setDriver(driverVO);
		return vehicleVO;
	}

	public static RestVehicleVO vehicleVoToRestVo(VehicleVO vehicle){
		RestDriverVO driverVO = null;
		RestVehicleVO restVO = new RestVehicleVO(vehicle.getVehicleId(), vehicle.getLicenceNumber(), vehicle.getManufacturer(), vehicle.getModel(), vehicle.getVehicleType(), driverVO);
		if(vehicle.getDriver() != null){
			driverVO = new RestDriverVO(vehicle.getDriver().getDriverId(), vehicle.getDriver().getName(), vehicle.getDriver().getEmail(), vehicle.getDriver().getPassword(), vehicle.getDriver().getMobile(), null);
		}
		restVO.setDriver(driverVO);
		return restVO;
	}

	public static DriverVO driverRestVoToVo(RestDriverVO restVO){
		RestVehicleVO vehicle = restVO.getVehicle();
		VehicleVO vehicleVO = null;
		DriverVO driverVO = new DriverVO(restVO.getDriverId(), restVO.getName(), restVO.getEmail(), restVO.getPassword(), restVO.getMobile(), vehicleVO);
		if(vehicle != null){
			vehicleVO = new VehicleVO(vehicle.getVehicleId(),vehicle.getLicenceNumber(),vehicle.getManufacturer(),vehicle.getModel(),vehicle.getVehicleType(), null);
		}
		driverVO.setVehicle(vehicleVO);
		return driverVO;
	}

	public static RestDriverVO driverVoToRestVo(DriverVO driver){
		RestVehicleVO vehicleVO = null;
		RestDriverVO restVO = new RestDriverVO(driver.getDriverId(),driver.getName(),driver.getEmail(),driver.getPassword(), driver.getMobile(),vehicleVO);
		VehicleVO vehicle = driver.getVehicle();
		if(vehicle != null)
			vehicleVO = new RestVehicleVO(vehicle.getVehicleId(),vehicle.getLicenceNumber(),vehicle.getManufacturer(),vehicle.getModel(),vehicle.getVehicleType(), null);
		restVO.setVehicle(vehicleVO);
		return restVO;
	}

	public static String getCurrentDate(int hour){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, hour);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = df.format(c.getTime());
		Timestamp ts = Timestamp.valueOf(formattedDate);
		System.out.println(ts);
		return formattedDate;
	}

}
