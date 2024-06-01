package monopoly.visuale;

import javafx.application.Application;
import javafx.stage.Stage;


import java.io.IOException;


public class MainVisuale extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        new GiocoVisuale(primaryStage);


    }
}
