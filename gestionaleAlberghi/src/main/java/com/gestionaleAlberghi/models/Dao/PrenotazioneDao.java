package com.gestionaleAlberghi.models.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;

import com.gestionaleAlberghi.models.Prenotazione;
import com.gestionaleAlberghi.models.Stanza;
import com.gestionaleAlberghi.models.db.SessionManager;

public class PrenotazioneDao implements IDao<Prenotazione>{
	
	private static PrenotazioneDao ogg;
	
	public static PrenotazioneDao getIstanza() {
		if(ogg == null)
			ogg = new PrenotazioneDao();
		
		return ogg;
	}
	
	public PrenotazioneDao() {
		
	}
	
	@Override
	public boolean insert(Prenotazione t) {
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

		if(t.getPrenotazioneID() == null)
			return false;
		
		return true;
	}

	@Override
	public List<Prenotazione> findAll() {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();

		List<Prenotazione> elenco = new ArrayList<Prenotazione>();
		
		try {
			sessione.beginTransaction();
			elenco = sessione.createQuery("FROM Prenotazione").list();
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
	public Prenotazione findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Prenotazione t) {
		// TODO Auto-generated method stub
		return false;
	}

}
