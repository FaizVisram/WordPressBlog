/**
 * 
 */
package com.faizvisram.WordPressBlog;

import java.util.ArrayList;
import java.util.Map;

import com.faizvisram.WordPressBlog.WordPress.OnReturnListener;
import com.faizvisram.WordPressBlog.WordPress.Post;
import com.faizvisram.WordPressBlog.WordPress.WordPress;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;

/**
 * @author Faiz
 *
 */
public class PostsFragment extends ListFragment {

	private PostAdapter mAdapter = null;

    /**
	 * 
	 */
	public PostsFragment(final Activity activity, String categoryId) {
		mAdapter = new PostAdapter(activity);
		setListAdapter(mAdapter);
		
		// If the category selected was "All Posts" get recent posts
    	if (categoryId.equals(WordPress.CATEGORY_ID_ALL)) {
    		WordPress.getRecentPosts(activity, new OnReturnListener() {

				@Override
				public void onReturn(ArrayList<Map<String, String>> result) {
					for (Map<String, String> rawPost : result) {
						Post post = Post.parse(rawPost);
						mAdapter.add(post);
						
						activity.runOnUiThread(new Runnable() {
							public void run() {
								mAdapter.notifyDataSetChanged();
							}
						});
						
					}
				
				}
				
    		});

    	} else {
    		WordPress.getCategoryPosts(activity, categoryId, new OnReturnListener() {

				@Override
				public void onReturn(ArrayList<Map<String, String>> result) {
					for (Map<String, String> rawPost : result) {
						Post post = Post.parse(rawPost);
						mAdapter.add(post);
						
						activity.runOnUiThread(new Runnable() {
							public void run() {
								mAdapter.notifyDataSetChanged();

							}
						
						});
						
					}
				
				}
				
    		});

    	}
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    
    }

	@Override
    public void onAttach(Activity activity) {
    	super.onAttach(activity);
    	
    }

}
