/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.business;

import edu.mum.dataaccess.Database;
import edu.mum.model.Course;
import edu.mum.model.PendingSwitch;
import edu.mum.model.Registration;
import edu.mum.model.User;
import edu.mum.viewmodel.CourseViewModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseManager {

    public CourseManager() {
        database = Database.getInstance();
    }

    private final Database database;

    public List<CourseViewModel> getCourses(User user, int courseId, int blockId) {
        List<Course> previousCourses = database.getRegistrations().stream()
                .filter(r -> r.getUser().equals(user) && r.getBlock().getStartDate().compareTo(LocalDate.now()) > 0)
                .map(r -> r.getCourse()).collect(Collectors.toList());

        List<Course> alreadyPreferenced = database.getRegistrations().stream()
                .filter(r -> r.getBlock().getId() == blockId && r.getUser().getId().equals(user.getId()))
                .map(r -> r.getPreferedCourses()).flatMap(Collection::stream).collect(Collectors.toList());

        List<Course> blockCourses = database.getBlocks().stream().filter(b -> b.getId() == blockId)
                .map(b -> b.getCourses()).flatMap(Collection::stream).collect(Collectors.toList());

        List<Course> courses = blockCourses.stream().filter(c -> !previousCourses.contains(c) && (c.getPrerequisites().isEmpty()
                || previousCourses.stream().anyMatch(pc -> c.getPrerequisites().contains(pc))
                && !alreadyPreferenced.contains(c)))
                .collect(Collectors.toList());

        List<CourseViewModel> courseViewModels = new ArrayList<>();

        List<Registration> registrations = database.getRegistrations().stream()
                .filter(r -> r.getBlock().getId() == blockId).collect(Collectors.toList());

        List<Course> pendingSwitches = database.getPendingSwitches().stream().filter(p -> p.getUser().equals(user)).map(p -> p.getToCourse()).collect(Collectors.toList());

        for (Course course : courses) {
            boolean isAvailable;
            long registeredCount = registrations.stream().filter(r -> r.getCourse().equals(course)).count();
            if (registeredCount < course.getClassCapacity()) {
                isAvailable = true;
            } else {
                isAvailable = registrations.stream().anyMatch(r -> r.getCourse().equals(course) && r.getPreferedCourses().stream().anyMatch(p -> p.getId() == courseId));
            }
            boolean isPendingApproval = pendingSwitches.contains(course);
            courseViewModels.add(new CourseViewModel(course, isAvailable, isPendingApproval));
        }

        return courseViewModels;
    }

}
