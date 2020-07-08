package com.iec.entity;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "activity")
@Getter
@Setter
public class Activity {
	
	@Id
    private String id;
	
	@NotEmpty
	@Size(max = 100)
	private String title;
	
	@NotEmpty
	@Size(max = 25)
	private String summary;
	
	@NotEmpty
	@Size(max = 200)
	private String description;
	
	@NotEmpty
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date startDateTime;
	
	@NotEmpty
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date endDateTime;

	private String info;

	public Activity() {}

	@Override
	public String toString() {
		return "ActivityEntity [id=" + id + ", title=" + title + ", summary=" + summary + ", description=" + description
				+ ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", info=" + info + "]";
	}
	
}