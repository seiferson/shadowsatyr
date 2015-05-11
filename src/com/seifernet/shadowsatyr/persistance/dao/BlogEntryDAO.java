package com.seifernet.shadowsatyr.persistance.dao;

import com.seifernet.shadowsatyr.persistance.dto.BlogEntry;

public class BlogEntryDAO extends GenericDAO<BlogEntry, Long>{

	public BlogEntryDAO(  ) {
		super( BlogEntry.class );
	}

}
