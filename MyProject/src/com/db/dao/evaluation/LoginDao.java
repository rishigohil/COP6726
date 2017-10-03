package com.db.dao.evaluation;

import java.io.IOException;

import com.db.FileDB;
import com.db.dao.AbstractDao;

public class LoginDao extends AbstractDao{

	private static LoginDao instance;

	public static LoginDao getInstance() throws IOException {
		if (instance == null) {
			synchronized (LoginDao.class) {
				if (instance == null) {
					instance = new LoginDao();
				}
			}
		}
		return instance;
	}

	private LoginDao() throws IOException {
		super(new FileDB("cop6726.evaluation.login.db"));
	}
}
