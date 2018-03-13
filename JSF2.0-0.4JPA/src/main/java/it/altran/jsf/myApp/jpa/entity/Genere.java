package it.altran.jsf.myApp.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genere database table.
 * 
 */
@Entity
@NamedQuery(name="Genere.findAll", query="SELECT g FROM Genere g")
public class Genere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_GENERE")
	private int idGenere;

	@Column(name="DESC_GENERE")
	private String descGenere;

	//bi-directional many-to-one association to CategoriaGenere
	@ManyToOne
	@JoinColumn(name="CATEGORIA_GENERE_ID_CATEGORIA_GENERE")
	private CategoriaGenere categoriaGenere;

	//bi-directional many-to-many association to Pubblicazione
	@ManyToMany(mappedBy="generes")
	private List<Pubblicazione> pubblicaziones;

	public Genere() {
	}

	public int getIdGenere() {
		return this.idGenere;
	}

	public void setIdGenere(int idGenere) {
		this.idGenere = idGenere;
	}

	public String getDescGenere() {
		return this.descGenere;
	}

	public void setDescGenere(String descGenere) {
		this.descGenere = descGenere;
	}

	public CategoriaGenere getCategoriaGenere() {
		return this.categoriaGenere;
	}

	public void setCategoriaGenere(CategoriaGenere categoriaGenere) {
		this.categoriaGenere = categoriaGenere;
	}

	public List<Pubblicazione> getPubblicaziones() {
		return this.pubblicaziones;
	}

	public void setPubblicaziones(List<Pubblicazione> pubblicaziones) {
		this.pubblicaziones = pubblicaziones;
	}

}