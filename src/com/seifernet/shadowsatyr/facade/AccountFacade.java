package com.seifernet.shadowsatyr.facade;

import java.util.ArrayList;

import com.seifernet.shadowsatyr.persistance.dao.AccountDAO;
import com.seifernet.shadowsatyr.persistance.dao.BlogEntryDAO;
import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.shadowsatyr.persistance.dto.BlogEntry;

public class AccountFacade {
	
	public Account getProfile( String nickname ){
		AccountDAO 	dao 	= null;
		Account		profile = null;
		
		dao = new AccountDAO( );
		profile = dao.read( "nickname" , nickname );
		return profile;
	}
	
	public ArrayList<BlogEntry> getBlogEntries( Long userID ){
		BlogEntryDAO dao = null;
		ArrayList<BlogEntry> blogEntries = null;
		
		dao = new BlogEntryDAO( );
		blogEntries = new ArrayList<BlogEntry>( dao.readAll( userID ) );
		
		return blogEntries;
	}
	
}
