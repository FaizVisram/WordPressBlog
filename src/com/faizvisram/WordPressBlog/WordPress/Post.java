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
public class Post {

	public static final String KEY_ID = "id";
	public static final String KEY_TYPE = "type";
	public static final String KEY_SLUG = "slug";
	public static final String KEY_URL = "url";
	public static final String KEY_STATUS = "status";
	public static final String KEY_TITLE = "title";
	public static final String KEY_TITLE_PLAIN = "title_plain";
	public static final String KEY_CONTENT = "content";
	public static final String KEY_EXCERPT = "excerpt";
	public static final String KEY_DATE = "date";
	public static final String KEY_MODIFIED = "modified";
	public static final String KEY_CATEGORIES = "categories";
	public static final String KEY_TAGS = "tags";
	public static final String KEY_AUTHOR = "author";
	public static final String KEY_COMMENTS = "comments";
	public static final String KEY_ATTACHMENTS = "attachments";
	public static final String KEY_COMMENT_COUNT = "comment_count";
	public static final String KEY_COMMENT_STATUS = "comment_status";
	
	public static final String COMMENT_STATUS_OPEN = "open"; // TODO confirm value
	public static final String COMMENT_STATUS_CLOSED = "closed";
		
    private String id = null;
	private String type = null;
	private String slug = null;
	private String url = null;
	private String status = null;
	private String title = null;
	private String titlePlain = null;
	private String content = null;
	private String excerpt = null;
	private String date = null;
	private String modified = null;
	private List<Category> categories = null;
	private List<Tag> tags = null;
	private Author author = null;
	private List<Comment> comments = null;
	private List<Attachment> attachments = null;
	private String commentCount = null;
	private String commentStatus = null;
	
	/**
	 * 
	 */
	public Post() {
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
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	/**
	 * @return the excerpt
	 */
	public String getExcerpt() {
		return excerpt;
	}

	/**
	 * @param excerpt the excerpt to set
	 */
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the modified
	 */
	public String getModified() {
		return modified;
	}

	/**
	 * @param modified the modified to set
	 */
	public void setModified(String modified) {
		this.modified = modified;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * @return the attachments
	 */
	public List<Attachment> getAttachments() {
		return attachments;
	}

	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	/**
	 * @return the commentCount
	 */
	public String getCommentCount() {
		return commentCount;
	}

	/**
	 * @param commentCount the commentCount to set
	 */
	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}

	/**
	 * @return the commentStatus
	 */
	public String getCommentStatus() {
		return commentStatus;
	}

	/**
	 * @param commentStatus the commentStatus to set
	 */
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}

	public static Post parse(String json) {
		return parse(JsonParser.parseObject(json));
	}
		
	public static Post parse(Map<String, String> rawPost) {
		Post post = new Post();

		post.setId(rawPost.get(KEY_ID));
		post.setType(rawPost.get(KEY_TYPE));
		post.setSlug(rawPost.get(KEY_SLUG));
		post.setUrl(rawPost.get(KEY_URL));
		post.setStatus(rawPost.get(KEY_STATUS));
		post.setTitle(rawPost.get(KEY_TITLE));
		post.setTitlePlain(rawPost.get(KEY_TITLE_PLAIN));
		post.setContent(rawPost.get(KEY_CONTENT));
		post.setExcerpt(rawPost.get(KEY_EXCERPT));
		post.setDate(rawPost.get(KEY_DATE));
		post.setModified(rawPost.get(KEY_MODIFIED));
		post.setCommentCount(rawPost.get(KEY_COMMENT_COUNT));
		post.setCommentStatus(rawPost.get(KEY_COMMENT_STATUS));
		post.setAuthor(Author.parse(rawPost.get(KEY_AUTHOR)));
		post.setCategories(Category.parseArray(rawPost.get(KEY_CATEGORIES)));
		post.setTags(Tag.parseArray(rawPost.get(KEY_TAGS)));
		
		// TODO comments, attachments
		return post;
	}
	
	public static List<Post> parseArray(String json) {
		List<Post> posts = new ArrayList<Post>();
		List<Map<String, String>> rawPosts = new ArrayList<Map<String, String>>();
		
		rawPosts = JsonParser.parseArray(json);
		
		for (Map<String, String> rawCategory : rawPosts) {
			posts.add(parse(rawCategory));
		}
		
		return posts;
	}

}
