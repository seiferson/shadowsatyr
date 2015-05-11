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
@Table( name="blog_entry" )
public class BlogEntry implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id 
	@SequenceGenerator( name="pk_sequence", sequenceName="blog_entry_id", allocationSize=1 )
	@GeneratedValue( strategy=GenerationType.AUTO, generator="pk_sequence" )
	private Long id;
	
	@Column( nullable = false, length = 150 )
	private String message;
	
	@OneToOne
 	@JoinColumn( name="account", referencedColumnName="id" )
	@NotNull
	private Account author;
	
	@Column( nullable = false )
	private Date date;

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
	 * @return the message
	 */
	public String getMessage( ) {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage( String message ) {
		this.message = message;
	}

	/**
	 * @return the author
	 */
	public Account getAuthor( ) {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor( Account author ) {
		this.author = author;
	}

	/**
	 * @return the date
	 */
	public Date getDate( ) {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate( Date date ) {
		this.date = date;
	}
}
