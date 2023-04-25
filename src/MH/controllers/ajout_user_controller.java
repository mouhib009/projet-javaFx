/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MH.controllers;

import MH.entities.User;
import MH.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class ajout_user_controller {

    @FXML
    private TextField email;

    @FXML
    private TextField image;

    @FXML
    private TextField last_name;

    @FXML
    private TextField name;

    @FXML
    private TextField nickname;

    @FXML
    private TextField password;

    @FXML
    private TextField region;

    @FXML
    private TextField roles;
    
    @FXML
    private Label errorLabel;

    @FXML
    void submit(ActionEvent event) throws Exception {
        errorLabel.setText("");
        
        if(email.getText().equals("") || roles.getText().equals("") || password.getText().equals("") || 
                name.getText().equals("") || last_name.getText().equals("") || image.getText().equals("") || region.getText().equals("") || nickname.getText().equals(""))
            errorLabel.setText("Please fill all the fields");
        else{
            User user= new User(email.getText(), roles.getText(), password.getText(), name.getText(), last_name.getText(), image.getText(), region.getText(), nickname.getText());
            UserService userSrvice= new UserService();
            userSrvice.addUser(user);
            goToCreateTeam();
        }
        
    }
    
    
    public void goToCreateTeam(){
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/MH/gui/ajout_team.fxml"));
            Parent root= loader.load();
            Stage stage = (Stage) ((Node)name).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
