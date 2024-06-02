package monopoly.visuale;

import javafx.application.Application;
import javafx.stage.Stage;


import java.io.IOException;


public class MainVisuale extends Application {
    private static GiocoVisuale giocoVisuale;

    public static void main(String[] args) {
        launch(args);
        MainVisuale.giocoVisuale.avviaGioco();

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        MainVisuale.giocoVisuale=new GiocoVisuale(primaryStage);


    }
}
