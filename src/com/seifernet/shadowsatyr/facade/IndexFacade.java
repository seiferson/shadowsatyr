package com.seifernet.shadowsatyr.facade;

import java.util.ArrayList;

import com.seifernet.shadowsatyr.persistance.dao.AccountDAO;
import com.seifernet.shadowsatyr.persistance.dao.BlogEntryDAO;
import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.shadowsatyr.persistance.dto.BlogEntry;

public class IndexFacade {
	
	public ArrayList<BlogEntry> getLatestBlogEntries( ){
		ArrayList<BlogEntry> 	blogEntries = null;
		BlogEntryDAO			dao			= null;
		
		dao = new BlogEntryDAO( );
		blogEntries = new ArrayList<BlogEntry>( dao.readAllDsc( "date", 5 ) );
		
		return blogEntries;
	}
	
	public Account getAccountByNickname( String nickname ){
		AccountDAO 	dao 	= null;
		Account		account = null;
		
		dao = new AccountDAO( );
		account = dao.read( "nickname" , nickname );
		
		return account;
	}
	
	public Account getAccountByMail( String mail ){
		AccountDAO 	dao 	= null;
		Account		account = null;
		
		dao = new AccountDAO( );
		account = dao.read( "mail" , mail );
		
		return account;
	}
}
