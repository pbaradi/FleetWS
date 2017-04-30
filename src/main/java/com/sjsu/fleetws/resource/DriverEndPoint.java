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

import com.sjsu.fleetws.dao.DriverDAO;
import com.sjsu.fleetws.dao.impl.DriverDAOImpl;
import com.sjsu.fleetws.model.DriverVO;
import com.sjsu.fleetws.model.RestDriverVO;

@Path("/drivers")
public class DriverEndPoint {

	private DriverDAO driverDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGeofences() {
		driverDAO = new DriverDAOImpl();
		List<DriverVO> drivers = (List<DriverVO>)driverDAO.getAllDrivers();

		List<RestDriverVO> result = new ArrayList<RestDriverVO>(); 
		// Printing the values
		for (DriverVO driver : drivers) {
			RestDriverVO eachGf = new RestDriverVO(driver.getDriverId(),driver.getName(),driver.getEmail(),driver.getPassword(), driver.getMobile(),driver.getVehicle());
			result.add(eachGf);
		}
		GenericEntity<List<RestDriverVO>> entity = new GenericEntity<List<RestDriverVO>>(
				result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDriver(RestDriverVO driver){
		driverDAO = new DriverDAOImpl();
		DriverVO driverVO = new DriverVO(driver.getDriverId(),driver.getName(),driver.getEmail(),driver.getPassword(),driver.getMobile(),driver.getVehicle());
		driverVO = driverDAO.addDriver(driverVO);
		driver.setDriverId(driverVO.getDriverId());
		GenericEntity<RestDriverVO> entity = new GenericEntity<RestDriverVO>(driver) {};
		return Response.status(Status.OK).entity(entity).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUserBug(RestDriverVO driver){
		DriverDAO geofenceImpl = new DriverDAOImpl();
		DriverVO driverVO = new DriverVO(driver.getDriverId(),driver.getName(),driver.getEmail(),driver.getPassword(),driver.getMobile(),driver.getVehicle());
		driverVO = geofenceImpl.updateDriver(driverVO);
		GenericEntity<RestDriverVO> entity = new GenericEntity<RestDriverVO>(driver) {};
		return Response.status(Status.OK).entity(entity).build();
	}


}
