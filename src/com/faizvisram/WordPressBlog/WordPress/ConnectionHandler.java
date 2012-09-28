/**
 * 
 */
package com.faizvisram.WordPressBlog.WordPress;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.util.Log;

import com.faizvisram.WordPressBlog.R;

/**
 * @author Faiz
 *
 */
public class ConnectionHandler {

	/**
	 * 
	 */
	public ConnectionHandler() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Execute API via HTTP Post and send response to OnResultListener.
	 * 
	 * @param context			Contextual Activity.
	 * @param api				API to execute from ServerHandler constants.
	 * @param params			Parameters to include in HTTP Post.
	 * @param onSyncListener	OnSyncListener to receive response.
	 */
	public static void execute(final Context context, final String api, final List<NameValuePair> params, final OnReturnListener onReturnListener) {
		new Thread() {
			public void run() {
				final String apiUrl = context.getString(R.string.site_url) + context.getString(R.string.api_dir) + api;
				
				InputStream is = null;
				String json = "";
				ArrayList<Map<String, String>> result;
				
				// HTTP post
				try {
					HttpClient httpClient = new DefaultHttpClient();
				    HttpPost httpPost = new HttpPost(apiUrl);
				    
				    if (params != null) {
				    	httpPost.setEntity(new UrlEncodedFormEntity(params));
				    }
				    
				    HttpResponse response = httpClient.execute(httpPost);
				    HttpEntity entity = response.getEntity();
				    is = entity.getContent();
				} catch (ConnectTimeoutException e) {	// Couldn't establish a connection
					Log.w("HTTP Connection", e.toString());
					return;
				} catch (HttpHostConnectException e) {	// Couldn't connect to server
					Log.w("HTTP Connection", e.toString());
					return;
				} catch (UnknownHostException e) {	// Couldn't connect to server
					Log.w("HTTP Connection", e.toString());
					return;
				} catch(Exception e) {	// Any other error
					Log.e("HTTP Connection", e.toString());
					return;
				}
				
				// Convert response to String
				try {
			        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"), 8);
			        StringBuilder sb = new StringBuilder();
			        String line = null;
			        
			        while ((line = reader.readLine()) != null) {
			        	sb.append(line + "\n");
			        }
			        
			        is.close();
			 
			        json = sb.toString();
				
				} catch(Exception e) {
			        Log.w("JSON Parsing Error", "Error converting result " + e.toString());
				}
				
				Log.i("HTTP Response", json);
				
				// The String should currently be in JSON format
				// Return ArrayList<Map<String, String>> formatted output from JSON array
				result = new ArrayList<Map<String, String>>();
				result.add(JsonParser.parseObject(json));
				
				onReturnListener.onReturn(result);
				return;
			}
		}.start();
		
		return;
	}


}
