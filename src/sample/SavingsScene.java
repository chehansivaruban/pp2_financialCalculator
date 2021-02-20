package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.io.FileNotFoundException;

import static java.lang.Math.round;


public class SavingsScene{

    public static boolean field1, field2,field3,field4;
    public static double future1,investment3,period3,future3,rate4,future4,investment4,period1,investment1,rate1;

    public static Scene savings() throws FileNotFoundException {

            //TabPane-----------------------------------------------------------------------------------------------
        TabPane savingsTab = new TabPane();

            //creating tabs-----------------------------------------------------------------------------------------
        Tab tab1 = new Tab("Future Value");
        Tab tab2 = new Tab("Start Principle ");
        Tab tab3 = new Tab("Interest Rate");
        Tab tab4 = new Tab("Number of Periods");
        savingsTab.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);//Disables closing function


        tab1.setContent(future());
        tab2.setContent(investment());
        tab3.setContent(rate());
        tab4.setContent(period());
        savingsTab.getTabs().addAll(tab1, tab2, tab3, tab4);

        //savings scene ends
        return new Scene(savingsTab, 500, 600);


    }
            //method for the first tab-----------------------------------------------------------------------------
    public static GridPane future(){

        GridPane future = new GridPane();
        future.setId("futurePane");
        future.getStylesheets().addAll(SavingsScene.class.getResource("Style2.css").toExternalForm());
        future.setPadding(new Insets(10, 10, 10, 10));
        future.setVgap(8);
        future.setHgap(10);


            //Labels------------------------------------------------------------------------------------------------
        Label investmentLbl1 = new Label("Start Principle ");
        Label periodLbl1 = new Label("Number of Periods");
        Label interestLbl1 = new Label("Interest Rate");
        Label answer1= new Label("The Future Value  ");
        Label result1 = new Label("" );


            //calculate button--------------------------------------------------------------------------------------
        Button calculate1 = new Button("Calculate");
        Button backBtn1 = new Button("Back");
        backBtn1.setOnAction(e-> {
            try {
                HomeScene.homeSc();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });


            //textFields----------------------------------------------------------------------------------------
        TextField periodTxt1 = new TextField("Enter Years");
        TextField investmentTxt1 = new TextField("$");
        TextField rateTxt1 = new TextField("%");

            //setting tab1 content--------------------------------------------------------------------------------------

        calculate1.setOnAction(e->{
            if (validation(periodTxt1)){
                period1 = Double.parseDouble(periodTxt1.getText());

            }

            if (validation(investmentTxt1)){
                investment1 = Double.parseDouble(investmentTxt1.getText());

            }
            if (validation(rateTxt1)){
                rate1 = Double.parseDouble(rateTxt1.getText());

            }
            if (validation(rateTxt1) && validation(investmentTxt1) &&validation(periodTxt1)){
                double result = Equations.futureValue(investment1,rate1/100,1,period1,0);

                result1.setText("$ "+String.valueOf(result));
            }
            else {
                result1.setText("Invalid input!");
            }
        });

            //Keyboard FUnctions

        periodTxt1.setOnMouseClicked(event -> {
            field1 = false;
            field2 = true;
            field4 = false;
            field3 = false;
        });

        investmentTxt1.setOnMouseClicked(event -> {
            field1 = true;
            field2 = false;
            field4 = false;
            field3 = false;

        });

        rateTxt1.setOnMouseClicked(event -> {
            field1 = false;
            field2 = false;
            field4 = false;
            field3 = true;
        });
        future.getChildren().add(Keyboard.keypad());
        Keyboard.keypadFunction(periodTxt1, investmentTxt1, rateTxt1, null);


        future.add(periodLbl1, 1, 5);
        future.add(periodTxt1, 3, 5);
        future.add(investmentLbl1, 1, 8);
        future.add(investmentTxt1, 3, 8);
        future.add(interestLbl1, 1, 11);
        future.add(rateTxt1, 3, 11);
        future.add(calculate1, 1, 25);
        future.add(result1, 3, 12);
        future.add(answer1,1,12);
        future.add(backBtn1, 1, 32);



       return future;

    }
    public static GridPane investment(){

        GridPane investment = new GridPane();
        investment.setId("investmentPane");
        investment.getStylesheets().addAll(SavingsScene.class.getResource("Style2.css").toExternalForm());
        investment.setPadding(new Insets(10, 10, 10, 10));
        investment.setVgap(8);
        investment.setHgap(10);

        //Labels------------------------------------------------------------------------------------------------
        Label rateLbl2 = new Label("Interest Rate");
        Label periodLbl2 = new Label("Number of Periods");
        Label futureLbl2 = new Label("Future Value");
        Label answer2= new Label("The Start Principal  ");
        Label result2 = new Label("" );
        // buttons--------------------------------------------------------------------------------------
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
        TextField periodTxt2 = new TextField("Enter Years");
        TextField futureTxt = new TextField("$");
        TextField rateTxt2 = new TextField("%");


        calculate2.setOnAction(e->{
            if (validation(periodTxt2)){
                period1 = Double.parseDouble(periodTxt2.getText());

            }

            if (validation(futureTxt)){
                future1 = Double.parseDouble(futureTxt.getText());

            }
            if (validation(rateTxt2)){
                rate1 = Double.parseDouble(rateTxt2.getText());

            }
            if (validation(rateTxt2) && validation(futureTxt) && validation(periodTxt2)){
                double resulInv = Equations.investment(future1,rate1/100,1,period1,0);

                result2.setText("$ "+String.valueOf(resulInv));
            }
            else {
                result2.setText("Invalid input!");
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

        futureTxt.setOnMouseClicked(event -> {
            field1 = false;
            field2 = false;
            field4 = false;
            field3 = true;


        });
        investment.getChildren().add(Keyboard.keypad());
        Keyboard.keypadFunction(periodTxt2, rateTxt2, futureTxt,null);

        investment.add(periodLbl2, 1, 5);
        investment.add(periodTxt2, 3, 5);
        investment.add(rateLbl2, 1, 8);
        investment.add(rateTxt2, 3, 8);
        investment.add(futureLbl2, 1, 11);
        investment.add(futureTxt, 3, 11);
        investment.add(calculate2, 1, 25);
        investment.add(result2, 3, 12);
        investment.add(answer2,1,12);
        investment.add(backBtn2, 1, 32);


        //calculations----------------------------------------------------------------------------------------------

        return investment;

    }

    public static GridPane rate(){
        GridPane rate = new GridPane();
        rate.setId("ratetPane");
        rate.getStylesheets().addAll(SavingsScene.class.getResource("Style2.css").toExternalForm());
        rate.setPadding(new Insets(10, 10, 10, 10));
        rate.setVgap(8);
        rate.setHgap(10);
        //Labels------------------------------------------------------------------------------------------------
        Label investmentLbl3 = new Label("Start Principle");
        Label periodLbl3 = new Label("Number of Periods");
        Label futureLbl3 = new Label("Future Value");
        Label answer3= new Label("Interest Rate    ");
        Label result3 = new Label("" );
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
        TextField periodTxt3 = new TextField("Enter Years");
        TextField futureTxt3 = new TextField("$");
        TextField investmentTxt3 = new TextField("$");


        calculate3.setOnAction(e->{
            if (validation(periodTxt3)){
                period3 = Double.parseDouble(periodTxt3.getText());

            }

            if (validation(futureTxt3)){
                future3 = Double.parseDouble(futureTxt3.getText());

            }
            if (validation(investmentTxt3)){
                investment3 = Double.parseDouble(investmentTxt3.getText());

            }
            if (validation(investmentTxt3) && validation(futureTxt3) && validation(periodTxt3)){
                double resulRate = Equations.rate(future3,1,investment3,period3);

                result3.setText(String.valueOf(resulRate)+" %");
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

        futureTxt3.setOnMouseClicked(event -> {
            field1 = false;
            field2 = false;
            field4 = false;
            field3 = true;


        });
        rate.getChildren().add(Keyboard.keypad());
        Keyboard.keypadFunction(periodTxt3, investmentTxt3, futureTxt3, null);


        //setting tab1 content--------------------------------------------------------------------------------------
        rate.add(periodLbl3, 1, 5);
        rate.add(periodTxt3, 3, 5);
        rate.add(investmentLbl3, 1, 8);
        rate.add(investmentTxt3, 3, 8);
        rate.add(futureLbl3, 1, 11);
        rate.add(futureTxt3, 3, 11);
        rate.add(calculate3, 1, 25);
        rate.add(result3, 3, 12);
        rate.add(answer3,1,12);
        rate.add(backBtn3, 1, 32);

        return rate;

    }
//
    public static GridPane period(){
        GridPane period = new GridPane();
        period.setId("periodPane");
        period.getStylesheets().addAll(SavingsScene.class.getResource("Style2.css").toExternalForm());
        period.setPadding(new Insets(10, 10, 10, 10));
        period.setVgap(8);
        period.setHgap(10);
        //Labels------------------------------------------------------------------------------------------------
        Label investmentLbl4 = new Label("Start Principle");
        Label rateLbl4 = new Label("Interest Rate");
        Label futureLbl4 = new Label("Future Value");
        Label answer4= new Label("No Of Periods  ");
        Label result4 = new Label("" );


        //calculate button--------------------------------------------------------------------------------------
        Button calculate4 = new Button("Calculate");
        Button backBtn4 = new Button("Back");
        backBtn4.setOnAction(e-> {
            try {
                HomeScene.homeSc();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        //textFields----------------------------------------------------------------------------------------
        TextField futureTxt4 = new TextField("$");
        TextField investmentTxt4 = new TextField("$");
        TextField rateTxt4 = new TextField("%");



        calculate4.setOnAction(e->{
            if (validation(rateTxt4)){
                rate4 = Double.parseDouble(rateTxt4.getText());

            }

            if (validation(investmentTxt4)){
                investment4 = Double.parseDouble(investmentTxt4.getText());

            }
            if (validation(futureTxt4)){
                future4 = Double.parseDouble(futureTxt4.getText());

            }
            if (validation(investmentTxt4) && validation(futureTxt4) && validation(rateTxt4)){
                double resulPer = round(Equations.period(future4,rate4,1,future3,0,1)*100.0)/100.0;

                result4.setText(String.valueOf(resulPer)+" Years");
            }
            else {
                result4.setText("Invalid Input!");
            }
        });


        //Keypad FUnctions

        rateTxt4.setOnMouseClicked(event -> {
            field1 = false;
            field2 = true;
            field4 = false;
            field3 = false;
        });

        investmentTxt4.setOnMouseClicked(event -> {
            field1 = true;
            field2 = false;
            field4 = false;
            field3 = false;


        });

        futureTxt4.setOnMouseClicked(event -> {
            field1 = false;
            field2 = false;
            field4 = false;
            field3 = true;


        });
        period.getChildren().add(Keyboard.keypad());
        Keyboard.keypadFunction(rateTxt4, investmentTxt4, futureTxt4, null);


        //setting tab1 content--------------------------------------------------------------------------------------
        period.add(rateLbl4, 1, 5);
        period.add(rateTxt4, 3, 5);
        period.add(investmentLbl4, 1, 8);
        period.add(investmentTxt4, 3, 8);
        period.add(futureLbl4, 1, 11);
        period.add(futureTxt4, 3, 11);
        period.add(calculate4, 1, 25);
        period.add(result4, 3, 12);
        period.add(answer4,1,12);
        period.add(backBtn4, 1, 32);

        return period;

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

