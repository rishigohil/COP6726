package com.db.dao.review;

import java.io.IOException;

import com.db.FileDB;
import com.db.dao.AbstractDao;

public class TimeSlotsDao extends AbstractDao {

	private static TimeSlotsDao instance;

	public static TimeSlotsDao getInstance() throws IOException {
		if (instance == null) {
			synchronized (TimeSlotsDao.class) {
				if (instance == null) {
					instance = new TimeSlotsDao();
				}
			}
		}
		return instance;
	}

	private TimeSlotsDao() throws IOException {
		super(new FileDB("cop6726.review.time_slots.db"));
	}

}
