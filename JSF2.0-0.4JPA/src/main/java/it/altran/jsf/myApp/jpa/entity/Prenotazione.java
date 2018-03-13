package it.altran.jsf.myApp.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the prenotazione database table.
 * 
 */
@Entity
@NamedQuery(name="Prenotazione.findAll", query="SELECT p FROM Prenotazione p")
public class Prenotazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PRENOTAZIONE_PUBBLICAZIONE")
	private int idPrenotazionePubblicazione;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_FINE_PRENOTAZIONE")
	private Date dataFinePrenotazione;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_INIZIO_PRENOTAZIONE")
	private Date dataInizioPrenotazione;

	@Column(name="ID_PUBBLICAZIONE")
	private int idPubblicazione;

	private int status;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-many association to Pubblicazione
	@ManyToMany
	@JoinTable(
		name="prenotazione_pubblicazione"
		, joinColumns={
			@JoinColumn(name="ID_PRENOTAZIONE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_PUBBLICAZIONE")
			}
		)
	private List<Pubblicazione> pubblicaziones;

	public Prenotazione() {
	}

	public int getIdPrenotazionePubblicazione() {
		return this.idPrenotazionePubblicazione;
	}

	public void setIdPrenotazionePubblicazione(int idPrenotazionePubblicazione) {
		this.idPrenotazionePubblicazione = idPrenotazionePubblicazione;
	}

	public Date getDataFinePrenotazione() {
		return this.dataFinePrenotazione;
	}

	public void setDataFinePrenotazione(Date dataFinePrenotazione) {
		this.dataFinePrenotazione = dataFinePrenotazione;
	}

	public Date getDataInizioPrenotazione() {
		return this.dataInizioPrenotazione;
	}

	public void setDataInizioPrenotazione(Date dataInizioPrenotazione) {
		this.dataInizioPrenotazione = dataInizioPrenotazione;
	}

	public int getIdPubblicazione() {
		return this.idPubblicazione;
	}

	public void setIdPubblicazione(int idPubblicazione) {
		this.idPubblicazione = idPubblicazione;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Pubblicazione> getPubblicaziones() {
		return this.pubblicaziones;
	}

	public void setPubblicaziones(List<Pubblicazione> pubblicaziones) {
		this.pubblicaziones = pubblicaziones;
	}

}