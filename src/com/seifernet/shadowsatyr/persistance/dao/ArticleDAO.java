package com.seifernet.shadowsatyr.persistance.dao;

import com.seifernet.shadowsatyr.persistance.dto.Article;

public class ArticleDAO extends GenericDAO<Article, Long>{

	public ArticleDAO( ) {
		super( Article.class );
	}
	
}
