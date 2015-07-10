package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jboss.logging.Logger;

import com.seifernet.shadowsatyr.bean.ProfileBean;
import com.seifernet.shadowsatyr.engine.account.AccountManager;
import com.seifernet.shadowsatyr.engine.microblog.BlogManager;
import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.shadowsatyr.security.SessionManager;
import com.seifernet.shadowsatyr.util.Definitions;
import com.seifernet.snwf.util.FormValidator;

/**
 * Helper for account operations
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class AccountHelper {

	private static Logger logger = Logger.getLogger( AccountHelper.class );
	
	/**
	 * Load specific account profile
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static void profile( HttpServletRequest request, HttpServletResponse response ) {
		String account = request.getParameter( "account" );
		
		if( !FormValidator.validateParameter( account ) || AccountManager.getAccountByNickname( account ) == null ){
			logger.error( Definitions.LOGGER_ERROR_ACCOUNT_PROFILE );
			ErrorHelper.error404( request, response );
		} else {
			Subject subject = SecurityUtils.getSubject( );
			ProfileBean bean = new ProfileBean( );
			
			if( subject.isAuthenticated( ) ){
				bean.setLayout( Definitions.PROFILE_AUTH_TILES_DEF );
				bean.setAccount( ( Account )SessionManager.getSession( subject ).getAttribute( Definitions.ACCOUNT_SESSION_PARAM_NAME ) );
			} else {
				bean.setLayout( Definitions.PROFILE_TILES_DEF );
			}
			
			bean.setProfile( AccountManager.getAccountByNickname( account ) );
			bean.setBlogEntries( BlogManager.getBlogEntries( bean.getProfile( ) ) );
			request.setAttribute( Definitions.BEAN_REQUEST_PARAM_NAME, bean );
		}
	}

}
