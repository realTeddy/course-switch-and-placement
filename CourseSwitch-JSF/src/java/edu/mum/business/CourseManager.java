/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.business;

import edu.mum.dataaccess.Database;
import edu.mum.model.Course;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseManager {

    private Database database;

    public List<Course> getCourses(String userId, LocalDate date) {
        List<Course> previousCourses = database.getRegistration().stream()
                .filter(r -> r.getUser().getId().equals(userId) && r.getBlock().getStartDate().compareTo(LocalDate.now()) > 0).map(r -> r.getCourse()).collect(Collectors.toList());
        Stream<Course> blockCourses = database.getBlocks().stream().filter(b -> b.getStartDate() == date)
                .map(b -> b.getCourses()).flatMap(Collection::stream);
        return blockCourses.filter(c -> !previousCourses.contains(c)
                && (c.getPrerequisites().isEmpty() || previousCourses.stream().anyMatch(pc -> c.getPrerequisites().contains(pc))))
                .collect(Collectors.toList());
    }
    
}
