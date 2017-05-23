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
import com.sjsu.fleetws.util.CommonUtils;

@Path("/drivers")
public class DriverEndPoint {

	private DriverDAO driverDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDrivers() {
		driverDAO = new DriverDAOImpl();
		List<DriverVO> drivers = (List<DriverVO>)driverDAO.getAllDrivers();
		List<RestDriverVO> result = new ArrayList<RestDriverVO>(); 
		for (DriverVO driver : drivers) {
			RestDriverVO restVO = CommonUtils.driverVoToRestVo(driver);
			if(restVO.getVehicle()!=null){
				restVO.getVehicle().setDriver(null);
			}
			result.add(restVO);
		}
		GenericEntity<List<RestDriverVO>> entity = new GenericEntity<List<RestDriverVO>>(result) {};
		return Response.status(Status.OK).entity(entity).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDriver(RestDriverVO driver){
		driverDAO = new DriverDAOImpl();
		DriverVO driverVO = CommonUtils.driverRestVoToVo(driver);
		driverVO = driverDAO.addDriver(driverVO);
		driver.setDriverId(driverVO.getDriverId());
		GenericEntity<RestDriverVO> entity = new GenericEntity<RestDriverVO>(driver) {};
		return Response.status(Status.OK).entity(entity).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDriver(RestDriverVO driver){
		driverDAO = new DriverDAOImpl();
		DriverVO driverVO = CommonUtils.driverRestVoToVo(driver);
		driverVO = driverDAO.updateDriver(driverVO);
		GenericEntity<RestDriverVO> entity = new GenericEntity<RestDriverVO>(driver) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(RestDriverVO driver){
		driverDAO = new DriverDAOImpl();
		DriverVO driverVO = CommonUtils.driverRestVoToVo(driver);
		driverVO = driverDAO.login(driver.getEmail(), driver.getPassword());
		driver = CommonUtils.driverVoToRestVo(driverVO);
		GenericEntity<RestDriverVO> entity = new GenericEntity<RestDriverVO>(driver) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@POST
	@Path("/bulk")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDrivers(List<RestDriverVO> restDrivers){
		driverDAO = new DriverDAOImpl();
		List<DriverVO> drivers = new ArrayList<>();
		for (RestDriverVO driver : restDrivers) {
			DriverVO restVO = CommonUtils.driverRestVoToVo(driver);
			if(restVO.getVehicle()!=null){
				restVO.getVehicle().setDriver(null);
			}
			drivers.add(restVO);
		}
		drivers = (List<DriverVO>)driverDAO.addDrivers(drivers);
		restDrivers = new ArrayList<RestDriverVO>(); 
		for (DriverVO driver : drivers) {
			RestDriverVO restVO = CommonUtils.driverVoToRestVo(driver);
			if(restVO.getVehicle()!=null){
				restVO.getVehicle().setDriver(null);
			}
			restDrivers.add(restVO);
		}
		GenericEntity<List<RestDriverVO>> entity = new GenericEntity<List<RestDriverVO>>(restDrivers) {};
		return Response.status(Status.OK).entity(entity).build();
	}


}
