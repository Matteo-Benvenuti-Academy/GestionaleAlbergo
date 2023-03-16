package com.gestionaleAlberghi.models.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;

import com.gestionaleAlberghi.models.Albergo;
import com.gestionaleAlberghi.models.Prenotazione;
import com.gestionaleAlberghi.models.db.SessionManager;

public class AlbergoDao implements IDao<Albergo>{
	
	private static AlbergoDao ogg;
	
	public static AlbergoDao getIstanza() {
		if(ogg == null)
			ogg = new AlbergoDao();
		
		return ogg;
	}
	
	public AlbergoDao() {
		
	}
	
	
	@Override
	public boolean insert(Albergo t) {
Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();
		
		try {
			sessione.beginTransaction();
			sessione.save(t);
			sessione.getTransaction().commit();
		} catch (IllegalStateException e) {
			System.out.println("Sono in illegal");
		} catch (RollbackException e) {
			System.out.println("Sono in Rbex");
		} catch (Exception e) {
			System.out.println("Sono in generica Exception: " + e.getMessage());
		} finally {
			sessione.close();
		}

		if(t.getAlbergoID() == null)
			return false;
		
		return true;
	}

	@Override
	public List<Albergo> findAll() {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();

		List<Albergo> elenco = new ArrayList<Albergo>();
		
		try {
			sessione.beginTransaction();
			elenco = sessione.createQuery("FROM Albergo").list();
			sessione.getTransaction().commit();
		} catch (IllegalStateException e) {
			System.out.println("Sono in illegal");
		} catch (RollbackException e) {
			System.out.println("Sono in Rbex");
		} catch (Exception e) {
			System.out.println("Sono in generica Exception: " + e.getMessage());
		} finally {
			sessione.close();
		}
		
		return elenco;
	}

	@Override
	public Albergo findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Albergo t) {
		// TODO Auto-generated method stub
		return false;
	}

}
