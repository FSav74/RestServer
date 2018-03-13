package it.altran.jsf.myApp.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria_genere database table.
 * 
 */
@Entity
@Table(name="categoria_genere")
@NamedQuery(name="CategoriaGenere.findAll", query="SELECT c FROM CategoriaGenere c")
public class CategoriaGenere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_CATEGORIA_GENERE")
	private int idCategoriaGenere;

	@Column(name="DESC_CATEGORIA_GENERE")
	private String descCategoriaGenere;

	//bi-directional many-to-one association to Genere
	@OneToMany(mappedBy="categoriaGenere")
	private List<Genere> generes;

	public CategoriaGenere() {
	}

	public int getIdCategoriaGenere() {
		return this.idCategoriaGenere;
	}

	public void setIdCategoriaGenere(int idCategoriaGenere) {
		this.idCategoriaGenere = idCategoriaGenere;
	}

	public String getDescCategoriaGenere() {
		return this.descCategoriaGenere;
	}

	public void setDescCategoriaGenere(String descCategoriaGenere) {
		this.descCategoriaGenere = descCategoriaGenere;
	}

	public List<Genere> getGeneres() {
		return this.generes;
	}

	public void setGeneres(List<Genere> generes) {
		this.generes = generes;
	}

	public Genere addGenere(Genere genere) {
		getGeneres().add(genere);
		genere.setCategoriaGenere(this);

		return genere;
	}

	public Genere removeGenere(Genere genere) {
		getGeneres().remove(genere);
		genere.setCategoriaGenere(null);

		return genere;
	}

}