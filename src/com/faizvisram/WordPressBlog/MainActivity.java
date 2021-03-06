package com.faizvisram.WordPressBlog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.faizvisram.WordPressBlog.WordPress.*;

public class MainActivity extends FragmentActivity implements ActionBar.OnNavigationListener {

    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
    private static final String CATEGORY_ID_TOP = "0";
    
    private Map<String, String> categories = null;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        categories = new HashMap<String, String>();
        
        categories.put(this.getString(R.string.title_all_posts), WordPress.CATEGORY_ID_ALL);

        refreshCategories(actionBar);
        getCategories();
    }

    private void getCategories() {
    	WordPress.getCategories(this, new OnReturnListener() {
    		@Override
    		public void onReturn(ArrayList<Map<String, String>> result) {
    			for (Map<String, String> category : result) {
    				String title = category.get(WordPress.KEY_TITLE);
    				String id = category.get(WordPress.KEY_ID);
    				
    				if (title != null && CATEGORY_ID_TOP.equals(category.get(WordPress.KEY_PARENT))) {
    					categories.put(title, id);
    				}
    			}
    			
    			runOnUiThread(new Runnable() {
					public void run() {
				    	refreshCategories(getActionBar());
					}
				});
    		}
    	});

    	return;
    }
    
    @SuppressWarnings("unchecked")
	private void refreshCategories(final ActionBar actionBar) {
    	// Set up the dropdown list navigation in the action bar.
        actionBar.setListNavigationCallbacks(
                // Specify a SpinnerAdapter to populate the dropdown list.
                new ArrayAdapter(
                        actionBar.getThemedContext(),
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        categories.keySet().toArray()),
                this);
    }
    
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,
                getActionBar().getSelectedNavigationIndex());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity, menu);
        return true;
    }

    public boolean onNavigationItemSelected(int position, long id) {
        // When the given tab is selected, show the tab contents in the container
    	String category = (String) categories.get(categories.keySet().toArray()[position]);
    	
    	PostsFragment fragment = new PostsFragment(this, category);
    	
    	Bundle args = new Bundle();
        fragment.setArguments(args);
        
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_container, fragment)
                .commit();
        return true;
    }

}
