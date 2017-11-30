package com.claycorp.nexstore.api.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Articles {

	@Id
	private String id;
	
	private String slug;
	
	private String title;
	
	private String description;
	
	private String body;
	
	private Long favoritesCount;
	
	private List<String> taglist;
	
	public Articles() {
	}

	public Articles(String id, String slug, String title, String description, String body, Long favoritesCount,
			List<String> taglist) {
		super();
		this.id = id;
		this.slug = slug;
		this.title = title;
		this.description = description;
		this.body = body;
		this.favoritesCount = favoritesCount;
		this.taglist = taglist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getFavoritesCount() {
		return favoritesCount;
	}

	public void setFavoritesCount(Long favoritesCount) {
		this.favoritesCount = favoritesCount;
	}

	public List<String> getTaglist() {
		return taglist;
	}

	public void setTaglist(List<String> taglist) {
		this.taglist = taglist;
	}

	@Override
	public String toString() {
		return "Articles [id=" + id + ", slug=" + slug + ", title=" + title + ", description=" + description + ", body="
				+ body + ", favoritesCount=" + favoritesCount + ", taglist=" + taglist + "]";
	}
}
