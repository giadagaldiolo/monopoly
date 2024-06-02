package monopoly.visuale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import monopoly.componentigioco.Dado;

import java.io.File;
import java.util.Random;

public class ControllerDado {
    @FXML
    private Button lanciaDadi;

    @FXML
    private ImageView dadoImg;
    @FXML
    private ImageView dadoImg1;
    @FXML
    public void rollDice(ActionEvent event){
        int numeroDiGiriDado=20;
        lanciaDadi.setDisable(true);
        Thread thread=new Thread(){
            public void run(){
                for (int i = 0; i <numeroDiGiriDado ; i++) {

                    String dadoScelto="dice_"+ new Random().nextInt(1,7)+".png";
                    File file= new File("risorse/img/".replace("/",File.separator)+dadoScelto);
                    dadoImg.setImage(new Image(file.toURI().toString()));
                    dadoImg1.setImage(new Image(file.toURI().toString()));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                Dado.lancioDadi();

                Dado dadi[]= Dado.getDadi();
                int c=0;
                for (Dado dado : dadi) {
                    String dadoScelto="dice_"+dado.getUltimoLancio()+ ".png";
                    File file= new File("risorse/img/".replace("/",File.separator)+dadoScelto);
                    if (c>0){
                        dadoImg1.setImage(new Image(file.toURI().toString()));
                        break;
                    }
                    dadoImg.setImage(new Image(file.toURI().toString()));
                    c++;

                }



                lanciaDadi.setDisable(false);

            }
        };
        thread.start();
        MainVisuale.getGiocoVisuale().turnoVisuale();


    }
}
