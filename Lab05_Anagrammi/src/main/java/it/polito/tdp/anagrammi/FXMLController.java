package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model; 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnAnagramma;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void calcolaAnagramma(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	
    	//controllo dell'input
    	if (txtParola.getText().length()==0) {
    		//non ha inserito nulla
    		txtCorretti.appendText("Inserire una parola da anagrammare! \n");
    		txtErrati.appendText("Inserire una parola da anagrammare! \n");
    		return; 
    	}
    	
    	List<Parola> anagrammi= new ArrayList<>(this.model.anagramma(txtParola.getText().toLowerCase())); 
    	for (Parola p : anagrammi) {
    		//if (model.parolaValida(p)) { anche con questo metodo
    		if(p.isValida()) {
    			txtCorretti.appendText(p+"\n");
    		}
    		else txtErrati.appendText(p+"\n");
    	}

    }

    //pulizia tutti i campi
    @FXML
    void doReset(ActionEvent event) {
    	
    	txtParola.clear();
    	txtCorretti.clear();
    	txtErrati.clear();

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model; 
		
	}
}
