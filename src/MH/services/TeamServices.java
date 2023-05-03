/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MH.services;
import MH.Utils.MyDB;
import MH.entities.Team;
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
/**
 *
 * @author Administrator
 */
public class TeamServices {
    
    private Connection cnt;
    
    public TeamServices(){
        cnt= MyDB.getInstance().getCnx();
    }
    
    public void addTeam(Team t){
        try{
            String query= "INSERT INTO Team (creator_id,name,logo) "
                    + "VALUES ('"+t.getCreator_id()+"', '"+t.getName()+"', '"+t.getLogo()
                   +"')";
            Statement pr= cnt.createStatement();
            pr.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e);
        }
    }
        public ArrayList<Team> getAllTeams(){
        
            ArrayList<Team> teams= new ArrayList<>();
        try{
            String query="SELECT * FROM team";
            Statement st= cnt.createStatement();
            ResultSet rs= st.executeQuery(query);
            while(rs.next()){
                Team team= new Team(rs.getInt("id"), rs.getString("name"), rs.getString("logo"));
                teams.add(team);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return teams;
    }

    public void logout(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
