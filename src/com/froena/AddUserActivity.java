package com.froena;

import com.froena.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddUserActivity extends Activity {
	final static String NAME = "NAME";
	final static String KAT = "KAT";
	final static String EPIL = "EPIL";
	final static String AOTH = "AOTH";
	private int[] prof = new int[14];
	private double[] grap = new double[7];
	int kat = 0;
	int chEpil = -1;
	private EditText etName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_user);

		etName = (EditText) findViewById(R.id.editTextName);
		final TextView textName = (TextView) findViewById(R.id.textViewName);
		final TextView textKat = (TextView) findViewById(R.id.textViewKat);
		final TextView textEpil = (TextView) findViewById(R.id.textViewEpil);
		final Button btnAddUser = (Button) findViewById(R.id.btnAddUser2);
		final Spinner spinKat = (Spinner) findViewById(R.id.spinnerKat);
		final Spinner spinEpil = (Spinner) findViewById(R.id.spinnerEpil);
		final CheckBox checkAoth = (CheckBox) findViewById(R.id.checkBoxAoth);

		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapterKat = ArrayAdapter
				.createFromResource(this, R.array.kat_array,
						R.layout.spinner_item);
		// Specify the layout to use when the list of choices appears
		adapterKat
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapterKat.setDropDownViewResource(R.layout.spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinKat.setAdapter(adapterKat);
		spinKat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				/*
				 * Toast.makeText( parent.getContext(),
				 * "OnItemSelectedListener : " +
				 * parent.getItemAtPosition(pos).toString(),
				 * Toast.LENGTH_SHORT).show();
				 */
				kat = pos;
			}

			@Override
			public void onNothingSelected(AdapterView<?> view) {

			}
		});

		ArrayAdapter<CharSequence> adapterEpil = ArrayAdapter
				.createFromResource(this, R.array.epilogis_array,
						R.layout.spinner_item);
		adapterEpil
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapterEpil.setDropDownViewResource(R.layout.spinner_dropdown_item);
		spinEpil.setAdapter(adapterEpil);
		spinEpil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				chEpil = pos;
				if (pos == 0) {
					checkAoth.setVisibility(View.VISIBLE);
				} else {
					checkAoth.setVisibility(View.INVISIBLE);
					checkAoth.setChecked(false);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> view) {

			}
		});

		btnAddUser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = etName.getText().toString();
				if (!name.equals("")) {
					Intent intent = new Intent(AddUserActivity.this,
							MoriaActivity.class);
					intent.putExtra(AddUserActivity.NAME, name);
					intent.putExtra(AddUserActivity.KAT, kat);
					intent.putExtra(AddUserActivity.EPIL, chEpil);
					intent.putExtra(AddUserActivity.AOTH, checkAoth.isChecked());
					intent.putExtra(MoriaActivity.PROF, prof);
					intent.putExtra(MoriaActivity.GRAP, grap);
					// eisodos apo prosthiki neou mathiti
					intent.putExtra(MoriaActivity.ACTIVITY, 0);
					startActivity(intent);
				} else {
					Toast.makeText(
							AddUserActivity.this,
							"?????? ?????????? ?????????????? ???????????? ??????????.",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

	}
}
