package com.iec.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "changes")  
public class Changes {
	
	@Id
	private String id;
	private String activityId;
	private String fieldName;
	private String oldValue;
	private String newValue;
	
	public Changes() {}

	public Changes(String activityId, String fieldName, String oldValue, String newValue) {
		this.activityId = activityId;
		this.fieldName = fieldName;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	@Override
	public String toString() {
		return "ChangesEntity [id=" + id + ", activityId=" + activityId + ", fieldName=" + fieldName + ", oldValue="
				+ oldValue + ", newValue=" + newValue + "]";
	}

}