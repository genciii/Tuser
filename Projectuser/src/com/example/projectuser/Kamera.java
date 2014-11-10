package com.example.projectuser;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Kamera extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_kamera);

	}
	
	
	public void finishOk(View view) {
		finish();
	}
	
	public void onKapi(View view) {
		Intent intent = new Intent(this, OnKapiKamera.class);
		startActivity(intent);
	}


}
