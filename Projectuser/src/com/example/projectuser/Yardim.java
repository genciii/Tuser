package com.example.projectuser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class Yardim extends Activity implements
		MyListFragment.Communicator {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yardim_activity_main);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

	}

	//
	@Override
	public void Message(String OS_Name) {
		DetailFragment detailfragment = (DetailFragment) getFragmentManager()
				.findFragmentById(R.id.detail_Fragment);
		if (detailfragment != null && detailfragment.isInLayout()) {
			detailfragment.setText(OS_Name);
		} else {
			Intent intent = new Intent(getApplicationContext(),
					DetailActivity.class);
			Bundle extras = new Bundle();
			extras.putString(DetailActivity.yardim, OS_Name);

			intent.putExtras(extras);
			startActivity(intent);

		}

	}

}
