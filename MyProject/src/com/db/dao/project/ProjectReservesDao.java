package com.db.dao.project;

import java.io.IOException;

import com.db.FileDB;
import com.db.dao.AbstractDao;

public class ProjectReservesDao extends AbstractDao{

	private static ProjectReservesDao instance;

	public static ProjectReservesDao getInstance() throws IOException {
		if (instance == null) {
			synchronized (ProjectReservesDao.class) {
				if (instance == null) {
					instance = new ProjectReservesDao();
				}
			}
		}
		return instance;
	}

	private ProjectReservesDao() throws IOException {
		super(new FileDB("cop6726.project.reserves.db"));
	}
}
