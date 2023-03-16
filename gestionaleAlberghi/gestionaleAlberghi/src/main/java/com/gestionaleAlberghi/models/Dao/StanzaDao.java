package com.gestionaleAlberghi.models.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;

import com.gestionaleAlberghi.models.Albergo;
import com.gestionaleAlberghi.models.Stanza;
import com.gestionaleAlberghi.models.db.SessionManager;


public class StanzaDao implements IDao<Stanza>{
	
	private static StanzaDao ogg;
	
	public static StanzaDao getIstanza() {
		if(ogg == null)
			ogg = new StanzaDao();
		
		return ogg;
	}
	
	public StanzaDao() {
		
	}
	
	@Override
	public boolean insert(Stanza t) {
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

		if(t.getStanzaID() == null)
			return false;
		
		return true;
	}

	@Override
	public List<Stanza> findAll() {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();

		List<Stanza> elenco = new ArrayList<Stanza>();
		
		try {
			sessione.beginTransaction();
			elenco = sessione.createQuery("FROM Stanza").list();
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
	public Stanza findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Stanza t) {
		// TODO Auto-generated method stub
		return false;
	}

}
