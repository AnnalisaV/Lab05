package it.polito.tdp.anagrammi.dao;

import it.polito.tdp.anagrammi.model.Parola;


public class testDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnagrammaDAO d= new AnagrammaDAO(); 
		Parola p = new Parola("abaco"); 
		System.out.println(d.parolaValida(p)); 
		
	}

}
