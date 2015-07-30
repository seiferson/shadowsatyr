package com.seifernet.shadowsatyr.persistence.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	
	@Column( nullable = false, length = 254, unique = true )
	private String mail;
	
	@Column( name = "register_date", nullable = false )
	private Date registerDate;

	@ManyToMany
	@LazyCollection( LazyCollectionOption.FALSE )
	@JoinTable( name = "permission_account", 
		joinColumns = { @JoinColumn( name="account", referencedColumnName="id" ) },  
	    inverseJoinColumns = { @JoinColumn( name="permission", referencedColumnName="id") } ) 
	private List<Permission> permissions;

	@OneToOne
	@JoinColumn( name="status", referencedColumnName="id" )
	@NotNull
	private AccountStatus status;
	
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
	
	/**
	 * @return the registerDate
	 */
	public Date getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the status
	 */
	public AccountStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
}
