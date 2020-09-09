package com.shopizer.db.description;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Description implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Column(name = "LANGUAGE_CODE")
	private String language;
	
	@NotEmpty
	@Column(name="NAME", nullable = false, length=120)
	private String name;
	
	@Column(name="TITLE", length=100)
	private String title;
	
	@Column(name="DESCRIPTION")
	@Type(type = "org.hibernate.type.TextType")
	private String description;
	
	public Description() {
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}

}
