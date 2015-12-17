/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.viewmodel;

import edu.mum.model.Block;
import edu.mum.model.Course;
import edu.mum.model.Registration;
import edu.mum.model.User;
import java.util.ArrayList;
import java.util.List;

public class RegistrationViewModel {

    public RegistrationViewModel(int id, User user, Block block, Course course, List<CourseViewModel> preferedCourses) {
        this.id = id;
        this.user = user;
        this.course = course;
        this.block = block;
        this.preferedCourses = preferedCourses != null ? preferedCourses : new ArrayList<>();
    }

    public RegistrationViewModel(Registration registration) {
        this.id = registration.getId();
        this.user = registration.getUser();
        this.course = registration.getCourse();
        this.block = registration.getBlock();
        this.preferedCourses = new ArrayList<>();
        for (Course course : registration.getPreferedCourses()) {
            this.preferedCourses.add(new CourseViewModel(course, false, false));
        }
    }

    private int id;
    private User user;
    private Course course;
    private Block block;
    private List<CourseViewModel> preferedCourses;

    public List<CourseViewModel> getPreferedCourses() {
        return preferedCourses;
    }

    public void setPreferedCourses(List<CourseViewModel> preferedCourses) {
        this.preferedCourses = preferedCourses;
    }

    public void addPreferedCourse(CourseViewModel preferedCourse) {
        this.preferedCourses.add(preferedCourse);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
