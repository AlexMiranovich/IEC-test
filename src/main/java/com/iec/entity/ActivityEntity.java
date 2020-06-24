package com.iec.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


@Document(collection = "activity")  
public class ActivityEntity {
	
	@Id
    private String id;
	private String title;
	private String summary;
	private String description;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date startDateTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date endDateTime;
	private String info;
		
	public ActivityEntity() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "ActivityEntity [id=" + id + ", title=" + title + ", summary=" + summary + ", description=" + description
				+ ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", info=" + info + "]";
	}
	
}