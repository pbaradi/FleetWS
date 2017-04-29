package com.sjsu.fleetws.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sjsu.fleetws.dao.GeofenceDAO;
import com.sjsu.fleetws.model.GeofenceVO;
import com.sjsu.fleetws.util.HibernateUtil;

public class GeofenceDAOImpl implements GeofenceDAO{
	
	public GeofenceVO saveGeofence(GeofenceVO gf) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			int fenceId = (Integer) session.save(gf);
			gf.setFenceId(fenceId);
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return gf;
	}
	
	public GeofenceVO updateGeofence(GeofenceVO gf) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(gf);
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return gf;
	}
	
	public List<GeofenceVO> getAllGeofences(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<GeofenceVO> geofences = null;
		try{
			tx = session.beginTransaction();
			Query q = session.createQuery("from GeofenceVO");
			geofences = (List<GeofenceVO>)q.list();
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return geofences;
	}
	
	public static void main(String[] args){
		 GeofenceVO gf = new GeofenceVO(2, 111.23 , 111.23, 123.0);
		
		GeofenceDAO geofenceImpl = new GeofenceDAOImpl();
//		List<GeofenceVO> result = geofenceImpl.getAllGeofences();
		
		// GeofenceVO result = geofenceImpl.updateGeofence(gf);
		GeofenceVO result = geofenceImpl.saveGeofence(gf);
		
//		Iterator<GeofenceVO> iter = result.iterator();
//		while(iter.hasNext()){
//			System.out.println(iter.next().getFenceId());
//		}
		
}

}
