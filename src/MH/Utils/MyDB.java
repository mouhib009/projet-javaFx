/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MH.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyDB {
    final String URL ="jdbc:mysql://127.0.0.1:3306/ms";
   final String USER ="root";
   final String PASSWORD ="";
   static private Connection cnx;
   static private MyDB instance ;
    
    private MyDB(){
        
        try {
            cnx =DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("cnx reussie ....");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
        
    }
    
   static public MyDB getInstance(){
     if (instance == null )
         instance = new MyDB();
        
    return instance;
    }
   
    static public Connection getCnx(){
        return cnx;
    }
}