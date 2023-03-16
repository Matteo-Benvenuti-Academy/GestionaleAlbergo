package com.gestionaleAlberghi.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer prenotazioneID;
	
	@Column
	private Date dataInizio;
	
	@Column
	private Date dataFine;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="stanzaRIF")
	private Stanza stanza;

	public Prenotazione(Integer prenotazioneID, Date dataInizio, Date dataFine, Stanza stanza) {
		super();
		this.prenotazioneID = prenotazioneID;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.stanza = stanza;
	}

	public Prenotazione() {
		super();
	}

	public Integer getPrenotazioneID() {
		return prenotazioneID;
	}

	public void setPrenotazioneID(Integer prenotazioneID) {
		this.prenotazioneID = prenotazioneID;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Stanza getStanza() {
		return stanza;
	}

	public void setStanza(Stanza stanza) {
		this.stanza = stanza;
	}

	@Override
	public String toString() {
		return "Prenotazione [prenotazioneID=" + prenotazioneID + ", dataInizio=" + dataInizio + ", dataFine="
				+ dataFine + "]";
	}
	
}
