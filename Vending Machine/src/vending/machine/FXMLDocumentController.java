/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending.machine;

import javafx.scene.shape.Shape;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author rober
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML 
    private Shape quater;
    private Shape dime;
    private Shape nickle;
    private Shape penny;
    @FXML 
    private Label currentprice;
    private double money = 0.00;
    @FXML
    private void onrectclick(MouseEvent event) {
        System.out.println("You clicked me!");
        currentprice.setText("Hello World! 2");
    }
    @FXML
    private void onpolyclick(MouseEvent event) {
        System.out.println("You clicked me!");
        currentprice.setText("Hello World! 3");
    }
    @FXML
    private void oncircleclick(MouseEvent event) {
        System.out.println("You clicked me!");
        currentprice.setText("Hello World! 4");
    }
    @FXML
    private void onarcclick(MouseEvent event) {
        System.out.println("You clicked me!");
        currentprice.setText("Hello World! 5");
    }
    @FXML
    private void onquaterclicked(MouseEvent event) {
        System.out.println("You clicked me!");
        money = money + .25;
        currentprice.setText("$" + money);
    }
    @FXML
    private void ondimeclicked(MouseEvent event) {
        System.out.println("You clicked me!");
        currentprice.setText("Hello World! 7");
    }
    @FXML
    private void onnickleclick(MouseEvent event) {
        System.out.println("You clicked me!");
        currentprice.setText("Hello World! 8");
    }
    @FXML
    private void onpennyclick(MouseEvent event) {
        System.out.println("You clicked me!");
        currentprice.setText("Hello World! 9");
    }

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentprice.setText("$" + money);
    }    
    
}
