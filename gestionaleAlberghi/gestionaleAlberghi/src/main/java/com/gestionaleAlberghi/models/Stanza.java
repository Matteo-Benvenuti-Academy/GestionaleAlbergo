package com.gestionaleAlberghi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Stanza {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer stanzaID;

	@Column
	private String numero;
	
	@Column
	private Boolean stato;
	
	@OneToMany(mappedBy = "stanza", fetch = FetchType.LAZY )
	private List<Prenotazione> elenco_prenotazioni = new ArrayList<Prenotazione>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="albergoRIF")
	private Albergo albergo;
	
	public Stanza(String numero, Boolean stato, Albergo albergo) {
		super();
		this.numero = numero;
		this.stato = stato;
		this.albergo = albergo;
	}

	public Stanza() {
	}

	public Integer getStanzaID() {
		return stanzaID;
	}

	public void setStanzaID(Integer stanzaID) {
		this.stanzaID = stanzaID;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Boolean getStato() {
		return stato;
	}

	public void setStato(Boolean stato) {
		this.stato = stato;
	}

	public List<Prenotazione> getElenco_prenotazioni() {
		return elenco_prenotazioni;
	}

	public void setElenco_prenotazioni(List<Prenotazione> elenco_prenotazioni) {
		this.elenco_prenotazioni = elenco_prenotazioni;
	}

	public Albergo getAlbergo() {
		return albergo;
	}

	public void setAlbergo(Albergo albergo) {
		this.albergo = albergo;
	}

	@Override
	public String toString() {
		return "Stanza [stanzaID=" + stanzaID + ", numero=" + numero + ", stato=" + stato + ", elenco_prenotazioni="
				+ elenco_prenotazioni + ", albergo=" + albergo + "]";
	}


}
