/**
 * 
 */
package com.faizvisram.WordPressBlog.WordPress;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Faiz Visram
 *
 */
public class Tag {

	public static final String KEY_ID = "id";
	public static final String KEY_SLUG = "slug";
	public static final String KEY_TITLE = "title";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_POST_COUNT = "post_count";
	
	private String id = null;
	private String slug = null;
	private String title = null;
	private String description = null;
	private String post_count = null;
		
	/**
	 * 
	 */
	public Tag() {
		// TODO Auto-generated constructor stub
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the post_count
	 */
	public String getPost_count() {
		return post_count;
	}

	/**
	 * @param post_count the post_count to set
	 */
	public void setPost_count(String post_count) {
		this.post_count = post_count;
	}
	
	public static Tag parse(String json) {
		return parse(JsonParser.parseObject(json));
	}

	public static Tag parse(Map<String, String> rawTag) {
		Tag tag = new Tag();
		
		// TODO complete implementation
		
		return tag;
	}
	
	public static List<Tag> parseArray(String json) {
		List<Tag> tags = new ArrayList<Tag>();
		List<Map<String, String>> rawTags = new ArrayList<Map<String, String>>();
		
		rawTags = JsonParser.parseArray(json);
		
		for (Map<String, String> rawCategory : rawTags) {
			tags.add(parse(rawCategory));
		}
		
		return tags;
	}
}
