package com.iec.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


@Document(collection = "history")  
public class History {
	
	@Id
	private String id;
	private String activityId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date dateTime;
	private ChangeTypes type;
	private List<Changes> changes;
	
	public History() {}

	public History(String activityId, Date dateTime, ChangeTypes type, List<Changes> changes) {
		this.activityId = activityId;
		this.dateTime = dateTime;
		this.type = type;
		this.changes = changes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public ChangeTypes getType() {
		return type;
	}

	public void setType(ChangeTypes type) {
		this.type = type;
	}

	public List<Changes> getChanges() {
		return changes;
	}

	public void setChanges(List<Changes> changes) {
		this.changes = changes;
	}

	@Override
	public String toString() {
		return "HistoryEntity [id=" + id + ", activityId=" + activityId + ", dateTime=" + dateTime + ", type=" + type
				+ ", changes=" + changes + "]";
	}
	
}