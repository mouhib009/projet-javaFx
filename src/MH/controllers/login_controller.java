/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MH.controllers;

import MH.Utils.Statics;
import MH.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class login_controller {
 
     @FXML
    private TextField emailInput;

    @FXML
    private Label loginError;

     @FXML
    private PasswordField pwdInput;

    @FXML
    void submit(ActionEvent event) {
        loginError.setText("");
        UserService userService= new UserService();
        Statics.user= userService.loginUser(emailInput.getText(), pwdInput.getText());
        System.out.println(Statics.user);
        if(Statics.user != null){
            if(Statics.user.getRoles().contains("ADMIN"))
                goToAdmin();
            else goToHome();
        }
        else
            loginError.setText("Email or password is invalid");
            
    }
    
    void goToHome(){
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/MH/gui/table_team.fxml"));
            Parent root= loader.load();
            Stage stage = (Stage) ((Node)loginError).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    void goToAdmin(){
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/MH/gui/table_user.fxml"));
            Parent root= loader.load();
            Stage stage = (Stage) ((Node)loginError).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    @FXML
    void goToRegister(ActionEvent event) {
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/MH/gui/ajout_user.fxml"));
            Parent root= loader.load();
            Stage stage = (Stage) ((Node)loginError).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
