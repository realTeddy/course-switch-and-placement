/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dataaccess;

import edu.mum.modelimpl.UserImpl;
import java.util.List;
import edu.mum.model.Block;
import edu.mum.model.Course;
import edu.mum.model.PendingSwitch;
import edu.mum.model.Registration;
import edu.mum.model.User;
import edu.mum.modelimpl.BlockImpl;
import edu.mum.modelimpl.CourseImpl;
import edu.mum.modelimpl.RegistrationImpl;
import java.time.LocalDate;
import java.util.ArrayList;

public class Database {

    private static final List<User> users = new ArrayList<>();
    private static final List<Course> courses = new ArrayList<>();
    private static final List<Block> blocks = new ArrayList<>();
    private static final List<Registration> registrations = new ArrayList<>();
    private static final List<PendingSwitch> pendingSwitches = new ArrayList<>();

    public static List<PendingSwitch> getPendingSwitches() {
        return pendingSwitches;
    }

    public static void addPendingSwitche(PendingSwitch pendingSwitch) {
        pendingSwitches.add(pendingSwitch);
    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<Course> getCourses() {
        return courses;
    }

    public static List<Block> getBlocks() {
        return blocks;
    }

    public static List<Registration> getRegistrations() {
        return registrations;
    }

    public static User addUser(String id, String firstName, String lastName, String email, String password) {
        UserImpl newUser = new UserImpl(id, firstName, lastName, email, password, false);
        users.add(newUser);
        return newUser;
    }

    public static void register(User user, Block block, Course course, List<Course> preferedCourses) {
        registrations.add(new RegistrationImpl(0, user, block, course, preferedCourses));
    }

    static {
        User user1 = new UserImpl("984511", "John", "Doe", "john@mum.edu", "123", false);
        users.add(user1);
        User user2 = new UserImpl("984512", "Jane", "Doe", "jane@mum.edu", "123", false);
        users.add(user2);
        User admin = new UserImpl("984513", "Admin", "", "admin@mum.edu", "123", true);
        users.add(admin);

        Course course1 = new CourseImpl(1, "CS 390", "Fundamental Programming Practices", "This course provides a focused program for enhancing programming and analytical skills in five areas", null, "Professor ...");
        Course course2 = new CourseImpl(2, "CS 401", "Modern Programming Practices", "Current Concepts and Best Practices in Software Development — Knowledge is the Basis of Action", null, "Professor ...");
        Course course3 = new CourseImpl(3, "CS 422", "Database Systems", "Capturing the Organizing Power of Information", null, "Professor ...");
        Course course4 = new CourseImpl(4, "CS 423", "Systems Analysis and Design", "The systems approach is an organized way of dealing with a problem", null, "Professor ...");
        Course course5 = new CourseImpl(5, "CS 425", "Software Engineering", "Knowledge Is the Basis of Action — Principles and Processes for Developing Large-Scale Software Systems", null, "Professor ...");
        Course course6 = new CourseImpl(6, "CS 428", "Software Development with Fund. Design Patterns", "This course is an introduction to 23 GoF (Gang of Four) design patterns.", null, "Professor ...");
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);

        List<Course> firstBlockCourses = new ArrayList<>();
        firstBlockCourses.add(course1);
        List<Course> secondBlockCourses = new ArrayList<>();
        firstBlockCourses.add(course2);
        List<Course> thirdBlockCourses = new ArrayList<>();
        thirdBlockCourses.add(course3);
        thirdBlockCourses.add(course4);
        thirdBlockCourses.add(course5);
        thirdBlockCourses.add(course6);

        Block block1 = new BlockImpl(firstBlockCourses, LocalDate.of(2016, 1, 1), 1);
        Block block2 = new BlockImpl(secondBlockCourses, LocalDate.of(2016, 2, 1), 2);
        Block block3 = new BlockImpl(thirdBlockCourses, LocalDate.of(2016, 3, 1), 3);
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);

        registrations.add(new RegistrationImpl(1, user1, block1, course1, null));
        registrations.add(new RegistrationImpl(2, user1, block2, course2, null));
        registrations.add(new RegistrationImpl(3, user1, block3, course3, null));

        registrations.add(new RegistrationImpl(4, user2, block1, course1, null));
        registrations.add(new RegistrationImpl(5, user2, block2, course2, null));
        registrations.add(new RegistrationImpl(6, user2, block3, course4, null));
    }
}
