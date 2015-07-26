package com.seifernet.shadowsatyr.persistance.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table( name="blog_entry" )
public class BlogEntry implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@SequenceGenerator( name="pk_sequence", sequenceName="blog_entry_id", allocationSize=1 )
	@GeneratedValue( strategy=GenerationType.AUTO, generator="pk_sequence" )
	private Long id;
	
	@Column( nullable = false, length = 150 )
	private String content;
	
	@OneToOne
 	@JoinColumn( name="author", referencedColumnName="id" )
	@NotNull
	private Account author;
	
	@Column( nullable = false )
	private Date date;
	
	@ManyToMany( cascade = CascadeType.ALL )
	@LazyCollection( LazyCollectionOption.FALSE )
	@JoinTable( name = "hashtag_blog_entry", 
		joinColumns = { @JoinColumn( name="blog_entry", referencedColumnName="id" ) },  
	    inverseJoinColumns = { @JoinColumn( name="hashtag", referencedColumnName="id") } ) 
	private List<Hashtag> hashtags;

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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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

	/**
	 * @return the hashtags
	 */
	public List<Hashtag> getHashtags( ) {
		return hashtags;
	}

	/**
	 * @param hashtags the hashtags to set
	 */
	public void setHashtags( List<Hashtag> hashtags ) {
		this.hashtags = hashtags;
	}
}
