package com.db;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.conf.DBConf;
import com.io.FileIn;
import com.io.FileOut;

public class FileDB {

	private final File dbFile;

	public FileDB(final String fileName) throws IOException {
		this.dbFile = new File(DBConf.userHome, fileName);
		dbFile.getParentFile().mkdirs();
		if (!dbFile.exists()) {
			dbFile.createNewFile();
		}
	}

	public List<KeyValue> getRecords() throws IOException {
		final Map<String, String> map = new HashMap<String, String>();
		final FileIn fileIn = new FileIn(dbFile);
		String str;
		while ((str = fileIn.read()) != null) {
			final int indexOfColon = str.indexOf(':');
			final String key = str.substring(0, indexOfColon).trim();
			final String value = str.substring(indexOfColon + 1).trim();
			map.put(key, value);
		}
		fileIn.close();
		final List<KeyValue> list = new ArrayList<KeyValue>();
		final String[] keyArray = map.keySet().toArray(new String[0]);
		Arrays.sort(keyArray);
		for (final String key : keyArray) {
			list.add(new KeyValue(key, map.get(key)));
		}
		return list;
	}

	public Map<String, String> getMap() throws IOException {
		final Map<String, String> map = new HashMap<String, String>();
		final FileIn fileIn = new FileIn(dbFile);
		String str;
		while ((str = fileIn.read()) != null) {
			final int indexOfColon = str.indexOf(':');
			final String key = str.substring(0, indexOfColon).trim();
			final String value = str.substring(indexOfColon + 1).trim();
			map.put(key, value);
		}
		fileIn.close();
		return map;
	}

	public Set<String> getKeySet() throws IOException {
		final Set<String> set = new HashSet<String>();
		final FileIn fileIn = new FileIn(dbFile);
		String str;
		while ((str = fileIn.read()) != null) {
			final int indexOfColon = str.indexOf(':');
			final String key = str.substring(0, indexOfColon).trim();
			set.add(key);
		}
		fileIn.close();
		return set;
	}

	public Set<String> getValueSet() throws IOException {
		final Set<String> set = new HashSet<String>();
		final FileIn fileIn = new FileIn(dbFile);
		String str;
		while ((str = fileIn.read()) != null) {
			final int indexOfColon = str.indexOf(':');
			final String value = str.substring(indexOfColon + 1).trim();
			set.add(value);
		}
		fileIn.close();
		return set;
	}

	public Set<String> getValueSet(final int index) throws IOException {
		final Set<String> set = new HashSet<String>();
		final FileIn fileIn = new FileIn(dbFile);
		String str;
		while ((str = fileIn.read()) != null) {
			final int indexOfColon = str.indexOf(':');
			final String value = str.substring(indexOfColon + 1).trim().split(",")[index];

			System.out.println(value);
			set.add(value);
		}
		fileIn.close();
		return set;
	}

	public String getRecord(final String key) throws IOException {
		final FileIn fileIn = new FileIn(dbFile);
		String str;
		while ((str = fileIn.read()) != null) {
			final int indexOfColon = str.indexOf(':');
			final String aKey = str.substring(0, indexOfColon).trim();
			if (key.equals(aKey)) {
				final String value = str.substring(indexOfColon + 1).trim();
				return value.equals("null") ? null : value;
			}
		}
		fileIn.close();
		return null;
	}

	public void updateRecord(final String neoKey, final String neoValue) throws IOException {
		final Map<String, String> map = new HashMap<String, String>();
		map.put(neoKey, neoValue);
		final FileIn fileIn = new FileIn(dbFile);
		String str;
		while ((str = fileIn.read()) != null) {
			final int indexOfColon = str.indexOf(':');
			final String aKey = str.substring(0, indexOfColon).trim();
			final String aValue = str.substring(indexOfColon + 1).trim();
			if (!neoKey.equals(aKey)) {
				map.put(aKey, aValue);
			}
		}
		fileIn.close();
		final FileOut fileOut = new FileOut(dbFile);
		final String[] keyArray = map.keySet().toArray(new String[0]);
		Arrays.sort(keyArray);
		for (final String key : keyArray) {
			fileOut.writeln(key + ": " + map.get(key));
		}
		fileOut.close();
	}

	public static void main(final String[] args) throws Exception {
		final FileDB fileDB = new FileDB("student");
		System.out.println(fileDB.getRecord("test2"));
		fileDB.updateRecord("test2", "testvalue2");
		System.out.println(fileDB.getRecord("test2"));
	}

}
