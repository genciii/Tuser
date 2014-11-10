package com.example.projectuser;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView takvim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.fragment_main);

		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		takvim = (TextView) findViewById(R.id.textView22);
		takvim.setText(date);
	}

	public void openKapi(View view) {
		Intent intent = new Intent(this, Kapi.class);
		startActivity(intent);
	}

	public void openKamera(View view) {
		Intent intent = new Intent(this, Kamera.class);
		startActivity(intent);
	}

	public void openGorusme(View view) {
		Intent intent = new Intent(this, Gorusme.class);
		startActivity(intent);
	}

	public void openAlarm(View view) {
		Intent intent = new Intent(this, Alarm.class);
		startActivity(intent);
	}

}
