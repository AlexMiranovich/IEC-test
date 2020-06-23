package com.iec.entity;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "history")  
public class HistoryEntity {
	
	@Id
	private ObjectId id;
	
	@Field(value = "dateTime")
	private Date dateTime;
	
	@Field(value = "type")
	private ChangeTypes type;
	
	@Field(value = "changes")
	private List<ChangesEntity> changes;
	
	public HistoryEntity() {}

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

	public List<ChangesEntity> getChanges() {
		return changes;
	}

	public void setChanges(List<ChangesEntity> changes) {
		this.changes = changes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((changes == null) ? 0 : changes.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoryEntity other = (HistoryEntity) obj;
		if (changes == null) {
			if (other.changes != null)
				return false;
		} else if (!changes.equals(other.changes))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HistoryEntity [id=" + id + ", dateTime=" + dateTime + ", type=" + type + ", changes=" + changes + "]";
	}
	
}