package com.froena;

import java.util.ArrayList;

import com.froena.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MoriaActivity extends Activity {

	final static String P1 = "PEDIA1";
	final static String P2 = "PEDIA2";
	final static String P3 = "PEDIA3";
	final static String P4 = "PEDIA4";
	final static String P5 = "PEDIA5";
	final static String BP = "BP";

	final static String ACTIVITY = "ACTIVITY";

	final static String PROF = "PROF";
	final static String GRAP = "GRAP";

	private String name;
	private int kat;
	private int epilogis;
	private Boolean aothBool;
	private int totalMathimata;

	private int activity;

	private ArrayList<EditText> editTextArr = new ArrayList<EditText>();

	EditText math_arxaia1;
	EditText math_arxaia2;
	EditText math_arxaia3;
	EditText fys_istoria1;
	EditText fys_istoria2;
	EditText fys_istoria3;
	EditText xhm_log_ae1;
	EditText xhm_log_ae2;
	EditText xhm_log_ae3;
	EditText bio_lat_aode1;
	EditText bio_lat_aode2;
	EditText bio_lat_aode3;
	EditText ng1;
	EditText ng2;
	EditText ng3;
	EditText epil1;
	EditText epil2;
	EditText epil3;
	EditText aoth1;
	EditText aoth2;
	EditText aoth3;

	private int[] proforika;
	private double[] grapta;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle extras = getIntent().getExtras();
		name = extras.getString(AddUserActivity.NAME);
		kat = extras.getInt(AddUserActivity.KAT);
		epilogis = extras.getInt(AddUserActivity.EPIL);
		aothBool = extras.getBoolean(AddUserActivity.AOTH);

		proforika = extras.getIntArray(MoriaActivity.PROF);
		grapta = extras.getDoubleArray(MoriaActivity.GRAP);

		activity = extras.getInt(MoriaActivity.ACTIVITY);

		setContentView(R.layout.layout_vathmoi);

		Button btnAddUser = (Button) findViewById(R.id.btnResults);
		btnAddUser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				calcMoria();
			}
		});

		math_arxaia1 = (EditText) findViewById(R.id.editTextMath1);
		math_arxaia2 = (EditText) findViewById(R.id.editTextMath2);
		math_arxaia3 = (EditText) findViewById(R.id.editTextMath3);

		fys_istoria1 = (EditText) findViewById(R.id.editTextFys1);
		fys_istoria2 = (EditText) findViewById(R.id.editTextFys2);
		fys_istoria3 = (EditText) findViewById(R.id.editTextFys3);

		xhm_log_ae1 = (EditText) findViewById(R.id.editTextXhm1);
		xhm_log_ae2 = (EditText) findViewById(R.id.editTextXhm2);
		xhm_log_ae3 = (EditText) findViewById(R.id.editTextXhm3);

		bio_lat_aode1 = (EditText) findViewById(R.id.editTextBio1);
		bio_lat_aode2 = (EditText) findViewById(R.id.editTextBio2);
		bio_lat_aode3 = (EditText) findViewById(R.id.editTextBio3);

		ng1 = (EditText) findViewById(R.id.editTextNG1);
		ng2 = (EditText) findViewById(R.id.editTextNG2);
		ng3 = (EditText) findViewById(R.id.editTextNG3);

		epil1 = (EditText) findViewById(R.id.editTextMathEpil1);
		epil2 = (EditText) findViewById(R.id.editTextMathEpil2);
		epil3 = (EditText) findViewById(R.id.editTextMathEpil3);

		aoth1 = (EditText) findViewById(R.id.editTextAOTH1);
		aoth2 = (EditText) findViewById(R.id.editTextAOTH2);
		aoth3 = (EditText) findViewById(R.id.editTextAOTH3);

		// restore saved data
		if (activity == 1) {
			math_arxaia1.setText(Integer.toString(proforika[0]));
			math_arxaia2.setText(Integer.toString(proforika[1]));
			math_arxaia3.setText(Double.toString(grapta[0]));
			fys_istoria1.setText(Integer.toString(proforika[2]));
			fys_istoria2.setText(Integer.toString(proforika[3]));
			fys_istoria3.setText(Double.toString(grapta[1]));
			xhm_log_ae1.setText(Integer.toString(proforika[4]));
			xhm_log_ae2.setText(Integer.toString(proforika[5]));
			xhm_log_ae3.setText(Double.toString(grapta[2]));
			bio_lat_aode1.setText(Integer.toString(proforika[6]));
			bio_lat_aode2.setText(Integer.toString(proforika[7]));
			bio_lat_aode3.setText(Double.toString(grapta[3]));
			ng1.setText(Integer.toString(proforika[8]));
			ng2.setText(Integer.toString(proforika[9]));
			ng3.setText(Double.toString(grapta[4]));
			epil1.setText(Integer.toString(proforika[10]));
			epil2.setText(Integer.toString(proforika[11]));
			epil3.setText(Double.toString(grapta[5]));
			aoth1.setText(Integer.toString(proforika[12]));
			aoth2.setText(Integer.toString(proforika[13]));
			aoth3.setText(Double.toString(grapta[6]));
		}

		/*
		 * Toast.makeText(MoriaActivity.this, name + ", " + kat + ", " +
		 * epilogis + ", " + aothBool, Toast.LENGTH_SHORT).show();
		 */

		TextView epilView = (TextView) findViewById(R.id.textViewMathEpil);
		if (epilogis == 0) {
			epilView.setText(R.string.statistiki);
		} else if (epilogis == 1) {
			epilView.setText(R.string.istoriagp);
		} else if (epilogis == 2) {
			epilView.setText(R.string.biogn);
		} else {
			epilView.setText(R.string.fysgp);
		}

		LinearLayout aothView = (LinearLayout) findViewById(R.id.linearAoth);
		if (aothBool == false) {
			aothView.setVisibility(View.INVISIBLE);
			totalMathimata = 6;
		} else {
			TextView aothText = (TextView) findViewById(R.id.textViewAOTH);
			aothText.setText(R.string.aoth);
			aothView.setVisibility(View.VISIBLE);
			totalMathimata = 7;
		}

		TextView ngView = (TextView) findViewById(R.id.textViewNG);
		ngView.setText(getString(R.string.ng));

		editTextArr.add(math_arxaia1);
		editTextArr.add(math_arxaia2);
		editTextArr.add(math_arxaia3);
		editTextArr.add(fys_istoria1);
		editTextArr.add(fys_istoria2);
		editTextArr.add(fys_istoria3);
		editTextArr.add(xhm_log_ae1);
		editTextArr.add(xhm_log_ae2);
		editTextArr.add(xhm_log_ae3);
		editTextArr.add(bio_lat_aode1);
		editTextArr.add(bio_lat_aode2);
		editTextArr.add(bio_lat_aode3);
		editTextArr.add(ng1);
		editTextArr.add(ng2);
		editTextArr.add(ng3);
		editTextArr.add(epil1);
		editTextArr.add(epil2);
		editTextArr.add(epil3);
		if (aothBool == true) {
			editTextArr.add(aoth1);
			editTextArr.add(aoth2);
			editTextArr.add(aoth3);
		}
		for (EditText et : editTextArr) {
			et.setOnFocusChangeListener(etListener);
		}

		// thetiki
		if (kat == 0) {
			TextView mathArxaiaView = (TextView) findViewById(R.id.textViewMathArxaia);
			TextView fysIstoriaView = (TextView) findViewById(R.id.textViewFysIstoria);
			TextView xhmLogAeView = (TextView) findViewById(R.id.textViewXhmLogAe);
			TextView bioLatinikaAodeView = (TextView) findViewById(R.id.textViewBioLatinikaAode);
			mathArxaiaView.setText(getString(R.string.mathimatika));
			fysIstoriaView.setText(R.string.fysikh);
			xhmLogAeView.setText(R.string.xhmeia);
			bioLatinikaAodeView.setText(R.string.biologia);

			// texnologiki
		} else if (kat == 1) {
			TextView mathArxaiaView = (TextView) findViewById(R.id.textViewMathArxaia);
			TextView fysIstoriaView = (TextView) findViewById(R.id.textViewFysIstoria);
			TextView xhmLogAeView = (TextView) findViewById(R.id.textViewXhmLogAe);
			TextView bioLatinikaAodeView = (TextView) findViewById(R.id.textViewBioLatinikaAode);
			mathArxaiaView.setText(R.string.mathimatika);
			fysIstoriaView.setText(R.string.fysikh);
			xhmLogAeView.setText(R.string.ae);
			bioLatinikaAodeView.setText(R.string.aode);

			// theoritiki
		} else {
			TextView mathArxaiaView = (TextView) findViewById(R.id.textViewMathArxaia);
			TextView fysIstoriaView = (TextView) findViewById(R.id.textViewFysIstoria);
			TextView xhmLogAeView = (TextView) findViewById(R.id.textViewXhmLogAe);
			TextView bioLatinikaAodeView = (TextView) findViewById(R.id.textViewBioLatinikaAode);
			mathArxaiaView.setText(R.string.arxaiael);
			fysIstoriaView.setText(R.string.istoria);
			xhmLogAeView.setText(R.string.nl);
			bioLatinikaAodeView.setText(R.string.lat);

		}
	}

	private double vathmosProsvasisMathimatos(double graptaMathimatos,
			double moMathimatos) {
		double roundVatmosProsvasis = (moMathimatos * 0.3)
				+ (graptaMathimatos * 0.7);
		double round = Math.round(roundVatmosProsvasis * 100.0);
		round = round / 100.0;
		round = Math.round(round * 10.0);
		return round / 10.0;
	}

	private double anaprosarmogiMO(double graptaMathimatos, double moMathimatos) {
		if ((graptaMathimatos - moMathimatos) > 2.0) {
			return graptaMathimatos - 2.0;
		}
		if ((graptaMathimatos - moMathimatos) < -2.0) {
			return graptaMathimatos + 2.0;
		}
		return moMathimatos;
	}

	private void calcMoria() {
		boolean nextActivity = true;
		for (EditText et : editTextArr) {
			if (et.getText().toString().equals("")) {
				nextActivity = false;
				break;
			}
		}

		if (nextActivity == true) {
			proforika[0] = Integer.parseInt(math_arxaia1.getText().toString());
			proforika[1] = Integer.parseInt(math_arxaia2.getText().toString());
			grapta[0] = Double.parseDouble(math_arxaia3.getText().toString());
			double moMath_arxaia = (Integer.parseInt(math_arxaia1.getText()
					.toString()) + Integer.parseInt(math_arxaia2.getText()
					.toString())) / 2.0;
			moMath_arxaia = anaprosarmogiMO(
					Double.parseDouble(math_arxaia3.getText().toString()),
					moMath_arxaia);
			double math_arxaia = vathmosProsvasisMathimatos(
					Double.parseDouble(math_arxaia3.getText().toString()),
					moMath_arxaia);

			proforika[2] = Integer.parseInt(fys_istoria1.getText().toString());
			proforika[3] = Integer.parseInt(fys_istoria2.getText().toString());
			grapta[1] = Double.parseDouble(fys_istoria3.getText().toString());
			double moFys_istoria = (Integer.parseInt(fys_istoria1.getText()
					.toString()) + Integer.parseInt(fys_istoria2.getText()
					.toString())) / 2.0;
			moFys_istoria = anaprosarmogiMO(
					Double.parseDouble(fys_istoria3.getText().toString()),
					moFys_istoria);
			double fys_istoria = vathmosProsvasisMathimatos(
					Double.parseDouble(fys_istoria3.getText().toString()),
					moFys_istoria);

			proforika[4] = Integer.parseInt(xhm_log_ae1.getText().toString());
			proforika[5] = Integer.parseInt(xhm_log_ae2.getText().toString());
			grapta[2] = Double.parseDouble(xhm_log_ae3.getText().toString());
			double moXhm_log_ae = (Integer.parseInt(xhm_log_ae1.getText()
					.toString()) + Integer.parseInt(xhm_log_ae2.getText()
					.toString())) / 2.0;
			moXhm_log_ae = anaprosarmogiMO(
					Double.parseDouble(xhm_log_ae3.getText().toString()),
					moXhm_log_ae);
			double xhm_log_ae = vathmosProsvasisMathimatos(
					Double.parseDouble(xhm_log_ae3.getText().toString()),
					moXhm_log_ae);

			proforika[6] = Integer.parseInt(bio_lat_aode1.getText().toString());
			proforika[7] = Integer.parseInt(bio_lat_aode2.getText().toString());
			grapta[3] = Double.parseDouble(bio_lat_aode3.getText().toString());
			double moBio_lat_aode = (Integer.parseInt(bio_lat_aode1.getText()
					.toString()) + Integer.parseInt(bio_lat_aode2.getText()
					.toString())) / 2.0;
			moBio_lat_aode = anaprosarmogiMO(
					Double.parseDouble(bio_lat_aode3.getText().toString()),
					moBio_lat_aode);
			double bio_lat_aode = vathmosProsvasisMathimatos(
					Double.parseDouble(bio_lat_aode3.getText().toString()),
					moBio_lat_aode);

			proforika[8] = Integer.parseInt(ng1.getText().toString());
			proforika[9] = Integer.parseInt(ng2.getText().toString());
			grapta[4] = Double.parseDouble(ng3.getText().toString());
			double moNg = (Integer.parseInt(ng1.getText().toString()) + Integer
					.parseInt(ng2.getText().toString())) / 2.0;
			moNg = anaprosarmogiMO(
					Double.parseDouble(ng3.getText().toString()), moNg);
			double ng = vathmosProsvasisMathimatos(
					Double.parseDouble(ng3.getText().toString()), moNg);

			proforika[10] = Integer.parseInt(epil1.getText().toString());
			proforika[11] = Integer.parseInt(epil2.getText().toString());
			grapta[5] = Double.parseDouble(epil3.getText().toString());
			double moEpil = (Integer.parseInt(epil1.getText().toString()) + Integer
					.parseInt(epil2.getText().toString())) / 2.0;
			moEpil = anaprosarmogiMO(
					Double.parseDouble(epil3.getText().toString()), moEpil);
			double epil = vathmosProsvasisMathimatos(
					Double.parseDouble(epil3.getText().toString()), moEpil);

			double aoth = 0.0;
			if (aothBool == true) {
				proforika[12] = Integer.parseInt(aoth1.getText().toString());
				proforika[13] = Integer.parseInt(aoth2.getText().toString());
				grapta[6] = Double.parseDouble(aoth3.getText().toString());
				double moAoth = (Integer.parseInt(aoth1.getText().toString()) + Integer
						.parseInt(aoth2.getText().toString())) / 2.0;
				moAoth = anaprosarmogiMO(
						Double.parseDouble(aoth3.getText().toString()), moAoth);
				aoth = vathmosProsvasisMathimatos(
						Double.parseDouble(aoth3.getText().toString()), moAoth);
			} else {
				proforika[12] = 0;
				proforika[13] = 0;
				grapta[6] = 0.0;
			}

			double gvp = Math
					.round(((math_arxaia + fys_istoria + xhm_log_ae
							+ bio_lat_aode + ng + epil + aoth) / totalMathimata) * 100.0);
			double roundgvp = gvp / 100.0;
			/*
			 * Log.d("math_arxaia", "" + math_arxaia); Log.d("fys_istoria", "" +
			 * fys_istoria); Log.d("xhm_log_ae", "" + xhm_log_ae);
			 * Log.d("bio_lat_aode", "" + bio_lat_aode); Log.d("ng", "" + ng);
			 * Log.d("epil", "" + epil); Log.d("aoth", "" + aoth);
			 * Log.d("totalMathimata", "" + totalMathimata); Log.d("roundgvp",
			 * "" + roundgvp);
			 */

			int pedio1 = 0;
			int pedio2 = 0;
			int pedio3 = 0;
			int pedio4 = 0;
			int pedio5 = 0;

			// thetiki
			if (kat == 0) {
				// istoria
				if (epilogis == 1) {
					pedio1 = (int) Math
							.round(((roundgvp * 8) + (ng * 0.9) + (epil * 0.4)) * 100);
				} else {
					pedio1 = 0;
				}
				pedio2 = (int) Math
						.round(((roundgvp * 8) + (math_arxaia * 1.3) + (fys_istoria * 0.7)) * 100);
				pedio3 = (int) Math.round(((roundgvp * 8)
						+ (bio_lat_aode * 1.3) + (xhm_log_ae * 0.7)) * 100);
				pedio4 = pedio2;

				// aoth
				if ((epilogis == 0) && (aothBool == true)) {
					pedio5 = (int) Math
							.round(((roundgvp * 8) + (aoth * 1.3) + (epil * 0.7)) * 100);
				} else {
					pedio5 = 0;
				}

				// texnologiki
			} else if (kat == 1) {
				// isoria
				if (epilogis == 1) {
					pedio1 = (int) Math
							.round(((roundgvp * 8) + (ng * 0.9) + (epil * 0.4)) * 100);
				} else {
					pedio1 = 0;
				}
				pedio2 = (int) Math
						.round(((roundgvp * 8) + (math_arxaia * 1.3) + (fys_istoria * 0.7)) * 100);

				// biologia
				if (epilogis == 2) {
					pedio3 = (int) Math
							.round(((roundgvp * 8) + (epil * 0.9) + (ng * 0.4)) * 100);
				} else {
					pedio3 = 0;
				}
				pedio4 = pedio2;

				// aoth
				if ((epilogis == 0) && (aothBool == true)) {
					pedio5 = (int) Math
							.round(((roundgvp * 8) + (aoth * 1.3) + (epil * 0.7)) * 100);
				} else {
					pedio5 = 0;
				}

				// theoritki
			} else {
				pedio1 = (int) Math
						.round(((roundgvp * 8) + (math_arxaia * 1.3) + (fys_istoria * 0.7)) * 100);

				// statistiki
				if (epilogis == 0) {
					pedio2 = (int) Math
							.round(((roundgvp * 8) + (epil * 0.9) + (ng * 0.4)) * 100);
				} else {
					pedio2 = 0;
				}

				// biologia
				if (epilogis == 2) {
					pedio3 = (int) Math
							.round(((roundgvp * 8) + (epil * 0.9) + (ng * 0.4)) * 100);
				} else {
					pedio3 = 0;
				}
				pedio4 = pedio2;

				// aoth
				if ((epilogis == 0) && (aothBool == true)) {
					pedio5 = (int) Math
							.round(((roundgvp * 8) + (aoth * 1.3) + (epil * 0.7)) * 100);
				} else {
					pedio5 = 0;
				}
			}

			Intent intent = new Intent(MoriaActivity.this,
					ResultsActivity.class);
			intent.putExtra(AddUserActivity.NAME, name);
			intent.putExtra(AddUserActivity.KAT, kat);
			intent.putExtra(AddUserActivity.EPIL, epilogis);
			intent.putExtra(AddUserActivity.AOTH, aothBool);
			intent.putExtra(MoriaActivity.BP, roundgvp);
			intent.putExtra(MoriaActivity.P1, pedio1);
			intent.putExtra(MoriaActivity.P2, pedio2);
			intent.putExtra(MoriaActivity.P3, pedio3);
			intent.putExtra(MoriaActivity.P4, pedio4);
			intent.putExtra(MoriaActivity.P5, pedio5);
			intent.putExtra(MoriaActivity.PROF, proforika);
			intent.putExtra(MoriaActivity.GRAP, grapta);
			intent.putExtra(MoriaActivity.ACTIVITY, activity);

			startActivity(intent);
		} else {
			Toast.makeText(
					MoriaActivity.this,
					"?????? ?????????? ?????????????? ?????? ???? ????????????????.",
					Toast.LENGTH_SHORT).show();
		}

		/*
		 * Toast.makeText( MoriaActivity.this, roundgvp + " --- " +
		 * Double.toString(pedio1) + ", " + Double.toString(pedio2) + ", " +
		 * Double.toString(pedio3) + ", " + Double.toString(pedio4) + ", " +
		 * Double.toString(pedio5), Toast.LENGTH_SHORT).show();
		 */
	}

	OnFocusChangeListener etListener = new OnFocusChangeListener() {

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			EditText et = (EditText) v;
			if (hasFocus == false) {
				if (!et.getText().toString().equals("")) {
					double vathmos = Double
							.parseDouble(et.getText().toString());
					if ((vathmos < 0.0) || (vathmos > 20.0)) {
						et.setText("");
					}
				}
			}
		}
	};
}
