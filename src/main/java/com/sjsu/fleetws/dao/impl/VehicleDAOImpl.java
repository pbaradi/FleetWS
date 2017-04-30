package com.sjsu.fleetws.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sjsu.fleetws.dao.VehicleDAO;
import com.sjsu.fleetws.model.VehicleVO;
import com.sjsu.fleetws.util.HibernateUtil;

public class VehicleDAOImpl implements VehicleDAO {

	@Override
	public VehicleVO addVehicle(VehicleVO vehicleVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			int vehicleId = (Integer) session.save(vehicleVO);
			vehicleVO.setVehicleId(vehicleId);
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return vehicleVO;
	}

	@Override
	public VehicleVO updateVehicle(VehicleVO vehicleVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(vehicleVO);
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return vehicleVO;
	}

	@Override
	public List<VehicleVO> getAllVehicles() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<VehicleVO> vehicles = new ArrayList<VehicleVO>();
		try{
			tx = session.beginTransaction();
			Query q = session.createQuery("from VehicleVO");
			vehicles = (List<VehicleVO>)q.list();
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return vehicles;
	}
	
	public static void main(String args[]){
		VehicleDAO dao = new VehicleDAOImpl();
		VehicleVO v = new VehicleVO(0, "7NTE189", "Honda", "Honda 2015", "Sedan", null);
		v = dao.addVehicle(v);
		System.out.println(v.getVehicleId());
	}

}
