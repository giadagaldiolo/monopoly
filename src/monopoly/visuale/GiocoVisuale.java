package monopoly.visuale;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;
import monopoly.Gioco;
import monopoly.componentigioco.giocatore.Giocatore;
import monopoly.utilita.Costanti;
import java.io.IOException;


public class GiocoVisuale extends Gioco {
    public static Stage stage;

    public GiocoVisuale(Stage primaryStage)throws IOException  {
        super(true);
        GiocoVisuale.stage=primaryStage;
        stage.setResizable(false);
        inizio();

    }
    private void inizio()throws IOException {
        int x =600;
        int y =400;
        ControllerInput controllerInput = new ControllerInput(super.getGiocatori(),this); // Passa l'istanza di GiocoVisuale al controller

        FXMLLoader fxmlLoader = new FXMLLoader(MainVisuale.class.getResource("PrimaSchermata.fxml"));

        fxmlLoader.setController(controllerInput);
        Scene scene = new Scene(fxmlLoader.load(), x, y);
        stage.setTitle("Monopoly");
        stage.setScene(scene);

        stage.show();

    }
    @Override
    public void creaGiocatori() {

        for (Giocatore giocatore  : super.getGiocatori() ) {
            super.getTabellone().modificaCasella(giocatore.getSimbolo(), Costanti.RIGHE-1, Costanti.CASELLE_PER_RIGA-1);

        }

    }
    @Override
    public void avviaGioco(){
        creaGiocatori();
        gameFlow();
    }




}
