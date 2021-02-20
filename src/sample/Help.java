package sample;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Help {
    public static Stage helpStage(){
        Stage helpStage = new Stage();

        ScrollPane helpScroll = new ScrollPane();
        BorderPane helpBorder = new BorderPane();

        helpScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        helpScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        helpStage.setTitle("Help");
        TextFlow mainHelp = new TextFlow();
        Text helpText = new Text("-------------HELP----------------\n\n\n\n\n" +
                "Welcome to financial calculator.\n\n" +
                "This program is developted in order to ease your in order to ease your financial calculations\n\n\n\n " +
                "-----------------------------------CONTENT-----------------------------------\n" +
                "1.  Fixed Savings\n\n" +
                "\t\t\t All the calculations relevant to fixed savings can be done\n " +
                "2.  Savings with monthly Patment\n\n" +
                "\t\t\t All the calculations relevant to Savings with monthly Patment can be done \n\n\n\n\n" +
                "3. Mortgage\n\n" +
                "\t\t\t All the calculations relevant to Mortgage can be done \n\n\n" +
                "4. Loan\n\n" +
                "\t\t\t All the calculations relevant to Loan can be done " +
                "");


        mainHelp.setMaxWidth(550);
        mainHelp.getChildren().addAll(helpText);
        helpBorder.setCenter(mainHelp);
        helpScroll.setContent(helpBorder);
        Scene mainHelpSce = new Scene(helpScroll,600,400);

       // helpStage.getIcons().add(new Image("C:\\pp2\\courswork\\images\\help.png"));

                helpStage.setResizable(false);
                helpStage.setScene(mainHelpSce);
                helpStage.show();
                return helpStage;



    }
}
