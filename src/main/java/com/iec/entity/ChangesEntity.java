package com.iec.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "changes")  
public class ChangesEntity {
	
	@Id
	private String id;
	private String activityId;
	private String fieldName;
	private String oldValue;
	private String newValue;
	
	public ChangesEntity() {}

	public ChangesEntity(String activityId, String fieldName, String oldValue, String newValue) {
		this.activityId = activityId;
		this.fieldName = fieldName;
		this.oldValue = oldValue;
		this.newValue = newValue;
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

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	@Override
	public String toString() {
		return "ChangesEntity [id=" + id + ", activityId=" + activityId + ", fieldName=" + fieldName + ", oldValue="
				+ oldValue + ", newValue=" + newValue + "]";
	}

}