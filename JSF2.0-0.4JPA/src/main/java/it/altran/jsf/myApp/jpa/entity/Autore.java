package it.altran.jsf.myApp.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the autore database table.
 * 
 */
@Entity
@NamedQuery(name="Autore.findAll", query="SELECT a FROM Autore a")
public class Autore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_AUTORE")
	private int idAutore;

	private String cognome;

	private String nome;

	//bi-directional many-to-one association to PubblicazioneAutore
	@OneToMany(mappedBy="autore")
	private List<PubblicazioneAutore> pubblicazioneAutores;

	public Autore() {
	}

	public int getIdAutore() {
		return this.idAutore;
	}

	public void setIdAutore(int idAutore) {
		this.idAutore = idAutore;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PubblicazioneAutore> getPubblicazioneAutores() {
		return this.pubblicazioneAutores;
	}

	public void setPubblicazioneAutores(List<PubblicazioneAutore> pubblicazioneAutores) {
		this.pubblicazioneAutores = pubblicazioneAutores;
	}

	public PubblicazioneAutore addPubblicazioneAutore(PubblicazioneAutore pubblicazioneAutore) {
		getPubblicazioneAutores().add(pubblicazioneAutore);
		pubblicazioneAutore.setAutore(this);

		return pubblicazioneAutore;
	}

	public PubblicazioneAutore removePubblicazioneAutore(PubblicazioneAutore pubblicazioneAutore) {
		getPubblicazioneAutores().remove(pubblicazioneAutore);
		pubblicazioneAutore.setAutore(null);

		return pubblicazioneAutore;
	}

}