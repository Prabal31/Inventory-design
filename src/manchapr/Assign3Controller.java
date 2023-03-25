package manchapr;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Assign3Controller  {

    TextField itemIDTextField;
    TextField itemNameTextField;
    TextField QOHTextField;
    TextField ROPTextField;
    TextField SellPriceTextField;
    InventoryList in;
    int count=1;

    public Assign3Controller(TextField itemIDTextField, TextField itemNameTextField, TextField QOHTextField, TextField ROPTextField, TextField SellPriceTextField) {
        this.itemIDTextField=itemIDTextField;
        this.itemNameTextField=itemNameTextField;
        this.QOHTextField=QOHTextField;
        this.ROPTextField=ROPTextField;
        this.SellPriceTextField=SellPriceTextField;
    }


    public void addmethod(Label MessageLabel) {
        MessageLabel.setText("No item to list. Add some!");
        MessageLabel.setTextFill(Color.RED);
        itemIDTextField.setText("");
        itemNameTextField.setText("");
        QOHTextField.setText("");
        ROPTextField.setText("");
        SellPriceTextField.setText("");
        
        
    }

    public void savemethod(Stage window,Label MessageLabel) {
        
        String id=itemIDTextField.getText();
        String name=itemNameTextField.getText();
        String qoh=QOHTextField.getText();
        String rop=ROPTextField.getText();
        String sellPrice=SellPriceTextField.getText();
        
        in = new InventoryList(id, name, qoh, rop, sellPrice, window,count);
        in.check();
        if(in.getAnswer()==0) {
            count++;
            MessageLabel.setText("Data Saved");
            MessageLabel.setTextFill(Color.GREEN);
        }
        
    }

    public void ordermethod(TextArea Text,Label MessageLabel) {
        for(int i=0;i<in.invList.size();i++) {
            int q=Integer.parseInt(in.invList.get(i).qoh);
            int r=Integer.parseInt(in.invList.get(i).rop);
            if(q<=r) { 
                Text.setText("ID :   "+in.invList.get(i).id+
                        " Name :   "+in.invList.get(i).name+
                        " Q-O-P :   "+in.invList.get(i).qoh+
                        " R-O-P :   "+in.invList.get(i).rop+
                        " SellPrice :   "+in.invList.get(i).SellPrice
                );
                MessageLabel.setText("");
                addmethod(MessageLabel);
            }
            else {
                MessageLabel.setText("No items to re-order.");
                MessageLabel.setTextFill(Color.RED);
            }
        }
    }
    public void exitmethod(Stage window) {

            Stage popup = new Stage();
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.initOwner(window);
            VBox layout = new VBox();
            Label message = new Label("Are you sure you want to exit?");
            Button yesButton = new Button("Yes");
            Button noButton = new Button("No");
            yesButton.setOnAction(e -> {
                // perform exit action
                System.exit(0);
            });
            noButton.setOnAction(e -> popup.close());
            layout.getChildren().addAll(message, yesButton, noButton);
            layout.setAlignment(Pos.CENTER);
            layout.setSpacing(10);
            Scene scene = new Scene(layout, 250, 250);
            popup.setScene(scene);
            popup.showAndWait();
        }

}