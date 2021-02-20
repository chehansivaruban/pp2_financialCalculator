package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
            //calls the homeSc method of HomeScene class
        HomeScene.homeSc();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
