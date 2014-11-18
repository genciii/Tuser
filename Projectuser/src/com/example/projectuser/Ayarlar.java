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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

public class Ayarlar extends Activity implements MenuAdapter.MenuListener {

	private static final String STATE_ACTIVE_POSITION = "net.simonvt.menudrawer.samples.LeftDrawerSample.activePosition";
	private static final String STATE_CONTENT_TEXT = "net.simonvt.menudrawer.samples.LeftDrawerSample.contentText";

	private MenuDrawer mMenuDrawer;

	private MenuAdapter mAdapter;
	private ListView mList;

	private int mActivePosition = -1;
	private String mContentText;
	private TextView mContentTextView;

	@Override
	protected void onCreate(Bundle inState) {
		super.onCreate(inState);

		if (inState != null) {
			mActivePosition = inState.getInt(STATE_ACTIVE_POSITION);
			mContentText = inState.getString(STATE_CONTENT_TEXT);
		}

		mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.Type.STATIC,
				Position.START, MenuDrawer.MENU_DRAG_CONTENT);
		mMenuDrawer.setContentView(R.layout.activity_main2);
		mMenuDrawer.setAllowIndicatorAnimation(true);
		TimePicker tp = (TimePicker) this.findViewById(R.id.timePicker1);
		tp.setIs24HourView(true);

		List<Object> items = new ArrayList<Object>();
		items.add(new Category("AYARLAR"));
		items.add(new Item("Alarm Kur"));
		items.add(new Item("Görünüm"));
		items.add(new Item("Ses"));
		items.add(new Item("Tarih ve Saat"));

		mList = new ListView(this);
		mAdapter = new MenuAdapter(this, items);
		mAdapter.setListener(this);
		mAdapter.setActivePosition(mActivePosition);
		mList.setAdapter(mAdapter);
		mList.setOnItemClickListener(mItemClickListener);

		mMenuDrawer.setMenuView(mList);

		mContentTextView = (TextView) findViewById(R.id.contentText);
		mContentTextView.setText(mContentText);
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
			fragment = new Deneme();
			break;
		case 2:
			fragment = new Gorunum();

			break;
		case 3:
			fragment = new Ses();
			break;

		case 4:
			fragment = new Tarihvesaat();
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
	public void VazgecButton(View view) {
		finish();
		}
}
