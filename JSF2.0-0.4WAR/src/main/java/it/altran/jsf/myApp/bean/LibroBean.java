package it.altran.jsf.myApp.bean;

public class LibroBean {

	private String id;
	private String titolo;
	private String genere;
	private String nomeAutore;
	private String cognomeAutore;
	
	
	public LibroBean(){		
		
	}
	
	public LibroBean(int id, String titolo){		
		new LibroBean( id,  titolo,null,null,null);
	}
	
	public LibroBean(int id, String titolo,String genere,String nomeAutore,String cognomeAutore){		
		this.id=""+id;
		this.titolo=titolo;
		this.genere=genere;
		this.nomeAutore=nomeAutore;
		this.cognomeAutore=cognomeAutore;
	}
	
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getNomeAutore() {
		return nomeAutore;
	}
	public void setNomeAutore(String nomeAutore) {
		this.nomeAutore = nomeAutore;
	}
	public String getCognomeAutore() {
		return cognomeAutore;
	}
	public void setCognomeAutore(String cognomeAutore) {
		this.cognomeAutore = cognomeAutore;
	}
	
	
	
	
}
