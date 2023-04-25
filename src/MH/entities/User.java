/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MH.entities;

/**
 *
 * @author Administrator
 */
public class User {
    private int id;
    private String email;
    private String roles;
    private String password;
    private String name;
    private String last_name;
    private String image;
    private String region;
    private String nickname; 

    public User(int id, String email, String roles, String passwrod, String name, String last_name, String image, String region, String nickname) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.password = passwrod;
        this.name = name;
        this.last_name = last_name;
        this.image = image;
        this.region = region;
        this.nickname = nickname;
        
    }

    public User(String email, String roles, String passwrod, String name, String last_name, String image, String region, String nickname) {
        this.email = email;
        this.roles = roles;
        this.password = passwrod;
        this.name = name;
        this.last_name = last_name;
        this.image = image;
        this.region = region;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getImage() {
        return image;
    }

    public String getRegion() {
        return region;
    }

    public String getNickname() {
        return nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public User() {
    }

    public User(int id, String nickname) {
        this.id= id;
        this.name= nickname;
    }

    
    @Override
    public String toString() {
        return "User{" + "email=" + email + ", roles=" + roles + ", passwrod=" + password + ", name=" + name + ", last_name=" + last_name + ", image=" + image + ", region=" + region + ", nickname=" + nickname + '}';
    }
   
}

