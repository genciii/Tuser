package com.example.projectuser;

import java.util.ArrayList;
import java.util.List;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Ayarlar extends Activity implements MenuAdapter.MenuListener {

	private static final String STATE_ACTIVE_POSITION = "net.simonvt.menudrawer.samples.LeftDrawerSample.activePosition";
	private static final String STATE_CONTENT_TEXT = "net.simonvt.menudrawer.samples.LeftDrawerSample.contentText";

	private MenuDrawer mMenuDrawer;

	private MenuAdapter mAdapter;
	private ListView mList;

	private int mActivePosition = -1;
	private String mContentText;
	private TextView mContentTextView;

	ListView listView;
	AlarmAdapter myadapter;
	ArrayList<String> alarmlist = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle inState) {
		super.onCreate(inState);

		if (inState != null) {
			mActivePosition = inState.getInt(STATE_ACTIVE_POSITION);
			mContentText = inState.getString(STATE_CONTENT_TEXT);
		}

		mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.Type.STATIC,
				Position.START, MenuDrawer.MENU_DRAG_CONTENT);
		mMenuDrawer.setContentView(R.layout.activity_alarm);
		mMenuDrawer.setAllowIndicatorAnimation(true);

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

		listView = (ListView) findViewById(R.id.alarmlist);

		ArrayList<Bitmap> arr_bitmaps = new ArrayList<Bitmap>(4);
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.alarmlogo));

		alarmlist.add("Otomatik Kapý Açma Alarmý");
		alarmlist.add("Kombi");
		alarmlist.add("Klima");
		alarmlist.add("Koridor Iþýðý");
		alarmlist.add("Televizyon");
		alarmlist.add("Oðuzhan OKUR");
		alarmlist.add("Deneme");
		alarmlist.add("Deneme");
		alarmlist.add("Deneme");
		alarmlist.add("Deneme");
		alarmlist.add("Deneme");
		alarmlist.add("Deneme");
		alarmlist.add("Deneme");
		alarmlist.add("Deneme");
		alarmlist.add("Deneme");

		myadapter = new AlarmAdapter(Ayarlar.this, arr_bitmaps, alarmlist);

		listView.setAdapter(myadapter);

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
			fragment = new Alarm();
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
					.replace(R.id.content_alarm, fragment).commit();

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

	public class AlarmAdapter extends BaseAdapter {

		public String title[];
		public String description[];
		ArrayList<String> alrm_name = new ArrayList<String>();
		public Activity context;
		ArrayList<Bitmap> imageId;

		public LayoutInflater inflater;

		public AlarmAdapter(Activity context, ArrayList<Bitmap> arr_bitmaps,
				ArrayList<String> alrm_name) {
			super();

			this.imageId = arr_bitmaps;
			this.context = context;
			this.alrm_name = alrm_name;

			this.inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public ArrayList<Bitmap> getImageId() {
			return imageId;
		}

		public void setImageId(ArrayList<Bitmap> imageId) {
			this.imageId = imageId;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return alrm_name.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		public class ViewAlarmholder {
			ImageView image;
			TextView txtName;
			Button btn2;
			Button btn3;
			RelativeLayout row;

		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub

			final ViewAlarmholder Alarmholder;
			if (convertView == null) {
				Alarmholder = new ViewAlarmholder();
				convertView = inflater.inflate(R.layout.list_item_alarm, null);

				Alarmholder.image = (ImageView) convertView
						.findViewById(R.id.alarmimageView);
				Alarmholder.txtName = (TextView) convertView
						.findViewById(R.id.alarmtextView);

				Alarmholder.btn3 = (Button) convertView
						.findViewById(R.id.alarmbutton3);
				Alarmholder.btn2 = (Button) convertView
						.findViewById(R.id.alarmbutton2);
				Alarmholder.row = (RelativeLayout) convertView
						.findViewById(R.id.alarmlineItem);
				convertView.setTag(Alarmholder);
			} else
				Alarmholder = (ViewAlarmholder) convertView.getTag();

			Alarmholder.image.setImageBitmap(getImageId().get(position));
			Alarmholder.txtName.setText(alrm_name.get(position));

			Alarmholder.btn2.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {

					/*
					 * 
					 * Alarm Aktif,Pasif
					 */

				}
			});

			Alarmholder.btn3.setOnClickListener(new View.OnClickListener() {
				Fragment fragment = null;

				@Override
				public void onClick(View v) {
					fragment = new Deneme();

					if (fragment != null) {
						FragmentManager fragmentManager = getFragmentManager();
						fragmentManager.beginTransaction()
								.replace(R.id.content_alarm, fragment).commit();

					} else {
						// error in creating fragment
						Log.e("Ayarlar", "Error in creating fragment");
					}

				}
			});

			Alarmholder.row.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {

					/*
					 * 
					 * Satira tiklandiginda
					 */

				}
			});

			return convertView;

		}

	}

}
