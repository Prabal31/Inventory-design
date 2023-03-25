package manchapr;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 *
 * @author manch
 */
public class Assign3 extends Application {
    
    
    TextField itemIDTextField;
    TextField itemNameTextField;
    TextField QOHTextField;
    TextField ROPTextField;
    TextField SellPriceTextField;
    Label MessageLabel;
    Stage window;
    GridPane pane;
    @Override
    public void start(Stage window) {
        window.setTitle("Inventory Tracker");

        pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(30);
        pane.setPadding(new Insets(10, 10, 10, 10));

        Label head = new Label("Inventory Tracker");
        head.setFont(Font.font("Courier New", 20));
        head.setTextFill(Color.web("#00ff00"));
        HBox heading = new HBox();
        heading.getChildren().addAll(head);
        heading.setAlignment(Pos.CENTER);

        pane.add(heading, 0, 0, 2, 1); // span across 2 columns

        Label itemIDLabel = new Label("Item ID:");
        itemIDLabel.setTextFill(Color.BLUE);
        itemIDTextField = new TextField();
        itemIDTextField.setPromptText("Item ID");
        HBox itemID = new HBox(10, itemIDLabel, itemIDTextField);
        pane.add(itemID, 0, 1);

        Label itemNameLabel = new Label("Item Name:");
        itemNameLabel.setTextFill(Color.BLUE);
        itemNameTextField = new TextField();
        itemNameTextField.setPromptText("Item Name");

        HBox itemName = new HBox(10, itemNameLabel, itemNameTextField);
        pane.add(itemName, 0, 2);

        HBox QOHROP = new HBox(10);
        Label QOHLabel = new Label("Q-O-H:");
        QOHLabel.setTextFill(Color.BLUE);
        QOHTextField = new TextField();
        QOHTextField.setPromptText("Q-O-H");
        QOHROP.getChildren().addAll(QOHLabel, QOHTextField);

        Label ROPLabel = new Label("R-O-P:");
        ROPLabel.setTextFill(Color.BLUE);
        ROPTextField = new TextField();
        ROPTextField.setPromptText("R-O-P");
        QOHROP.getChildren().addAll(ROPLabel, ROPTextField);

        pane.add(QOHROP, 0, 3);

        Label SellPriceLabel = new Label("Sell Price:");
        SellPriceLabel.setTextFill(Color.BLUE);
        SellPriceTextField = new TextField();
        SellPriceTextField.setPromptText("Sell Price");
        HBox SellPrice = new HBox(10, SellPriceLabel, SellPriceTextField);
        pane.add(SellPrice, 0, 4);
        
        MessageLabel = new Label("No item to list. Add some!");
        MessageLabel.setTextFill(Color.RED);
        pane.add(MessageLabel, 0, 7);
        
        HBox area = new HBox();
        TextArea Text = new TextArea();
        Text.setEditable(false);
        Text.setPrefHeight(200);
        area.getChildren().add(Text);
        area.setAlignment(Pos.CENTER);
        pane.add(area, 0, 6, 2, 1);
        
        Assign3Controller control=new Assign3Controller(itemIDTextField,itemNameTextField,QOHTextField,ROPTextField,SellPriceTextField);

        Button addButton = new Button("_Add");
        addButton.setMnemonicParsing(true);
        addButton.setOnAction(e-> control.addmethod(MessageLabel));

        Button saveButton = new Button("_Save");
        saveButton.setMnemonicParsing(true);
        saveButton.setOnAction(e-> control.savemethod(window,MessageLabel));

        Button ordersButton = new Button("_Orders");
        ordersButton.setMnemonicParsing(true);
        ordersButton.setOnAction(e-> control.ordermethod(Text,MessageLabel));

        Button exitButton = new Button("_Exit");
        exitButton.setMnemonicParsing(true);
        exitButton.setOnAction(e-> control.exitmethod(window));

        HBox buttons = new HBox(50, addButton, saveButton, ordersButton, exitButton);
        buttons.setAlignment(Pos.CENTER); // Set alignment to center
        pane.add(buttons, 0, 5, 2, 1); // span across 2 columns

        Scene scene = new Scene(pane, 500, 600);
        window.setScene(scene);
        window.show();

    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
