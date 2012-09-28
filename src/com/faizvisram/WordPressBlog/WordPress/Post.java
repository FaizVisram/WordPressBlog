/**
 * 
 */
package com.faizvisram.WordPressBlog.WordPress;

import java.util.List;

/**
 * @author Faiz Visram
 *
 */
public class Post {

	private String id = null;
	private String type = null;
	private String slug = null;
	private String url = null;
	private String status = null;
	private String title = null;
	private String titlePlain = null;
	private String content = null;
	private List<Category> categories = null;
	private List<String> tags = null;
	
	/**
	 * 
	 */
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(String id, String type, String slug, String url, String status,
			String title, String titlePlain, String content,
			List<Category> categories, List<String> tags) {
		super();
		this.id = id;
		this.type = type;
		this.slug = slug;
		this.url = url;
		this.status = status;
		this.title = title;
		this.titlePlain = titlePlain;
		this.content = content;
		this.categories = categories;
		this.tags = tags;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the titlePlain
	 */
	public String getTitlePlain() {
		return titlePlain;
	}

	/**
	 * @param titlePlain the titlePlain to set
	 */
	public void setTitlePlain(String titlePlain) {
		this.titlePlain = titlePlain;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
