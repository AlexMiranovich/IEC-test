package com.iec.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


@Document(collection = "history")  
public class HistoryEntity {
	
	@Id
	private ObjectId id;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date dateTime;
	private ChangeTypes type;
	private ChangesEntity changes;
	
	public HistoryEntity() {}
	
	public HistoryEntity(Date dateTime, ChangeTypes type, ChangesEntity changes) {
		this.dateTime = dateTime;
		this.type = type;
		this.changes = changes;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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

	public ChangesEntity getChanges() {
		return changes;
	}

	public void setChanges(ChangesEntity changes) {
		this.changes = changes;
	}

	@Override
	public String toString() {
		return "HistoryEntity [id=" + id + ", dateTime=" + dateTime + ", type=" + type + ", changes=" + changes + "]";
	}
	
}