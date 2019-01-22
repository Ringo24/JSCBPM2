package com.lee.jscbpm2.search;

public class Search {
	private String title;
	private String link;
	private String image;
	private int price;
	
	public Search() {
		super();
	}

	public Search(String title, String link, String image, int price) {
		super();
		this.title = title;
		this.link = link;
		this.image = image;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
