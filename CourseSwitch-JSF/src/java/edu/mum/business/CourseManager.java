/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.business;

import edu.mum.dataaccess.Database;
import edu.mum.model.Course;
import edu.mum.model.User;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseManager {

    public CourseManager() {
        database = new Database();
    }

    private Database database;

    public List<Course> getCourses(User user, int blockId) {
        List<Course> previousCourses = database.getRegistrations().stream()
                .filter(r -> r.getUser().equals(user) && r.getBlock().getStartDate().compareTo(LocalDate.now()) > 0).map(r -> r.getCourse()).collect(Collectors.toList());
        
        List<Course> blockCourses = database.getBlocks().stream().filter(b -> b.getId() == blockId)
                .map(b -> b.getCourses()).flatMap(Collection::stream).collect(Collectors.toList());
        
        return blockCourses.stream().filter(c -> !previousCourses.contains(c)
                && (c.getPrerequisites().isEmpty() || previousCourses.stream().anyMatch(pc -> c.getPrerequisites().contains(pc))))
                .collect(Collectors.toList());
    }

}
