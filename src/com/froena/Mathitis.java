package com.froena;

import java.util.Arrays;

public class Mathitis {

	private int id;
	private String name;
	private int kat;
	private int epilogis;
	private boolean aothBool;

	private int[] proforika;
	private double[] grapta;

	Mathitis(String name, int kat, int epilogis, boolean aothBool,
			int[] proforika, double[] grapta) {
		this.name = name;
		this.kat = kat;
		this.epilogis = epilogis;
		this.aothBool = aothBool;
		this.proforika = proforika;
		this.grapta = grapta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKat() {
		return kat;
	}

	public void setKat(int kat) {
		this.kat = kat;
	}

	public int getEpilogis() {
		return epilogis;
	}

	public void setEpilogis(int epilogis) {
		this.epilogis = epilogis;
	}

	public boolean isAothBool() {
		return aothBool;
	}

	public void setAothBool(boolean aothBool) {
		this.aothBool = aothBool;
	}

	public int[] getProforika() {
		return proforika;
	}

	public void setProforika(int[] proforika) {
		this.proforika = proforika;
	}

	public double[] getGrapta() {
		return grapta;
	}

	public void setGrapta(double[] grapta) {
		this.grapta = grapta;
	}

	@Override
	public String toString() {
		return "Mathitis [id=" + id + ", name=" + name + ", kat=" + kat
				+ ", epilogis=" + epilogis + ", aothBool=" + aothBool
				+ ", proforika=" + Arrays.toString(proforika) + ", grapta="
				+ Arrays.toString(grapta) + "]";
	}
}
