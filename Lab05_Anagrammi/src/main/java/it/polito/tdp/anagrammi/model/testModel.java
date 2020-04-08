package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public abstract class testModel {

	public static void main(String[] args) {
		
		Model model= new Model(); 
		
		List<Parola> elenco= new ArrayList<>(model.anagramma("ab"));
		
		for (Parola p : elenco) {
			System.out.println(p); 
		}

	}

}
