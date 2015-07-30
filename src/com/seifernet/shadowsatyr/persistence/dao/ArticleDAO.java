package com.seifernet.shadowsatyr.persistence.dao;

import com.seifernet.shadowsatyr.persistence.dto.Article;

public class ArticleDAO extends GenericDAO<Article, Long>{

	public ArticleDAO( ) {
		super( Article.class );
	}
	
}
