package edu.mum.model;

import java.util.List;


public class Course {
	private String code;
	private String title;
	private String description;
	private List<Course> prerequisites;
        private String instructor;

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public List<Course> getPrerequisites() {
		return prerequisites;
	}

	public String getTitle() {
		return title;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrerequisites(List<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
