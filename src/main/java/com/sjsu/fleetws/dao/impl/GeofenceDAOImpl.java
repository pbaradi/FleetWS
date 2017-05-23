package com.sjsu.fleetws.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

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

	public Long getGeofenceCount(){
		Long count = (long) 0;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			count = (Long)session.createQuery("select count(*) from GeofenceVO").uniqueResult();
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return count;
	}

}

