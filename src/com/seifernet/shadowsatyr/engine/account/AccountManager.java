package com.seifernet.shadowsatyr.engine.account;

import java.util.ArrayList;

import com.seifernet.shadowsatyr.persistence.dao.AccountDAO;
import com.seifernet.shadowsatyr.persistence.dao.AccountStatusDAO;
import com.seifernet.shadowsatyr.persistence.dto.Account;
import com.seifernet.shadowsatyr.persistence.dto.AccountStatus;

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

	public static final Long ACTIVE_ACCOUNT_STATUS_ID = 1L;
	
	public static AccountStatus ACTIVE_ACCOUNT_STATUS;
	
	/**
	 * Reads constants from database and store them on
	 * the objects
	 */
	public static void init( ) {
		AccountStatusDAO dao = new AccountStatusDAO( );
		
		ACTIVE_ACCOUNT_STATUS = dao.read( ACTIVE_ACCOUNT_STATUS_ID );
	}
	
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
	
	public static ArrayList<Account> getAccounts( int page ){
		AccountDAO dao = new AccountDAO( );
		ArrayList<Account> accounts = new ArrayList<Account>( dao.readAllDscByNickname( page ) );
		
		return accounts;
	}
	
}
