/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MH.controllers;

import MH.entities.Team;
import MH.entities.User;
import MH.services.TeamServices;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class list_team_controller implements Initializable{
 
    
     @FXML
    private TableView<Team> dataTable;
     
     @FXML
    private TableColumn<Team, String> name;

     @FXML
    private TableColumn<Team, String> logo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
      
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        logo.setCellValueFactory(new PropertyValueFactory<>("logo"));
   
        TeamServices tm= new TeamServices();
        
        ArrayList<Team> teams= tm.getAllTeams();
        
        
        for(Team team :teams){
            try{
            dataTable.getItems().add(team);
            }catch(Exception e){
            System.out.println(e);
        }
        }
        
    }
    
    @FXML
    void logout(ActionEvent event) {
        TeamServices tm= new TeamServices();
        tm.logout(event);
    }
    
    @FXML
    void goToUsers(ActionEvent event) {
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/MH/gui/table_user.fxml"));
            Parent root= loader.load();
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
     @FXML
    void newTeam(ActionEvent event) {
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/MH/gui/ajout_team.fxml"));
            Parent root= loader.load();
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

