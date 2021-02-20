package sample;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static sample.SavingsScene.*;


public class Mortgage{
    public static double pmt2,period2,rate2,rate3,down3,down2;
    public static Scene mortgage() throws FileNotFoundException {

        //TabPane-----------------------------------------------------------------------------------------------
        TabPane savingsTabc = new TabPane();

        //creating tabs-----------------------------------------------------------------------------------------
        Tab tab1 = new Tab("Monthly Payment");
        Tab tab2 = new Tab("Mortgage Amount");

        savingsTabc.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);


        tab1.setContent(payment());
        tab2.setContent(investment());
        savingsTabc.getTabs().addAll(tab1, tab2);

        Scene savingsScene = new Scene(savingsTabc, 500, 600);
        //savings scene ends
        return savingsScene;


    }
    public static GridPane payment(){
        GridPane payment = new GridPane();
        payment.setPadding(new Insets(10, 10, 10, 10));
        payment.setVgap(8);
        payment.setHgap(10);
        //Labels------------------------------------------------------------------------------------------------
        Label investmentLbl3 = new Label("Total Mortgage Amount");
        Label periodLbl3 = new Label("Number of Periods");
        Label rateLbl3 = new Label("Interest Rate");
        Label downLbl3 = new Label("Down Pament");
        Label result3 = new Label("" );
        Label answer3 = new Label("Monthly Payment");
        //calculate button--------------------------------------------------------------------------------------
        Button calculate3 = new Button("Calculate");

        Button backBtn3 = new Button("Back");
        backBtn3.setOnAction(e-> {
            try {
                HomeScene.homeSc();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        //textFields----------------------------------------------------------------------------------------
        TextField periodTxt3 = new TextField();
        TextField investmentTxt3 = new TextField();
        TextField rateTxt3 = new TextField();
        TextField downTxt3 = new TextField();


        calculate3.setOnAction(e->{
            if (validation(periodTxt3)){
                period3 = Double.parseDouble(periodTxt3.getText());

            }

            if (validation(investmentTxt3)){
                investment3 = Double.parseDouble(investmentTxt3.getText());

            }if (validation(downTxt3)){
                down3 = Double.parseDouble(downTxt3.getText());

            }
            if (validation(rateTxt3)){
                rate3 = Double.parseDouble(rateTxt3.getText());

            }

            if (validation(investmentTxt3) && validation(periodTxt3) && (validation(rateTxt3))){
                double result1PmtM = Math.round((Equations.payment(0,rate3/100,12,-(investment3-down3),period3/12)/12)*100.0)/100.0;

                result3.setText(String.valueOf(result1PmtM));
            }
            else {
                result3.setText("Invalid input!");
            }
        });


        //Keypad FUnctions

        periodTxt3.setOnMouseClicked(event -> {
            field1 = false;
            field2 = true;
            field4 = false;
            field3 = false;
        });



        investmentTxt3.setOnMouseClicked(event -> {

            field1 = true;
            field2 = false;
            field4 = false;
            field3 = false;


        });downTxt3.setOnMouseClicked(event -> {

            field1 = true;
            field2 = false;
            field4 = false;
            field3 = true;


        });
        rateTxt3.setOnMouseClicked(event -> {
            field1 = false;
            field2 = false;
            field4 = true;
            field3 = false;


        });
        payment.getChildren().add(Keyboard.keypad());
        Keyboard.keypadFunction(periodTxt3,  investmentTxt3,downTxt3, rateTxt3);



        //setting tab1 content--------------------------------------------------------------------------------------
        payment.add(periodLbl3, 1, 5);
        payment.add(periodTxt3, 3, 5);
        payment.add(investmentLbl3, 1, 8);
        payment.add(investmentTxt3, 3, 8);
        payment.add(downLbl3, 1, 9);
        payment.add(downTxt3, 3, 9);
        payment.add(rateLbl3, 1, 12);
        payment.add(rateTxt3, 3, 12);
        payment.add(calculate3, 1, 25);
        payment.add(result3, 3, 14);
        payment.add(answer3,1,14);
        payment.add(backBtn3, 1, 32);
        return payment;

    }


    public static GridPane investment(){

        GridPane investment = new GridPane();
        investment.setPadding(new Insets(10, 10, 10, 10));
        investment.setVgap(8);
        investment.setHgap(10);

        //Labels------------------------------------------------------------------------------------------------
        Label rateLbl2 = new Label("Interest Rate");
        Label periodLbl2 = new Label("Number of Periods");
        Label answer2= new Label("Loan Amount  ");
        Label result2 = new Label("" );
        Label pmtLbl2 = new Label("Monthly Amount");
        Label downLbl2 = new Label("Down Pament");
        //calculate button--------------------------------------------------------------------------------------
        Button calculate2 = new Button("Calculate");
        Button backBtn2 = new Button("Back");
        backBtn2.setOnAction(e-> {
            try {
                HomeScene.homeSc();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        //textFields----------------------------------------------------------------------------------------
        TextField periodTxt2 = new TextField();
        TextField rateTxt2 = new TextField();
        TextField pmtTxt2 = new TextField();
        TextField downTxt2 = new TextField();


        calculate2.setOnAction(e->{
            if (validation(periodTxt2)){
                period2 = Double.parseDouble(periodTxt2.getText());
            }
            if (validation(rateTxt2)){
                rate2 = Double.parseDouble(rateTxt2.getText());
            }if (validation(downTxt2)){
                down2 = Double.parseDouble(downTxt2.getText());
            }
            if (validation(pmtTxt2)){
                pmt2 = Double.parseDouble(pmtTxt2.getText());
            }
            if (validation(rateTxt2)  && validation(periodTxt2)){
                double result1InvM = (-Equations.investment(0,rate1/100,12,period2/12,pmt2))+down3;

                result2.setText(String.valueOf(result1InvM));
            }
            else {
                result2.setText("Invalid Inut!");
            }

            try {
                FileWriter writeMortgageData = new FileWriter("mortgageData.txt");
                writeMortgageData.append("\n" + period2);
                writeMortgageData.append("\n" + rate2);
                writeMortgageData.append("\n" + down2);
                writeMortgageData.append("\n" + pmt2);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });
        File mortgageDataFile = new File("mortgageData.txt");
        String[] data = new String[4];
        try {
            if (mortgageDataFile.exists()){
                Scanner readMortgageData = new Scanner(mortgageDataFile);
                while (readMortgageData.hasNextLine()){
                    int x = 0;
                    data[x] = readMortgageData.nextLine();
                    x += 1;
                }
                readMortgageData.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        periodTxt2.setText(data[0]);
        rateTxt2.setText(data[1]);
        downTxt2.setText(data[2]);
        pmtTxt2.setText(data[3]);

        //Keypad FUnctions

        periodTxt2.setOnMouseClicked(event -> {
            field1 = false;
            field2 = true;
            field4 = false;
            field3 = false;
        });

        rateTxt2.setOnMouseClicked(event -> {
            field1 = true;
            field2 = false;
            field4 = false;
            field3 = false;


        });
        downTxt2.setOnMouseClicked(event -> {

            field1 = true;
            field2 = false;
            field4 = false;
            field3 = true;


        });


        pmtTxt2.setOnMouseClicked(event -> {
            field1 = false;
            field2 = false;
            field4 = true;
            field3 = false;


        });
        investment.getChildren().add(Keyboard.keypad());
        Keyboard.keypadFunction(periodTxt2, rateTxt2, downTxt2, pmtTxt2);



        investment.add(periodLbl2, 1, 5);
        investment.add(periodTxt2, 3, 5);
        investment.add(rateLbl2, 1, 8);
        investment.add(rateTxt2, 3, 8);
        investment.add(downLbl2, 1, 10);
        investment.add(downTxt2, 3, 10);
        investment.add(pmtLbl2, 1, 12);
        investment.add(pmtTxt2, 3, 12);
        investment.add(calculate2, 1, 25);
        investment.add(result2, 3, 14);
        investment.add(answer2,1,14);
        investment.add(backBtn2, 1, 32);




        //calculations----------------------------------------------------------------------------------------------

        return investment;

    }


    public static boolean validation(TextField textFieldName){

        try{
            double text = Double.parseDouble(textFieldName.getText());
            return true;
        }
        catch (Exception e){
            textFieldName.setText("Invalid Text");
            return false;
        }

    }
}


























