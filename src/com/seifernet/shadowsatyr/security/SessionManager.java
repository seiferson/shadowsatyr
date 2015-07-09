package com.seifernet.shadowsatyr.security;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.seifernet.shadowsatyr.engine.account.AccountManager;
import com.seifernet.shadowsatyr.util.Definitions;

/**
 * Session manager handle account retrieval
 * based on shiro subject principals
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class SessionManager {

	/**
	 * Retrieves shiro session and validates if account
	 * is already loaded as a parameter
	 * 
	 * @param subject Shiro subject
	 * @return Shiro session
	 */
	public static Session getSession( Subject subject ) {
		Session	session = subject.getSession( );
		
		if( session.getAttribute( Definitions.ACCOUNT_SESSION_PARAM_NAME ) == null ){
			session.setAttribute( Definitions.ACCOUNT_SESSION_PARAM_NAME , AccountManager.getAccountByNickname( ( String )subject.getPrincipal( ) ) );
		}
		
		return session;
	}
}
