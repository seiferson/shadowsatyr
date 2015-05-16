package com.seifernet.shadowsatyr.facade;

import com.seifernet.shadowsatyr.persistance.dao.AccountDAO;
import com.seifernet.shadowsatyr.persistance.dto.Account;

public class AccountFacade {
	
	public Account getProfile( String nickname ){
		AccountDAO 	dao 	= null;
		Account		profile = null;
		
		dao = new AccountDAO( );
		profile = dao.read( "nickname" , nickname );
		return profile;
	}
	
}
