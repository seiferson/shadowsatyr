package com.seifernet.shadowsatyr.bean;

import java.util.ArrayList;

import com.seifernet.shadowsatyr.persistence.dto.BlogEntry;

/**
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 *
 */
public class BlogListBean extends SystemBean{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<BlogEntry> blogEntries;

	/**
	 * @return the blogEntries
	 */
	public ArrayList<BlogEntry> getBlogEntries() {
		return blogEntries;
	}

	/**
	 * @param blogEntries the blogEntries to set
	 */
	public void setBlogEntries(ArrayList<BlogEntry> blogEntries) {
		this.blogEntries = blogEntries;
	}

}
