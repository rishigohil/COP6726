package com.db.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.db.FileDB;
import com.db.KeyValue;

public class AbstractDao {

	private final FileDB fileDB;

	public AbstractDao(final FileDB fileDB) throws IOException {
		this.fileDB = fileDB;
	}

	public synchronized List<KeyValue> getRecords() throws IOException {
		return fileDB.getRecords();
	}

	public synchronized String getRecord(final String key) throws IOException {
		return fileDB.getRecord(key);
	}

	public synchronized void updateRecord(final String neoKey, final String neoValue) throws IOException {
		fileDB.updateRecord(neoKey, neoValue);
	}

	public synchronized Set<String> getKeySet() throws IOException {
		return fileDB.getKeySet();
	}
	
	public synchronized Map<String,String> getMap() throws IOException {
		return fileDB.getMap();
	}

	public synchronized Set<String> getValueSet() throws IOException {
		return fileDB.getValueSet();
	}
	
	public synchronized Set<String> getValueSet(final int index) throws IOException {
		return fileDB.getValueSet(index);
	}

}
