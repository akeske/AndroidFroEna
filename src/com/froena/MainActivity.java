package com.froena;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Typeface font = Typeface.createFromAsset(getAssets(), "font.ttf");
		// btnUsers.setTypeface(font);

		Button btnUsers = (Button) findViewById(R.id.btnUsers);
		btnUsers.setOnClickListener(listener);
		Button btnInfo = (Button) findViewById(R.id.btnInfo);
		btnInfo.setOnClickListener(listener);
		Button btnAddUser = (Button) findViewById(R.id.btnAddUser1);

		btnAddUser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						AddUserActivity.class);
				startActivity(intent);
			}
		});

		final Context context = this;
		Button btnRate = (Button) findViewById(R.id.btnRate);
		btnRate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Uri uri = Uri.parse("market://details?id="
						+ context.getPackageName());
				Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
				try {
					startActivity(goToMarket);
				} catch (ActivityNotFoundException e) {
					startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse("https://play.google.com/store/apps/details?id="
									+ context.getPackageName())));
				}
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("market://details?id=com.froena"));
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent;
			switch (v.getId()) {
			case R.id.btnUsers:
				intent = new Intent(MainActivity.this,
						MathitesListActivity.class);
				startActivity(intent);
				break;
			case R.id.btnInfo:
				intent = new Intent(MainActivity.this, InfoActivity.class);
				startActivity(intent);
				break;
			}
		}
	};

}
