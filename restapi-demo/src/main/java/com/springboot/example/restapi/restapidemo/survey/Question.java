package com.springboot.example.restapi.restapidemo.survey;

import java.util.List;

public class Question {
	
	public Question()
	{
		
	}
	public Question(String id, String description, List<String> options, String correctAnswer) {
		super();
		this.id = id;
		this.description = description;
		Options = options;
		this.correctAnswer = correctAnswer;
	}
	
	private String id;
	private String description;
	private List<String> Options;
	private String correctAnswer;
	
	public String getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public List<String> getOptions() {
		return Options;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", Options=" + Options + ", correctAnswer="
				+ correctAnswer + "]";
	}
	
	
	

}
