package it.polito.tdp.parole.model;

import java.util.Comparator;

public class ComparatorByOrdineAlfabetico implements Comparator <String>{

	@Override
	public int compare(String s1, String s2) {
		if(s1.compareTo(s2)!=0) {
			return s1.compareTo(s2);
		}
		else
		return 0;
	}

}
