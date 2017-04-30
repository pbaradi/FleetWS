package com.sjsu.fleetws.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sjsu.fleetws.dao.VehicleDAO;
import com.sjsu.fleetws.dao.impl.VehicleDAOImpl;
import com.sjsu.fleetws.model.DriverVO;
import com.sjsu.fleetws.model.RestDriverVO;
import com.sjsu.fleetws.model.RestVehicleVO;
import com.sjsu.fleetws.model.VehicleVO;

@Path("/vehicles")
public class VehicleEndPoint {

	private VehicleDAO vehicleDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVehicles() {
		vehicleDAO = new VehicleDAOImpl();
		List<VehicleVO> vehicles = (List<VehicleVO>)vehicleDAO.getAllVehicles();

		List<RestVehicleVO> result = new ArrayList<RestVehicleVO>(); 
		// Printing the values
		for (VehicleVO vehicle : vehicles) {
			RestDriverVO driverVO = null;
			if(vehicle.getDriver()!=null){
				driverVO = new RestDriverVO(vehicle.getDriver().getDriverId(), vehicle.getDriver().getName(), vehicle.getDriver().getEmail(), vehicle.getDriver().getPassword(), vehicle.getDriver().getMobile(), null);
			}
			RestVehicleVO vehicleVO = new RestVehicleVO(vehicle.getVehicleId(), vehicle.getLicenceNumber(), vehicle.getManufacturer(), vehicle.getModel(), vehicle.getVehicleType(), driverVO);
			result.add(vehicleVO);
		}
		GenericEntity<List<RestVehicleVO>> entity = new GenericEntity<List<RestVehicleVO>>(
				result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addVehicle(RestVehicleVO vehicle){
		vehicleDAO = new VehicleDAOImpl();
		DriverVO driverVO = null;
		if(vehicle.getDriver()!=null){
			RestDriverVO driver = vehicle.getDriver();
			driverVO = new DriverVO(driver.getDriverId(),driver.getName(),driver.getEmail(),driver.getPassword(),driver.getMobile(),null);
		}
		VehicleVO vehicleVO = new VehicleVO(vehicle.getVehicleId(),vehicle.getLicenceNumber(),vehicle.getManufacturer(),vehicle.getModel(),vehicle.getVehicleType(), driverVO);
		vehicleVO = vehicleDAO.addVehicle(vehicleVO);
		vehicle.setVehicleId(vehicleVO.getVehicleId());
		GenericEntity<RestVehicleVO> entity = new GenericEntity<RestVehicleVO>(vehicle) {};
		return Response.status(Status.OK).entity(entity).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateVehicle(RestVehicleVO vehicle){
		vehicleDAO = new VehicleDAOImpl();
		DriverVO driverVO = null;
		if(vehicle.getDriver()!=null){
			RestDriverVO driver = vehicle.getDriver();
			driverVO = new DriverVO(driver.getDriverId(),driver.getName(),driver.getEmail(),driver.getPassword(),driver.getMobile(),null);
		}
		VehicleVO vehicleVO = new VehicleVO(vehicle.getVehicleId(),vehicle.getLicenceNumber(),vehicle.getManufacturer(),vehicle.getModel(),vehicle.getVehicleType(), driverVO);
		vehicleVO = vehicleDAO.updateVehicle(vehicleVO);
		GenericEntity<RestVehicleVO> entity = new GenericEntity<RestVehicleVO>(vehicle) {};
		return Response.status(Status.OK).entity(entity).build();
	}

}
