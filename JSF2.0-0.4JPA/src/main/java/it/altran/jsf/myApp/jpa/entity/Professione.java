package it.altran.jsf.myApp.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the professione database table.
 * 
 */
@Entity
@NamedQuery(name="Professione.findAll", query="SELECT p FROM Professione p")
public class Professione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PROFESSIONE")
	private int idProfessione;

	@Column(name="DESC_PROFESSIONE")
	private String descProfessione;

	//bi-directional many-to-one association to PubblicazioneAutore
	@OneToMany(mappedBy="professione")
	private List<PubblicazioneAutore> pubblicazioneAutores;

	public Professione() {
	}

	public int getIdProfessione() {
		return this.idProfessione;
	}

	public void setIdProfessione(int idProfessione) {
		this.idProfessione = idProfessione;
	}

	public String getDescProfessione() {
		return this.descProfessione;
	}

	public void setDescProfessione(String descProfessione) {
		this.descProfessione = descProfessione;
	}

	public List<PubblicazioneAutore> getPubblicazioneAutores() {
		return this.pubblicazioneAutores;
	}

	public void setPubblicazioneAutores(List<PubblicazioneAutore> pubblicazioneAutores) {
		this.pubblicazioneAutores = pubblicazioneAutores;
	}

	public PubblicazioneAutore addPubblicazioneAutore(PubblicazioneAutore pubblicazioneAutore) {
		getPubblicazioneAutores().add(pubblicazioneAutore);
		pubblicazioneAutore.setProfessione(this);

		return pubblicazioneAutore;
	}

	public PubblicazioneAutore removePubblicazioneAutore(PubblicazioneAutore pubblicazioneAutore) {
		getPubblicazioneAutores().remove(pubblicazioneAutore);
		pubblicazioneAutore.setProfessione(null);

		return pubblicazioneAutore;
	}

}