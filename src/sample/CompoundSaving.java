package sample;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.io.FileNotFoundException;
import static sample.SavingsScene.*;


public class CompoundSaving{
    public static double pmt1,pmt2,pmt4,period2,future2,rate2,rate3;
    public static Scene savings() throws FileNotFoundException {

        //TabPane-----------------------------------------------------------------------------------------------
        TabPane savingsTabc = new TabPane();

        //creating tabs-----------------------------------------------------------------------------------------
        Tab tab1 = new Tab("Future Value");
        Tab tab2 = new Tab("Start Principle");
        Tab tab3 = new Tab("Payment");
        Tab tab4 = new Tab("Number of Periods");
        Tab tab5 = new Tab("PMT");
        savingsTabc.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);


        tab1.setContent(futurec());
        tab2.setContent(investment());
        tab3.setContent(payment());
        tab4.setContent(period());
        savingsTabc.getTabs().addAll(tab1, tab2, tab3, tab4);

        Scene savingsScene = new Scene(savingsTabc, 500, 600);
        //savings scene ends
        return savingsScene;


    }
    public static GridPane futurec(){
        GridPane futurec = new GridPane();
        futurec.setId("periodPane");
        futurec.getStylesheets().addAll(CompoundSaving.class.getResource("Style2.css").toExternalForm());
        futurec.setPadding(new Insets(10, 10, 10, 10));
        futurec.setVgap(8);
        futurec.setHgap(10);

        //Labels------------------------------------------------------------------------------------------------
        Label investmentLbl1 = new Label("Start Principle");
        Label periodLbl1 = new Label("Number of Periods");
        Label interestLbl1 = new Label("interest rate");
        Label pmtLbl1 = new Label("Annuity Payment");
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
        TextField periodTxt1 = new TextField("Years");
        TextField investmentTxt1 = new TextField("$");
        TextField rateTxt1 = new TextField("%");
        TextField pmtTxt1 = new TextField("$");

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
            if (validation(pmtTxt1)){
                pmt1 = Double.parseDouble(pmtTxt1.getText());

            }
            if (validation(rateTxt1) && validation(investmentTxt1) &&validation(periodTxt1) && validation(pmtTxt1)){
                double result = Equations.futureValue(investment1,rate1/100,1,period1,pmt1);

                result1.setText("$ "+String.valueOf(result));
            }
            else {
                result1.setText("Invalid Input!");
            }
        });

        //Keypad FUnctions

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
        pmtTxt1.setOnMouseClicked(event -> {
            field1 = false;
            field2 = false;
            field4 = true;
            field3 = false;


        });
        futurec.getChildren().add(Keyboard.keypad());
        Keyboard.keypadFunction(periodTxt1, investmentTxt1, rateTxt1, pmtTxt1);

        futurec.add(periodLbl1, 1, 5);
        futurec.add(periodTxt1, 3, 5);
        futurec.add(investmentLbl1, 1, 8);
        futurec.add(investmentTxt1, 3, 8);
        futurec.add(interestLbl1, 1, 11);
        futurec.add(rateTxt1, 3, 11);
        futurec.add(pmtLbl1, 1, 12);
        futurec.add(pmtTxt1, 3, 12);
        futurec.add(calculate1, 1, 25);
        futurec.add(result1, 3, 14);
        futurec.add(answer1,1,14);
        futurec.add(backBtn1, 1, 32);



        return futurec;

    }
    public static GridPane investment(){

        GridPane investment = new GridPane();
        investment.setId("periodPane");
        investment.getStylesheets().addAll(CompoundSaving.class.getResource("Style2.css").toExternalForm());
        investment.setPadding(new Insets(10, 10, 10, 10));
        investment.setVgap(8);
        investment.setHgap(10);

        //Labels------------------------------------------------------------------------------------------------
        Label rateLbl2 = new Label("Interest Rate");
        Label periodLbl2 = new Label("Number of Periods");
        Label futureLbl2 = new Label("Future Value");
        Label answer2= new Label("Start Principle ");
        Label result2 = new Label("" );
        Label pmtLbl2 = new Label("Annuity Payment");
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
        TextField periodTxt2 = new TextField("Years");
        TextField futureTxt = new TextField("$");
        TextField rateTxt2 = new TextField("%");
        TextField pmtTxt2 = new TextField("$");


        calculate2.setOnAction(e->{
            if (validation(periodTxt2)){
                period2 = Double.parseDouble(periodTxt2.getText());

            }

            if (validation(futureTxt)){
                future2 = Double.parseDouble(futureTxt.getText());

            }
            if (validation(rateTxt2)){
                rate2 = Double.parseDouble(rateTxt2.getText());

            }
            if (validation(pmtTxt2)){
                pmt2 = Double.parseDouble(pmtTxt2.getText());

            }
            if (validation(rateTxt2) && validation(futureTxt) && validation(periodTxt2)){
                double resultInvC = Equations.investment(future2,rate1/100,1,period2,pmt2);

                result2.setText("$ "+String.valueOf(resultInvC));
            }
            else {
                result2.setText("Invalid Input!");
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
        pmtTxt2.setOnMouseClicked(event -> {
            field1 = false;
            field2 = false;
            field4 = true;
            field3 = false;


        });
        investment.getChildren().add(Keyboard.keypad());
        Keyboard.keypadFunction(periodTxt2, rateTxt2, futureTxt, pmtTxt2);



        investment.add(periodLbl2, 1, 5);
        investment.add(periodTxt2, 3, 5);
        investment.add(rateLbl2, 1, 8);
        investment.add(rateTxt2, 3, 8);
        investment.add(futureLbl2, 1, 11);
        investment.add(futureTxt, 3, 11);
        investment.add(pmtLbl2, 1, 12);
        investment.add(pmtTxt2, 3, 12);
        investment.add(calculate2, 1, 25);
        investment.add(result2, 3, 14);
        investment.add(answer2,1,14);
        investment.add(backBtn2, 1, 32);




        //calculations----------------------------------------------------------------------------------------------

        return investment;

    }

    public static GridPane payment(){
        GridPane payment = new GridPane();
        payment.setId("periodPane");
        payment.getStylesheets().addAll(CompoundSaving.class.getResource("Style2.css").toExternalForm());
        payment.setPadding(new Insets(10, 10, 10, 10));
        payment.setVgap(8);
        payment.setHgap(10);
        //Labels------------------------------------------------------------------------------------------------
        Label investmentLbl3 = new Label("Start Principle");
        Label periodLbl3 = new Label("Number of Periods");
        Label futureLbl3 = new Label("Future Value");
        Label rateLbl3 = new Label("Interest Rate");
        Label result3 = new Label("" );
        Label answer3 = new Label("Annuity Payment");
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
        TextField futureTxt3 = new TextField();
        TextField investmentTxt3 = new TextField();
        TextField rateTxt3 = new TextField();


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
            if (validation(rateTxt3)){
                rate3 = Double.parseDouble(rateTxt3.getText());

            }

            if (validation(investmentTxt3) && validation(futureTxt3) && validation(periodTxt3)){
                double resultPmtC = Equations.payment(future3,rate3/100,1,investment3,period3)/12;

                result3.setText(String.valueOf(resultPmtC));
            }
            else {
                result3.setText("Invalid Input!");
            }
        });


        //Keypad FUnctions

        periodTxt3.setOnMouseClicked(event -> {
            field1 = false;
            field2 = true;
            field4 = false;
            field3 = false;
        });

        futureTxt3.setOnMouseClicked(event -> {
            field1 = true;
            field2 = false;
            field4 = false;
            field3 = false;


        });

        investmentTxt3.setOnMouseClicked(event -> {

            field1 = false;
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
        Keyboard.keypadFunction(periodTxt3, futureTxt3, investmentTxt3, rateTxt3);



        //setting tab1 content--------------------------------------------------------------------------------------
        payment.add(periodLbl3, 1, 5);
        payment.add(periodTxt3, 3, 5);
        payment.add(investmentLbl3, 1, 8);
        payment.add(investmentTxt3, 3, 8);
        payment.add(futureLbl3, 1, 11);
        payment.add(futureTxt3, 3, 11);
        payment.add(rateLbl3, 1, 12);
        payment.add(rateTxt3, 3, 12);
        payment.add(calculate3, 1, 25);
        payment.add(result3, 3, 14);
        payment.add(answer3,1,14);
        payment.add(backBtn3, 1, 32);
        return payment;

    }
    //
    public static GridPane period(){
        GridPane period = new GridPane();
        period.setId("periodPane");
        period.getStylesheets().addAll(CompoundSaving.class.getResource("Style2.css").toExternalForm());
        period.setPadding(new Insets(10, 10, 10, 10));
        period.setVgap(8);
        period.setHgap(10);
        //Labels------------------------------------------------------------------------------------------------
        Label investmentLbl4 = new Label("Start Principle");
        Label rateLbl4 = new Label("Interest Rate");
        Label futureLbl4 = new Label("Future Value");
        Label pmtLbl4 = new Label("Annuity Payment");
        Label result4 = new Label("" );
        Label answer4 = new Label("No of Periods");
        //calculate button--------------------------------------------------------------------------------------
        Button calculate4 = new Button("Calculate");

        Button backBtn3 = new Button("Back");
        backBtn3.setOnAction(e-> {
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
        TextField pmtTxt4 = new TextField("$");



        calculate4.setOnAction(e->{
            if (validation(rateTxt4)){
                rate4 = Double.parseDouble(rateTxt4.getText());

            }

            if (validation(investmentTxt4)){
                investment4 = Double.parseDouble(investmentTxt4.getText());

            }
            if (validation(futureTxt4)){
                future3 = Double.parseDouble(futureTxt4.getText());

            }
            if (validation(pmtTxt4)){
                pmt4 = Double.parseDouble(pmtTxt4.getText());

            }
            if (validation(investmentTxt4) && validation(futureTxt4) && validation(futureTxt4)){
                double result1PerC = Equations.period(future4,rate4,1,future3,pmt4,1);

                result4.setText(String.valueOf(result1PerC)+"  Years");
            }
            else {
                result4.setText("Invalid Input");
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
        pmtTxt4.setOnMouseClicked(event -> {
            field1 = false;
            field2 = false;
            field4 = true;
            field3 = false;


        });
        period.getChildren().add(Keyboard.keypad());
        Keyboard.keypadFunction(rateTxt4, investmentTxt4, futureTxt4, pmtTxt4);






        //setting tab1 content--------------------------------------------------------------------------------------
        period.add(rateLbl4, 1, 5);
        period.add(rateTxt4, 3, 5);
        period.add(investmentLbl4, 1, 8);
        period.add(investmentTxt4, 3, 8);
        period.add(futureLbl4, 1, 11);
        period.add(futureTxt4, 3, 11);
        period.add(pmtLbl4, 1, 12);
        period.add(pmtTxt4, 3, 12);
        period.add(calculate4, 1, 25);
        period.add(result4, 3, 14);
        period.add(answer4,1,14);
        period.add(backBtn3, 1, 32);
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


























