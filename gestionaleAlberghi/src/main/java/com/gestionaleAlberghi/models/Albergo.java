package com.gestionaleAlberghi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Alberghi")
public class Albergo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer albergoID;
	
	@Column
	private String nome;
	
	@Column
	private Integer numeroStelle;
	
	@OneToMany(mappedBy = "albergo", fetch = FetchType.LAZY )
	private List<Stanza> elenco_stanze = new ArrayList<Stanza>();

	public Albergo(String nome, Integer numeroStelle) {
		super();
		this.nome = nome;
		this.numeroStelle = numeroStelle;
	}

	public Albergo() {}

	public Integer getAlbergoID() {
		return albergoID;
	}

	public void setAlbergoID(Integer albergoID) {
		this.albergoID = albergoID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroStelle() {
		return numeroStelle;
	}

	public void setNumeroStelle(Integer numeroStelle) {
		this.numeroStelle = numeroStelle;
	}

	public List<Stanza> getElenco_stanze() {
		return elenco_stanze;
	}

	public void setElenco_stanze(List<Stanza> elenco_stanze) {
		this.elenco_stanze = elenco_stanze;
	}

	@Override
	public String toString() {
		return "Albergo [albergoID=" + albergoID + ", nome=" + nome + ", numeroStelle=" + numeroStelle
				+ ", elenco_stanze=" + elenco_stanze + "]";
	}
	
	
	
	
}
