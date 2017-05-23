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

import com.sjsu.fleetws.dao.GeofenceDAO;
import com.sjsu.fleetws.dao.impl.GeofenceDAOImpl;
import com.sjsu.fleetws.model.GeofenceVO;
import com.sjsu.fleetws.model.RestGeofenceVO;


@Path("/geofences")
public class GeofenceEndPoint {
	GeofenceDAO geofenceImpl;
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getGeofences() {
		geofenceImpl = new GeofenceDAOImpl();
		List<GeofenceVO> gf = (List<GeofenceVO>)geofenceImpl.getAllGeofences();
		
		List<RestGeofenceVO> result = new ArrayList<RestGeofenceVO>(); 
		// Printing the values
		for (GeofenceVO geofence : gf) {
			RestGeofenceVO eachGf = new RestGeofenceVO(geofence.getFenceId(),geofence.getNorth(),geofence.getSouth(),geofence.getEast(), geofence.getWest());
			result.add(eachGf);
		}
		GenericEntity<List<RestGeofenceVO>> entity = new GenericEntity<List<RestGeofenceVO>>(
				result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveGF(GeofenceVO geofence){
		geofenceImpl = new GeofenceDAOImpl();
		GeofenceVO gf = new GeofenceVO(geofence.getFenceId(),geofence.getNorth(),geofence.getSouth(),geofence.getEast(), geofence.getWest(), 1);
		gf = geofenceImpl.saveGeofence(gf);
		GenericEntity<GeofenceVO> entity = new GenericEntity<GeofenceVO>(gf) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUserBug(GeofenceVO geofence){
		geofenceImpl = new GeofenceDAOImpl();
		GeofenceVO gf = new GeofenceVO(geofence.getFenceId(),geofence.getNorth(),geofence.getSouth(),geofence.getEast(), geofence.getWest(), geofence.getVehiclesCount());
		gf = geofenceImpl.updateGeofence(gf);	
		GenericEntity<GeofenceVO> entity = new GenericEntity<GeofenceVO>(gf) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	

}
