package com.example.projectuser;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MyListFragment extends Fragment implements OnClickListener {

	private Communicator communicator;

	Button cihaz_btn, alarm_btn, kamera_btn, gorusme_btn;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (activity instanceof Communicator) {
			communicator = (Communicator) activity;
		} else {
			throw new ClassCastException(activity.toString()
					+ " must implemenet MyListFragment.OnItemSelectedListener");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.yardim_list_fragment, container,
				false);

		// Initialize Views
		cihaz_btn = (Button) view.findViewById(R.id.cihaz_btn_id);
		alarm_btn = (Button) view.findViewById(R.id.alarm_btn_id);
		kamera_btn = (Button) view.findViewById(R.id.kamera_btn_id);
		gorusme_btn = (Button) view.findViewById(R.id.gorusme_btn_id);

		// set on click Listeners for buttons
		cihaz_btn.setOnClickListener(this);
		alarm_btn.setOnClickListener(this);
		kamera_btn.setOnClickListener(this);
		gorusme_btn.setOnClickListener(this);

		return view;
	}

	public interface Communicator {
		public void Message(String OS_Name);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.cihaz_btn_id:
			updateFragment("Cihaz Hakkýnda");
			break;

		case R.id.alarm_btn_id:
			updateFragment("Alarm Kurulumu");
			break;

		case R.id.kamera_btn_id:
			updateFragment("Kamera");
			break;
		case R.id.gorusme_btn_id:
			updateFragment("Görüþme");
			break;
		}

	}

	private void updateFragment(String OS_Name) {
		communicator.Message(OS_Name);
	}

}