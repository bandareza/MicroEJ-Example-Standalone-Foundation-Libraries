/**
 * Java
 *
 * Copyright 2009-2016 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package com.microej.example.foundation.microui.mvc;

import java.util.Observable;
import java.util.Random;

public class PercentageModel extends Observable {
	
	private static final int PAGE_INCREMENT = 10;
	private static final int RANGE = 100;
	
	private final Random random;
	private int percentage;
	
	public PercentageModel() {
		this.random = new Random(System.currentTimeMillis());
		this.percentage = 25;
	}
	
	public int get() {
		return percentage;
	}
	
	private void increment(int incr) {
		//get old value
		int oldValue = percentage;
		//increment value
		int value = oldValue + incr;
		//crop to [0..RANGE].
		if (value > RANGE) value = RANGE;
		if (value < 0) value = 0;
		update(value);
	}
	
	private void update(int value){
		//update value and notify listeners
		if (percentage != value) {
			percentage = value;
			setChanged();
			notifyObservers();
		}
	}
	
	/* API */
	public void incrementValue() {
		increment(1);
	}

	/* API */
	public void decrementValue() {
		increment(-1);
	}

	/* API */
	public void pageIncrementValue() {
		increment(PAGE_INCREMENT);
	}

	/* API */
	public void pageDecrementValue() {
		increment(-PAGE_INCREMENT);
	}

	public void random() {
		update(random.nextInt(RANGE));
	}
}
