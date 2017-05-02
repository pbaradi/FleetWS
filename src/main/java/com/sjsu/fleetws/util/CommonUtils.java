package com.sjsu.fleetws.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import com.sjsu.fleetws.model.DriverVO;
import com.sjsu.fleetws.model.RestDriverVO;
import com.sjsu.fleetws.model.RestSessionTripVO;
import com.sjsu.fleetws.model.RestVehicleVO;
import com.sjsu.fleetws.model.SessionTripVO;
import com.sjsu.fleetws.model.VehicleVO;

public class CommonUtils {

	public static VehicleVO vehicleRestVoToVo(RestVehicleVO restVO){
		DriverVO driverVO = null;
		VehicleVO vehicleVO = new VehicleVO(restVO.getVehicleId(),restVO.getLicenceNumber(),restVO.getManufacturer(),restVO.getModel(),restVO.getVehicleType(), restVO.getDeviceId(),  driverVO);
		if(restVO.getDriver() != null){
			RestDriverVO driver = restVO.getDriver();
			driverVO = new DriverVO(driver.getDriverId(),driver.getName(),driver.getEmail(),driver.getPassword(),driver.getMobile(),null);
		}
		vehicleVO.setDriver(driverVO);
		
		if(restVO.getSessionTripVOs()!=null && restVO.getSessionTripVOs().size()>0){
			Set<SessionTripVO> tripVOs = new HashSet<>();
			for (RestSessionTripVO tripVO : restVO.getSessionTripVOs()) {
				tripVOs.add(tripRestVoToVo(tripVO));
			}
			vehicleVO.setSessionTripVOs(tripVOs);
		}
		return vehicleVO;
	}

	public static RestVehicleVO vehicleVoToRestVo(VehicleVO vehicle){
		RestDriverVO driverVO = null;
		RestVehicleVO restVO = new RestVehicleVO(vehicle.getVehicleId(), vehicle.getLicenceNumber(), vehicle.getManufacturer(), vehicle.getModel(), vehicle.getVehicleType(),vehicle.getDeviceId(), driverVO);
		if(vehicle.getDriver() != null){
			driverVO = new RestDriverVO(vehicle.getDriver().getDriverId(), vehicle.getDriver().getName(), vehicle.getDriver().getEmail(), vehicle.getDriver().getPassword(), vehicle.getDriver().getMobile(), null);
		}
		restVO.setDriver(driverVO);
		if(vehicle.getSessionTripVOs()!=null && vehicle.getSessionTripVOs().size()>0){
			Set<RestSessionTripVO> tripVOs = new HashSet<>();
			for (SessionTripVO tripVO : vehicle.getSessionTripVOs()) {
				tripVOs.add(tripVoToRestVo(tripVO));
			}
			restVO.setSessionTripVOs(tripVOs);
		}
		return restVO;
	}

	public static DriverVO driverRestVoToVo(RestDriverVO restVO){
		RestVehicleVO vehicle = restVO.getVehicle();
		VehicleVO vehicleVO = null;
		DriverVO driverVO = new DriverVO(restVO.getDriverId(), restVO.getName(), restVO.getEmail(), restVO.getPassword(), restVO.getMobile(), vehicleVO);
		if(vehicle != null){
			vehicleVO = new VehicleVO(vehicle.getVehicleId(),vehicle.getLicenceNumber(),vehicle.getManufacturer(),vehicle.getModel(),vehicle.getVehicleType(), vehicle.getDeviceId(), null);
		}
		driverVO.setVehicle(vehicleVO);
		return driverVO;
	}

	public static RestDriverVO driverVoToRestVo(DriverVO driver){
		RestVehicleVO vehicleVO = null;
		RestDriverVO restVO = new RestDriverVO(driver.getDriverId(),driver.getName(),driver.getEmail(),driver.getPassword(), driver.getMobile(),vehicleVO);
		VehicleVO vehicle = driver.getVehicle();
		if(vehicle != null)
			vehicleVO = new RestVehicleVO(vehicle.getVehicleId(),vehicle.getLicenceNumber(),vehicle.getManufacturer(),vehicle.getModel(),vehicle.getVehicleType(), vehicle.getDeviceId(), null);
		restVO.setVehicle(vehicleVO);
		return restVO;
	}
	
	public static SessionTripVO tripRestVoToVo(RestSessionTripVO restVO){
		SessionTripVO tripVO = new SessionTripVO(restVO.getSessionTripId(), restVO.getStartTime(), restVO.getEndTime(), restVO.getStartLat(), restVO.getEndLat(), restVO.getStartLong(), restVO.getEndLong());
		if(restVO.getVehicle()!=null){
			RestVehicleVO vehicle = restVO.getVehicle();
			tripVO.setVehicle(new VehicleVO(vehicle.getVehicleId(),vehicle.getLicenceNumber(),vehicle.getManufacturer(),vehicle.getModel(),vehicle.getVehicleType(), vehicle.getDeviceId(), null));
		}
		return tripVO;
	}
	
	public static RestSessionTripVO tripVoToRestVo(SessionTripVO trip){
		RestSessionTripVO restVO = new RestSessionTripVO(trip.getSessionTripId(), trip.getStartTime(), trip.getEndTime(), trip.getStartLat(), trip.getEndLat(), trip.getStartLong(), trip.getEndLong());
		if(trip.getVehicle()!=null){
			VehicleVO vehicle = trip.getVehicle();
			restVO.setVehicle(new RestVehicleVO(vehicle.getVehicleId(),vehicle.getLicenceNumber(),vehicle.getManufacturer(),vehicle.getModel(),vehicle.getVehicleType(), vehicle.getDeviceId(), null));
		}
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
