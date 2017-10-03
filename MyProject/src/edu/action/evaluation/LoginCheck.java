package edu.action.evaluation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.db.dao.evaluation.LoginDao;

import edu.servlet.HttpRequestUtil;

public class LoginCheck {

	public static String getId(final HttpServletRequest req) throws Exception {
		final LoginDao loginDao = LoginDao.getInstance();
		final HttpSession session = req.getSession(false);
		if (session == null) {
			req.setAttribute("errorMessage", "Please Login");
			return null;
		}
		final String id = (String) session.getAttribute("id");
		final String password = (String) session.getAttribute("password");
		if (id == null) {
			req.setAttribute("errorMessage", "Please Login");
			return null;
		}

		final Map<String, String> map = loginDao.getMap();
		final String aPassword = map.get(id);
		if (aPassword == null || !aPassword.equals(password)) {
			req.setAttribute("errorMessage", "ID/PASSWORD is incorrect");
			return null;
		}
		return id;
	}

	public static boolean createSession(final HttpServletRequest req) throws Exception {
		final String id = HttpRequestUtil.getString(req, "id");
		final String password = HttpRequestUtil.getString(req, "password");
		final LoginDao loginDao = LoginDao.getInstance();
		final Map<String, String> loginMap = loginDao.getMap();
		final String aPassword = loginMap.get(id);
		if (aPassword == null || !aPassword.equals(password)) {
			req.setAttribute("errorMessage", "ID/PASSWORD is incorrect");
			return false;
		}
		final HttpSession session = req.getSession(false);
		session.setAttribute("id", id);
		session.setAttribute("password", password);
		return true;
	}
}
