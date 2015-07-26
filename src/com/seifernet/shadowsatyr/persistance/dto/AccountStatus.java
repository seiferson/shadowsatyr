package com.seifernet.shadowsatyr.persistance.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="account_status" )
public class AccountStatus implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@Column( nullable = false, length = 254, unique = true )
	private String status;
	
	@Column( nullable = false, length = 254 )
	private String description;

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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
