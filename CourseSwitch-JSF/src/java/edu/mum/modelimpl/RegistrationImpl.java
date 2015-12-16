package edu.mum.modelimpl;

import edu.mum.model.Block;
import edu.mum.model.Course;
import edu.mum.model.Registration;
import edu.mum.model.User;
import java.util.ArrayList;
import java.util.List;

public class RegistrationImpl implements Registration {

    public RegistrationImpl(int id, User user, Block block, Course course, List<Course> preferedCourses) {
        this.id = id;
        this.user = user;
        this.course = course;
        this.block = block;
        this.preferedCourses = preferedCourses != null ? preferedCourses : new ArrayList<>();
    }

    private int id;
    private User user;
    private Course course;
    private Block block;
    private List<Course> preferedCourses;
    
    @Override
    public List<Course> getPreferedCourses() {
        return preferedCourses;
    }
    
    @Override
    public void setPreferedCourses(List<Course> preferedCourses) {
        this.preferedCourses = preferedCourses;
    }
    
    @Override
    public void addPreferedCourse(Course preferedCourse) {
        this.preferedCourses.add(preferedCourse);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Course getCourse() {
        return course;
    }

    @Override
    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public void setBlock(Block block) {
        this.block = block;
    }
}
