package com.seifernet.shadowsatyr.persistance.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
		return getSessionFactoryInstance( ).getCurrentSession( );
	}
	
	@SuppressWarnings("unchecked")
	public PK create( T object ) {
		return ( PK )getSession( ).save( object );
	}
	
	public void update( T object ) {
		getSession( ).update( object );
	}
	
	public void delete( T object ) {
		getSession( ).delete( object );
	}
	
	@SuppressWarnings("unchecked")
	public T read( PK id ) {
		return ( T )getSession( ).get( type, id );
	}
	
	@SuppressWarnings("unchecked")
	public T read( String column, Object data ){
		return ( T )getSession( ).createCriteria( type ).add( Restrictions.eq( column, data ) ).uniqueResult( );
	}
	
	@SuppressWarnings("unchecked")
	public List<T> readAll( ){
		return getSession( ).createCriteria( type ).list( );
	}
	
	@SuppressWarnings("unchecked")
	public List<T> readAll( String column, Object data ){
		return getSession( ).createCriteria( type ).add( Restrictions.eq( column, data ) ).list( );
	}
	
	@SuppressWarnings("unchecked")
	public List<T>readAllAsc( String column ){
		return getSession( ).createCriteria( type ).addOrder( Order.asc( column ) ).list( );
	}
	
	@SuppressWarnings("unchecked")
	public List<T>readAllDesc( String column ){
		return getSession( ).createCriteria( type ).addOrder( Order.desc( column ) ).list( );
	}
	
	public Number getCount( ){
		return ( Number )getSession( ).createCriteria( type ).setProjection( Projections.rowCount( ) ).uniqueResult( );
	}
	
	public Number getCount( String column, Object data ){
		return ( Number )getSession( ).createCriteria( type ).add( Restrictions.eq( column, data ) ).setProjection( Projections.rowCount( ) ).uniqueResult( );
	}

}
