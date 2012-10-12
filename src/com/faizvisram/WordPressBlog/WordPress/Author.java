/**
 * 
 */
package com.faizvisram.WordPressBlog.WordPress;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.util.Log;

/**
 * @author Faiz Visram
 *
 */
public class Author {

	public static final String KEY_ID = "id";
	public static final String KEY_SLUG = "slug";
	public static final String KEY_NAME = "name";
	public static final String KEY_FIRST_NAME = "first_name";
	public static final String KEY_LAST_NAME = "last_name";
	public static final String KEY_NICKNAME = "nickname";
	public static final String KEY_URL = "url";
	public static final String KEY_DESCRIPTION = "description";
		
	private String id = null;
	private String slug = null;
	private String name = null;
	private String firstName = null;
	private String lastName = null;
	private String nickname = null;
	private String url = null;
	private String description = null;
		
	/**
	 * 
	 */
	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(String id, String slug, String firstName, String lastName,
			String nickname, String url, String description) {
		this.id = id;
		this.slug = slug;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.url = url;
		this.description = description;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param nameame the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	 * Deprecated.
	 * @return
	 */
	private String getDisplayName() {
		final String EMPTY_STRING = "";
		String name = null;
		
		// Try Author's nickname
		if ((name = this.getNickname()) != null && !name.trim().equals(EMPTY_STRING)) {
			return name;
		} 
		
		// Try Author's first and/or last names; whatever exists
		String firstName = this.getFirstName();
		String lastName = this.getLastName();
		
		if (firstName == null)
			firstName = EMPTY_STRING;
		if (lastName == null)
			lastName = EMPTY_STRING;

		name = (firstName + " " + lastName).trim();
		
		if (!name.equals(EMPTY_STRING))
			return name;
		
		// Try Author's slug
		if ((name = this.getSlug()) != null && !name.trim().equals(EMPTY_STRING)) {
			return name;
		} 

		// Author has no String-type identity, return null
		return null;
			
	}
	
	public String toString() {
		String string = "";
		
		if (id != null)
			string += id + " ";
		if (slug != null)
			string += slug + " ";
		if (name != null)
			string += name + " ";
		if (firstName != null)
			string += firstName + " ";
		if (lastName != null)
			string += lastName + " ";
		if (nickname != null)
			string += nickname + " ";
		if (url != null)
			string += url + " ";
		if (description != null)
			string += description + " ";
				
		return string;
	}
	
	public static Author parse(String json) {
		return parse(JsonParser.parseObject(json));
	}

	public static Author parse(Map<String, String> rawAuthor) {
		Author author = new Author();
		
		author.setId(rawAuthor.get(KEY_ID));
		author.setSlug(rawAuthor.get(KEY_SLUG));
		author.setName(rawAuthor.get(KEY_NAME));
		author.setFirstName(rawAuthor.get(KEY_FIRST_NAME));
		author.setLastName(rawAuthor.get(KEY_LAST_NAME));
		author.setNickname(rawAuthor.get(KEY_NICKNAME));
		author.setUrl(rawAuthor.get(KEY_URL));
		author.setDescription(rawAuthor.get(KEY_DESCRIPTION));
				
		return author;
	}
	
	public static List<Author> parseArray(String json) {
		List<Author> authors = new ArrayList<Author>();
		List<Map<String, String>> rawAuthors = new ArrayList<Map<String, String>>();
		
		rawAuthors = JsonParser.parseArray(json);
		
		for (Map<String, String> rawCategory : rawAuthors) {
			authors.add(parse(rawCategory));
		}
		
		return authors;
	}
	
}
