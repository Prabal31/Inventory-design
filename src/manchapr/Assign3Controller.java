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
        
        InventoryList in = new InventoryList(id, name, qoh, rop, sellPrice, window);
        
        if(in.getAnswer()==0) {
            MessageLabel.setText("Data Saved");
            MessageLabel.setTextFill(Color.GREEN);
        }
    }

    public void ordermethod(TextArea Text,Label MessageLabel) {
        
        InventoryList list=new InventoryList();
        
        boolean found=false;
        
        for (int i = 0; i < list.length(); i++) {
            int qoh = Integer.parseInt(list.invList.get(i).qoh);
            int rop = Integer.parseInt(list.invList.get(i).rop);
            if (qoh <= rop) {
                String id=list.invList.get(i).id;
                String name=list.invList.get(i).name;
                String q=list.invList.get(i).qoh;
                String r=list.invList.get(i).rop;
                String SellPrice=list.invList.get(i).SellPrice;
                System.out.println(id);
                found=true;
            }
        }
        if(!found) {
            MessageLabel.setText("No items to re-order.");
            MessageLabel.setTextFill(Color.RED);

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