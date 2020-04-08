package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	private List<Parola> soluzione; 
	
	
	/**
	 * Data una parola, si ottengono tutti i suoi possibili anagrammi
	 * @param input parola da anagrammare
	 * @return elenco degli anagrammi di quella {@code Parola}
	 */
	public List<Parola> anagramma(String input) {
		
		this.soluzione= new ArrayList<>(); 
		
		//quali lettere vi sono per anagrammare 
		List<Character> lettere= new ArrayList<>(); 
		for (int i=0; i<input.length(); i++) {
			lettere.add(input.charAt(i)); 
		}
		
		//avviamento del processo ricorsivo
		formazioneAnagramma("", 0, lettere); 
		
		return this.soluzione; 
	}


	/**
	 * Procedura ricorsiva di creazione dell'anagramma 
	 * @param pezzo  parola anagrammata che si sta costruendo
	 * @param livello numro di lettere che compongono il 'pezzo'
	 * @param lettereDisponibili insieme delle lettere che possono essere usate per creare l'anagramma 
	 */
	private void formazioneAnagramma(String pezzo, int livello, List<Character> lettereDisponibili) {
	
		Parola parola; 
		
		// caso terminale 
		if (lettereDisponibili.size()==0) {
			parola= new Parola(pezzo); 
			this.soluzione.add(parola); 
		}
		//situazione generica 
		for (Character c : lettereDisponibili) {
			String anagramma= pezzo+c; 
			
			List<Character> lettereRimaste= new ArrayList<>(lettereDisponibili); 
			lettereRimaste.remove(c); 
			
			formazioneAnagramma(anagramma, livello+1,lettereRimaste); 
		}
		
	}
	
	

}
