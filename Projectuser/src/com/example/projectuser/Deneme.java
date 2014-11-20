package com.example.projectuser;

/**
 * 
 * Ayarlar sayfasi icin dummy activity. Tekrar cagrilmalar durumunda kullanmak icin...
 * 
 * 
 */


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Deneme extends Fragment {

	public Deneme() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_main2, container,
				false);

		return rootView;
	}

}
