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
import com.sjsu.fleetws.model.RestVehicleVO;
import com.sjsu.fleetws.model.VehicleVO;
import com.sjsu.fleetws.util.CommonUtils;

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
			result.add(CommonUtils.vehicleVoToRestVo(vehicle));
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
		VehicleVO vehicleVO = CommonUtils.vehicleRestVoToVo(vehicle);
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
		VehicleVO vehicleVO = CommonUtils.vehicleRestVoToVo(vehicle);
		vehicleVO = vehicleDAO.updateVehicle(vehicleVO);
		GenericEntity<RestVehicleVO> entity = new GenericEntity<RestVehicleVO>(vehicle) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@POST
	@Path("/bulk")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDrivers(List<RestVehicleVO> restVehicles){
		vehicleDAO = new VehicleDAOImpl();
		List<VehicleVO> vehicles = new ArrayList<>();
		for (RestVehicleVO vehicle : restVehicles) {
			VehicleVO restVO = CommonUtils.vehicleRestVoToVo(vehicle);
			if(restVO.getDriver()!=null){
				restVO.getDriver().setVehicle(null);
			}
			vehicles.add(restVO);
		}
		vehicles = (List<VehicleVO>)vehicleDAO.addVehicles(vehicles);
		restVehicles = new ArrayList<RestVehicleVO>(); 
		for (VehicleVO vehicle : vehicles) {
			RestVehicleVO restVO = CommonUtils.vehicleVoToRestVo(vehicle);
			if(restVO.getDriver()!=null){
				restVO.getDriver().setVehicle(null);
			}
			restVehicles.add(restVO);
		}
		GenericEntity<List<RestVehicleVO>> entity = new GenericEntity<List<RestVehicleVO>>(restVehicles) {};
		return Response.status(Status.OK).entity(entity).build();
	}

}
