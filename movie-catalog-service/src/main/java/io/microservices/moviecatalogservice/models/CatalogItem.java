package io.microservices.moviecatalogservice.models;

public class CatalogItem {

	private String name;// created getter and setter 
	private String desc;
	private int rating;
	
	
	public CatalogItem(String name, String desc, int rating) {   //constructor
		
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
