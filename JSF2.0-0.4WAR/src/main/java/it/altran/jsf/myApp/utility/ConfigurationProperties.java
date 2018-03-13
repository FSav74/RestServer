package it.altran.jsf.myApp.utility;

import it.altran.jsf.myApp.bean.GenereBean;

import java.util.ArrayList;

public class ConfigurationProperties {
	
	private static ConfigurationProperties instance;
	
	private static ArrayList<GenereBean> listaGeneri = null;
	
	private ConfigurationProperties(){
		
		System.out.println("Costruttore ConfigurationProperties...carico le liste");
		
		//carico le costanti
		_caricoDalDB();
		
		
		
	}

	
	public static ConfigurationProperties getInstance(){
		
		if(instance==null){
			synchronized(ConfigurationProperties.class){
				
				if(instance==null){
					instance = new ConfigurationProperties();
				}
			}
		
		}
		return instance;
		
	}
	
	
	private void _caricoDalDB(){
		
		//TODO:Only for Test
		//TODO:Only for Test
		listaGeneri = new ArrayList<GenereBean>();
		this.listaGeneri.add(new GenereBean(0," "));
		this.listaGeneri.add(new GenereBean(1,"ROSA"));
		this.listaGeneri.add(new GenereBean(2,"GIALLO"));	
		this.listaGeneri.add(new GenereBean(3,"FANTASY"));	
		this.listaGeneri.add(new GenereBean(4,"FANTASCIENZA"));	
		this.listaGeneri.add(new GenereBean(5,"HORROR"));	
		
		
		
	}
	
	public ArrayList<GenereBean> getListaGeneri(){
		return this.listaGeneri;
	}
		
	
}
