package it.altran.jsf.myApp.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import it.altran.jsf.myApp.bean.LibroBean;
import it.altran.jsf.myApp.jpa.dao.PubblicazioneDAO;
import it.altran.jsf.myApp.jpa.dao.common.DataException;
import it.altran.jsf.myApp.jpa.entity.Autore;
import it.altran.jsf.myApp.jpa.entity.Pubblicazione;
import it.altran.jsf.myApp.jpa.entity.PubblicazioneAutore;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyBookDataModel extends LazyDataModel<LibroBean>{
	
	private static final long serialVersionUID = 3689378583688350375L;
	
	private EntityManager em;
	private String titoloSel;

	
	public LazyBookDataModel(EntityManager entityManager,String sel) {
        this.em = entityManager;
        this.titoloSel = sel;
    }
	
	
	@Override
	public List<LibroBean> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
//        super.load(first, pageSize, sortField, sortOrder, filters);
		List<LibroBean> data = new ArrayList<LibroBean>();
 
		System.out.println("load..............."+titoloSel);
		
		
		PubblicazioneDAO dao = new PubblicazioneDAO(em);
		ArrayList<Pubblicazione> lista = null;
		
		int pageIndex = first / pageSize;
		System.out.println("PAGEINDEX:"+pageIndex);
		
		try {
			lista = dao.getPubblicazionefromTitolo( titoloSel, pageIndex, pageSize);
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
				data.add(libro);
			}
		}
		
		int dataSize=0;
		try {
			dataSize = (int)dao.getCountPubblicazionefromTitolo(titoloSel);
		} catch (DataException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        this.setRowCount(dataSize);
  
        
        System.out.println("DIM2:"+dataSize);
 
     
        return data;


		
    }
	
	

}
