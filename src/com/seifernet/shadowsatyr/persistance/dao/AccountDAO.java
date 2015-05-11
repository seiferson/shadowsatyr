package com.seifernet.shadowsatyr.persistance.dao;

import com.seifernet.shadowsatyr.persistance.dto.Account;

public class AccountDAO extends GenericDAO<Account, Long>{

	public AccountDAO( ) {
		super( Account.class );
	}

}
