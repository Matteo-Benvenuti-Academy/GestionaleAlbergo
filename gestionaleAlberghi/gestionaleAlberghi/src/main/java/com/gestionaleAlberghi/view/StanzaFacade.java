package com.gestionaleAlberghi.view;

import java.util.List;

import com.gestionaleAlberghi.models.Albergo;
import com.gestionaleAlberghi.models.Stanza;
import com.gestionaleAlberghi.models.Dao.StanzaDao;

public class StanzaFacade {
	
	public boolean createStanza(String numero, Boolean stato, Albergo albergo) {
		return StanzaDao.getIstanza().insert(new Stanza(numero,stato,albergo));
	}
	
	public List<Stanza> listaStanza(){
		return StanzaDao.getIstanza().findAll();
	}
}
