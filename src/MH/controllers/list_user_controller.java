/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MH.controllers;

import MH.entities.User;
import MH.services.UserService;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class list_user_controller implements Initializable{
 
    
     @FXML
    private TableView<User> dataTable;
     
     @FXML
    private TableColumn<User, String> email;

    @FXML
    private TableColumn<User, String> lastName;

    @FXML
    private TableColumn<User, String> name;

    @FXML
    private TableColumn<User, String> nickname;

    @FXML
    private TableColumn<User, String> region;

    @FXML
    private TableColumn<User, String> roles;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        nickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        region.setCellValueFactory(new PropertyValueFactory<>("region"));
        roles.setCellValueFactory(new PropertyValueFactory<>("roles"));
        
        UserService us= new UserService();
        
        ArrayList<User> users= us.getAllUsers();
        
        for(User user :users){
            dataTable.getItems().add(user);
        }
    }
    
    @FXML
    void logout(ActionEvent event) {
        UserService us= new UserService();
        us.logout(event);
    }
    
    @FXML
    void goToTeams(ActionEvent event) {
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/MH/gui/table_team.fxml"));
            Parent root= loader.load();
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
