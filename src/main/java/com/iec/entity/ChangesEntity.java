package com.iec.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "changes")  
public class ChangesEntity {
	
	@Id
	private ObjectId id;
	
	@Field(value = "fieldName")
	private String fieldName;
	
	@Field(value = "oldValue")
	private String oldValue;
	
	@Field(value = "newValue")
	private String newValue;
	
	public ChangesEntity() {}

	public ChangesEntity(String fieldName, String oldValue, String newValue) {
		this.fieldName = fieldName;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
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
		return "ChangesEntity [id=" + id + ", fieldName=" + fieldName + ", oldValue=" + oldValue + ", newValue="
				+ newValue + "]";
	}

}