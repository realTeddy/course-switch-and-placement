/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.presentation;

import edu.mum.business.PreferenceManager;
import edu.mum.model.Course;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PreferencesBean implements Serializable {

    public UserBean getUser() {
        return userBean;
    }

    public void setUser(UserBean user) {
        this.userBean = user;
    }

    public PreferencesBean() {
        preferenceManager = new PreferenceManager();
    }
    
    private final PreferenceManager preferenceManager;

    @Inject
    private UserBean userBean;
    
//    public List<Course> getPreferences(int blockId) {
//        return preferenceManager.getPreferences(userBean.getUser(), blockId);
//    }
}
