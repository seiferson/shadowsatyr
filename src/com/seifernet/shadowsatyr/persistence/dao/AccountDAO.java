package com.seifernet.shadowsatyr.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.seifernet.shadowsatyr.persistence.dto.Account;

public class AccountDAO extends GenericDAO<Account, Long>{

	public AccountDAO( ) {
		super( Account.class );
	}
	
	/**
	 * Read a list of objects
	 * SELECT... ORDER BY column DESC LIMIT n
	 * 
	 * @return List of registers from database
	 */
	@SuppressWarnings("unchecked")
	public List<Account> readAllDscByNickname( int page ){
		Transaction 	transaction = null;
		Session 		session 	= null;
		List<Account>	list		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		list = session.createCriteria( Account.class ).addOrder( Order.desc( "nickname" ) ).setMaxResults( 15 ).setFirstResult( 15 * page ).list(  );
		transaction.commit( );
		return list;
	}
	
	/**
	 * Get the count of all registered accounts on the system
	 * SELECT count( id ) FROM account;
	 * 
	 * @return
	 */
	public Long getCount(  ){
		Transaction 	transaction = null;
		Session 		session 	= null;
		Long			count		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		count = ( Long ) session.createCriteria( Account.class ).setProjection( Projections.count( "id" ) ).uniqueResult( );
		transaction.commit( );
		return count;
	}

}
