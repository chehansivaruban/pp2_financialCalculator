package sample;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class HomeScene {
    Stage stage = new Stage();//stage

    public static void homeSc() throws FileNotFoundException {

            //stage----------------------------------------------------------------------------------------------
        Stage stage = new Stage();



        //Grid pane------------------------------------------------------------------------------------------
        GridPane homeLayout = new GridPane();
        homeLayout.setStyle("-fx-background-color: coral");
        homeLayout.getStylesheets().addAll(HomeScene.class.getResource("Style.css").toExternalForm());
        homeLayout.setVgap(10);
        homeLayout.setHgap(10);
        homeLayout.setPadding(new Insets(10, 40, 0, 10));


            //home scene------------------------------------------------------------------------------------------
        Scene homeScene = new Scene(homeLayout);


            //Ttle Label-------------------------------------------------------------------------------------------
        Label title = new Label("Financial Calculator");
        title.setId("title");
        title.getStylesheets().addAll(HomeScene.class.getResource("Style.css").toExternalForm());


             //add button icon--------------------------------------------------------------------------------------
        FileInputStream inputIcon1 = new FileInputStream("C:\\pp2\\courswork\\images\\icon1.png");
        Image savingsIcon = new Image(inputIcon1);
        ImageView imageViewIcon1 = new ImageView(savingsIcon);


            //savings calculation scene button----------------------------------------------------------------------
        Button savingBtn = new Button("\n\n\n\n\n\n\n\n\nFixed Saving", imageViewIcon1);//savings button 1
        savingBtn.setOnAction(event -> {
            try {
                stage.setScene(SavingsScene.savings());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });


            //add button icon--------------------------------------------------------------------------------------
        FileInputStream inputIcon2 = new FileInputStream("C:\\pp2\\courswork\\images\\icon2.png");
        Image compoundSavingsIcon = new Image(inputIcon2);
        ImageView imageViewIcon2 = new ImageView(compoundSavingsIcon);


            //compound savings calculation scene button------------------------------------------------------------
        Button compoundSavingBtn = new Button("\n\n\n\n\n\n\n\n\nSavings With Payment", imageViewIcon2);//compoundSaving button 2
        compoundSavingBtn.setOnAction(e -> {
            try {
                stage.setScene(CompoundSaving.savings());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });


          //add button icon-----------------------------------------------------------------------------------
        FileInputStream inputIcon3 = new FileInputStream("C:\\pp2\\courswork\\images\\icon3.png");
        Image mortgageIcon = new Image(inputIcon3);
        ImageView imageViewIcon3 = new ImageView(mortgageIcon);


            //mortgage savings calculation scene button------------------------------------------------------------
        Button mortgageBtn = new Button("\n\n\n\n\n\n\n\n\nMortgage", imageViewIcon3);//mortgageBtn button 3
        mortgageBtn.setOnAction(e -> {
                    try {
                        stage.setScene(Mortgage.mortgage());
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                });


             //add button icon--------------------------------------------------------------------------------------
        FileInputStream inputIcon4 = new FileInputStream("C:\\pp2\\courswork\\images\\icon4.png");
        Image loanIcon = new Image(inputIcon4);
        ImageView imageViewIcon4 = new ImageView(loanIcon);


            //Loans calculation scene button------------------------------------------------------------
        Button loanBtn = new Button("\n\n\n\n\n\n\n\n\nLoan", imageViewIcon4);// loanBtn button 4
        loanBtn.setOnAction(e -> {
            try {
                stage.setScene(Loan.loan());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });


            //add button icon--------------------------------------------------------------------------------------
        FileInputStream inputIcon5 = new FileInputStream("C:\\pp2\\courswork\\images\\icon5.png");
        Image helpIcon = new Image(inputIcon5);
        ImageView imageViewIcon5 = new ImageView(helpIcon);
        //Help label------------------------------------------------------------
        Label helpLbl = new Label("Want some Help?");
        helpLbl.setId("help");
            //Help button------------------------------------------------------------
        Button helpBtn = new Button("",imageViewIcon5);// loanBtn button 4
        helpBtn.setOnAction(e -> {
            Help.helpStage();
        });
        stage.setResizable(false);


        homeLayout.add(title,2,2,3,2);
        homeLayout.add(savingBtn, 1, 5);
        homeLayout.add(compoundSavingBtn, 2, 5);
        homeLayout.add(mortgageBtn, 1, 6);
        homeLayout.add(loanBtn, 2, 6);
        homeLayout.add(helpLbl, 3, 17);
        homeLayout.add(helpBtn, 3, 19);
        //end of home scene-----------------------------------------------------------------------------------


        //setting stage-----------------------------------------------------------------------------------
        stage.setX(50);
        stage.setY(10);
        stage.setWidth(655);
        stage.setHeight(700);
        stage.setTitle("Financial Calculator");
        stage.setScene(homeScene);
        stage.show();
    }
}

