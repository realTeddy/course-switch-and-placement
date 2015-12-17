/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.presentation;

import edu.mum.dataaccess.Database;
import edu.mum.helpers.EmailHelper;
import edu.mum.model.PendingSwitch;
import edu.mum.modelimpl.RegistrationImpl;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class AdminBean implements Serializable {
    
    public List<PendingSwitch> getPendingSwitches() {
        return Database.getPendingSwitches();
    }
    
    public String approve(PendingSwitch pendingSwitch) {
        Database.getRegistrations().add(new RegistrationImpl(0, pendingSwitch.getUser(), pendingSwitch.getFromRegistration().getBlock(), pendingSwitch.getToCourse(), null));
        Database.getRegistrations().remove(pendingSwitch.getFromRegistration());
        Database.getPendingSwitches().remove(pendingSwitch);
        EmailHelper.sendApprovalEmail();
        return "admin";
    }
    
    public String reject(PendingSwitch pendingSwitch) {
        Database.getPendingSwitches().remove(pendingSwitch);
        
        return "admin";
    }
}
