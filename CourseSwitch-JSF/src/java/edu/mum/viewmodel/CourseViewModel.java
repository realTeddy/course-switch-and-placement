/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.viewmodel;

import edu.mum.model.Course;

/**
 *
 * @author Tewodros Ayele Assefa
 */
public class CourseViewModel {

    public CourseViewModel(Course course, boolean isAvailable) {
        this.course = course;
        this.isAvailable = isAvailable;
    }
    
    private Course course;
    private boolean isAvailable;

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
