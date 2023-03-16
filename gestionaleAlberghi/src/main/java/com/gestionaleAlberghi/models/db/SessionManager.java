package com.gestionaleAlberghi.models.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gestionaleAlberghi.models.Albergo;
import com.gestionaleAlberghi.models.Prenotazione;
import com.gestionaleAlberghi.models.Stanza;

public class SessionManager {

	private static SessionManager sm;
	private SessionFactory factory;
		
	public static SessionManager getInstance() {		
		if(sm == null)
			sm = new SessionManager();
		
		return sm;
	}
	
	private SessionManager() {
		
	}
		
	public SessionFactory getFactory() {
		if(factory == null)
			factory = new Configuration()
				.configure("/resources/hibernate.cfg.xml")
				.addAnnotatedClass(Albergo.class)
				.addAnnotatedClass(Stanza.class)
				.addAnnotatedClass(Prenotazione.class)
				.buildSessionFactory();
		
		return factory;
	}
		
}


