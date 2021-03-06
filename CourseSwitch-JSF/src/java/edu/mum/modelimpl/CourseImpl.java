package edu.mum.modelimpl;

import java.util.List;
import edu.mum.model.Course;
import java.util.ArrayList;
import java.util.Objects;

public class CourseImpl implements Course {

    public CourseImpl(int id, String code, String title, String description, List<Course> prerequisites, String instructor) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.description = description;
        this.prerequisites = prerequisites != null ? prerequisites : new ArrayList<>();
        this.instructor = instructor;
    }

    private int id;
    private String code;
    private String title;
    private String description;
    private List<Course> prerequisites;
    private String instructor;
    private int classCapacity;

    @Override
    public String getInstructor() {
        return instructor;
    }

    @Override
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title + " (" + code + ")";
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
    public int getClassCapacity() {
        return classCapacity;
    }

    @Override
    public void setClassCapacity(int classCapacity) {
        this.classCapacity = classCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof CourseImpl) {
            CourseImpl course = (CourseImpl) obj;
            return course.getId() == id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.prerequisites);
        return hash;
    }
}
