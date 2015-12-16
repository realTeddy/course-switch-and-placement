/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Tewodros Ayele Assefa
 */
public interface Block {
    
    int getId();
    
    void setId(int id);

    List<Course> getCourses();

    LocalDate getStartDate();

    void setCourses(List<Course> courses);

    void setStartDate(LocalDate startDate);
    
}
