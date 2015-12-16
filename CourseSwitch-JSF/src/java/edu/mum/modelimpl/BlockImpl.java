/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.modelimpl;

import java.time.LocalDate;
import java.util.List;
import edu.mum.model.Block;
import edu.mum.model.Course;

public class BlockImpl implements Block {

    public BlockImpl(List<Course> courses, LocalDate startDate, int blockId) {
        this.courses = courses;
        this.startDate = startDate;
        this.blockId = blockId;
    }
    
    private List<Course> courses;
    private LocalDate startDate;
    private int blockId;

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    @Override
    public String toString() {
        return startDate.toString();
    }

    @Override
    public int getBlockId() {
        return blockId;
    }

    @Override
    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }
}
