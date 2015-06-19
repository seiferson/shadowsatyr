package com.seifernet.shadowsatyr.engine.account;

import com.seifernet.shadowsatyr.persistance.dao.AccountDAO;
import com.seifernet.shadowsatyr.persistance.dto.Account;

/**
 * Account manager works as a facade
 * between the backend database objects and
 * controller
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class AccountManager {

	/**
	 * Creates an account in the database
	 * 
	 * @param account
	 */
	public static void createAccount( Account account ){
		AccountDAO dao = null;
		
		dao = new AccountDAO( );
		dao.create( account );
	}
	
	/**
	 * Retrieves an account object from database
	 * based on the mail
	 * 
	 * @param mail
	 * @return The account object if found
	 */
	public static Account getAccountByMail( String mail ){
		AccountDAO 	dao 	= null;
		Account		account = null;
		
		dao = new AccountDAO( );
		account = dao.read( "mail" , mail );
		
		return account;
	}
	
	/**
	 * Retrieves an account object from database
	 * based on the nickname
	 * 
	 * @param nickname
	 * @return The account object if found
	 */
	public static Account getAccountByNickname( String nickname ){
		AccountDAO 	dao 	= null;
		Account		account = null;
		
		dao = new AccountDAO( );
		account = dao.read( "nickname" , nickname );
		
		return account;
	}
	
}
