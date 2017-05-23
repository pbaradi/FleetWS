package com.sjsu.fleetws.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sjsu.fleetws.dao.SessionTripDAO;
import com.sjsu.fleetws.model.SessionTripVO;
import com.sjsu.fleetws.model.VehicleVO;
import com.sjsu.fleetws.util.HibernateUtil;

public class SessionTripDAOImpl implements SessionTripDAO{

	@Override
	public SessionTripVO addSessionTrip(SessionTripVO sessionTrip) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			int sessionTripId = (Integer) session.save(sessionTrip);
			sessionTrip.setSessionTripId(sessionTripId);
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return sessionTrip;
	}
	
	@Override
	public List<SessionTripVO> getVehicleTrips(int vehicleId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<SessionTripVO> sessionTrips = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("from SessionTripVO where vehicle.vehicleId ="+vehicleId);
			sessionTrips = (List<SessionTripVO>)query.list();
			System.out.println(sessionTrips);
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return sessionTrips;
	}

	@Override
	public SessionTripVO updateSessionTrip(SessionTripVO sessionTrip) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(sessionTrip);
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return sessionTrip;
	}

	@Override
	public List<SessionTripVO> getAllSessionTrips() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<SessionTripVO> sessionTrips = new ArrayList<SessionTripVO>();
		try{
			tx = session.beginTransaction();
			Query q = session.createQuery("from SessionTripVO");
			sessionTrips = (List<SessionTripVO>)q.list();
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return sessionTrips;
	}

	
	
	public static void main(String args[]){
		SessionTripDAO dao = new SessionTripDAOImpl();
		VehicleVO vehicleVO = new VehicleVO();
		vehicleVO.setVehicleId(1);
		SessionTripVO sessionTrip = new SessionTripVO(0, Timestamp.valueOf(LocalDateTime.now()), null, "20.22", null, "30.34", null);
		sessionTrip.setVehicle(vehicleVO);
		//sessionTrip = dao.addSessionTrip(sessionTrip);
		List<SessionTripVO> list = dao.getVehicleTrips(1);
		//System.out.println(sessionTrip.getSessionTripId());
		for (SessionTripVO sessionTripVO : list) {
			System.out.println(sessionTripVO.getSessionTripId());
		}
	}

}
