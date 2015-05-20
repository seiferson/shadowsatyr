package com.seifernet.shadowsatyr.persistance.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name="permission" )
public class Permission implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@SequenceGenerator( name="pk_sequence", sequenceName="permission_id", allocationSize=1 )
	@GeneratedValue( strategy=GenerationType.AUTO, generator="pk_sequence" )
	private Long id;
	
	@Column( nullable = false, length = 500 )
	private String permission;
	
	@Column( nullable = false, length = 500 )
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
	 * @return the permission
	 */
	public String getPermission( ) {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission( String permission ) {
		this.permission = permission;
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
