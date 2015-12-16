/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.presentation;

import edu.mum.business.PreferenceManager;
import edu.mum.model.Preference;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PreferencesBean implements Serializable {

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public PreferencesBean() {
        preferenceManager = new PreferenceManager();
    }
    
    private final PreferenceManager preferenceManager;

    @Inject
    private UserBean user;
    
    public List<Preference> getPreferences(int blockId) {
        return preferenceManager.getPreferences(user.getUser(), blockId);
    }
}
