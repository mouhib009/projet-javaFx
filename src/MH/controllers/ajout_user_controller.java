/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MH.controllers;

import MH.Utils.Statics;
import MH.entities.User;
import MH.services.UserService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Administrator
 */
public class ajout_user_controller {

    @FXML
    private TextField email;

    @FXML
    private ImageView img;
    
    private String image;

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
                name.getText().equals("") || last_name.getText().equals("") || img.getImage()==null || region.getText().equals("") || nickname.getText().equals(""))
            errorLabel.setText("Please fill all the fields");
        else{
            saveImage();
            User user= new User(email.getText(), roles.getText(), password.getText(), name.getText(), last_name.getText(), image, region.getText(), nickname.getText());
            UserService userSrvice= new UserService();
            userSrvice.addUser(user);
            goToCreateTeam();
        }
        
    }
    
    
    public void goToCreateTeam(){
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/MH/gui/table_user.fxml"));
            Parent root= loader.load();
            Stage stage = (Stage) ((Node)name).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    void saveImage(){
        try{
            image= email.getText()+".png";
            File f= new File(Statics.PUBLIC_PATH+ image);
            ImageIO.write(SwingFXUtils.fromFXImage(img.getImage(), null), "png", f);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    @FXML
    void uploadImage(ActionEvent event) {
        FileChooser fileChooser= new FileChooser();
        fileChooser.setTitle("Upload your image");
        
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpeg", "*.jpg"));
        File file= fileChooser.showOpenDialog(((Node)event.getSource()).getScene().getWindow());
        if(file!= null){
            try {
                img.setImage(new Image(new FileInputStream(file)));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ajout_user_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            img.setImage(null);
        }
    }
}
