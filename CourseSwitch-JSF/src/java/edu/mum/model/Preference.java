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
public interface Preference {

    Course getCourse();

    Block getBlock();

    User getUser();

    void setCourse(Course course);

    void setBlock(Block block);

    void setUser(User user);
    
}
