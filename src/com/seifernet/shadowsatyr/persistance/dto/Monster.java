package com.seifernet.shadowsatyr.persistance.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name="monster" )
public class Monster implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@SequenceGenerator( name="pk_sequence", sequenceName="monster_id", allocationSize=1 )
	@GeneratedValue( strategy=GenerationType.AUTO, generator="pk_sequence" )
	private Long id;
	
	private String name;
	private String description;
	
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
	 * @return the name
	 */
	public String getName( ) {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName( String name ) {
		this.name = name;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription( ) {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription( String description ) {
		this.description = description;
	}
}
