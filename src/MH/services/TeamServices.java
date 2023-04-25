/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MH.services;
import MH.Utils.MyDB;
import MH.entities.Team;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
}
