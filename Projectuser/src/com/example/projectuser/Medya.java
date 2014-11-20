package com.example.projectuser;

import java.util.ArrayList;
import java.util.List;
import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Medya extends Activity implements MenuAdapter.MenuListener {

	private static final String STATE_ACTIVE_POSITION = "net.simonvt.menudrawer.samples.LeftDrawerSample.activePosition";
	private static final String STATE_CONTENT_TEXT = "net.simonvt.menudrawer.samples.LeftDrawerSample.contentText";

	private MenuDrawer mMenuDrawer;

	private MenuAdapter mAdapter;
	private ListView mList;

	private int mActivePosition = -1;
	private String mContentText;

	@Override
	protected void onCreate(Bundle inState) {
		super.onCreate(inState);

		if (inState != null) {
			mActivePosition = inState.getInt(STATE_ACTIVE_POSITION);
			mContentText = inState.getString(STATE_CONTENT_TEXT);
		}

		mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.Type.STATIC,
				Position.START, MenuDrawer.MENU_DRAG_CONTENT);
		mMenuDrawer.setContentView(R.layout.activity_medya);
		mMenuDrawer.setAllowIndicatorAnimation(true);

		List<Object> items = new ArrayList<Object>();
		items.add(new Category("MEDYA"));
		items.add(new Item("Dahili Hafýza"));
		items.add(new Item("Hafýza Kartý"));
		items.add(new Item("Resimler"));
		items.add(new Item("Müzikler"));
		items.add(new Item("Videolar"));

		mList = new ListView(this);
		mAdapter = new MenuAdapter(this, items);
		mAdapter.setListener(this);
		mAdapter.setActivePosition(mActivePosition);
		mList.setAdapter(mAdapter);
		mList.setOnItemClickListener(mItemClickListener);

		mMenuDrawer.setMenuView(mList);

	}

	public void VazgecButton(View view) {
		finish();
	}

	private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	};

	private void selectItem(int position) {

		// update the main content by replacing fragments

		Fragment fragment = null;

		switch (position) {
		case 1:
			fragment = new GorusmeSikKullanilanlar();
			break;
		case 2:
			fragment = new HafizaKarti();

			break;
		case 3:
			fragment = new GorusmeSikKullanilanlar();
			break;

		case 4:
			fragment = new GorusmeSikKullanilanlar();
			break;

		case 5:
			fragment = new GorusmeSikKullanilanlar();
			break;
		
		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, fragment).commit();

			// update selected item and title, then close the drawer
			mList.setItemChecked(position, true);
			mList.setSelection(position);

		} else {
			// error in creating fragment
			Log.e("Ayarlar", "Error in creating fragment");
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_ACTIVE_POSITION, mActivePosition);
		outState.putString(STATE_CONTENT_TEXT, mContentText);
	}

	@Override
	public void onActiveViewChanged(View v) {
		mMenuDrawer.setActiveView(v, mActivePosition);
	}

	public class GorusmeSonArananlar extends Fragment {

		public GorusmeSonArananlar() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.activity_gorusme,
					container, false);

			return rootView;
		}

	}

	public class GorusmeCevapsizAramalar extends Fragment {

		public GorusmeCevapsizAramalar() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.activity_gorusme,
					container, false);

			return rootView;
		}

	}

	public class GorusmeSikKullanilanlar extends Fragment {

		public GorusmeSikKullanilanlar() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.activity_gorusme,
					container, false);

			return rootView;
		}

	}

	public class GorusmeAile extends Fragment {

		public GorusmeAile() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.activity_gorusme,
					container, false);

			return rootView;
		}

	}

	public class GorusmeIs extends Fragment {

		public GorusmeIs() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.activity_gorusme,
					container, false);

			return rootView;
		}

	}

	public class GorusmeKomsu extends Fragment {

		public GorusmeKomsu() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.activity_gorusme,
					container, false);

			return rootView;
		}

	}

}
