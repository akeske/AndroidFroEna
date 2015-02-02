package com.froena;

import com.froena.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplahScreen extends Activity {
	private static final int SPLASH_DISPLAY_TIME = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent mainIntent = new Intent(SplahScreen.this,
						MainActivity.class);
				startActivity(mainIntent);
				finish();
			}
		}, SplahScreen.SPLASH_DISPLAY_TIME);

	}
}
