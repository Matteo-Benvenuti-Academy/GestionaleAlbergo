package com.gestionaleAlberghi.view;

import java.sql.Date;
import java.util.List;

import com.gestionaleAlberghi.models.Albergo;
import com.gestionaleAlberghi.models.Prenotazione;
import com.gestionaleAlberghi.models.Stanza;
import com.gestionaleAlberghi.models.Dao.AlbergoDao;
import com.gestionaleAlberghi.models.Dao.PrenotazioneDao;

public class PrenotazioneFacade {

	private static PrenotazioneFacade ogg;

	public static PrenotazioneFacade getIstanza() {
		if (ogg == null)
			ogg = new PrenotazioneFacade();

		return ogg;
	}

	public PrenotazioneFacade() {

	}

	public Prenotazione createPrenotazione(Date dataInizio, Date dataFine, Stanza stanza) {
		Prenotazione temp = new Prenotazione(dataInizio, dataFine, stanza);
	    PrenotazioneDao.getIstanza().insert(temp);
	    return temp;
	}

	public List<Prenotazione> listaPrenotazione() {
		return PrenotazioneDao.getIstanza().findAll();
	}
}
