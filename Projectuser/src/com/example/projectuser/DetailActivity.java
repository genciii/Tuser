package com.example.projectuser;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class DetailActivity extends Activity {

	public static String yardim = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		}
		setContentView(R.layout.yardim_detail_activity);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String name = extras.getString(yardim);
			DetailFragment detailFragment = (DetailFragment) getFragmentManager()
					.findFragmentById(R.id.detailFragment);
			detailFragment.setText(name);
		}

	}

}
