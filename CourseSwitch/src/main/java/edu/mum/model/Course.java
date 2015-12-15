package edu.mum.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	private String code;
	private String title;
	private String description;
	private List<Course> prerequisites;

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
