
package it.polito.tdp.parole;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.parole.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    

    @FXML
    private TextArea txtTempi;

    @FXML
    private Button btnCancella;

    @FXML
    private Button btnReset;

    @FXML
    void doCancella(ActionEvent event) {
    	long tempoInizio = System.nanoTime();
    	
    	String selezionato = txtResult.getSelectedText();
    	//txtResult.appendText("selezionato="+selezionato+"\n");
    	elenco.cancella(selezionato);
    	txtResult.clear();
    	
    	String risultato="";
    	for(String s : elenco.getElenco()) {
    		risultato=risultato+s+"\n";
    	}
    	txtResult.appendText(risultato);
    	//String tempo=(Integer.toString(((int) System.nanoTime())));
    	//txtTempi.appendText("il Tempo impiegato per questa operazione è di"+"nanosecondi\n");
    	
    	long tempoFine=System.nanoTime();
    	txtTempi.appendText("Il tempo impiegato per l'operazione cancella e': "+Double.toString((tempoFine-tempoInizio)/1000000.0) +"ms\n");
    	
    	
    		
    }

    @FXML
    void doInsert(ActionEvent event) {
    	long tempoInizio = System.nanoTime();
    	txtResult.clear();
    	String Parola = txtParola.getText();
    	elenco.addParola(Parola);
    	elenco.getElenco();
    	String result="";
    	for(String s: elenco.getElenco()) {
    		result= result+ s+ "\n";
    	}
    	
    	txtResult.appendText(result);
    	txtParola.clear();
    	long tempoFine=System.nanoTime();
    	txtTempi.appendText("Il tempo impiegato per l'operazione cancella e': "+Double.toString((tempoFine-tempoInizio)/1000000.0) +"ms\n");
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.clear();
    	txtTempi.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempi != null : "fx:id=\"txtTempi\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
        
    }
}

