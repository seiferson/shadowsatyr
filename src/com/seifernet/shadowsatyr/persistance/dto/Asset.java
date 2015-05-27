package com.seifernet.shadowsatyr.persistance.dto;

import java.io.Serializable;

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

}
