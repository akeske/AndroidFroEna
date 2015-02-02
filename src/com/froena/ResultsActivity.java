package com.froena;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends Activity {

	private Database db;

	private String name;
	private int kat;
	private int epilogis;
	private Boolean aothBool;
	private Double bp;
	private int pedio1;
	private int pedio2;
	private int pedio3;
	private int pedio4;
	private int pedio5;
	private int activity;

	private int[] proforika;
	private double[] grapta;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_results);

		db = new Database(this);

		Bundle extras = getIntent().getExtras();
		name = extras.getString(AddUserActivity.NAME);
		kat = extras.getInt(AddUserActivity.KAT);
		epilogis = extras.getInt(AddUserActivity.EPIL);
		aothBool = extras.getBoolean(AddUserActivity.AOTH);
		bp = extras.getDouble(MoriaActivity.BP);
		pedio1 = extras.getInt(MoriaActivity.P1);
		pedio2 = extras.getInt(MoriaActivity.P2);
		pedio3 = extras.getInt(MoriaActivity.P3);
		pedio4 = extras.getInt(MoriaActivity.P4);
		pedio5 = extras.getInt(MoriaActivity.P5);
		proforika = extras.getIntArray(MoriaActivity.PROF);
		grapta = extras.getDoubleArray(MoriaActivity.GRAP);
		activity = extras.getInt(MoriaActivity.ACTIVITY);

		TextView nameView = (TextView) findViewById(R.id.textViewName);
		TextView katView = (TextView) findViewById(R.id.textViewKat);
		TextView epilView = (TextView) findViewById(R.id.textViewEpil);
		TextView aothView = (TextView) findViewById(R.id.textViewAoth);
		TextView bpView = (TextView) findViewById(R.id.textViewBP);
		TextView pedio1View = (TextView) findViewById(R.id.textViewPedio1);
		TextView pedio2View = (TextView) findViewById(R.id.textViewPedio2);
		TextView pedio3View = (TextView) findViewById(R.id.textViewPedio3);
		TextView pedio4View = (TextView) findViewById(R.id.textViewPedio4);
		TextView pedio5View = (TextView) findViewById(R.id.textViewPedio5);

		nameView.setText(name);
		katView.setText(intToStringKat(kat));
		epilView.setText(intToStringEpil(epilogis));
		if (aothBool == true) {
			aothView.setText(R.string.aoth);
		} else {
			aothView.setText("");
		}

		bpView.setText("Βαθμός πρόσβασης: " + Double.toString(bp));
		pedio1View.setText(Integer.toString(pedio1));
		pedio2View.setText(Integer.toString(pedio2));
		pedio3View.setText(Integer.toString(pedio3));
		pedio4View.setText(Integer.toString(pedio4));
		pedio5View.setText(Integer.toString(pedio5));

		Button sbtnSave = (Button) findViewById(R.id.btnSave);
		sbtnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (activity == 0) {
					Mathitis mathitis = new Mathitis(name, kat, epilogis,
							aothBool, proforika, grapta);
					db.insertMathiti(mathitis);

					Toast toast = Toast.makeText(getApplicationContext(),
							getResources().getString(R.string.toastSave),
							Toast.LENGTH_SHORT);
					toast.show();
				} else {
					Mathitis mathitis = new Mathitis(name, kat, epilogis,
							aothBool, proforika, grapta);
					db.deleteMathiti(mathitis.getName());
					db.insertMathiti(mathitis);

					Log.d("qwt", grapta[0] + "");
					Toast toast = Toast.makeText(getApplicationContext(),
							getResources().getString(R.string.toastChange),
							Toast.LENGTH_SHORT);
					toast.show();
				}
				db.close();
			}
		});

	}

	private String intToStringEpil(int epilogis) {
		if (epilogis == 0) {
			return getResources().getString(R.string.statistiki);
		} else if (epilogis == 1) {
			return getResources().getString(R.string.istoriagp);
		} else if (epilogis == 2) {
			return getResources().getString(R.string.biogn);
		} else {
			return getResources().getString(R.string.fysgp);
		}
	}

	private String intToStringKat(int kat) {
		if (kat == 0) {
			return getResources().getString(R.string.thetiki);
		} else if (kat == 1) {
			return getResources().getString(R.string.texnologiki);
		} else {
			return getResources().getString(R.string.thewritiki);
		}
	}

}
