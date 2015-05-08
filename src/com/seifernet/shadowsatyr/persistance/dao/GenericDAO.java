package com.seifernet.shadowsatyr.persistance.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.seifernet.snwf.hibernate.AbstractDAO;

/**
 * Base DAO to implement common hibernate transactions.
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <T> Object type
 * @param <PK> Object primary key
 */
public abstract class GenericDAO <T, PK extends Serializable> implements AbstractDAO<T, PK>{

	private Class<T> type;
	private static SessionFactory sessionFactoryInstance;
	
	/**
	 * Generic constructor sets type.
	 * 
	 * @param type The class type
	 */
	public GenericDAO( Class<T> type ) {
		this.type = type;
	}
	
	/**
	 * Session factory singleton, to avoid multiple factory
	 * instantiation.
	 * 
	 * @return The session factory object
	 */
	public static SessionFactory getSessionFactoryInstance( ){
		Configuration 					configuration 	= null;
		StandardServiceRegistryBuilder 	builder 		= null;
		
		if( sessionFactoryInstance == null ){
			configuration = new Configuration( );
			configuration.configure( );
			builder = new StandardServiceRegistryBuilder( );
			builder.applySettings( configuration.getProperties(  ) );
			sessionFactoryInstance = configuration.buildSessionFactory( builder.build( ) );
		}
		return sessionFactoryInstance;
	}

	/**
	 * Returns session obtained from session factory
	 * 
	 * @return Session instance
	 */
	protected Session getSession(  ){
		Session session = null;
		
		try{
			session = getSessionFactoryInstance( ).getCurrentSession( );
		} catch( HibernateException e ){
			session = getSessionFactoryInstance( ).openSession( );
		}
		return session;
	}
	
	/**
	 * Creates an object on the database
	 * INSERT
	 * 
	 * @param object The register to insert
	 * @return Primary key of the inserted object
	 */
	@SuppressWarnings("unchecked")
	public PK create( T object ) {
		Transaction transaction = null;
		Session 	session 	= null;
		PK 			key			= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		key = ( PK )getSession( ).save( object );
		transaction.commit( );
		return key;
	}
	
	/**
	 * Update information of a register on database
	 * UPDATE
	 * 
	 * @param object The register to update
	 */
	public void update( T object ) {
		Transaction transaction = null;
		Session 	session 	= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		session.update( object );
		transaction.commit( );
	}
	
	/**
	 * Delete specified object from database
	 * DELETE
	 * 
	 * @param object The register to delete
	 */
	public void delete( T object ) {
		Transaction transaction = null;
		Session 	session 	= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		session.delete( object );
		transaction.commit( );
	}
	
	/**
	 * Read an object by id from the database
	 * SELECT... WHERE id = ID
	 * 
	 * @param Id The id to search
	 * @return Register from database
	 */
	@SuppressWarnings("unchecked")
	public T read( PK id ) {
		Transaction transaction = null;
		Session 	session 	= null;
		T			object		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		object =  ( T )session.get( type, id );
		transaction.commit( );
		return object;
	}
	
	/**
	 * Read an object by a specific column
	 * SELECT... WHERE column = data
	 * 
	 * @param column The column to search
	 * @param data The value to search
	 * @return Register from database
	 */
	@SuppressWarnings("unchecked")
	public T read( String column, Object data ){
		Transaction transaction = null;
		Session 	session 	= null;
		T			object		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		object = ( T )session.createCriteria( type ).add( Restrictions.eq( column, data ) ).uniqueResult( );
		transaction.commit( );
		return object;
	}
	
	/**
	 * Read an object by specific columns
	 * 
	 * @param searchParameters Column, Value pairs
	 * @return Register from database
	 */
	@SuppressWarnings("unchecked")
	public T read( HashMap<String, Object> searchParameters ){
		Transaction transaction = null;
		Session 	session 	= null;
		Criteria	criteria	= null;
		T			object		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		criteria = session.createCriteria( type );
		
		if( searchParameters != null ){
			for( Entry<String, Object> element : searchParameters.entrySet( ) ){
				criteria = criteria.add( Restrictions.eq( element.getKey( ), element.getValue( ) ) );
			}
		}
		object = ( T )criteria.uniqueResult( );
		transaction.commit( );
		return object;
	}
	
	/**
	 * Read a list of objects
	 * SELECT... 
	 * 
	 * @return List of registers from database
	 */
	@SuppressWarnings("unchecked")
	public List<T> readAll( ){
		Transaction transaction = null;
		Session 	session 	= null;
		List<T>		list		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		list = session.createCriteria( type ).list( );
		transaction.commit( );
		return list;
	}
	
	/**
	 * Read a list of objects by a specific column
	 * SELECT... WHERE column = data
	 * 
	 * @param column The column to search
	 * @param data The value to search
	 * @return List of registers from database
	 */
	@SuppressWarnings("unchecked")
	public List<T> readAll( String column, Object data ){
		Transaction transaction = null;
		Session 	session 	= null;
		List<T>		list		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		list = session.createCriteria( type ).add( Restrictions.eq( column, data ) ).list( );
		transaction.commit( );
		return list;
	}
	
	/**
	 * Read a list of objects by specific columns
	 * 
	 * @param searchParameters Column, Value pairs
	 * @return List of registers from database
	 */
	@SuppressWarnings("unchecked")
	public List<T> readAll( HashMap<String, Object> searchParameters ){
		Transaction transaction = null;
		Session 	session 	= null;
		Criteria	criteria	= null;
		List<T>		list		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		criteria = session.createCriteria( type );
		
		if( searchParameters != null ){
			for( Entry<String, Object> element : searchParameters.entrySet( ) ){
				criteria = criteria.add( Restrictions.eq( element.getKey( ), element.getValue( ) ) );
			}
		}
		
		list = criteria.list( );
		transaction.commit( );
		return list;
	}
}
