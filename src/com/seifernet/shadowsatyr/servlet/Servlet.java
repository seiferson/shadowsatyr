package com.seifernet.shadowsatyr.servlet;

import javax.servlet.annotation.WebServlet;

import com.seifernet.firegoblin.dispatcher.ContextDispatcher;
import com.seifernet.firegoblin.servlet.ContextServlet;
import com.seifernet.shadowsatyr.dispatcher.Dispatcher;

/**
 * Main servlet implementation, this server
 * implements front controller design pattern
 * and extends SNWF ContextServlet.
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @since 1.0.0
 * @version 1.0.0
 *
 */
@WebServlet( "/shadowsatyr/*" )
public class Servlet extends ContextServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected ContextDispatcher getDispatcher() {
		return new Dispatcher( );
	}

}
