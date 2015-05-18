package com.seifernet.shadowsatyr.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.seifernet.shadowsatyr.persistance.dto.BlogEntry;

public class BlogEntryDAO extends GenericDAO<BlogEntry, Long>{

	public BlogEntryDAO(  ) {
		super( BlogEntry.class );
	}
	
	@SuppressWarnings("unchecked")
	public List<BlogEntry> readAll( Long id ){
		Transaction 	transaction = null;
		Session 		session 	= null;
		List<BlogEntry>	list		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		list = session.createCriteria( BlogEntry.class ).add( Restrictions.eq( "id", id ) ).addOrder( Order.desc( "date" ) ).list( );
		transaction.commit( );
		return list;
	}
}
