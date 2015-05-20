package com.seifernet.shadowsatyr.persistance.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table( name="account" )
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@SequenceGenerator( name="pk_sequence", sequenceName="account_id", allocationSize=1 )
	@GeneratedValue( strategy=GenerationType.AUTO, generator="pk_sequence" )
	private Long id;
	
	@Column( name="nick_name", nullable = false, length = 25, unique = true )
	private String nickname;
	
	@Column( nullable = false, length = 64 )
	private String passwd;
	
	@Column( nullable = false, length = 254 )
	private String mail;
	
	@OneToMany
	@LazyCollection( LazyCollectionOption.FALSE )
	@JoinTable( name = "permission_account", 
		joinColumns = { @JoinColumn( name="account", referencedColumnName="id" ) },  
	    inverseJoinColumns = { @JoinColumn( name="permission", referencedColumnName="id") } ) 
	private List<Permission> permissions;

	
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
	 * @return the nickname
	 */
	public String getNickname( ) {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname( String nickname ) {
		this.nickname = nickname;
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd( ) {
		return passwd;
	}

	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd( String passwd ) {
		this.passwd = passwd;
	}

	/**
	 * @return the mail
	 */
	public String getMail( ) {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail( String mail ) {
		this.mail = mail;
	}
	
	public String getMailMD5( ){
		return new Md5Hash( mail ).toString( );
	}

	/**
	 * @return the permissions
	 */
	public List<Permission> getPermissions( ) {
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions( List<Permission> permissions ) {
		this.permissions = permissions;
	}
}
