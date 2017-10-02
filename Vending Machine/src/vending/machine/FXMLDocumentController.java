/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending.machine;

import javafx.scene.shape.Shape;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author rober
 */
public class FXMLDocumentController implements Initializable {
    DecimalFormat df = new DecimalFormat("0.00"); 
    @FXML 
    private Label currentprice;
    @FXML 
    private Label rectval;
    @FXML 
    private Label trival;
    @FXML 
    private Label circval;
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
    @FXML 
    private HBox coin_return;
    @FXML 
    private Button return_money;
    private double money = 0.00;
    double rectValue = 0.25;
    double triValue = 0.50;
    double circValue = 0.75;
 
 private void currency_input() { // this creates the currency input box displayed at the program start
         TextInputDialog dialog = new TextInputDialog("Coins");
            dialog.setTitle("Insert Coin");
            dialog.setHeaderText("Please Insert Your Coins");
            dialog.setContentText("Please enter your coins seperated by a comma");
            Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:src/vending/machine/assets/images/vending-512.png"));
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
               String coins = result.get();
            String coins_list[] = coins.split(",");
           for (String coin : coins_list)  {
                boolean quarter = coin.contains("quarter");
                boolean nickle = coin.contains("nickle");
                boolean dime = coin.contains("dime");
                boolean pennyo = coin.contains("penny");
                    if (quarter) {
                     money = money + 0.25;
                    }
                    if (dime) {
                     money = money + 0.10;
                    }
                    if (nickle) {
                     money = money + 0.05;
                    }
                    if (pennyo) {
                        ImageView imv = new ImageView();
                        imv.setFitHeight(100);
                        imv.setFitWidth(100);
                        Image penny = new Image("file:src/vending/machine/assets/images/penny.png");
                        imv.setImage(penny);
                     coin_return.getChildren().add(imv);
                    }
                }
            }
             currentprice.setText("$" + df.format(money));
        }
        
    
    
    private void update_price() { // updates price after item purchase and coin input
    double rect_price = rectValue - money;
    double tri_price = triValue - money;
    double circ_price = circValue - money;
    if (rect_price <= 0.00) {
     rect_price = 0.00;
    }
    if (circ_price <= 0.00) {
     circ_price = 0.00;
    }
    if (tri_price <= 0.00) {
     tri_price = 0.00;
    }
    rectval.setText("$" + df.format(rect_price));
    trival.setText("$" + df.format(tri_price));
    circval.setText("$" + df.format(circ_price));
   
    }
    
    private void nc_error() { // displays error if no coin or not enough currency
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Vending Information");
            alert.setHeaderText("Not Enought Currency");
            alert.setContentText("Please Enter More Currency To Purchase!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:src/vending/machine/assets/images/vending-512.png"));
            alert.showAndWait();
            if (money <= 0 ){
            currency_input();
        }
    }
    
    private void change_due() { // shows change due and allows customer to take change
        changeDue.setText("$" + df.format(money));
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Vending Information");
            alert.setHeaderText("Change Due");
            alert.setContentText("Thank You For Your Purchase! Please Take Your Change Of $" + df.format(money));
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:src/vending/machine/assets/images/vending-512.png"));
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
            stage.getIcons().add(new Image("file:src/vending/machine/assets/images/vending-512.png"));
            alert.showAndWait();
    }
    private void purchase_thank() {
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Vending Information");
            alert.setHeaderText("Thank You");
            alert.setContentText("Thank you for your purchase, enjoy your day!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:src/vending/machine/assets/images/vending-512.png"));
            alert.showAndWait();
             if (money <= 0 ){
            currency_input();
            coin_return.getChildren().clear();
        }
    }
    
     private void show_change() { //TODO Finish code to show change icons
    int change = (int)(Math.ceil(money*100));
    int quarters = Math.round((int)change/25);
    change=change%25;
    int dimes = Math.round((int)change/10);
    change=change%10;
    int nickels = Math.round((int)change/5);
    change=change%5;
    int pennies = Math.round((int)change/1);
     while(quarters >= 0){
            ImageView imv = new ImageView();
                        imv.setFitHeight(100);
                        imv.setFitWidth(100);
                        Image penny = new Image("file:src/vending/machine/assets/images/quater.png");
                        imv.setImage(penny);
                     coin_return.getChildren().add(imv);
        }
     while(dimes >= 0){
            ImageView imv = new ImageView();
                        imv.setFitHeight(100);
                        imv.setFitWidth(100);
                        Image penny = new Image("file:src/vending/machine/assets/images/dime.png");
                        imv.setImage(penny);
                     coin_return.getChildren().add(imv);
        }
     while(nickels >= 0){
            ImageView imv = new ImageView();
                        imv.setFitHeight(100);
                        imv.setFitWidth(100);
                        Image penny = new Image("file:src/vending/machine/assets/images/nickel.png");
                        imv.setImage(penny);
                     coin_return.getChildren().add(imv);
        }
     while(pennies >= 0){
            ImageView imv = new ImageView();
                        imv.setFitHeight(100);
                        imv.setFitWidth(100);
                        Image penny = new Image("file:src/vending/machine/assets/images/penny.png");
                        imv.setImage(penny);
                     coin_return.getChildren().add(imv);
        }
    
    }
    
     @FXML
    private void return_money_click(MouseEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Vending Information");
            alert.setHeaderText("Money Returned");
            alert.setContentText("Here Is Your Return Of $" + money);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:src/vending/machine/assets/images/vending-512.png"));
            alert.showAndWait();
            money = 0.00;
            coin_return.getChildren().clear();
             currentprice.setText("$" + df.format(money));
            currency_input();
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (money <= 0 ){
            currency_input();
        }
        currentprice.setText("$" + df.format(money));
        update_price();
    }    
    
}
