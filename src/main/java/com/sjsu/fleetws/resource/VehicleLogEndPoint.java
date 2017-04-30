package com.sjsu.fleetws.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sjsu.fleetws.dao.VehicleLogDAO;
import com.sjsu.fleetws.dao.impl.VehicleLogDAOImpl;
import com.sjsu.fleetws.model.VehicleLogVO;

@Path("/vehiclelogs")
public class VehicleLogEndPoint {

	private VehicleLogDAO vehicleLogDAO;

	public VehicleLogEndPoint() {
		vehicleLogDAO = new VehicleLogDAOImpl();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVehicleLogs(){
		List<VehicleLogVO> vehicleLogs = vehicleLogDAO.getVehicleLog();
		GenericEntity<List<VehicleLogVO>> entity = new GenericEntity<List<VehicleLogVO>>(vehicleLogs) {};
		return Response.status(Status.OK).entity(entity).build();

	}

}
