package com.sjsu.fleetws.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sjsu.fleetws.dao.SessionTripDAO;
import com.sjsu.fleetws.dao.impl.SessionTripDAOImpl;
import com.sjsu.fleetws.model.SessionTripVO;
import com.sjsu.fleetws.model.RestSessionTripVO;
import com.sjsu.fleetws.util.CommonUtils;

@Path("/trips")
public class SessionTripEndPoint {
	
	private SessionTripDAO tripDAO;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSessionTrips() {
		tripDAO = new SessionTripDAOImpl();
		List<SessionTripVO> tripVOs = (List<SessionTripVO>)tripDAO.getAllSessionTrips();
		List<RestSessionTripVO> result = new ArrayList<RestSessionTripVO>(); 
		for (SessionTripVO tripVO : tripVOs) {
			RestSessionTripVO restVO = CommonUtils.tripVoToRestVo(tripVO);
			result.add(restVO);
		}
		GenericEntity<List<RestSessionTripVO>> entity = new GenericEntity<List<RestSessionTripVO>>(result) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@GET
	@Path("/{vehicleId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVehicleSessionTrips(@PathParam("vehicleId") int vehicleId) {
		tripDAO = new SessionTripDAOImpl();
		List<SessionTripVO> tripVOs = (List<SessionTripVO>)tripDAO.getVehicleTrips(vehicleId);
		List<RestSessionTripVO> result = new ArrayList<RestSessionTripVO>(); 
		for (SessionTripVO tripVO : tripVOs) {
			RestSessionTripVO restVO = CommonUtils.tripVoToRestVo(tripVO);
			result.add(restVO);
		}
		GenericEntity<List<RestSessionTripVO>> entity = new GenericEntity<List<RestSessionTripVO>>(result) {};
		return Response.status(Status.OK).entity(entity).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSessionTrip(RestSessionTripVO restVO){
		tripDAO = new SessionTripDAOImpl();
		SessionTripVO tripVO = CommonUtils.tripRestVoToVo(restVO);
		tripVO = tripDAO.addSessionTrip(tripVO);
		restVO.setSessionTripId(tripVO.getSessionTripId());
		GenericEntity<RestSessionTripVO> entity = new GenericEntity<RestSessionTripVO>(restVO) {};
		return Response.status(Status.OK).entity(entity).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSessionTrip(RestSessionTripVO restVO){
		tripDAO = new SessionTripDAOImpl();
		SessionTripVO tripVO = CommonUtils.tripRestVoToVo(restVO);
		tripVO = tripDAO.updateSessionTrip(tripVO);
		GenericEntity<RestSessionTripVO> entity = new GenericEntity<RestSessionTripVO>(restVO) {};
		return Response.status(Status.OK).entity(entity).build();
	}

}
