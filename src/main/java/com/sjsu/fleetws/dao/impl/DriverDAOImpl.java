package com.sjsu.fleetws.dao.impl;

import java.util.ArrayList;
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
		List<DriverVO> drivers = new ArrayList<DriverVO>();
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
	
	public Long getDriverCount(){
		Long count=(long) 0;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			count = (Long)session.createQuery("select count(*) from DriverVO").uniqueResult();
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return count;
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
		
//		DriverVO d = dao.login("pavanib@gmail.com", "1234");
//		System.out.println("driver is "+d);
	}

	@Override
	public DriverVO login(String email, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		DriverVO driver = null;
		try{
			tx = session.beginTransaction();
			Query q = session.createQuery("from DriverVO where email = :email and password = :password");
			q.setString("email", email);
			q.setString("password", password);
			driver = (DriverVO)q.uniqueResult();
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
	public List<DriverVO> addDrivers(List<DriverVO> drivers) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			for (DriverVO driver : drivers) {
				int driverId = (Integer) session.save(driver);
				driver.setDriverId(driverId);
			}
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return drivers;
	}

}
