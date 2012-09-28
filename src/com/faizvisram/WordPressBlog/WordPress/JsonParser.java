/**
 * 
 */
package com.faizvisram.WordPressBlog.WordPress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * @author Faiz Visram
 *
 */
public class JsonParser {

	/**
	 * Parse a JSON object into an ArrayList of Maps.
	 * 
	 * @param jsonString	String representation of JSON array to parse.
	 * @return		Return an ArrayList of Maps of parameters <String, String>
	 */
	public static Map<String, String> parseObject(String jsonString) {
		Map<String, String> result = new HashMap<String, String>();

		// parse JSON data
		try {
            JSONObject jsonItem = new JSONObject(jsonString);
            
            for (Iterator<?> keys = jsonItem.keys(); keys.hasNext();) {
            	String key = (String) keys.next();
            	result.put(key, jsonItem.getString(key));
            }

		} catch(JSONException e) {
	        Log.w("Parse JSON Object", e.toString());
	        Log.w("Parse JSON Object", jsonString);
		}
				
		return result;
	}

	/**
	 * Parse a JSON array into an ArrayList of Maps.
	 * 
	 * @param jsonString	String representation of JSON array to parse.
	 * @return		Return an ArrayList of Maps of parameters <String, String>
	 */
	public static ArrayList<Map<String, String>> parseArray(String jsonString) {
		ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();

		// parse JSON data
		try {
	        JSONArray jArray = new JSONArray(jsonString);
	        
	        for(int i = 0; i < jArray.length(); i++) {
                JSONObject jsonItem = jArray.getJSONObject(i);
                Map<String, String> mapItem = new HashMap<String, String>();
                
                for (Iterator<?> keys = jsonItem.keys(); keys.hasNext();) {
                	String key = (String) keys.next();
                	mapItem.put(key, jsonItem.getString(key));
                }
                
                result.add(mapItem);
	        }
	
		} catch(JSONException e) {
	        Log.w("Parse JSON Array", e.toString());
	        Log.w("Parse JSON Array", jsonString);
		}
				
		return result;
	}
	
}
