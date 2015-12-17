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
public interface PendingSwitch {

    Registration getFromRegistration();

    Course getToCourse();

    User getUser();

    void setFromRegistration(Registration fromRegistration);

    void setToCourse(Course toCourse);

    void setUser(User user);
    
}
