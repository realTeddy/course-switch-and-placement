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
import edu.mum.modelimpl.PendingSwitchImpl;
import edu.mum.viewmodel.CourseViewModel;
import edu.mum.viewmodel.RegistrationViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RegistrationManager {

    public List<RegistrationViewModel> getRegistrations(User user) {
        List<Registration> registrations = Database.getRegistrations().stream().filter(b -> b.getUser().equals(user)).collect(Collectors.toList());

        List<RegistrationViewModel> registrationViewModels = new ArrayList<>();
        for (Registration registration : registrations) {
            RegistrationViewModel registrationViewModel = new RegistrationViewModel(registration);
            for (CourseViewModel courseViewModel : registrationViewModel.getPreferedCourses()) {
                if (courseViewModel.getCourse().getClassCapacity() > Database.getRegistrations().stream().filter(r -> r.getCourse().equals(courseViewModel.getCourse())).count()) {
                    courseViewModel.setIsAvailable(true);
                }
                if (Database.getRegistrations().stream().anyMatch(r -> r.getBlock().equals(registration.getBlock()) && r.getPreferedCourses().contains(courseViewModel.getCourse()))) {
                    courseViewModel.setIsAvailable(true);
                }
                if (Database.getPendingSwitches().stream().anyMatch(p -> p.getUser().equals(user) && p.getToCourse().equals(courseViewModel.getCourse()))) {
                    courseViewModel.setIsPendingApproval(true);
                }
            }
            registrationViewModels.add(registrationViewModel);
        }

        return registrationViewModels;
    }

    public void register(User user, Block block, Course course, List<Course> preferedCourses) {
        Database.register(user, block, course, preferedCourses);
    }

    public boolean addPreferedCourse(User user, int registrationId, int courseId) {
        Registration registration = Database.getRegistrations().stream().filter(r -> r.getId() == registrationId).findFirst().get();
        Course course = Database.getCourses().stream().filter(r -> r.getId() == courseId).findFirst().get();
        registration.addPreferedCourse(course);

        if (course.getClassCapacity() > Database.getRegistrations().stream().filter(r -> r.getCourse().equals(course)).count()) {
            Database.addPendingSwitche(new PendingSwitchImpl(user, registration, course, false));

            return true;
        } else if (Database.getRegistrations().stream().anyMatch(r -> r.getBlock().equals(registration.getBlock()) && r.getPreferedCourses().contains(course))) {
            Optional<Registration> otherRegistration = Database.getRegistrations().stream().filter(r -> r.getBlock().equals(registration.getBlock()) && r.getCourse().equals(course) && r.getPreferedCourses().contains(registration.getCourse())).findFirst();
            if (otherRegistration.isPresent()) {
                Database.addPendingSwitche(new PendingSwitchImpl(user, registration, course, true));
                Database.addPendingSwitche(new PendingSwitchImpl(otherRegistration.get().getUser(), otherRegistration.get(), registration.getCourse(), true));
                return true;
            }
        }
        return false;
    }
}
