/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.presentation;

import edu.mum.business.UserManager;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import edu.mum.model.User;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class UserBean implements Serializable {

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserBean() {
        userManager = new UserManager();
    }

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private boolean isLoggedIn;

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    private boolean isAdmin;

    private User user;

    public User getUser() {
        return user;
    }

    private final UserManager userManager;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return "";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        user = userManager.getUser(email, password);
        if (user != null) {
            email = user.getEmail();
            firstName = user.getFirstName();
            lastName = user.getLastName();
            id = user.getId();
            isAdmin = user.getIsAdmin();

            isLoggedIn = true;
            if (isAdmin) {
                return "admin?faces-redirect=true";
            } else {
                return "main?faces-redirect=true";
            }
        }
        return "main";
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        isLoggedIn = false;
        return "index?faces-redirect=true";
    }

    public String register() {
        user = userManager.addUser(id, firstName, lastName, email, password);
        isLoggedIn = true;
        return "main?faces-redirect=true";
    }

    public void checkLogin(ComponentSystemEvent event) {
        if (!isLoggedIn) {
            FacesContext context = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
            handler.performNavigation("index?faces-redirect=true");
        }
    }

    public void checkAdminLogin(ComponentSystemEvent event) {
        if (!isLoggedIn || !isAdmin) {
            FacesContext context = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
            handler.performNavigation("index?faces-redirect=true");
        }
    }
}
