package com.vbeyond.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="BOOKS")
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(name = "id", sequenceName = "id",  initialValue = 101)
public class Book {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id")
	@ApiModelProperty(notes = "Id of the Book", name="id", required=true, value="1")
	private Long id;
	
	@Column(name="TITLE")
	@ApiModelProperty(notes = "Title of the Book", name="title", required=true, value="Book Name")
	private String title;
	
	@Column(name="AUTHOR")
	@ApiModelProperty(notes = "Name of the Author", name="author", required=true, value="Author's name")
	private String author;
	
	@Column(name="COVER")
	@ApiModelProperty(notes = "URL Cover Image", name="cover", required=true, value="http://www.image.com/image.jpg")
	private String cover;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}
}
