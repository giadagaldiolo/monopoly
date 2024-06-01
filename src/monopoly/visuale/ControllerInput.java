package monopoly.visuale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import monopoly.Gioco;
import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.utilita.Costanti;
import monopoly.utilita.ScannerUtils;


import java.io.IOException;
import java.util.LinkedHashSet;

public class ControllerInput {

    @FXML
    private Button RegistrazioneCompleta;
    @FXML
    private TextField InserisciNome;
    @FXML
    private TextField InserisciSimbolo;
    @FXML
    private Label NumeroGiocatore;
    private int nPlayer=1;
    private LinkedHashSet<Giocatore> giocatori;
    private Gioco gioco;
    public ControllerInput(LinkedHashSet<Giocatore> giocatori, Gioco gioco){
        this.gioco=gioco;
        this.giocatori=giocatori;

    }


    public void creaGiocatore(ActionEvent event) throws IOException {

        if (this.InserisciSimbolo.getText().isBlank()||this.InserisciNome.getText().isBlank()) return;
        Giocatore giocatore=ScannerUtils.leggiSimboloStringa(new String[]{this.InserisciNome.getText().strip(),this.InserisciSimbolo.getText().strip()});
        if (this.giocatori.add(giocatore)) this.NumeroGiocatore.setText(this.NumeroGiocatore.getText()+ ++nPlayer);
        if (this.nPlayer>Costanti.NUMERO_GIOCATORI) {

            GiocoVisuale.stage.close();
            gioco.avviaGioco();
        }


    }


}
