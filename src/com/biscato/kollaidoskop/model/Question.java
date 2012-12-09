package com.biscato.kollaidoskop.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.appengine.api.datastore.Key;


@XmlRootElement
@PersistenceCapable
public class Question {
	
	@PrimaryKey //Annotation for jersey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	private String language;
	private String questionText;
	private String category;
	private boolean active;
	
	public Question(){
		super();
		this.active = true;
	}
	
	public Question(String description) {
		super();
		this.questionText = description;
		this.active = true;
	}	
	
	public Question(String language, String description, String category) {
		super();
		this.language = language;
		this.questionText = description;
		this.category = category;
		this.active = true;
	}
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return questionText;
	}

	public void setDescription(String description) {
		this.questionText = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@XmlElement // why an annotation only for Id? why not for other attribute?
	public long getId() {
		if (key != null)
			return this.key.getId();
		else 
			return -1;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
