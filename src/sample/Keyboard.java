package sample;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

import static sample.SavingsScene.*;

public class Keyboard {

    public  static  Button button0;
    public  static  Button button1;
    public  static  Button button2;
    public  static  Button button3;
    public  static  Button button4;
    public  static  Button button5;
    public  static  Button button6;
    public  static  Button button7;
    public  static  Button button8;
    public  static  Button button9;
    public  static  Button buttonClear;
    public  static  Button buttonDot;

    public static VBox keypad() {


        //Buttons
        button0 = new Button("0");
        button1 = new Button("1");
        button2 = new Button("2");
        button3 = new Button("3");
        button4 = new Button("4");
        button5 = new Button("5");
        button6 = new Button("6");
        button7 = new Button("7");
        button8 = new Button("8");
        button9 = new Button("9");
        buttonClear = new Button("C");
        buttonDot = new Button(" .");

        //Button Functionality


        //Keyboard Layout

        HBox hBox123 = new HBox();
        hBox123.getChildren().addAll(button1,button2,button3);

        HBox hBox456 = new HBox();
        hBox456.getChildren().addAll(button4,button5,button6);

        HBox hBox789 = new HBox();
        hBox789.getChildren().addAll(button7,button8,button9);

        HBox hBox0 = new HBox();
        hBox0.getChildren().addAll(button0,buttonDot,buttonClear);

        VBox keypadVbox = new VBox();
        keypadVbox.getChildren().addAll(hBox123,hBox456,hBox789,hBox0);

        GridPane.setConstraints(keypadVbox,5,20);

        return keypadVbox;

    }

    public static void keypadFunction(TextField periodField,TextField principalField,TextField interestField,TextField paymentField){

        button0.setOnAction(event -> {
            if (field2){
                periodField.appendText("0");
            } else if (field3){
                interestField.appendText("0");
            } else  if (field1){
                principalField.appendText("0");
            } else if (field4){
                paymentField.appendText("0");
            }
        });

        button1.setOnAction(event -> {
            if (field2){
                periodField.appendText("1");
            } else if (field3){
                interestField.appendText("1");
            } else  if (field1){
                principalField.appendText("1");
            } else if (field4){
                paymentField.appendText("1");
            }
        });

        button2.setOnAction(event -> {
            if (field2){
                periodField.appendText("2");
            } else if (field3){
                interestField.appendText("2");
            } else  if (field1){
                principalField.appendText("2");
            } else if (field4){
                paymentField.appendText("2");
            }
        });

        button3.setOnAction(event -> {
            if (field2){
                periodField.appendText("3");
            } else if (field3){
                interestField.appendText("3");
            } else  if (field1){
                principalField.appendText("3");
            } else if (field4){
                paymentField.appendText("3");
            }
        });

        button4.setOnAction(event -> {
            if (field2){
                periodField.appendText("4");
            } else if (field3){
                interestField.appendText("4");
            } else  if (field1){
                principalField.appendText("4");
            } else if (field4){
                paymentField.appendText("4");
            }
        });

        button5.setOnAction(event -> {
            if (field2){
                periodField.appendText("5");
            } else if (field3){
                interestField.appendText("5");
            } else  if (field1){
                principalField.appendText("5");
            } else if (field4){
                paymentField.appendText("5");
            }
        });

        button6.setOnAction(event -> {
            if (field2){
                periodField.appendText("6");
            } else if (field3){
                interestField.appendText("6");
            } else  if (field1){
                principalField.appendText("6");
            } else if (field4){
                paymentField.appendText("6");
            }
        });

        button7.setOnAction(event -> {
            if (field2){
                periodField.appendText("7");
            } else if (field3){
                interestField.appendText("7");
            } else  if (field1){
                principalField.appendText("7");
            } else if (field4){
                paymentField.appendText("7");
            }
        });
        button8.setOnAction(event -> {
            if (field2){
                periodField.appendText("8");
            } else if (field3){
                interestField.appendText("8");
            } else  if (field1){
                principalField.appendText("8");
            } else if (field4){
                paymentField.appendText("8");
            }
        });

        button9.setOnAction(event -> {
            if (field2){
                periodField.appendText("9");
            } else if (field3){
                interestField.appendText("9");
            } else  if (field1){
                principalField.appendText("9");
            } else if (field4){
                paymentField.appendText("9");
            }
        });

        buttonDot.setOnAction(event -> {
            if (field2){
                periodField.appendText(".");
            } else if (field3){
                interestField.appendText(".");
            } else  if (field1){
                principalField.appendText(".");
            } else if (field4){
                paymentField.appendText(".");
            }
        });

        buttonClear.setOnAction(event -> {
            if (field2){
                periodField.setText("");
            } else if (field3){
                interestField.setText("");
            } else  if (field1){
                principalField.setText("");
            } else if (field4){
                paymentField.setText("");
            }
        });

    }

}
