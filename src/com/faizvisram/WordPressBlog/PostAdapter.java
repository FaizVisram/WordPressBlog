/**
 * 
 */
package com.faizvisram.WordPressBlog;

import java.util.ArrayList;
import java.util.List;

import com.faizvisram.WordPressBlog.WordPress.Author;
import com.faizvisram.WordPressBlog.WordPress.Post;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author Faiz Visram
 *
 */
public class PostAdapter extends BaseAdapter {

	private List<Post> mPosts = null;
	private Context mContext = null;
	
	/**
	 * 
	 */
	public PostAdapter(Context context) {
		mContext = context;
		mPosts = new ArrayList<Post>();
		
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	public int getCount() {
		return mPosts.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	public Post getItem(int index) {
		return mPosts.get(index);
	}

	public void add(Post post) {
		mPosts.add(post);
	}
	
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	public long getItemId(int index) {
		return index;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	public View getView(int index, View view, ViewGroup viewGroup) {
		Post post = getItem(index);
        Author author = post.getAuthor();
        
		// Inflate the view
	    LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = li.inflate(android.R.layout.simple_list_item_2, null);
        TextView text1 = (TextView) view.findViewById(android.R.id.text1);
        TextView text2 = (TextView) view.findViewById(android.R.id.text2);
        
        // Display the Post's title on the first line
        text1.setText(post.getTitle());
        
        // Display the Author's name on the second line
        if (author != null && author.getName() != null) {
        	text2.setText(author.getName());
        }
		
        return view;
	}

}
