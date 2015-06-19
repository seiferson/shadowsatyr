package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.seifernet.shadowsatyr.bean.UserProfileBean;
import com.seifernet.shadowsatyr.engine.account.AccountManager;
import com.seifernet.shadowsatyr.engine.microblog.BlogManager;
import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.shadowsatyr.security.SessionManager;
import com.seifernet.snwf.util.FormValidator;

public class AccountHelper {

	public static void userProfile( HttpServletRequest request, HttpServletResponse response ) {
		UserProfileBean bean 	= null;
		String			user 	= null;
		Session			session = null;
		Subject			subject	= null;
		Account			profile	= null;
		
		
		bean = new UserProfileBean( );
		subject = SecurityUtils.getSubject( );
		
		user = request.getParameter( "account" );
		if( !FormValidator.validateParameter( user ) || AccountManager.getAccountByNickname( user ) == null ){
			ErrorHelper.error404( request, response );
		} else {
			profile = AccountManager.getAccountByNickname( user );
			if( subject.isAuthenticated( ) ){
				session = SessionManager.getSession( subject );
				
				bean.setUserData( ( Account )session.getAttribute( "user_data" ) );
				bean.setProfile( profile );
				bean.setLayout( "system.user_profile_auth" );
			} else {
				bean.setProfile( profile );
				bean.setLayout( "system.user_profile" );
			}
			bean.setBlogEntries( BlogManager.getBlogEntries( bean.getProfile( ) ) );
			request.setAttribute( "Bean" , bean );
		}
	}

}
