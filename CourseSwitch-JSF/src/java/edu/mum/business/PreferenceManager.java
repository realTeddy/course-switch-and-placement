/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.business;

import edu.mum.dataaccess.Database;
import edu.mum.model.Course;
import java.util.List;
import java.util.stream.Collectors;

public class PreferenceManager {

    public List<Course> getPreferences(int courseId) {
        return Database.getRegistrations().stream().filter(p -> p.getCourse().getId() == courseId).map(r -> r.getCourse()).collect(Collectors.toList());
    }
}
