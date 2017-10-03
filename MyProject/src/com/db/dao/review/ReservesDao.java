package com.db.dao.review;

import java.io.IOException;

import com.db.FileDB;
import com.db.dao.AbstractDao;

public class ReservesDao extends AbstractDao{

	private static ReservesDao instance;

	public static ReservesDao getInstance() throws IOException {
		if (instance == null) {
			synchronized (ReservesDao.class) {
				if (instance == null) {
					instance = new ReservesDao();
				}
			}
		}
		return instance;
	}

	private ReservesDao() throws IOException {
		super(new FileDB("cop6726.review.reserves.db"));
	}
}
