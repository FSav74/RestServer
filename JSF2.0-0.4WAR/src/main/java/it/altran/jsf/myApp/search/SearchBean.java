package it.altran.jsf.myApp.search;



import it.altran.jsf.myApp.bean.GenereBean;
import it.altran.jsf.myApp.bean.LibroBean;
import it.altran.jsf.myApp.jpa.dao.PubblicazioneDAO;
import it.altran.jsf.myApp.jpa.dao.common.DataException;
import it.altran.jsf.myApp.jpa.entity.Autore;
import it.altran.jsf.myApp.jpa.entity.Pubblicazione;
import it.altran.jsf.myApp.jpa.entity.PubblicazioneAutore;



import it.altran.jsf.myApp.utility.ConfigurationProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import org.primefaces.model.LazyDataModel;


@ManagedBean(name="searchBean")
@SessionScoped
public class SearchBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8846481736140622961L;

	@PersistenceContext
	private EntityManager em;
	
	private List<GenereBean> listaGeneri;
	private String genereSel;
	
	private String titolo;
	
	private LazyDataModel<LibroBean> lazyModel;
	
	private ArrayList<LibroBean> listaLibri = null;

	
	public SearchBean(){
		
		ConfigurationProperties configuration = ConfigurationProperties.getInstance();
		listaGeneri = configuration.getListaGeneri();
		
		this.genereSel="2";
	}
	
	public LazyDataModel<LibroBean> getLazyModel() {
        return lazyModel;
    }
 
	
    public String search() {
    	System.out.println("Start search...........");
		System.out.println("titolo selezionato:"+titolo);
		
       lazyModel = new LazyBookDataModel(em, titolo);
        
        return "resultSearch";
    }
    
	
	public String searchOLD(){
		
		System.out.println("Start search...........");
		System.out.println("titolo selezionato:"+titolo);
		System.out.println("genere selezionato:"+genereSel);
		
		
		listaLibri = new ArrayList<LibroBean>(); 
//		//TODO:Only for test
//		//TODO:Only for test
//		listaLibri.add(new LibroBean( 1,  "IL NOME DELLA ROSA","ROMANZO","UMBERTO","ECO"));
//		listaLibri.add(new LibroBean( 1,  "IL PENDOLO DI FOCAULT","ROMANZO","UMBERTO","ECO"));
//		listaLibri.add(new LibroBean( 1,  "IT","HORROR","STEPHEN","KING"));
		
		
		PubblicazioneDAO dao = new PubblicazioneDAO(em);
		ArrayList<Pubblicazione> lista = null;
		try {
			lista = dao.getPubblicazionefromTitolo(titolo);
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (lista!=null){
			for (Pubblicazione next : lista) {
				LibroBean libro = new LibroBean();
				libro.setTitolo(next.getTitolo());
				List<PubblicazioneAutore> autori = next.getPubblicazioneAutores();
				String totale ="";
				for (PubblicazioneAutore next2 : autori) {
					Autore autore = next2.getAutore();
					totale += autore.getNome() + " "+ autore.getCognome()+ " ";
				}
				libro.setCognomeAutore(totale);
				listaLibri.add(libro);
			}
		}
		
	
		return "resultSearch";
		
	}
	

	
	
	public List<GenereBean> getListaGeneri() {
		return listaGeneri;
	}

	public void setListaGeneri(List<GenereBean> listaGeneri) {
		this.listaGeneri = listaGeneri;
	}

	public String getGenereSel() {
		return genereSel;
	}

	public void setGenereSel(String genereSel) {
		this.genereSel = genereSel;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public ArrayList<LibroBean> getListaLibri() {
		return listaLibri;
	}

	public void setListaLibri(ArrayList<LibroBean> listaLibri) {
		this.listaLibri = listaLibri;
	}
	
	
	
	

}
