package com.example.projectuser;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.yardim_detail_fragment, container, false);
		return view;
	}

	// we call this method when button from listfragment is clicked
	public void setText(String item) {
		TextView view = (TextView) getView().findViewById(R.id.display_yardim);
		view.setText(item);
	}
}
