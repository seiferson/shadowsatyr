package com.seifernet.shadowsatyr.persistence.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name="hashtag" )
public class Hashtag implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@SequenceGenerator( name="pk_sequence", sequenceName="hashtag_id", allocationSize=1 )
	@GeneratedValue( strategy=GenerationType.AUTO, generator="pk_sequence" )
	private Long id;
	
	@Column( nullable = false, length = 150, unique = true )
	private String hashtag;

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
	 * @return the hashtag
	 */
	public String getHashtag( ) {
		return hashtag;
	}

	/**
	 * @param hashtag the hashtag to set
	 */
	public void setHashtag( String hashtag ) {
		this.hashtag = hashtag;
	}

}