/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.business;

import edu.mum.dataaccess.Database;
import edu.mum.model.Block;
import java.util.List;
import java.util.stream.Collectors;

public class BlockManager {

    private Database database;

    public List<Block> getBlocks(String userId) {
        return database.getRegistration().stream().filter(r -> r.getUser().getId().equals(userId)).map(r -> r.getBlock()).collect(Collectors.toList());
    }
}
