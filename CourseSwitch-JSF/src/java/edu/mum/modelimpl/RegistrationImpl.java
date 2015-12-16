package edu.mum.modelimpl;

import edu.mum.model.Block;
import edu.mum.model.Course;
import edu.mum.model.Registration;
import edu.mum.model.User;

public class RegistrationImpl implements Registration {

    public RegistrationImpl(User user, Block block, Course course) {
        this.user = user;
        this.course = course;
        this.block = block;
    }

    private User user;
    private Course course;
    private Block block;

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
