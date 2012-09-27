/**
 * 
 */
package com.faizvisram.WordPressBlog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Faiz
 *
 */
public class PostsFragment extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number";

    /**
	 * 
	 */
	public PostsFragment() {
		// TODO Auto-generated constructor stub
	}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.CENTER);
        Bundle args = getArguments();
        if (args != null && args.containsKey(ARG_SECTION_NUMBER)) {
        	textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
        }
        return textView;
    }
}
