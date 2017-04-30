package com.sjsu.fleetws.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sjsu.fleetws.dao.DriverDAO;
import com.sjsu.fleetws.model.DriverVO;
import com.sjsu.fleetws.util.HibernateUtil;

public class DriverDAOImpl implements DriverDAO{

	@Override
	public DriverVO addDriver(DriverVO driver) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			int driverId = (Integer) session.save(driver);
			driver.setDriverId(driverId);
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return driver;
	}

	@Override
	public DriverVO updateDriver(DriverVO driver) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(driver);
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return driver;
	}

	@Override
	public List<DriverVO> getAllDrivers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<DriverVO> drivers = null;
		try{
			tx = session.beginTransaction();
			Query q = session.createQuery("from DriverVO");
			drivers = (List<DriverVO>)q.list();
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return drivers;
	}
	
	public static void main(String args[]){
		DriverDAO dao = new DriverDAOImpl();
		//DriverVO d = new DriverVO(1, "Pavani", "pavanib@gmail.com", "1234", 123456789, null);
		//DriverVO d = dao.addDriver(new DriverVO(0, "Pavani", "pavani@gmail.com", "1234", 123456789, null));
		//d = dao.updateDriver(d);
		List<DriverVO> drivers = dao.getAllDrivers();
		for (DriverVO driverVO : drivers) {
			System.out.println(driverVO.toString());
		}
	}

}
