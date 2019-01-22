package com.lee.jscbpm2.sns;

public class Query {
	
	private String search;
	private String query;
	
	public Query() {super();}

	public Query(String search, String query) {
		super();
		this.search = search;
		this.query = query;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
}
