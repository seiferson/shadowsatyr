package com.seifernet.shadowsatyr.persistance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name="account" )
public class Account {

	@Id 
	@SequenceGenerator( name="pk_sequence", sequenceName="account_id", allocationSize=1 )
	@GeneratedValue( strategy=GenerationType.AUTO, generator="pk_sequence" )
	private Long id;
	
	@Column( name="nick_name", nullable = false, length = 100 )
	private String nickname;
	
	@Column( nullable = false, length = 255 )
	private String passwd;
}
