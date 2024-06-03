package monopoly.visuale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import monopoly.componentigioco.Dado;
import monopoly.utilita.Costanti;

import java.io.File;

import java.util.Random;

public class ControllerDado {
    @FXML
    private Button lanciaDadi;
    @FXML
    private Label scrittaGiocatore;

    @FXML
    private ImageView dadoImg;
    @FXML
    private ImageView dadoImg1;
    @FXML
    public void initialize() {

        this.scrittaGiocatore.setText("Simbolo giocatore in gioco: "+GiocoVisuale.getCurrentPlayer().getSimboloChar());
    }

    @FXML
    public void rollDice(ActionEvent event){

        int numeroDiGiriDado=20;
        lanciaDadi.setDisable(true);
        int last[]= new int[2];



        for (int i = 0; i <numeroDiGiriDado ; i++) {
            last[0]=new Random().nextInt(1,7);
            String dadoScelto="dice_"+ last[0]+".png";
            last[1]=new Random().nextInt(1,7);
            String dadoScelto1="dice_"+ last[1]+".png";
            File file= new File("risorse/img/".replace("/",File.separator)+dadoScelto);
            File file1= new File("risorse/img/".replace("/",File.separator)+dadoScelto1);
            dadoImg.setImage(new Image(file.toURI().toString()));
            dadoImg1.setImage(new Image(file1.toURI().toString()));
            try {
                Thread.sleep(6);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
        lanciaDadi.setDisable(false);

        Dado dadi[]= Dado.getDadi();
        for (int i = 0; i < Costanti.NUMERO_DADI; i++) {
            dadi[i].setUltimoLancio(last[i]);
        }



        MainVisuale.getGiocoVisuale().turnoVisuale();


    }
}
