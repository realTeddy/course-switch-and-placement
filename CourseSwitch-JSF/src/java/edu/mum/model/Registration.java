/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.model;

import java.util.List;

public interface Registration {
    
    int getId();
    
    void setId(int id);

    Block getBlock();

    Course getCourse();

    User getUser();

    void setBlock(Block block);

    void setCourse(Course course);

    void setUser(User user);
    
    public List<Course> getPreferedCourses();
    
    public void setPreferedCourses(List<Course> preferedCourses);

    public void addPreferedCourse(Course preferedCourse);
}
