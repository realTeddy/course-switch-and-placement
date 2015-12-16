/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dataaccess;

import edu.mum.modelimpl.UserImpl;
import java.util.List;
import edu.mum.model.Block;
import edu.mum.model.Course;
import edu.mum.model.Preference;
import edu.mum.model.Registration;
import edu.mum.model.User;
import edu.mum.modelimpl.BlockImpl;
import edu.mum.modelimpl.CourseImpl;
import edu.mum.modelimpl.RegistrationImpl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Database {

    public Database() {
        users = new ArrayList<>();
        courses = new ArrayList<>();
        registrations = new ArrayList<>();
        blocks = new ArrayList<>();
        preferences = new ArrayList<>();
        init();
    }

    private List<User> users;
    private List<Course> courses;
    private List<Block> blocks;
    private List<Preference> preferences;
    private List<Registration> registrations;

    public List<User> getUsers() {
        return users;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Preference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Preference> preferences) {
        this.preferences = preferences;
    }

    public List<Registration> getRegistration() {
        return registrations;
    }

    public void setRegistration(List<Registration> registration) {
        this.registrations = registration;
    }

    public void setStudents(List<User> users) {
        this.users = users;
    }

    public User addUser(String id, String firstName, String lastName, String email, String password) {
        UserImpl newUser = new UserImpl(id, firstName, lastName, email, password);
        users.add(newUser);
        return newUser;
    }

    public void register(User user, Block block, Course course) {
        registrations.add(new RegistrationImpl(user, block, course));
    }

    private void init() {
        User user = new UserImpl("984511", "John", "Doe", "jdoe@mum.edu", "123");
        users.add(user);

        Course course = new CourseImpl("CS...", "W", "...", null, "Professor ...");
        courses.add(course);
        courses.add(new CourseImpl("CS545", "Web Application Architecture and Frameworks", "...", Arrays.asList(course), "Professor Levi"));
        
        Block block = new BlockImpl(courses, LocalDate.of(2015, 12, 1), 1);
        
        registrations.add(new RegistrationImpl(user, block, course));
    }
}
