package com.reviewanime.model;

import java.util.ArrayList;
import java.util.List;

public class AnimeModel extends AbstractModel<AnimeModel>{
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content;
	private Float rating;
	private String releaseYear;
	private String episodes;
	private String status;
	private String country;

	private List<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
	private String[] categoryCodes;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public List<CategoryModel> getCategoryModels() {
		return categoryModels;
	}
	public void setCategoryModels(List<CategoryModel> categoryModels) {
		this.categoryModels = categoryModels;
	}
	
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getEpisodes() {
		return episodes;
	}
	public void setEpisodes(String episodes) {
		this.episodes = episodes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getCategoryCodes() {
		return categoryCodes;
	}
	public void setCategoryCodes(String[] categoryCodes) {
		this.categoryCodes = categoryCodes;
	}
	
}
