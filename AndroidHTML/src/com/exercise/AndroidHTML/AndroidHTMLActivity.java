package com.exercise.AndroidHTML;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;

public class AndroidHTMLActivity extends Activity {
	
	WebView myBrowser;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
        myBrowser = (WebView)findViewById(R.id.mybrowser);
        myBrowser.getSettings().setJavaScriptEnabled(true);
        
        myBrowser.loadUrl("file:///android_asset/website/index.html");
      
    }
}