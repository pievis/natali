package it.mtr.robotBase.utils;

public class Counter {

	int val = 0;

	public Counter(int val) {
		this.val = val;
	}

	public Counter() {

	}

	public void inc() {
		val++;
	}

	public void dec() {
		val--;
	}

	public int getVal() {
		return val;
	}

}
