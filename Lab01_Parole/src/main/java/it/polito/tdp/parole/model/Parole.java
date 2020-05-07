package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	private List <String> elencoParole;
	public Parole() {
		elencoParole = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		elencoParole.add(p);
		Collections.sort(elencoParole,new ComparatorByOrdineAlfabetico());
	}
	
	public List<String> getElenco() {
		
		return elencoParole;
	}
	
	public void reset() {
		elencoParole.clear();
	}
	public void cancella(String s) {
		if(elencoParole.contains(s)) {
			elencoParole.remove(s);
		}
	}
}
