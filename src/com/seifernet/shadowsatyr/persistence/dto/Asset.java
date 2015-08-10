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
@Table( name="asset" )
public class Asset implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@SequenceGenerator( name="pk_sequence", sequenceName="asset_id", allocationSize=1 )
	@GeneratedValue( strategy=GenerationType.AUTO, generator="pk_sequence" )
	private Long id;
	
	@Column( nullable = false, length = 255, unique = true )
	private String path;
	
	@Column( nullable = false, length = 255 )
	private String hash;
	
	@Column( nullable = false, length = 255 )
	private String name;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
