package com.example.projectuser;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
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

public class GorusmeTelefonRehberim extends Fragment {

	public GorusmeTelefonRehberim() {
	}

	ListView listView;
	AramaAdapter myadapter;
	ArrayList<String> arrama = new ArrayList<String>();
	AlertDialog.Builder alertDialogBuilder;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_deneme3, container,
				false);

		listView = (ListView) rootView.findViewById(R.id.mainList);

		ArrayList<Bitmap> arr_bitmaps = new ArrayList<Bitmap>(4);
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));
		arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.telrehkisi));

		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");
		arrama.add("Oðuzhan OKUR");

		myadapter = new AramaAdapter(getActivity(), arr_bitmaps, arrama);

		listView.setAdapter(myadapter);

		return rootView;
	}


	public class AramaAdapter extends BaseAdapter {

		public String title[];
		public String description[];
		ArrayList<String> arr_calllog_name = new ArrayList<String>();
		public Activity context;
		ArrayList<Bitmap> imageId;

		public LayoutInflater inflater;

		public AramaAdapter(Activity context, ArrayList<Bitmap> arr_bitmaps,
				ArrayList<String> arr_calllog_name) {
			super();

			this.imageId = arr_bitmaps;
			this.context = context;
			this.arr_calllog_name = arr_calllog_name;

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
			return arr_calllog_name.size();
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

		public class ViewHolder {
			ImageView image;
			TextView txtName;
			Button btn;
			Button btn2;
			Button btn3;
			RelativeLayout row;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub

			final ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = inflater.inflate(R.layout.list_item_gelen, null);

				holder.image = (ImageView) convertView
						.findViewById(R.id.imageView);
				holder.txtName = (TextView) convertView
						.findViewById(R.id.textView);
				holder.btn = (Button) convertView.findViewById(R.id.button);
				holder.btn2 = (Button) convertView.findViewById(R.id.button2);
				holder.btn3 = (Button) convertView.findViewById(R.id.button3);
				holder.row = (RelativeLayout) convertView
						.findViewById(R.id.lineItem);
				convertView.setTag(holder);
			} else
				holder = (ViewHolder) convertView.getTag();

			holder.image.setImageBitmap(getImageId().get(position));
			holder.txtName.setText(arr_calllog_name.get(position));

			holder.btn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {

					Intent myIntent = new Intent(v.getContext(),
							GorusmeArama.class);
					startActivity(myIntent);

				}
			});

			holder.btn2.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					/*
					 * 
					 * Videolu Ara butonu
					 */

				}
			});

			holder.btn3.setOnClickListener(new View.OnClickListener() {
				Fragment fragment = null;

				@Override
				public void onClick(View v) {
					fragment = new GorusmeMesajYaz();

					if (fragment != null) {
						FragmentManager fragmentManager = getFragmentManager();
						fragmentManager.beginTransaction()
								.replace(R.id.content_mesajyaz, fragment).commit();

					} else {
						// error in creating fragment
						Log.e("Ayarlar", "Error in creating fragment");
					}

				}
			});

			holder.row.setOnClickListener(new View.OnClickListener() {

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
