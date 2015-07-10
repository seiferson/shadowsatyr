package com.seifernet.shadowsatyr.persistance.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	@OneToOne
 	@JoinColumn( name="author", referencedColumnName="id" )
	@NotNull
	private Account author;
	
	@Column( nullable = false, length = 255, unique = true )
	private String title;
	
	@Column( name = "hash", nullable = false, length = 254, unique = true )
	private String hashKey;

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

	/**
	 * @return the hashKey
	 */
	public String getHashKey() {
		return hashKey;
	}

	/**
	 * @param hashKey the hashKey to set
	 */
	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

	/**
	 * @return the author
	 */
	public Account getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Account author) {
		this.author = author;
	}
}
