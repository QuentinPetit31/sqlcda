package com.adrar.sqlcda.model;

import javax.management.relation.Role;

public class User {
    /*
     * Attributs
     * */
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Roles roles;

    /*
     * Constructeurs
     * */
    public User(){}

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;


    }

    /*
     * Getters et Setters
     * */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRolesName() { return roles; }

    public void setRolesName(Roles roles) { this.roles = roles; }

    /*
     * Méthodes
     * */
    @Override
    public String toString() {
        return "User{" +
                "firstname='" + this.firstname + '\'' +
                ", lastname='" + this.lastname + '\'' +
                '}';
    }
}