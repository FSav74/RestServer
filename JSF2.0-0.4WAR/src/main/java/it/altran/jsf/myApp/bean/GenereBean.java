package it.altran.jsf.myApp.bean;

public class GenereBean {

	
	private int  genereId;
	private String descrizione;
	
	public GenereBean(int id, String descrizione){
		
		this.genereId=id;
		this.descrizione=descrizione;
	}
	
	
	
	public int getGenereId() {
		return genereId;
	}
	public void setGenereId(int genereId) {
		this.genereId = genereId;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
