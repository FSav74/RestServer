package it.altran.jsf.myApp.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pubblicazione_autore database table.
 * 
 */
@Embeddable
public class PubblicazioneAutorePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_PUBBLICAZIONE", insertable=false, updatable=false)
	private int idPubblicazione;

	@Column(name="ID_AUTORE", insertable=false, updatable=false)
	private int idAutore;

	@Column(name="ID_PROFESSIONE", insertable=false, updatable=false)
	private int idProfessione;

	public PubblicazioneAutorePK() {
	}
	public int getIdPubblicazione() {
		return this.idPubblicazione;
	}
	public void setIdPubblicazione(int idPubblicazione) {
		this.idPubblicazione = idPubblicazione;
	}
	public int getIdAutore() {
		return this.idAutore;
	}
	public void setIdAutore(int idAutore) {
		this.idAutore = idAutore;
	}
	public int getIdProfessione() {
		return this.idProfessione;
	}
	public void setIdProfessione(int idProfessione) {
		this.idProfessione = idProfessione;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PubblicazioneAutorePK)) {
			return false;
		}
		PubblicazioneAutorePK castOther = (PubblicazioneAutorePK)other;
		return 
			(this.idPubblicazione == castOther.idPubblicazione)
			&& (this.idAutore == castOther.idAutore)
			&& (this.idProfessione == castOther.idProfessione);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPubblicazione;
		hash = hash * prime + this.idAutore;
		hash = hash * prime + this.idProfessione;
		
		return hash;
	}
}