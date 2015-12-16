/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.business;

import edu.mum.dataaccess.Database;
import edu.mum.model.Block;
import edu.mum.model.Preference;
import edu.mum.model.User;
import java.util.List;
import java.util.stream.Collectors;

public class PreferenceManager {

    public PreferenceManager() {
        database = new Database();
    }
    
    Database database;
    
    public List<Preference> getPreferences(User user, int blockId) {
        return database.getPreferences().stream().filter(p -> p.getUser().equals(user) && p.getBlock().getBlockId() == blockId).collect(Collectors.toList());
    }
    
    public List<Preference> getPreferences(User user, Block block) {
        return getPreferences(user, block.getBlockId());
    }
}
