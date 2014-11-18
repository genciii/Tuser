package com.example.projectuser;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class OnKapiKamera extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_on_kapi_kamera);

	}
	
	public void finishOk(View view) {
		finish();
	}
	
	public void onKapi(View view) {
		Intent intent = new Intent(this, OnKapiKamera.class);
		startActivity(intent);
	}
	
	
	
	public void onKapiAna(View view) {
		Toast.makeText(this, "Bu ekran temsilidir", Toast.LENGTH_SHORT).show();
		
	}
	
	
	
	
}
