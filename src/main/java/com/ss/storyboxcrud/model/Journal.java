package com.ss.storyboxcrud.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Journal {
	@Id
	String id;
	@NotNull
	String text;
	String tags;
	@NotNull
	String username;
	List<String> img;
	@NotNull
	LocalDateTime date;
	
	public String getDbId() {
		return id;
	}
}
