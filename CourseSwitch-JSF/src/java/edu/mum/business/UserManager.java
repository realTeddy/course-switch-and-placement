/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.business;

import edu.mum.dataaccess.Database;
import edu.mum.model.User;
import java.util.Optional;

public class UserManager {

    public UserManager() {
        database = new Database();
    }

    private final Database database;

    public User getUser(String email, String password) {
        Optional<User> user = database.getUsers().stream().filter(s -> s.getEmail().equals(email) && s.getPassword().equals(password)).findAny();
        return user.isPresent() ? user.get() : null;
    }

    public void addUser(String id, String firstName, String lastName, String email, String password) {
        database.addUser(new User(id, firstName, lastName, email, password));
    }
}
