/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MH.controllers;
import MH.Utils.Statics;
import MH.entities.Team;
import MH.services.TeamServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class ajout_team_controller {
    

    @FXML
    private TextField name;

    @FXML
    private TextField logo;

    @FXML
    private Label errorLabel;

    @FXML
    void submit(ActionEvent event) throws Exception {
        errorLabel.setText("");
        
        if(name.getText().equals("") || logo.getText().equals("") 
             )
            errorLabel.setText("Please fill all the fields");
        else{
            Team team= new Team(Statics.user.getId(), name.getText(), logo.getText());
            TeamServices teamServices= new TeamServices();
            teamServices.addTeam(team);
        }
        
    }
    
    
    
}

