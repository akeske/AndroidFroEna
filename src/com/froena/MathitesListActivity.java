package com.froena;

import java.util.ArrayList;
import java.util.List;

import com.froena.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class MathitesListActivity extends Activity {

	private Database db;
	private List<Mathitis> mathites;
	private MathitesAdapterView adapter;
	private MathitesListActivity activity = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_mathites);

		ListView listview = (ListView) findViewById(R.id.listview);

		db = new Database(this);
		mathites = db.getAllMathites();

		ArrayList<String> onomata = new ArrayList<String>();
		for (int i = 0; i < mathites.size(); i++) {
			onomata.add(mathites.get(i).getName());
		}

		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, onomata);
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// R.layout.mathites_list_item, R.id.mathitisName, onomata);

		activity = this;
		adapter = new MathitesAdapterView(activity,
				R.layout.mathites_list_item, onomata);
		listview.setAdapter(adapter);

		/*
		 * listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
		 * {
		 * 
		 * @Override public void onItemClick(AdapterView<?> parent, View view,
		 * int position, long id) { Intent intent = new
		 * Intent(MathitesListActivity.this, MoriaActivity.class);
		 * intent.putExtra(AddUserActivity.NAME, mathites.get(position)
		 * .getName()); intent.putExtra(AddUserActivity.KAT,
		 * mathites.get(position) .getKat());
		 * intent.putExtra(AddUserActivity.EPIL, mathites.get(position)
		 * .getEpilogis()); intent.putExtra(AddUserActivity.AOTH,
		 * mathites.get(position) .isAothBool()); Bundle b1 = new Bundle();
		 * b1.putIntArray(MoriaActivity.PROF, mathites.get(position)
		 * .getProforika()); intent.putExtras(b1); Bundle b2 = new Bundle();
		 * b2.putDoubleArray(MoriaActivity.GRAP, mathites.get(position)
		 * .getGrapta()); intent.putExtras(b2);
		 * intent.putExtra(MoriaActivity.ACTIVITY, 1); startActivity(intent); }
		 * });
		 */
	}

	public void onItemClick(int position) {
		Intent intent = new Intent(MathitesListActivity.this,
				MoriaActivity.class);
		intent.putExtra(AddUserActivity.NAME, mathites.get(position).getName());
		intent.putExtra(AddUserActivity.KAT, mathites.get(position).getKat());
		intent.putExtra(AddUserActivity.EPIL, mathites.get(position)
				.getEpilogis());
		intent.putExtra(AddUserActivity.AOTH, mathites.get(position)
				.isAothBool());
		Bundle b1 = new Bundle();
		b1.putIntArray(MoriaActivity.PROF, mathites.get(position)
				.getProforika());
		intent.putExtras(b1);
		Bundle b2 = new Bundle();
		b2.putDoubleArray(MoriaActivity.GRAP, mathites.get(position)
				.getGrapta());
		intent.putExtras(b2);
		// eisodos apo lista mathitwn gia allages
		intent.putExtra(MoriaActivity.ACTIVITY, 1);
		startActivity(intent);
		finish();
	}

	public void refreshActivity() {
		Intent intent = new Intent(MathitesListActivity.this,
				MathitesListActivity.class);
		startActivity(intent);
		finish();
	}
}
