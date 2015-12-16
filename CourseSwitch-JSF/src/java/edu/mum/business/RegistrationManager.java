/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.business;

import edu.mum.dataaccess.Database;
import edu.mum.model.Registration;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrationManager {    
    
    private Database database;
    
    public List<Registration> getRegistrations(String id) {
        return database.getRegistration().stream().filter(b -> b.getUser().getId().equals(id)).collect(Collectors.toList());
    }
}
