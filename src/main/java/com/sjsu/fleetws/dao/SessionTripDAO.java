package com.sjsu.fleetws.dao;

import java.util.List;

import com.sjsu.fleetws.model.SessionTripVO;

public interface SessionTripDAO {
	
	public SessionTripVO addSessionTrip(SessionTripVO sessionTrip);
	public SessionTripVO updateSessionTrip(SessionTripVO sessionTrip);
	public List<SessionTripVO> getAllSessionTrips();
	public List<SessionTripVO> getVehicleTrips(int vehicleId);
}
