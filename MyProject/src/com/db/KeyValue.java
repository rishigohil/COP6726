package com.db;

public class KeyValue implements Comparable<KeyValue> {

	private final String key;
	private final String value;

	public KeyValue(final String key, final String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public boolean isNull() {
		return value == null || value.equals("null") ? true : false;
	}

	public String getValue(final int index) {
		return value.split(",")[index];
	}

	public int compareTo(final KeyValue o) {
		return key.compareTo(o.key);
	}
}
