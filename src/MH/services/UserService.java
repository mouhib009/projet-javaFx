/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MH.services;


import MH.Utils.MyDB;
import MH.Utils.Statics;
import MH.entities.User;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author Administrator
 */
public class UserService {
    
    private Connection cnt;
    
    public UserService(){
        cnt= MyDB.getInstance().getCnx();
    }
    
    public void addUser(User u){
        try{
            String query= "INSERT INTO User (email, roles, password, name, last_name, image, region, nickname) "
                    + "VALUES ('"+u.getEmail()+"','"+u.getRoles()+"', '"+u.getPassword()+"', '"+u.getName()
                    +"', '"+u.getLast_name()+"', '"+u.getImage()+"', '"+u.getRegion()+"', '"+u.getNickname()+"')";
            Statement pr= cnt.createStatement();
            pr.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public ArrayList<User> getAllUsers(){
        
            ArrayList<User> users= new ArrayList<>();
        try{
            String query="SELECT * FROM user";
            Statement st= cnt.createStatement();
            ResultSet rs= st.executeQuery(query);
            while(rs.next()){
                User user= new User(rs.getInt("id"), rs.getString("email") , rs.getString("roles"), rs.getString("password"), rs.getString("name"), rs.getString("last_name"), rs.getString("image"), rs.getString("region"), rs.getString("nickname"));
                users.add(user);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return users;
    }
    
    public User loginUser(String email, String pwd){
        try{
            String query="SELECT * FROM user where email='"+email+"'";
            Statement st= cnt.createStatement();
            
            ResultSet rs= st.executeQuery(query);
            if(rs.next()){
                User user= new User(rs.getInt("id"), rs.getString("email") , rs.getString("roles"), rs.getString("password"), rs.getString("name"), rs.getString("last_name"), rs.getString("image"), rs.getString("region"), rs.getString("nickname"));
                if(checkPwd(user.getPassword(), pwd))
                    return user;
            }else System.out.println("Bruh");
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    
    public Boolean checkPwd(String userPwd, String pwd){
        String hashed = "$2a" + userPwd.substring(3);
        System.out.println(hashed);
        return BCrypt.checkpw(pwd,hashed);
    }
    
    public void logout(ActionEvent elem){
        Statics.user= null;
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/MH/gui/login.fxml"));
            Parent root= loader.load();
            Stage stage = (Stage) ((Node)elem.getSource()).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
