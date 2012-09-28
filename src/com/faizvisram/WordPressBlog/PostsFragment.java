/**
 * 
 */
package com.faizvisram.WordPressBlog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.faizvisram.WordPressBlog.WordPress.ConnectionHandler;
import com.faizvisram.WordPressBlog.WordPress.OnReturnListener;
import com.faizvisram.WordPressBlog.WordPress.Post;
import com.faizvisram.WordPressBlog.WordPress.WordPress;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Faiz
 *
 */
public class PostsFragment extends ListFragment {

	private List<String> titles = new ArrayList<String>();
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

				@SuppressWarnings("unchecked")
				@Override
				public void onReturn(ArrayList<Map<String, String>> result) {
					for (Map<String, String> rawPost : result) {
						if (rawPost.containsKey(WordPress.KEY_TITLE)) {
							Post post = new Post();
							post.setTitle(rawPost.get(WordPress.KEY_TITLE));
							mAdapter.add(post);
							
							
							activity.runOnUiThread(new Runnable() {
								@SuppressWarnings("unchecked")
								public void run() {
									mAdapter.notifyDataSetChanged();

								}
							
							});
							
							titles.add(rawPost.get(WordPress.KEY_TITLE));
						}
					}

//					getActivity().runOnUiThread(new Runnable() {
//						@SuppressWarnings("unchecked")
//						public void run() {
//							setListAdapter(new ArrayAdapter<String>(
//					                getActivity(),
//					                android.R.layout.simple_list_item_1,
//					                android.R.id.text1,
//					                titles));
//				    	
//						}
//					
//					});
				
				}
				
    		}
    		
    	);
    		

    	} else {
    		// TODO use api for getting posts by category
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
