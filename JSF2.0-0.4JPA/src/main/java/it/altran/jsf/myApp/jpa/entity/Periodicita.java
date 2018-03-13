package it.altran.jsf.myApp.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the periodicita database table.
 * 
 */
@Entity
@NamedQuery(name="Periodicita.findAll", query="SELECT p FROM Periodicita p")
public class Periodicita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PERIODICITA")
	private int idPeriodicita;

	@Column(name="DESC_PERIODICITA")
	private String descPeriodicita;

	//bi-directional many-to-one association to Pubblicazione
	@OneToMany(mappedBy="periodicita")
	private List<Pubblicazione> pubblicaziones;

	public Periodicita() {
	}

	public int getIdPeriodicita() {
		return this.idPeriodicita;
	}

	public void setIdPeriodicita(int idPeriodicita) {
		this.idPeriodicita = idPeriodicita;
	}

	public String getDescPeriodicita() {
		return this.descPeriodicita;
	}

	public void setDescPeriodicita(String descPeriodicita) {
		this.descPeriodicita = descPeriodicita;
	}

	public List<Pubblicazione> getPubblicaziones() {
		return this.pubblicaziones;
	}

	public void setPubblicaziones(List<Pubblicazione> pubblicaziones) {
		this.pubblicaziones = pubblicaziones;
	}

	public Pubblicazione addPubblicazione(Pubblicazione pubblicazione) {
		getPubblicaziones().add(pubblicazione);
		pubblicazione.setPeriodicita(this);

		return pubblicazione;
	}

	public Pubblicazione removePubblicazione(Pubblicazione pubblicazione) {
		getPubblicaziones().remove(pubblicazione);
		pubblicazione.setPeriodicita(null);

		return pubblicazione;
	}

}