package com.example.projectuser;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GorusmeMesajYaz extends Fragment {

	public GorusmeMesajYaz() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_gorusme_mesaj, container,
				false);

		return rootView;
	}
	
	public void VazgecButton(View view) {
		getActivity().finish();
		}

}
