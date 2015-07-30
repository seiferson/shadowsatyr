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
@Table( name="system_property" )
public class SystemProperty implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@SequenceGenerator( name="pk_sequence", sequenceName="system_property_id", allocationSize=1 )
	@GeneratedValue( strategy=GenerationType.AUTO, generator="pk_sequence" )
	private Long id;
	
	@Column( nullable = false, length = 500 )
	private String key;
	
	@Column( nullable = false, length = 500 )
	private String value;

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
	 * @return the key
	 */
	public String getKey( ) {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey( String key ) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue( ) {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue( String value ) {
		this.value = value;
	}
}