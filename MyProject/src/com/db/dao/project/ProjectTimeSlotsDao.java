package com.db.dao.project;

import java.io.IOException;

import com.db.FileDB;
import com.db.dao.AbstractDao;

public class ProjectTimeSlotsDao extends AbstractDao {

	private static ProjectTimeSlotsDao instance;

	public static ProjectTimeSlotsDao getInstance() throws IOException {
		if (instance == null) {
			synchronized (ProjectTimeSlotsDao.class) {
				if (instance == null) {
					instance = new ProjectTimeSlotsDao();
				}
			}
		}
		return instance;
	}

	private ProjectTimeSlotsDao() throws IOException {
		super(new FileDB("cop6726.project.time_slots.db"));
	}

}
