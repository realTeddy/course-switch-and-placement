/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.modelimpl;

import edu.mum.model.Block;
import edu.mum.model.Course;
import edu.mum.model.Preference;
import edu.mum.model.User;

/**
 *
 * @author Tewodros Ayele Assefa
 */
public class PreferenceImpl implements Preference {

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
    
    @Override
    public String toString() {
        return block.toString() + " - " + course.toString();
    }
}
