package com.seifernet.shadowsatyr.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.seifernet.shadowsatyr.persistence.dto.Account;
import com.seifernet.shadowsatyr.persistence.dto.BlogEntry;

public class BlogEntryDAO extends GenericDAO<BlogEntry, Long>{

	public BlogEntryDAO(  ) {
		super( BlogEntry.class );
	}
	
	@SuppressWarnings("unchecked")
	public List<BlogEntry> readAll( Account author ){
		Transaction 	transaction = null;
		Session 		session 	= null;
		List<BlogEntry>	list		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		list = session.createCriteria( BlogEntry.class ).add( Restrictions.eq( "author", author ) ).addOrder( Order.desc( "date" ) ).list( );
		transaction.commit( );
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<BlogEntry> readAll( String hashtag, Integer page ){
		Transaction 	transaction = null;
		Session 		session 	= null;
		List<BlogEntry>	list		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		list = session.createCriteria( BlogEntry.class )
				.createAlias( "hashtags" , "hashtag" )
				.add( Restrictions.eq( "hashtag.hashtag", hashtag ) )
				.addOrder( Order.desc( "date" ) )
				.setMaxResults( 30 )
				.setFirstResult( 30 * page )
				.list( );
		transaction.commit( );
		return list;
	}
}
