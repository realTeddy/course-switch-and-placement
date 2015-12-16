/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.presentation;

import edu.mum.business.PreferenceManager;
import edu.mum.business.RegistrationManager;
import edu.mum.model.Block;
import edu.mum.model.Course;
import edu.mum.model.Registration;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class RegistrationBean implements Serializable {

    public RegistrationManager getRegistrationManager() {
        return registrationManager;
    }

    public void setRegistrationManager(RegistrationManager registrationManager) {
        this.registrationManager = registrationManager;
    }

    public PreferenceManager getPreferenceManager() {
        return preferenceManager;
    }

    public void setPreferenceManager(PreferenceManager preferenceManager) {
        this.preferenceManager = preferenceManager;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public RegistrationBean() {
        registrationManager = new RegistrationManager();
        preferenceManager = new PreferenceManager();
    }

    RegistrationManager registrationManager;
    PreferenceManager preferenceManager;

    @Inject
    private UserBean userBean;

    private Course course;
    private Block block;

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

    public List<Registration> getRegistrations() {
        return registrationManager.getRegistrations(userBean.getUser());
    }

//    public List<Preference> getPreferences(Block block) {
//        return preferenceManager.getPreferences(userBean.getUser(), block);
//    }
    public String register() {
        registrationManager.register(userBean.getUser(), block, course, null);
        return "main";
    }
}
