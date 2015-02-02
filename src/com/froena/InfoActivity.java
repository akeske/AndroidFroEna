package com.froena;

import com.froena.R;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends Activity {

	private Context con;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_info);

		ImageView fb = (ImageView) findViewById(R.id.imagefb);
		ImageView phone = (ImageView) findViewById(R.id.imagephone);
		TextView text1 = (TextView) findViewById(R.id.textView1);
		TextView text2 = (TextView) findViewById(R.id.textView2);

		con = this;

		fb.setOnClickListener(listenerfb);
		text1.setOnClickListener(listenerfb);
		phone.setOnClickListener(listenertel);
		text2.setOnClickListener(listenertel);
	}

	public static Intent getOpenFacebookIntent(Context context) {
		try {
			context.getPackageManager()
					.getPackageInfo("com.facebook.katana", 0);
			return new Intent(Intent.ACTION_VIEW,
					Uri.parse("fb://profile/100000042393035"));
		} catch (Exception e) {
			return new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://www.facebook.com/FROENA"));
		}
	}

	View.OnClickListener listenerfb = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent facebookIntent = InfoActivity.getOpenFacebookIntent(con);
			startActivity(facebookIntent);
		}
	};

	View.OnClickListener listenertel = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			try {
				String phn_no = "2102623577";
				Intent my_callIntent = new Intent(Intent.ACTION_CALL);
				my_callIntent.setData(Uri.parse("tel:" + phn_no));
				startActivity(my_callIntent);
			} catch (ActivityNotFoundException e) {
				Toast.makeText(getApplicationContext(),
						"Error in your phone call" + e.getMessage(),
						Toast.LENGTH_LONG).show();
			}
		}
	};

}
