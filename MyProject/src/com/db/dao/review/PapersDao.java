package com.db.dao.review;

import java.io.IOException;

import com.db.FileDB;
import com.db.dao.AbstractDao;

public class PapersDao extends AbstractDao {

	private static PapersDao instance;

	public static PapersDao getInstance() throws IOException {
		if (instance == null) {
			synchronized (PapersDao.class) {
				if (instance == null) {
					instance = new PapersDao();
				}
			}
		}
		return instance;
	}

	private PapersDao() throws IOException {
		super(new FileDB("cop6726.review.papers.db"));
	}

}
