/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.modelimpl;

import edu.mum.model.Course;
import edu.mum.model.PendingSwitch;
import edu.mum.model.Registration;
import edu.mum.model.User;

public class PendingSwitchImpl implements PendingSwitch {

    public PendingSwitchImpl(User user, Registration fromRegistration, Course toCourse) {
        this.user = user;
        this.fromRegistration = fromRegistration;
        this.toCourse = toCourse;
    }
    
    private User user;
    private Registration fromRegistration;
    private Course toCourse;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Registration getFromRegistration() {
        return fromRegistration;
    }

    @Override
    public void setFromRegistration(Registration fromRegistration) {
        this.fromRegistration = fromRegistration;
    }

    @Override
    public Course getToCourse() {
        return toCourse;
    }

    @Override
    public void setToCourse(Course toCourse) {
        this.toCourse = toCourse;
    }
    
}
