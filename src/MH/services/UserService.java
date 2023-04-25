/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MH.services;


import MH.Utils.MyDB;
import MH.entities.User;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
}
