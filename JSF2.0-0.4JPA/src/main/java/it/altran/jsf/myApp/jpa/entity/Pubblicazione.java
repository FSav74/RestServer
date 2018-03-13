package it.altran.jsf.myApp.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pubblicazione database table.
 * 
 */
@Entity
@NamedQueries( {
@NamedQuery(name="Pubblicazione.findAll", query="SELECT p FROM Pubblicazione p"),
@NamedQuery(name="Pubblicazione.findFromTitolo", query="SELECT DISTINCT a  FROM Pubblicazione a JOIN FETCH a.pubblicazioneAutores b JOIN FETCH b.autore c  WHERE a.titolo LIKE :titolo"),
@NamedQuery(name="Pubblicazione.countFromTitolo", query="SELECT COUNT(a.idPubblicazione)  FROM Pubblicazione a WHERE a.titolo LIKE :titolo")

})

public class Pubblicazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PUBBLICAZIONE")
	private int idPubblicazione;

	@Column(name="ANNO_PUBBLICAZIONE")
	private String annoPubblicazione;

	private String collana;

	private String descrizione;

	private String immagine;

	private String isbn;

	@Column(name="MESE_PUBBLICAZIONE")
	private String mesePubblicazione;

	private int numero;

	private String titolo;

	//bi-directional many-to-many association to Prenotazione
	@ManyToMany(mappedBy="pubblicaziones")
	private List<Prenotazione> prenotaziones;

	//bi-directional many-to-one association to Editore
	@ManyToOne
	@JoinColumn(name="ID_EDITORE")
	private Editore editore;

	//bi-directional many-to-one association to Periodicita
	@ManyToOne
	@JoinColumn(name="ID_PERIODICITA")
	private Periodicita periodicita;

	//bi-directional many-to-one association to TipoPubblicazione
	@ManyToOne
	@JoinColumn(name="ID_TIPO_PUBBLICAZIONE")
	private TipoPubblicazione tipoPubblicazione;

	//bi-directional many-to-one association to PubblicazioneAutore
	@OneToMany(mappedBy="pubblicazione")
	private List<PubblicazioneAutore> pubblicazioneAutores;

	//bi-directional many-to-many association to Genere
	@ManyToMany
	@JoinTable(
		name="pubblicazione_genere"
		, joinColumns={
			@JoinColumn(name="PUBBLICAZIONE_ID_PUBBLICAZIONE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="GENERE_ID_GENERE")
			}
		)
	private List<Genere> generes;

	public Pubblicazione() {
	}

	public int getIdPubblicazione() {
		return this.idPubblicazione;
	}

	public void setIdPubblicazione(int idPubblicazione) {
		this.idPubblicazione = idPubblicazione;
	}

	public String getAnnoPubblicazione() {
		return this.annoPubblicazione;
	}

	public void setAnnoPubblicazione(String annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public String getCollana() {
		return this.collana;
	}

	public void setCollana(String collana) {
		this.collana = collana;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getImmagine() {
		return this.immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getMesePubblicazione() {
		return this.mesePubblicazione;
	}

	public void setMesePubblicazione(String mesePubblicazione) {
		this.mesePubblicazione = mesePubblicazione;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public Editore getEditore() {
		return this.editore;
	}

	public void setEditore(Editore editore) {
		this.editore = editore;
	}

	public Periodicita getPeriodicita() {
		return this.periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	public TipoPubblicazione getTipoPubblicazione() {
		return this.tipoPubblicazione;
	}

	public void setTipoPubblicazione(TipoPubblicazione tipoPubblicazione) {
		this.tipoPubblicazione = tipoPubblicazione;
	}

	public List<PubblicazioneAutore> getPubblicazioneAutores() {
		return this.pubblicazioneAutores;
	}

	public void setPubblicazioneAutores(List<PubblicazioneAutore> pubblicazioneAutores) {
		this.pubblicazioneAutores = pubblicazioneAutores;
	}

	public PubblicazioneAutore addPubblicazioneAutore(PubblicazioneAutore pubblicazioneAutore) {
		getPubblicazioneAutores().add(pubblicazioneAutore);
		pubblicazioneAutore.setPubblicazione(this);

		return pubblicazioneAutore;
	}

	public PubblicazioneAutore removePubblicazioneAutore(PubblicazioneAutore pubblicazioneAutore) {
		getPubblicazioneAutores().remove(pubblicazioneAutore);
		pubblicazioneAutore.setPubblicazione(null);

		return pubblicazioneAutore;
	}

	public List<Genere> getGeneres() {
		return this.generes;
	}

	public void setGeneres(List<Genere> generes) {
		this.generes = generes;
	}

}