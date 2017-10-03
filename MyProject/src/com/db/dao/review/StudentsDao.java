package com.db.dao.review;

import java.io.IOException;

import com.db.FileDB;
import com.db.dao.AbstractDao;

public class StudentsDao extends AbstractDao {

	private static StudentsDao instance;

	public static StudentsDao getInstance() throws IOException {
		if (instance == null) {
			synchronized (StudentsDao.class) {
				if (instance == null) {
					instance = new StudentsDao();
				}
			}
		}
		return instance;
	}

	private StudentsDao() throws IOException {
		super(new FileDB("cop6726.review.students.db"));
	}

}
