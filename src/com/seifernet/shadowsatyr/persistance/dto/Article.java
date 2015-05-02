package com.seifernet.shadowsatyr.persistance.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name="article" )
public class Article implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@SequenceGenerator( name="pk_sequence", sequenceName="article_id", allocationSize=1 )
	@GeneratedValue( strategy=GenerationType.AUTO, generator="pk_sequence" )
	private Long id;
	
	@Column( name="creation_date", nullable = false )
	private Date creationDate;
	
	@Column( columnDefinition = "TEXT", nullable = false )
	private String content;
	
	@Column( nullable = false, length = 100 )
	private String author;
	
	@Column( nullable = false, length = 255 )
	private String title;

	/**
	 * @return the id
	 */
	public Long getId( ) {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId( Long id ) {
		this.id = id;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate( ) {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate( Date creationDate ) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the content
	 */
	public String getContent( ) {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent( String content ) {
		this.content = content;
	}

	/**
	 * @return the author
	 */
	public String getAuthor( ) {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor( String author ) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle( ) {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle( String title ) {
		this.title = title;
	}
}
