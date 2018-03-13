package it.altran.jsf.myApp.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pubblicazione_autore database table.
 * 
 */
@Entity
@Table(name="pubblicazione_autore")
@NamedQuery(name="PubblicazioneAutore.findAll", query="SELECT p FROM PubblicazioneAutore p")
public class PubblicazioneAutore implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PubblicazioneAutorePK id;

	//bi-directional many-to-one association to Autore
	@ManyToOne
	@JoinColumn(name="ID_AUTORE", insertable=false,updatable=false)
	private Autore autore;

	//bi-directional many-to-one association to Professione
	@ManyToOne
	@JoinColumn(name="ID_PROFESSIONE", insertable=false,updatable=false)
	private Professione professione;

	//bi-directional many-to-one association to Pubblicazione
	@ManyToOne
	@JoinColumn(name="ID_PUBBLICAZIONE", insertable=false,updatable=false)
	private Pubblicazione pubblicazione;

	public PubblicazioneAutore() {
	}

	public PubblicazioneAutorePK getId() {
		return this.id;
	}

	public void setId(PubblicazioneAutorePK id) {
		this.id = id;
	}

	public Autore getAutore() {
		return this.autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public Professione getProfessione() {
		return this.professione;
	}

	public void setProfessione(Professione professione) {
		this.professione = professione;
	}

	public Pubblicazione getPubblicazione() {
		return this.pubblicazione;
	}

	public void setPubblicazione(Pubblicazione pubblicazione) {
		this.pubblicazione = pubblicazione;
	}

}