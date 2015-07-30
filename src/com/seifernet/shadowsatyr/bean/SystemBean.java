package com.seifernet.shadowsatyr.bean;

import com.seifernet.shadowsatyr.persistence.dto.Account;
import com.seifernet.snwf.bean.Bean;

/**
 * Default bean with common attributes used across
 * the application
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class SystemBean extends Bean{

	private static final long serialVersionUID = 1L;
	
	private Account account;

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
}
