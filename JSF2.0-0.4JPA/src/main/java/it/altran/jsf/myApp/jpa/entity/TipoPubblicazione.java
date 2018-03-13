package it.altran.jsf.myApp.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_pubblicazione database table.
 * 
 */
@Entity
@Table(name="tipo_pubblicazione")
@NamedQuery(name="TipoPubblicazione.findAll", query="SELECT t FROM TipoPubblicazione t")
public class TipoPubblicazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_TIPO_PUBBLICAZIONE")
	private int idTipoPubblicazione;

	@Column(name="DESC_TIPO_PUBBLICAZIONE")
	private String descTipoPubblicazione;

	//bi-directional many-to-one association to Pubblicazione
	@OneToMany(mappedBy="tipoPubblicazione")
	private List<Pubblicazione> pubblicaziones;

	public TipoPubblicazione() {
	}

	public int getIdTipoPubblicazione() {
		return this.idTipoPubblicazione;
	}

	public void setIdTipoPubblicazione(int idTipoPubblicazione) {
		this.idTipoPubblicazione = idTipoPubblicazione;
	}

	public String getDescTipoPubblicazione() {
		return this.descTipoPubblicazione;
	}

	public void setDescTipoPubblicazione(String descTipoPubblicazione) {
		this.descTipoPubblicazione = descTipoPubblicazione;
	}

	public List<Pubblicazione> getPubblicaziones() {
		return this.pubblicaziones;
	}

	public void setPubblicaziones(List<Pubblicazione> pubblicaziones) {
		this.pubblicaziones = pubblicaziones;
	}

	public Pubblicazione addPubblicazione(Pubblicazione pubblicazione) {
		getPubblicaziones().add(pubblicazione);
		pubblicazione.setTipoPubblicazione(this);

		return pubblicazione;
	}

	public Pubblicazione removePubblicazione(Pubblicazione pubblicazione) {
		getPubblicaziones().remove(pubblicazione);
		pubblicazione.setTipoPubblicazione(null);

		return pubblicazione;
	}

}