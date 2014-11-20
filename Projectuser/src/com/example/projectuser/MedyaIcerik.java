package com.example.projectuser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MedyaIcerik extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medya_icerik);
	}

	public void finishOk(View view) {
		finish();
	}
}
