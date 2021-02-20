package sample;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.io.FileNotFoundException;
import static sample.SavingsScene.*;


public class Loan{
    public static double pmt1,pmt2,pmt4,period2,future2,rate2,rate3;
    public static Scene loan() throws FileNotFoundException {

        //TabPane------------------------------------------------------------------------------------
        // -----------
        TabPane savingsTabc = new TabPane();

        //creating tabs-----------------------------------------------------------------------------------------
        Tab tab1 = new Tab("Monthly Payment");
        Tab tab2 = new Tab("Loan Amount");

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
        Label investmentLbl3 = new Label("Total Loan Amount");
        Label periodLbl3 = new Label("Number of Periods");
        Label rateLbl3 = new Label("Interest Rate");
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


        calculate3.setOnAction(e->{
            if (validation(periodTxt3)){
                period3 = Double.parseDouble(periodTxt3.getText());

            }

            if (validation(investmentTxt3)){
                investment3 = Double.parseDouble(investmentTxt3.getText());

            }
            if (validation(rateTxt3)){
                rate3 = Double.parseDouble(rateTxt3.getText());

            }

            if (validation(investmentTxt3) && validation(periodTxt3) && (validation(rateTxt3))){
                double result1PmtL = Math.round((Equations.payment(0,rate3/100,12,-investment3,period3/12)/12)*100.0)/100.0;

                result3.setText(String.valueOf(result1PmtL));
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


        });
        rateTxt3.setOnMouseClicked(event -> {
            field1 = false;
            field2 = false;
            field4 = false;
            field3 = true;


        });
        payment.getChildren().add(Keyboard.keypad());
        Keyboard.keypadFunction(periodTxt3,  investmentTxt3, rateTxt3,null);



        //setting tab1 content--------------------------------------------------------------------------------------
        payment.add(periodLbl3, 1, 5);
        payment.add(periodTxt3, 3, 5);
        payment.add(investmentLbl3, 1, 8);
        payment.add(investmentTxt3, 3, 8);
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


        calculate2.setOnAction(e->{
            if (validation(periodTxt2)){
                period2 = Double.parseDouble(periodTxt2.getText());

            }


            if (validation(rateTxt2)){
                rate2 = Double.parseDouble(rateTxt2.getText());

            }
            if (validation(pmtTxt2)){
                pmt2 = Double.parseDouble(pmtTxt2.getText());

            }
            if (validation(rateTxt2)  && validation(periodTxt2)){
                double result1InvL = -Equations.investment(0,rate1/100,12,period2/12,pmt2);

                result2.setText(String.valueOf(result1InvL));
            }
            else {
                result2.setText("Invalid Inut!");
            }
        });

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


        pmtTxt2.setOnMouseClicked(event -> {
            field1 = false;
            field2 = false;
            field4 = true;
            field3 = false;


        });
        investment.getChildren().add(Keyboard.keypad());
        Keyboard.keypadFunction(periodTxt2, rateTxt2, null, pmtTxt2);



        investment.add(periodLbl2, 1, 5);
        investment.add(periodTxt2, 3, 5);
        investment.add(rateLbl2, 1, 8);
        investment.add(rateTxt2, 3, 8);
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


























