package it.altran.jsf.myApp.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the editore database table.
 * 
 */
@Entity
@NamedQuery(name="Editore.findAll", query="SELECT e FROM Editore e")
public class Editore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_EDITORE")
	private int idEditore;

	@Column(name="DESC_EDITORE")
	private String descEditore;

	//bi-directional many-to-one association to Pubblicazione
	@OneToMany(mappedBy="editore")
	private List<Pubblicazione> pubblicaziones;

	public Editore() {
	}

	public int getIdEditore() {
		return this.idEditore;
	}

	public void setIdEditore(int idEditore) {
		this.idEditore = idEditore;
	}

	public String getDescEditore() {
		return this.descEditore;
	}

	public void setDescEditore(String descEditore) {
		this.descEditore = descEditore;
	}

	public List<Pubblicazione> getPubblicaziones() {
		return this.pubblicaziones;
	}

	public void setPubblicaziones(List<Pubblicazione> pubblicaziones) {
		this.pubblicaziones = pubblicaziones;
	}

	public Pubblicazione addPubblicazione(Pubblicazione pubblicazione) {
		getPubblicaziones().add(pubblicazione);
		pubblicazione.setEditore(this);

		return pubblicazione;
	}

	public Pubblicazione removePubblicazione(Pubblicazione pubblicazione) {
		getPubblicaziones().remove(pubblicazione);
		pubblicazione.setEditore(null);

		return pubblicazione;
	}

}