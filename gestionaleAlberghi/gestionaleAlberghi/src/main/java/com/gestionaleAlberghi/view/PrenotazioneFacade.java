package com.gestionaleAlberghi.view;

import java.sql.Date;
import java.util.List;

import com.gestionaleAlberghi.models.Prenotazione;
import com.gestionaleAlberghi.models.Stanza;
import com.gestionaleAlberghi.models.Dao.PrenotazioneDao;

public class PrenotazioneFacade {
	
	public boolean createPrenotazione(Integer prenotazioneID, Date dataInizio, Date dataFine, Stanza stanza) {
		return PrenotazioneDao.getIstanza().insert(new Prenotazione(prenotazioneID,dataInizio,dataFine,stanza));
	}
	
	public List<Prenotazione> listaPrenotazione(){
		return PrenotazioneDao.getIstanza().findAll();
	}
}
