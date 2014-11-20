package com.example.projectuser;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

public class AlarmDuzenle extends Fragment {

	public AlarmDuzenle() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_alarm_duzenle,
				container, false);
		TimePicker tp = (TimePicker) rootView.findViewById(R.id.timePicker1);
		tp.setIs24HourView(true);
		return rootView;
	}

}
