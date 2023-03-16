package com.gestionaleAlberghi.view;

import java.util.List;

import com.gestionaleAlberghi.models.Albergo;
import com.gestionaleAlberghi.models.Prenotazione;
import com.gestionaleAlberghi.models.Stanza;
import com.gestionaleAlberghi.models.Dao.AlbergoDao;
import com.gestionaleAlberghi.models.Dao.PrenotazioneDao;
import com.gestionaleAlberghi.models.Dao.StanzaDao;

public class StanzaFacade {
	private static StanzaFacade ogg;

	public static StanzaFacade getIstanza() {
		if (ogg == null)
			ogg = new StanzaFacade();

		return ogg;
	}

	public StanzaFacade() {

	}

	public Stanza createStanza(String numero, Boolean stato, Albergo albergo) {
		Stanza temp = new Stanza(numero, stato, albergo);
		StanzaDao.getIstanza().insert(temp);
	    return temp;
	}

	public List<Stanza> listaStanza() {
		return StanzaDao.getIstanza().findAll();
	}
}
