package com.froena;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

	private static final String LOG = "DatabaseHelper";
	private static final int DATABASE_VERSION = 2;
	private static final String DATABASE_NAME = "mathitesPanellinies";

	// Table mathites
	private static final String TABLE_MATHITES = "mathites";

	// Common column mathites
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_KAT = "kat";
	private static final String KEY_EPILOGIS = "epilogis";
	private static final String KEY_AOTH = "aoth";

	private static final String KEY_MATH_ARXAIA1 = "a1";
	private static final String KEY_MATH_ARXAIA2 = "a2";
	private static final String KEY_MATH_ARXAIA3 = "a3";

	private static final String KEY_FYS_ISTORIA1 = "b1";
	private static final String KEY_FYS_ISTORIA2 = "b2";
	private static final String KEY_FYS_ISTORIA3 = "b3";

	private static final String KEY_XHM_LOG_AE1 = "c1";
	private static final String KEY_XHM_LOG_AE2 = "c2";
	private static final String KEY_XHM_LOG_AE3 = "c3";

	private static final String KEY_BIO_LAT_AE1 = "d1";
	private static final String KEY_BIO_LAT_AE2 = "d2";
	private static final String KEY_BIO_LAT_AE3 = "d3";

	private static final String KEY_NG1 = "e1";
	private static final String KEY_NG2 = "e2";
	private static final String KEY_NG3 = "e3";

	private static final String KEY_EPIL1 = "f1";
	private static final String KEY_EPIL2 = "f2";
	private static final String KEY_EPIL3 = "f3";

	private static final String KEY_AOTH1 = "g1";
	private static final String KEY_AOTH2 = "g2";
	private static final String KEY_AOTH3 = "g3";

	private static final String CREATE_TABLE_MATHITES = "CREATE TABLE "
			+ Database.TABLE_MATHITES + "(" + Database.KEY_ID
			+ " INTEGER PRIMARY KEY," + Database.KEY_NAME + " TEXT,"
			+ Database.KEY_KAT + " INTEGER," + Database.KEY_EPILOGIS
			+ " INTEGER," + Database.KEY_AOTH + " BOOLEAN, "
			+ Database.KEY_MATH_ARXAIA1 + " INTEGER,"
			+ Database.KEY_MATH_ARXAIA2 + " INTEGER,"
			+ Database.KEY_MATH_ARXAIA3 + " DOUBLE,"
			+ Database.KEY_FYS_ISTORIA1 + " INTEGER,"
			+ Database.KEY_FYS_ISTORIA2 + " INTEGER,"
			+ Database.KEY_FYS_ISTORIA3 + " DOUBLE," + Database.KEY_XHM_LOG_AE1
			+ " INTEGER," + Database.KEY_XHM_LOG_AE2 + " INTEGER,"
			+ Database.KEY_XHM_LOG_AE3 + " DOUBLE," + Database.KEY_BIO_LAT_AE1
			+ " INTEGER," + Database.KEY_BIO_LAT_AE2 + " INTEGER,"
			+ Database.KEY_BIO_LAT_AE3 + " DOUBLE," + Database.KEY_NG1
			+ " INTEGER," + Database.KEY_NG2 + " INTEGER," + Database.KEY_NG3
			+ " DOUBLE," + Database.KEY_EPIL1 + " INTEGER,"
			+ Database.KEY_EPIL2 + " INTEGER," + Database.KEY_EPIL3
			+ " DOUBLE," + Database.KEY_AOTH1 + " INTEGER,"
			+ Database.KEY_AOTH2 + " INTEGER," + Database.KEY_AOTH3 + " DOUBLE"
			+ ")";

	public Database(Context context) {
		super(context, Database.DATABASE_NAME, null, Database.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(Database.CREATE_TABLE_MATHITES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + Database.TABLE_MATHITES);
		onCreate(db);
	}

	public void closeDB() {
		SQLiteDatabase db = getReadableDatabase();
		if ((db != null) && db.isOpen()) {
			db.close();
		}
	}

	public long insertMathiti(Mathitis mathitis) {
		SQLiteDatabase db = getWritableDatabase();

		int proforika[] = mathitis.getProforika();
		double grapta[] = mathitis.getGrapta();

		ContentValues values = new ContentValues();
		// values.put(Database.KEY_ID, mathitis.getId());
		values.put(Database.KEY_NAME, mathitis.getName());
		values.put(Database.KEY_KAT, mathitis.getKat());
		values.put(Database.KEY_EPILOGIS, mathitis.getEpilogis());
		values.put(Database.KEY_AOTH, mathitis.isAothBool());

		Map<String, Integer> prof = new HashMap<String, Integer>();
		Map<String, Double> grap = new HashMap<String, Double>();

		prof.put(Database.KEY_MATH_ARXAIA1, proforika[0]);
		prof.put(Database.KEY_MATH_ARXAIA2, proforika[1]);
		prof.put(Database.KEY_FYS_ISTORIA1, proforika[2]);
		prof.put(Database.KEY_FYS_ISTORIA2, proforika[3]);
		prof.put(Database.KEY_XHM_LOG_AE1, proforika[4]);
		prof.put(Database.KEY_XHM_LOG_AE2, proforika[5]);
		prof.put(Database.KEY_BIO_LAT_AE1, proforika[6]);
		prof.put(Database.KEY_BIO_LAT_AE2, proforika[7]);
		prof.put(Database.KEY_NG1, proforika[8]);
		prof.put(Database.KEY_NG2, proforika[9]);
		prof.put(Database.KEY_EPIL1, proforika[10]);
		prof.put(Database.KEY_EPIL2, proforika[11]);
		prof.put(Database.KEY_AOTH1, proforika[12]);
		prof.put(Database.KEY_AOTH2, proforika[13]);

		grap.put(Database.KEY_MATH_ARXAIA3, grapta[0]);
		grap.put(Database.KEY_FYS_ISTORIA3, grapta[1]);
		grap.put(Database.KEY_XHM_LOG_AE3, grapta[2]);
		grap.put(Database.KEY_BIO_LAT_AE3, grapta[3]);
		grap.put(Database.KEY_NG3, grapta[4]);
		grap.put(Database.KEY_EPIL3, grapta[5]);
		grap.put(Database.KEY_AOTH3, grapta[6]);

		Set s = prof.entrySet();
		Iterator it = s.iterator();
		while (it.hasNext()) {
			Map.Entry m = (Map.Entry) it.next();
			String key = (String) m.getKey();
			int value = (Integer) m.getValue();
			values.put(key, value);
		}

		s = grap.entrySet();
		it = s.iterator();
		while (it.hasNext()) {
			Map.Entry m = (Map.Entry) it.next();
			String key = (String) m.getKey();
			double value = (Double) m.getValue();
			values.put(key, value);
		}

		long mathitisid = db.insert(Database.TABLE_MATHITES, null, values);
		db.close();
		return mathitisid;
	}

	public void deleteMathiti(String string) {
		SQLiteDatabase db = getWritableDatabase();

		db.delete(Database.TABLE_MATHITES, Database.KEY_NAME + " = ?",
				new String[] { string });
		db.close();
	}

	public List<Mathitis> getAllMathites() {

		List<Mathitis> mathites = new LinkedList<Mathitis>();

		String query = "SELECT  * FROM " + Database.TABLE_MATHITES;

		SQLiteDatabase db = getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		Mathitis math = null;
		if (cursor.moveToFirst()) {
			do {
				math = new Mathitis(query, 0, 0, false, null, null);
				math.setId(Integer.parseInt(cursor.getString(0)));
				math.setName(cursor.getString(1));
				math.setKat(Integer.parseInt(cursor.getString(2)));
				math.setEpilogis(Integer.parseInt(cursor.getString(3)));
				math.setAothBool((Integer.parseInt(cursor.getString(4)) == 1) ? true
						: false);

				int[] pro = new int[14];
				pro[0] = Integer.parseInt(cursor.getString(5));
				pro[1] = Integer.parseInt(cursor.getString(6));
				pro[2] = Integer.parseInt(cursor.getString(8));
				pro[3] = Integer.parseInt(cursor.getString(9));
				pro[4] = Integer.parseInt(cursor.getString(11));
				pro[5] = Integer.parseInt(cursor.getString(12));
				pro[6] = Integer.parseInt(cursor.getString(14));
				pro[7] = Integer.parseInt(cursor.getString(15));
				pro[8] = Integer.parseInt(cursor.getString(17));
				pro[9] = Integer.parseInt(cursor.getString(18));
				pro[10] = Integer.parseInt(cursor.getString(20));
				pro[11] = Integer.parseInt(cursor.getString(21));
				pro[12] = Integer.parseInt(cursor.getString(23));
				pro[13] = Integer.parseInt(cursor.getString(24));

				double[] gra = new double[7];
				gra[0] = Double.parseDouble(cursor.getString(7));
				gra[1] = Double.parseDouble(cursor.getString(10));
				gra[2] = Double.parseDouble(cursor.getString(13));
				gra[3] = Double.parseDouble(cursor.getString(16));
				gra[4] = Double.parseDouble(cursor.getString(19));
				gra[5] = Double.parseDouble(cursor.getString(22));
				gra[6] = Double.parseDouble(cursor.getString(25));

				math.setProforika(pro);
				math.setGrapta(gra);

				// Add book to books
				mathites.add(math);
			} while (cursor.moveToNext());
		}

		// Log.d("getAllMathites()", mathites.toString());

		return mathites;
	}
}
