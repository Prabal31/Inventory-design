package manchapr;

import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Inventory {

    //creating string, integer and double variable
    String id;    
    String name;
    String qoh;
    String rop;
    String SellPrice;
    Stage window;
    String message="";
    int m=0;
    boolean answer=false;
    
    Scanner in=new Scanner(System.in);
    
    Inventory(String id, String name, String qoh, String rop, String SellPrice) {
        this.id=id;
        this.name=name;
        this.qoh=qoh;
        this.rop=rop;
        this.SellPrice=SellPrice;

    }
    
    public int Check(Stage window){
        //Asiking the user to input the right id in the form of abc-1234
        int c=0;
        char ch='-';
        try {    //try block
            if(id.length()==8) {

                //checking if the first 3 character of the id string is a alphabetic
                for(int i=0;i<3;i++) {    
                    if(Character.isAlphabetic(id.charAt(i))) {
                        c=c+1;
                    }
                }

                //checking if the 3 index of the id string is a '-'
                if(id.charAt(3)==ch) {
                    c=c+1;
                    }

                //checking if the last 4 character of the id string is a digit
                for(int j=4;j<id.length();j++) {
                    if(Character.isDigit(id.charAt(j))) {
                        c=c+1; 
                    }  
                }

                //checking if the length is equal or not equal to 8
                if(c!=8) {  
                    throw new Exception();   //throw an exception if the enter data is not correct
                }        
            }
            else {
                throw new Exception();
            } 
        }      //end of try block
        catch(Exception e) {        //catch block
            m=1;
            message="Error: Inventory ID must be in the form ABC-1234";
        }   //end of catch block

        
        
        //asking user to input a valin name of the item
        int cc=0;
        try {     //try block 
            //checking if the value is an alphabetic
            for(int i=0;i<name.length();i++) {
                if(Character.isAlphabetic(name.charAt(i))) {
                    cc=cc+1;   
                }
            }
            //checking if the user input the right value
            if(cc!=name.length()||name.length()==0) {  
                throw new Exception(); //throw an exception the the input is invaluid 
            }
        }     //end of try block
        catch (Exception e) {  //catch block
            m=1;
            message=message + "\n You must enter a valid item name";
        }   //end of catch block

        
        
        //asking user to input the Quantity on hand 
        try {       //try block

            //Checking if the user input the right data'Integer'
            int qohh = Integer.parseInt(qoh);

            //checking if the data entered is greater then or equyal to zero
            if(qohh<=0) {
                throw new Exception();
            }
        }   //end of try block

        catch (Exception e) {   //catch block
            m=1;
            message=message + "\n QOH must be 0 or more";
        }   //end of catch block

        //Asking user to input valid re order points
        try {   //try block

            //Checking if the user entered a valid data 
            int ropp = Integer.parseInt(rop);

            //checking if the data entered is greater then or equal to zero
            if(ropp<=0) {
                //throw an exception the data entered is invalid
                throw new Exception();
            }
        }    //end of try block
        catch (Exception e) {   //catch block
            m=1;
            message=message + "\n rop must be 0 or more.";
        }   //end of catch block

        
        
        //Asking user to input the selling price of the product in double
        try {    //try block

            double Price = Double.parseDouble(SellPrice);

            //checking id the data entered is greater then zero
            if(Price<0) {
                throw new Exception();
            }
        }    //end of try block

        catch (Exception e) {     //catch block
            m=1;
            message=message + "\n Selling price must be greater than 0";
        }   //end of catch block
        
        if(m==1) {
            Alert(window,message);
        }
        return m;
    }
    
    public void Alert(Stage window,String message) {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(window);
        VBox layout = new VBox();
        Label alert = new Label(message);
        Button backButton = new Button("Go back");
        backButton.setOnAction(e -> {
            // perform exit action
            popup.close();
        });

        layout.getChildren().addAll(alert, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        Scene scene = new Scene(layout, 300, 300);
        popup.setScene(scene);
        popup.showAndWait();
    }
    
}

