package com.example.projectuser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class GorusmeArama extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gorusme_arama);
	}

	public void finishOk(View view) {
		finish();
	}
}
