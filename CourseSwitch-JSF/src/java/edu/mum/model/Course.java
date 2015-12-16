/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.model;

import java.util.List;

/**
 *
 * @author Tewodros Ayele Assefa
 */
public interface Course {
    
    public String getInstructor();

    public void setInstructor(String instructor);

    String getCode();

    String getDescription();

    List<Course> getPrerequisites();

    String getTitle();

    void setCode(String code);

    void setDescription(String description);

    void setPrerequisites(List<Course> prerequisites);

    void setTitle(String title);
    
}
