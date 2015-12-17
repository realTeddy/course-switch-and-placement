/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.model;

/**
 *
 * @author Tewodros Ayele Assefa
 */
public interface User {

    String getEmail();

    String getFirstName();

    String getId();

    String getLastName();

    String getPassword();

    void setEmail(String email);

    void setFirstName(String firstName);

    void setId(String id);

    void setLastName(String lastName);

    void setPassword(String password);

    void setUsername(String username);

    void setIsAdmin(boolean isAdmin);

    boolean getIsAdmin();
    
}
