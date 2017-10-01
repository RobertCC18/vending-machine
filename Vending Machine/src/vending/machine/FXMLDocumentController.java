/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending.machine;

import javafx.scene.shape.Shape;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author rober
 */
public class FXMLDocumentController implements Initializable {
    DecimalFormat df = new DecimalFormat("0.00"); 
    @FXML 
    private Shape quater;
    private Shape dime;
    private Shape nickle;
    private Shape penny;
    @FXML 
    private Label currentprice;
    @FXML 
    private Label rectval;
    @FXML 
    private Label trival;
    @FXML 
    private Label circval;
    @FXML 
    private Label arcval;
    @FXML 
    private Label changeDue;
    @FXML 
    private Label rect_inven;
    @FXML 
    private Label tri_invin;
    @FXML 
    private Label circ_inven;
    @FXML 
    private Label arc_inven;
    private double money = 0.00;
    double rectValue = 0.25;
    double triValue = 0.50;
    double circValue = 0.75;
    double arcValue = 1.00;
    
    
    private void update_price() {
    double rect_price = rectValue - money;
    double tri_price = triValue - money;
    double circ_price = circValue - money;
    double arc_price = arcValue - money;
    if (rect_price <= 0.00) {
     rect_price = 0.00;
    }
    if (circ_price <= 0.00) {
     circ_price = 0.00;
    }
    if (tri_price <= 0.00) {
     tri_price = 0.00;
    }
    if (arc_price <= 0.00) {
     arc_price = 0.00;
    }
    rectval.setText("$" + df.format(rect_price));
    trival.setText("$" + df.format(tri_price));
    circval.setText("$" + df.format(circ_price));
    arcval.setText("$" + df.format(arc_price));
    }
    
    private void nc_error() {
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Vending Information");
            alert.setHeaderText("Not Enought Currency");
            alert.setContentText("Please Enter More Currency To Purchase!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:images/vending-512.png"));
            alert.showAndWait();
    }
    
    private void change_due() {
        changeDue.setText("$" + df.format(money));
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Vending Information");
            alert.setHeaderText("Change Due");
            alert.setContentText("Thank You For Your Purchase! Your Change is $" + df.format(money));
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:images/vending-512.png"));
            alert.showAndWait();
        changeDue.setText("$0.00");
        money = 0.00;
    }
    private void inventory_out() {
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Vending Information");
            alert.setHeaderText("Out Of Stock");
            alert.setContentText("The Item You Requested Is Currently Out Of Stock, Please Check Back Later.");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:images/vending-512.png"));
            alert.showAndWait();
    }
    private void purchase_thank() {
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Vending Information");
            alert.setHeaderText("Thank You");
            alert.setContentText("Thank you for your purchase, enjoy your day!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:images/vending-512.png"));
            alert.showAndWait();
    }
    
    @FXML
    private void onrectclick(MouseEvent event) {
        int inventory = Integer.parseInt(rect_inven.getText());
        inventory = inventory - 1;
        String ui = Integer.toString(inventory);
         if (inventory <= -1) {
                    inventory_out();
                    ui = "0";
                }
         else {
        if (money >= rectValue) {
        money = money - rectValue;
        
            if (money != 0.00) {
                change_due();
            }
        
               
        currentprice.setText("$" + df.format(money));
        rect_inven.setText(ui);
        purchase_thank();
        update_price();
        }
        else {
            nc_error();
        }
      }
    }
    @FXML
    private void onpolyclick(MouseEvent event) {
        int inventory = Integer.parseInt(tri_invin.getText());
        inventory = inventory - 1;
        String ui = Integer.toString(inventory);
        if (inventory <= -1) {
                    inventory_out();
                    ui = "0";
                }
         else {
        if (money >= triValue) {
            money = money - triValue;
       
          if (money != 0.00) {
            change_due();
            }
        
        currentprice.setText("$" + df.format(money));
        tri_invin.setText(ui);
        update_price();
        purchase_thank();
         }
         else {
            nc_error();
        }
      }
    }
    @FXML
    private void oncircleclick(MouseEvent event) {
        int inventory = Integer.parseInt(circ_inven.getText());
        inventory = inventory - 1;
        String ui = Integer.toString(inventory);
        if (inventory <= -1) {
                    inventory_out();
                    ui = "0";
                }
         else {
        if (money >= circValue) {
            money = money - circValue;
       
            if (money != 0.00) {
                change_due();
            }
              
        currentprice.setText("$" + df.format(money));
        circ_inven.setText(ui);
        update_price();
        purchase_thank();
         }
         else {
            nc_error();
        }
      }
    }
    @FXML
    private void onarcclick(MouseEvent event) {
        int inventory = Integer.parseInt(arc_inven.getText());
        inventory = inventory - 1;
        String ui = Integer.toString(inventory);
        if (inventory <= -1) {
                    inventory_out();
                    ui = "0";
                }
         else {
        if (money >= arcValue) {
        money = money - arcValue;
        
            if (money != 0.00) {
                change_due();
            }
               
        currentprice.setText("$" + df.format(money));
        arc_inven.setText(ui);
        update_price();
        purchase_thank();
        }
        else {
            nc_error();
        }
      }
    }
    @FXML
    private void onquaterclicked(MouseEvent event) {
        
        money = money + .25;
        currentprice.setText("$" + df.format(money));
        update_price();
        
    }
    @FXML
    private void ondimeclicked(MouseEvent event) {
        
        money = money + .10;
        currentprice.setText("$" + df.format(money));
        update_price();
    }
    @FXML
    private void onnickleclick(MouseEvent event) {
      
        money = money + .05;
        currentprice.setText("$" + df.format(money));
        update_price();
    }
    @FXML
    private void onpennyclick(MouseEvent event) {
        
        money = money + .01;
        currentprice.setText("$" + df.format(money));
        update_price();
    }

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentprice.setText("$" + df.format(money));
    }    
    
}
