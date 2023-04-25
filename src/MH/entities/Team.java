/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MH.entities;

/**
 *
 * @author Administrator
 */
public class Team {
private int id;
private int creator_id ;
private String name;
private String logo;

    public Team(int id, int creator_id, String name, String logo) {
        this.id = id;
        this.creator_id = creator_id;
        this.name = name;
        this.logo = logo;
    }

    public Team(int creator_id, String name, String logo) {
        this.creator_id = creator_id;
        this.name = name;
        this.logo = logo;
    }

    public Team() {
    }

    public int getId() {
        return id;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Team{" + "creator_id=" + creator_id + ", name=" + name + ", logo=" + logo + '}';
    }

}
    

