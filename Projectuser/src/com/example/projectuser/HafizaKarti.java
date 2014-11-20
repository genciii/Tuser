package com.example.projectuser;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HafizaKarti extends Fragment {
	Fragment fragment = null;

	public HafizaKarti() {
	}

	Button btnAlarmEkle;
	ListView listView;
	MedyaAdapter myadapter;
	ArrayList<String> medyalist = new ArrayList<String>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_hafizakarti,
				container, false);

		listView = (ListView) rootView.findViewById(R.id.medyalist);

		ArrayList<Bitmap> arr_bitmaps = new ArrayList<Bitmap>(4);
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyadosya));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyapictures));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.medyaimg));

		medyalist.add("Dosyalarým");
		medyalist.add("Pictures");
		medyalist.add("DSC035401");
		medyalist.add("Koridor Iþýðý");
		medyalist.add("Mezuniyet Foto-1");
		medyalist.add("Mezuniyet Foto-2");
		medyalist.add("Mezuniyet Foto-3");
		medyalist.add("Mezuniyet Foto-4");
		medyalist.add("Mezuniyet Foto-5");
		medyalist.add("Mezuniyet Foto-6");
		medyalist.add("Mezuniyet Foto-7");
		medyalist.add("Mezuniyet Foto-8");
		medyalist.add("Mezuniyet Foto-9");
		medyalist.add("Mezuniyet Foto-10");
		medyalist.add("Mezuniyet Foto-11");

		myadapter = new MedyaAdapter(getActivity(), arr_bitmaps, medyalist);

		listView.setAdapter(myadapter);
		return rootView;
	}

	public class MedyaAdapter extends BaseAdapter {

		public String title[];
		public String description[];
		ArrayList<String> medya_name = new ArrayList<String>();

		public Activity context;
		ArrayList<Bitmap> imageId;

		public LayoutInflater inflater;

		public MedyaAdapter(Activity context, ArrayList<Bitmap> arr_bitmaps,
				ArrayList<String> medya_name) {
			super();

			this.imageId = arr_bitmaps;
			this.context = context;
			this.medya_name = medya_name;

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
			return medya_name.size();
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
			RelativeLayout row;

		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub

			final ViewAlarmholder Alarmholder;
			if (convertView == null) {
				Alarmholder = new ViewAlarmholder();
				convertView = inflater.inflate(R.layout.list_item_medya, null);

				Alarmholder.image = (ImageView) convertView
						.findViewById(R.id.medyaimageView);
				Alarmholder.txtName = (TextView) convertView
						.findViewById(R.id.medyatext);
				Alarmholder.row = (RelativeLayout) convertView
						.findViewById(R.id.medyalineItem);
				convertView.setTag(Alarmholder);
			} else
				Alarmholder = (ViewAlarmholder) convertView.getTag();

			Alarmholder.image.setImageBitmap(getImageId().get(position));
			Alarmholder.txtName.setText(medya_name.get(position));

			Alarmholder.row.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent myIntent = new Intent(v.getContext(),
							MedyaIcerik.class);
					startActivity(myIntent);
				}
			});

			return convertView;

		}

	}

}
