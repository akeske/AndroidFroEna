package com.froena;

import java.util.ArrayList;

import com.froena.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MathitesAdapterView extends ArrayAdapter<String> {

	private Database db;
	private Activity activity;
	private int layoutResourceId;
	private ArrayList<String> onomata = new ArrayList<String>();

	public MathitesAdapterView(Activity activity, int layoutResourceId,
			ArrayList<String> onomata) {
		super(activity, layoutResourceId, onomata);
		this.layoutResourceId = layoutResourceId;
		this.activity = activity;
		this.onomata = onomata;
		db = new Database(activity);
	}

	private int pos;

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		pos = position;
		RowHolder holder = null;
		View row = convertView;

		if (row == null) {
			LayoutInflater inflater = activity.getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new RowHolder();
			holder.txtMathitis = (TextView) row.findViewById(R.id.mathitisName);
			holder.btnDelete = (Button) row.findViewById(R.id.btnDelete);
			holder.btnDelete.setTag(position);
			holder.btnDelete.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Integer index = (Integer) v.getTag();
					// Log.d("fasdfs", "" + v.getTag());
					// Log.d("fasdfs", "" + onomata.get(index));
					db.deleteMathiti(onomata.get(index));
					MathitesListActivity act = (MathitesListActivity) activity;
					act.refreshActivity();
				}
			});
			row.setTag(holder);
		} else {
			holder = (RowHolder) row.getTag();
		}

		holder.txtMathitis.setText(onomata.get(position));

		row.setOnClickListener(new OnItemClickListener(position));
		return row;
	}

	static class RowHolder {
		TextView txtMathitis;
		Button btnDelete;
	}

	private class OnItemClickListener implements OnClickListener {
		private int mPosition;

		OnItemClickListener(int position) {
			mPosition = position;
		}

		@Override
		public void onClick(View view) {
			MathitesListActivity act = (MathitesListActivity) activity;
			act.onItemClick(mPosition);
		}
	}

}
