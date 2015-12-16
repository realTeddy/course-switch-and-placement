/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.business;

import edu.mum.dataaccess.Database;
import edu.mum.model.Block;
import edu.mum.model.Course;
import edu.mum.model.Registration;
import edu.mum.model.User;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrationManager {

    public RegistrationManager() {
        database = new Database();
    }

    private final Database database;

    public List<Registration> getRegistrations(User user) {
        return database.getRegistrations().stream().filter(b -> b.getUser().equals(user)).collect(Collectors.toList());
    }

    public void register(User user, Block block, Course course, List<Course> preferedCourses) {
        database.register(user, block, course, preferedCourses);
    }

    public void addPreferedCourse(int registrationId, int courseId) {
        Registration registration = database.getRegistrations().stream().filter(r -> r.getId() == registrationId).findFirst().get();
        Course course = database.getCourses().stream().filter(r -> r.getId() == courseId).findFirst().get();
        registration.addPreferedCourse(course);
    }
}
