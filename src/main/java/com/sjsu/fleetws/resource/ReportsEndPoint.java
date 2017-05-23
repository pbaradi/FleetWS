package com.sjsu.fleetws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sjsu.fleetws.dao.ReportsDAO;
import com.sjsu.fleetws.dao.impl.ReportsDAOImpl;
import com.sjsu.fleetws.model.ReportVO;

@Path("/reports")
public class ReportsEndPoint {
	
	private ReportsDAO reportsDAO;
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getReports() {
		reportsDAO = new ReportsDAOImpl();
		ReportVO reportVO = reportsDAO.getReports();
		
		
		GenericEntity<ReportVO> entity = new GenericEntity<ReportVO>(
				reportVO) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

}
